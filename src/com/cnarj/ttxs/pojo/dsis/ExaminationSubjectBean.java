package com.cnarj.ttxs.pojo.dsis;

import java.io.Serializable;

/**
 * 科目分数javabean
 * @author hedan
 *
 */
public class ExaminationSubjectBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3459496534096450343L;

	private TSubject subject;//科目
	
	private Long score; //分数

	public TSubject getSubject() {
		return subject;
	}

	public void setSubject(TSubject subject) {
		this.subject = subject;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}
	
	
}
