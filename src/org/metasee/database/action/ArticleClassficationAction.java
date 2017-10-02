package org.metasee.database.action;

import java.util.List;

import org.metasee.database.model.ArticleClassfication;

public class ArticleClassficationAction extends ArticleAction {
	List<ArticleClassfication> articleClassfications;
	private void builtArticleClassfication(){
		this.articleClassfication = new ArticleClassfication();
		articleClassfication.setClassName(className);
	}
	
	public String save() throws Exception{
		this.builtArticleClassfication();
		if(this.articleClassificationManager.checkArticleClassficationName(articleClassfication)){
			return "exists";
		}
		articleClassificationManager.save(articleClassfication);
		return SUCCESS;
	}
	public String deleteById() throws Exception{
		this.articleClassificationManager.deleteById(articleClassficationId);
		return SUCCESS;
	}
	public String getArticleClassficationById() throws Exception{
		articleClassificationManager.getArticleClassficationById(articleClassficationId);
		if(null==articleClassfication){
			return NONE;
		}
		return SUCCESS;
	}
	public String getArticleClassfications() throws Exception{
		articleClassificationManager.getArticleClassfications();
		return SUCCESS;
	}
	
}
