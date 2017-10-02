package org.metasee.database.action;

public class FrontPageAction extends SuperClass{
	public String index(){
		this.setWebPageTitle("A well-organized metagenomic data analysis system");
		return SUCCESS;
	}
	public String metadata_search(){
		this.setWebPageTitle("metagenome project search");
		return SUCCESS;
	}
}
