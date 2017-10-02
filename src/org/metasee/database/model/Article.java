package org.metasee.database.model;

import java.util.Date;

public class Article {
	private int id;
	private String keyWord;
	private String content;
	private Date createTime;
	private int songChecked;
	private ArticleClassfication articleClassfication;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public int getSongChecked() {
		return songChecked;
	}
	public void setSongChecked(int songChecked) {
		this.songChecked = songChecked;
	}
	public ArticleClassfication getArticleClassfication() {
		return articleClassfication;
	}
	public void setArticleClassfication(ArticleClassfication articleClassfication) {
		this.articleClassfication = articleClassfication;
	}
	
}
