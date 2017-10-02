import static org.junit.Assert.*;

import org.junit.Test;
import org.metasee.database.action.ArticleAction;


public class ArticleActionTest {

	@Test
	public void testSave() throws Exception {
		ArticleAction articleAction = new ArticleAction();
		articleAction.setKeyWord("FAQ");
		articleAction.setContent("FAQ content");
		articleAction.save();
	}
}
