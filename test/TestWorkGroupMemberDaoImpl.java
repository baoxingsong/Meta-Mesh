import static org.junit.Assert.*;

import org.junit.Test;
import org.metasee.database.dao.impl.WorkGroupDaoImpl;
import org.metasee.database.dao.impl.WorkGroupMemberDaoImpl;
import org.metasee.database.model.User;
import org.metasee.database.model.WorkGroup;
import org.metasee.database.model.WorkGroupMember;
import org.metasee.database.service.impl.UserManagerImpl;


public class TestWorkGroupMemberDaoImpl {

	@Test
	public void testGetByUserAndWorkGroup() {
		WorkGroupMemberDaoImpl workGroupMemberDaoImpl = new WorkGroupMemberDaoImpl();
		UserManagerImpl userManagerImpl = new UserManagerImpl();
		User user = userManagerImpl.getUserByUserId(2);
		WorkGroupDaoImpl workGroupDaoImpl = new WorkGroupDaoImpl();
		WorkGroup workGroup = workGroupDaoImpl.getWorkGroupById(3);
		WorkGroupMember workGroupMember = workGroupMemberDaoImpl.getByUserAndWorkGroup(user, workGroup);
		System.out.println(workGroupMember.getId());
	}

}
