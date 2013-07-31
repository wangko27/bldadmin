package com.cnarj.ttxs.pojo.dsis;

/**
 * TSchoolinfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TSchoolinfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8739964318562964647L;
	private long xxId;
	private String xxid;
	private String schName;
	private String linkman;
	private String contactphone;
	private String qqnumber;
	private long dlId;
	private String dbname;
	private String connstr;
	private long proid;
	private long cityid;
    private long  countryid;
	private String reamrks;
	private int  type;
	private int  subxxid;//用来记录后四位学校编码

	// Constructors

	/** default constructor */
	public TSchoolinfo() {
	}

	/** minimal constructor */
	public TSchoolinfo(String xxid, String schName, String linkman,
			String contactphone,String qqnumber, long dlId, String reamrks,int subxxid) {
		this.xxid = xxid;
		this.schName = schName;
		this.linkman = linkman;
		this.contactphone = contactphone;
		this.dlId = dlId;
		this.reamrks = reamrks;
		this.subxxid=subxxid;
		this.qqnumber=qqnumber;
	}

	/** full constructor */
	public TSchoolinfo(String xxid, String schName, String linkman,
			String contactphone,String qqnumber, long dlId, String dbname, String connstr,
			long proid, long cityid, String reamrks,int type,int subxxid,long countryid) {
		this.xxid = xxid;
		this.schName = schName;
		this.linkman = linkman;
		this.contactphone = contactphone;
		this.dlId = dlId;
		this.dbname = dbname;
		this.connstr = connstr;
		this.proid = proid;
		this.cityid = cityid;
		this.reamrks = reamrks;
		this.type=type;
		this.subxxid=subxxid;
		this.countryid=countryid;
		this.qqnumber=qqnumber;
	}

	// Property accessors

	public long getXxId() {
		return this.xxId;
	}

	public void setXxId(long xxId) {
		this.xxId = xxId;
	}

	public String getXxid() {
		return this.xxid;
	}

	public void setXxid(String xxid) {
		this.xxid = xxid;
	}

	public String getSchName() {
		return this.schName;
	}

	public void setSchName(String schName) {
		this.schName = schName;
	}

	public String getLinkman() {
		return this.linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getContactphone() {
		return this.contactphone;
	}

	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}

	public long getDlId() {
		return this.dlId;
	}

	public void setDlId(long dlId) {
		this.dlId = dlId;
	}

	public String getDbname() {
		return this.dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public String getConnstr() {
		return this.connstr;
	}

	public void setConnstr(String connstr) {
		this.connstr = connstr;
	}

	public long getProid() {
		return this.proid;
	}

	public void setProid(long proid) {
		this.proid = proid;
	}

	public long getCityid() {
		return this.cityid;
	}

	public void setCityid(long cityid) {
		this.cityid = cityid;
	}

	public String getReamrks() {
		return this.reamrks;
	}

	public void setReamrks(String reamrks) {
		this.reamrks = reamrks;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSubxxid() {
		return subxxid;
	}

	public void setSubxxid(int subxxid) {
		this.subxxid = subxxid;
	}

	public long getCountryid() {
		return countryid;
	}

	public void setCountryid(long countryid) {
		this.countryid = countryid;
	}

	public String getQqnumber() {
		return qqnumber;
	}

	public void setQqnumber(String qqnumber) {
		this.qqnumber = qqnumber;
	}
    
}