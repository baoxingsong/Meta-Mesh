package org.metasee.database.scheduler;

public class MultipleThreadRun extends Thread{
	public void run() {
		while(true){
				RunUncompletedParallelMetaTask runUncompletedParallelMetaTask = new RunUncompletedParallelMetaTask();
				runUncompletedParallelMetaTask.run();
				//runUncompletedParallelMetaTask.wait();
				
				RunUnstartedParallelMetaTask runUnstartedParallelMetaTask = new RunUnstartedParallelMetaTask();
				runUnstartedParallelMetaTask.run();
				//runUnstartedParallelMetaTask.wait();
		}
	}
}
