import static org.junit.Assert.*;

import org.junit.Test;
import org.metasee.database.scheduler.MultipleThreadRun;


public class TestMultipleThreadRun {

	@Test
	public void test() {
		MultipleThreadRun multipleThreadRun = new MultipleThreadRun();
		multipleThreadRun.run();
	}

}
