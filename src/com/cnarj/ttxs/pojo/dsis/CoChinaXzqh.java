package com.cnarj.ttxs.pojo.dsis;

/**
 * 区域实体类
 * 
 * @author 唐其
 * 
 */
public class CoChinaXzqh implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String bm;// 编码
	private String jc;// 简称
	private String mc;// 名称
	private String mj;// 面积
	private String rk;// 人口
	private String yzbm;// 邮政编码
	private String qh;// 区号

	public CoChinaXzqh() {
		super();
	}

	public CoChinaXzqh(Long id, String bm, String jc, String mc, String mj,
			String rk, String yzbm, String qh) {
		super();
		this.id = id;
		this.bm = bm;
		this.jc = jc;
		this.mc = mc;
		this.mj = mj;
		this.rk = rk;
		this.yzbm = yzbm;
		this.qh = qh;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBm() {
		return bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}

	public String getJc() {
		return jc;
	}

	public void setJc(String jc) {
		this.jc = jc;
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getMj() {
		return mj;
	}

	public void setMj(String mj) {
		this.mj = mj;
	}

	public String getRk() {
		return rk;
	}

	public void setRk(String rk) {
		this.rk = rk;
	}

	public String getYzbm() {
		return yzbm;
	}

	public void setYzbm(String yzbm) {
		this.yzbm = yzbm;
	}

	public String getQh() {
		return qh;
	}

	public void setQh(String qh) {
		this.qh = qh;
	}
}
