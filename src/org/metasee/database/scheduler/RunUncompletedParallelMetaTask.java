package org.metasee.database.scheduler;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.metasee.database.commonUtil.runCommand.ParallelMetaRunCommand;
import org.metasee.database.model.ParallelMetaResult;
import org.metasee.database.util.HibernateUtil;

public class RunUncompletedParallelMetaTask extends Thread{
	public void run(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<ParallelMetaResult> parallelMetaResults=(List<ParallelMetaResult>)s.createQuery("from ParallelMetaResult parallelMetaResult where parallelMetaResult.start=1 and parallelMetaResult.error=0 and parallelMetaResult.complete=0 and parallelMetaResult.songChecked=1").list();
		s.getTransaction().commit();
		
		for(ParallelMetaResult i : parallelMetaResults){
			try {
				ParallelMetaRunCommand runCommand=new ParallelMetaRunCommand();
				runCommand.setParallelMetaResult(i);
				runCommand.run();
			} catch (Exception e) {
				i.setError(1);
				
				sf = HibernateUtil.getSessionFactory();
				s = sf.getCurrentSession();
				s.beginTransaction();
				s.update(i);
				s.getTransaction().commit();
				
				e.printStackTrace();
			}
		}
	}
}
