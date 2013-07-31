package com.cnarj.ttxs.pojo.dsis;

public class TSubjectValue {
private  TSubject  ts;//���Կ�Ŀ
private  String    tsvalue;//�����ܷ���
public TSubjectValue() {
	super();
	// TODO Auto-generated constructor stub
}



public TSubjectValue(TSubject ts, String tsvalue) {
	super();
	this.ts = ts;
	this.tsvalue = tsvalue;
}



public TSubject getTs() {
	
	return ts;
}
public void setTs(TSubject ts) {
	this.ts = ts;
}
public String getTsvalue() {
	return tsvalue;
}
public void setTsvalue(String tsvalue) {
	this.tsvalue = tsvalue;
}

}
