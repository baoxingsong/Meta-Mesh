package org.metasee.database.action;

import java.util.List;

import org.metasee.database.model.Article;
import org.metasee.database.model.ArticleClassfication;
import org.metasee.database.service.ArticleManager;
import org.metasee.database.service.impl.ArticleManagerImpl;
import org.metasee.database.service.ArticleClassificationManager;
import org.metasee.database.service.impl.ArticleClassificationManagerImpl;

public class ArticleAction extends SuperClass {
	int id;
	String keyWord;
	String content;
	int articleClassficationId;
	ArticleClassfication articleClassfication;
	Article article;
	ArticleManager articleManager = new ArticleManagerImpl();
	ArticleClassificationManager articleClassificationManager = new ArticleClassificationManagerImpl();
	List<Article> articles;
	String className;
	
	private void builtArticle() throws Exception{
		this.article = new Article();
		this.article.setContent(content);
		this.article.setKeyWord(keyWord);
		articleClassfication = articleClassificationManager.getArticleClassficationById(articleClassficationId);
		this.article.setArticleClassfication(articleClassfication);
	}
	
	public String save() throws Exception{
		this.builtArticle();
		if(this.articleManager.checkArticleWithKeyword(article)){
			return "exists";
		}
		articleManager.save(article);
		return SUCCESS;
	}
		
	public String getArticleByKeyword() throws Exception{
		this.article=this.articleManager.getArticleByKeyword(keyWord);
		if(null==article){
			return NONE;
		}
		return SUCCESS;
	}
	public String deleteById() throws Exception{
		this.articleManager.deleteById(id);
		return SUCCESS;
	}
	public String update() throws Exception{
		this.article = this.articleManager.getArticleById(id);
		if(null==article){
			return NONE;
		}
		this.article.setKeyWord(keyWord);
		this.article.setContent(content);
		this.articleManager.update(article);
		return SUCCESS;
	}
	public String getArticleById() throws Exception{
		this.article = this.articleManager.getArticleById(id);
		if(null==article){
			return NONE;
		}
		return SUCCESS;
	}
	public String getArticles() throws Exception{
		this.articles = articleManager.getArticles();
		return SUCCESS;
	}
	
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getArticleClassficationId() {
		return articleClassficationId;
	}
	public void setArticleClassficationId(int articleClassficationId) {
		this.articleClassficationId = articleClassficationId;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}

	public ArticleClassfication getArticleClassfication() {
		return articleClassfication;
	}

	public void setArticleClassfication(ArticleClassfication articleClassfication) {
		this.articleClassfication = articleClassfication;
	}

	public ArticleManager getArticleManager() {
		return articleManager;
	}

	public void setArticleManager(ArticleManager articleManager) {
		this.articleManager = articleManager;
	}

	public ArticleClassificationManager getArticleClassificationManager() {
		return articleClassificationManager;
	}

	public void setArticleClassificationManager(
			ArticleClassificationManager articleClassificationManager) {
		this.articleClassificationManager = articleClassificationManager;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
