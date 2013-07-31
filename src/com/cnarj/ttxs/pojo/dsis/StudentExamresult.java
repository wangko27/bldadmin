package com.cnarj.ttxs.pojo.dsis;

import java.util.List;

/**
 * StudentExamresult entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class StudentExamresult implements java.io.Serializable {

	// Fields

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	private long cjId;
	private TExamination TExamination;
	private TStugrade TStugrade;
	private TStudent TStudent;
	private TClasses TClasses;
	private Float cj1;
	private Float cj2;
	private Float cj3;
	private Float cj4;
	private Float cj5;
	private Float cj6;
	private Float cj7;
	private Float cj8;
	private Float cj9;
	private Float cj10;
	private Float cj11;
	private Float cj12;
	private Float cj13;
	private Float cj14;
	private Float cj15;
	private Float cj16;
	private Float cj17;
	private Float cj18;
	private Float cj19;
	private Float cj20;
	private Float totalScore;
	private Long totalScoreOne;
	private Long totalScoreTwo;
	private Float averageScore;
	private Float alltotalScore;
	private Long  njRank;
	private Long  classRank;
	private String xxid;
	private List<ExaminationSubjectBean> listExamSubject;
	// Constructors

	/** default constructor */
	public StudentExamresult() {
	}
    
	
	
	
	public StudentExamresult(long cjId, TExamination examination,
			TStugrade stugrade, TStudent student, TClasses classes, Float cj1,
			Float cj2, Float cj3, Float cj4, Float cj5, Float cj6, Float cj7,
			Float cj8, Float cj9, Float cj10, Float cj11, Float cj12,
			Float cj13, Float cj14, Float cj15, Float cj16, Float cj17,
			Float cj18, Float cj19, Float cj20, Float totalScore,
			Long totalScoreOne, Long totalScoreTwo, Float averageScore,
			Float alltotalScore, Long  njRank, Long  classRank, String xxid) {
		super();
		this.cjId = cjId;
		TExamination = examination;
		TStugrade = stugrade;
		TStudent = student;
		TClasses = classes;
		this.cj1 = cj1;
		this.cj2 = cj2;
		this.cj3 = cj3;
		this.cj4 = cj4;
		this.cj5 = cj5;
		this.cj6 = cj6;
		this.cj7 = cj7;
		this.cj8 = cj8;
		this.cj9 = cj9;
		this.cj10 = cj10;
		this.cj11 = cj11;
		this.cj12 = cj12;
		this.cj13 = cj13;
		this.cj14 = cj14;
		this.cj15 = cj15;
		this.cj16 = cj16;
		this.cj17 = cj17;
		this.cj18 = cj18;
		this.cj19 = cj19;
		this.cj20 = cj20;
		this.totalScore = totalScore;
		this.totalScoreOne = totalScoreOne;
		this.totalScoreTwo = totalScoreTwo;
		this.averageScore = averageScore;
		this.alltotalScore = alltotalScore;
		this.njRank = njRank;
		this.classRank = classRank;
		this.xxid = xxid;
	}




	public long getCjId() {
		return cjId;
	}

	public void setCjId(long cjId) {
		this.cjId = cjId;
	}

	public TExamination getTExamination() {
		return TExamination;
	}

	public void setTExamination(TExamination examination) {
		TExamination = examination;
	}

	public TStugrade getTStugrade() {
		return TStugrade;
	}

	public void setTStugrade(TStugrade stugrade) {
		TStugrade = stugrade;
	}

	public TStudent getTStudent() {
		return TStudent;
	}

	public void setTStudent(TStudent student) {
		TStudent = student;
	}

	public TClasses getTClasses() {
		return TClasses;
	}

	public void setTClasses(TClasses classes) {
		TClasses = classes;
	}

	public Float getCj1() {
		return cj1;
	}

	public void setCj1(Float cj1) {
		this.cj1 = cj1;
	}

	public Float getCj2() {
		return cj2;
	}

	public void setCj2(Float cj2) {
		this.cj2 = cj2;
	}

	public Float getCj3() {
		return cj3;
	}

	public void setCj3(Float cj3) {
		this.cj3 = cj3;
	}

	public Float getCj4() {
		return cj4;
	}

	public void setCj4(Float cj4) {
		this.cj4 = cj4;
	}

	public Float getCj5() {
		return cj5;
	}

	public void setCj5(Float cj5) {
		this.cj5 = cj5;
	}

	public Float getCj6() {
		return cj6;
	}

	public void setCj6(Float cj6) {
		this.cj6 = cj6;
	}

	public Float getCj7() {
		return cj7;
	}

	public void setCj7(Float cj7) {
		this.cj7 = cj7;
	}

	public Float getCj8() {
		return cj8;
	}

	public void setCj8(Float cj8) {
		this.cj8 = cj8;
	}

	public Float getCj9() {
		return cj9;
	}

	public void setCj9(Float cj9) {
		this.cj9 = cj9;
	}

	public Float getCj10() {
		return cj10;
	}

	public void setCj10(Float cj10) {
		this.cj10 = cj10;
	}

	public Float getCj11() {
		return cj11;
	}

	public void setCj11(Float cj11) {
		this.cj11 = cj11;
	}

	public Float getCj12() {
		return cj12;
	}

	public void setCj12(Float cj12) {
		this.cj12 = cj12;
	}

	public Float getCj13() {
		return cj13;
	}

	public void setCj13(Float cj13) {
		this.cj13 = cj13;
	}

	public Float getCj14() {
		return cj14;
	}

	public void setCj14(Float cj14) {
		this.cj14 = cj14;
	}

	public Float getCj15() {
		return cj15;
	}

	public void setCj15(Float cj15) {
		this.cj15 = cj15;
	}

	public Float getCj16() {
		return cj16;
	}

	public void setCj16(Float cj16) {
		this.cj16 = cj16;
	}

	public Float getCj17() {
		return cj17;
	}

	public void setCj17(Float cj17) {
		this.cj17 = cj17;
	}

	public Float getCj18() {
		return cj18;
	}

	public void setCj18(Float cj18) {
		this.cj18 = cj18;
	}

	public Float getCj19() {
		return cj19;
	}

	public void setCj19(Float cj19) {
		this.cj19 = cj19;
	}

	public Float getCj20() {
		return cj20;
	}

	public void setCj20(Float cj20) {
		this.cj20 = cj20;
	}

	public Float getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Float totalScore) {
		this.totalScore = totalScore;
	}

	public Long getTotalScoreOne() {
		return totalScoreOne;
	}

	public void setTotalScoreOne(Long totalScoreOne) {
		this.totalScoreOne = totalScoreOne;
	}

	public Long getTotalScoreTwo() {
		return totalScoreTwo;
	}

	public void setTotalScoreTwo(Long totalScoreTwo) {
		this.totalScoreTwo = totalScoreTwo;
	}

	public Float getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(Float averageScore) {
		this.averageScore = averageScore;
	}

	public String getXxid() {
		return xxid;
	}

	public void setXxid(String xxid) {
		this.xxid = xxid;
	}

	public Float getAlltotalScore() {
		return alltotalScore;
	}
	public void setAlltotalScore(Float alltotalScore) {
		this.alltotalScore = alltotalScore;
	}
	
	public Long getNjRank() {
		return njRank;
	}

	public void setNjRank(Long njRank) {
		this.njRank = njRank;
	}

	public Long getClassRank() {
		return classRank;
	}

	public void setClassRank(Long classRank) {
		this.classRank = classRank;
	}

	public List<ExaminationSubjectBean> getListExamSubject() {
		return listExamSubject;
	}

	public void setListExamSubject(List<ExaminationSubjectBean> listExamSubject) {
		this.listExamSubject = listExamSubject;
	}
	
}