package com.cnarj.ttxs.web.actions.learn;

import com.cnarj.ttxs.web.actions.base.PageAction;

@SuppressWarnings("serial")
public class LearnTopAction extends PageAction {

	private int subjectCodeID;
	private String keyword;
	public int getSubjectCodeID() {
		return subjectCodeID;
	}
	public void setSubjectCodeID(int subjectCodeID) {
		this.subjectCodeID = subjectCodeID;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String select(){
		
		return SUCCESS;
	}
}
