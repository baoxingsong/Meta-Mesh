package org.metasee.database.model;

public class MetaStormMatch {
	private String match;
	private String similarity;
	private String sampleGroup;
	private String samplePath;
	public String getMatch() {
		return match;
	}
	public void setMatch(String match) {
		this.match = match;
	}
	public String getSimilarity() {
		return similarity;
	}
	public void setSimilarity(String similarity) {
		this.similarity = similarity;
	}
	public String getSampleGroup() {
		return sampleGroup;
	}
	public void setSampleGroup(String sampleGroup) {
		this.sampleGroup = sampleGroup;
	}
	public String getSamplePath() {
		return samplePath;
	}
	public void setSamplePath(String samplePath) {
		this.samplePath = samplePath;
	}
}
