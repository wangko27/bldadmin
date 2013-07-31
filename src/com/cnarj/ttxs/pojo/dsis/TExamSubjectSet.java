package com.cnarj.ttxs.pojo.dsis;

/**
 * TExamSubjectSet entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TExamSubjectSet implements java.io.Serializable {

	// Fields

	private long examSubId;
	private long examId;
	private long njId;
	private String subidStr;
	private String subjectScoring;
	private long totalScoremodel;
	private String countSubjectOne;
	private String totalModelOne;
	private String countSubjectTwo;
	private String totalModelTwo;
	private String countSubjectThree;
	private String totalModelThree;
	private String countSubjectFour;
	private String totalModelFour;
	private String countSubjectFine;
	private String totalModelFine;
	private long operState;
	private String xxid;

	// Constructors

	/** default constructor */
	public TExamSubjectSet() {
	}

	/** minimal constructor */
	public TExamSubjectSet(long examId, long njId, String subidStr,
			long totalScoremodel, String countSubjectOne, String totalModelOne,
			String countSubjectTwo) {
		this.examId = examId;
		this.njId = njId;
		this.subidStr = subidStr;
		this.totalScoremodel = totalScoremodel;
		this.countSubjectOne = countSubjectOne;
		this.totalModelOne = totalModelOne;
		this.countSubjectTwo = countSubjectTwo;
	}

	/** full constructor */
	public TExamSubjectSet(long examId, long njId, String subidStr,
			String subjectScoring, long totalScoremodel,
			String countSubjectOne, String totalModelOne,
			String countSubjectTwo, String totalModelTwo,
			String countSubjectThree, String totalModelThree,
			String countSubjectFour, String totalModelFour,
			String countSubjectFine, String totalModelFine, long operState,
			String xxid) {
		this.examId = examId;
		this.njId = njId;
		this.subidStr = subidStr;
		this.subjectScoring = subjectScoring;
		this.totalScoremodel = totalScoremodel;
		this.countSubjectOne = countSubjectOne;
		this.totalModelOne = totalModelOne;
		this.countSubjectTwo = countSubjectTwo;
		this.totalModelTwo = totalModelTwo;
		this.countSubjectThree = countSubjectThree;
		this.totalModelThree = totalModelThree;
		this.countSubjectFour = countSubjectFour;
		this.totalModelFour = totalModelFour;
		this.countSubjectFine = countSubjectFine;
		this.totalModelFine = totalModelFine;
		this.operState = operState;
		this.xxid = xxid;
	}

	// Property accessors

	public long getExamSubId() {
		return this.examSubId;
	}

	public void setExamSubId(long examSubId) {
		this.examSubId = examSubId;
	}

	public long getExamId() {
		return this.examId;
	}

	public void setExamId(long examId) {
		this.examId = examId;
	}

	public long getNjId() {
		return this.njId;
	}

	public void setNjId(long njId) {
		this.njId = njId;
	}

	public String getSubidStr() {
		return this.subidStr;
	}

	public void setSubidStr(String subidStr) {
		this.subidStr = subidStr;
	}

	public String getSubjectScoring() {
		return this.subjectScoring;
	}

	public void setSubjectScoring(String subjectScoring) {
		this.subjectScoring = subjectScoring;
	}

	public long getTotalScoremodel() {
		return this.totalScoremodel;
	}

	public void setTotalScoremodel(long totalScoremodel) {
		this.totalScoremodel = totalScoremodel;
	}

	public String getCountSubjectOne() {
		return this.countSubjectOne;
	}

	public void setCountSubjectOne(String countSubjectOne) {
		this.countSubjectOne = countSubjectOne;
	}

	public String getTotalModelOne() {
		return this.totalModelOne;
	}

	public void setTotalModelOne(String totalModelOne) {
		this.totalModelOne = totalModelOne;
	}

	public String getCountSubjectTwo() {
		return this.countSubjectTwo;
	}

	public void setCountSubjectTwo(String countSubjectTwo) {
		this.countSubjectTwo = countSubjectTwo;
	}

	public String getTotalModelTwo() {
		return this.totalModelTwo;
	}

	public void setTotalModelTwo(String totalModelTwo) {
		this.totalModelTwo = totalModelTwo;
	}

	public String getCountSubjectThree() {
		return this.countSubjectThree;
	}

	public void setCountSubjectThree(String countSubjectThree) {
		this.countSubjectThree = countSubjectThree;
	}

	public String getTotalModelThree() {
		return this.totalModelThree;
	}

	public void setTotalModelThree(String totalModelThree) {
		this.totalModelThree = totalModelThree;
	}

	public String getCountSubjectFour() {
		return this.countSubjectFour;
	}

	public void setCountSubjectFour(String countSubjectFour) {
		this.countSubjectFour = countSubjectFour;
	}

	public String getTotalModelFour() {
		return this.totalModelFour;
	}

	public void setTotalModelFour(String totalModelFour) {
		this.totalModelFour = totalModelFour;
	}

	public String getCountSubjectFine() {
		return this.countSubjectFine;
	}

	public void setCountSubjectFine(String countSubjectFine) {
		this.countSubjectFine = countSubjectFine;
	}

	public String getTotalModelFine() {
		return this.totalModelFine;
	}

	public void setTotalModelFine(String totalModelFine) {
		this.totalModelFine = totalModelFine;
	}

	public long getOperState() {
		return this.operState;
	}

	public void setOperState(long operState) {
		this.operState = operState;
	}

	public String getXxid() {
		return this.xxid;
	}

	public void setXxid(String xxid) {
		this.xxid = xxid;
	}

}