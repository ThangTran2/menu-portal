package com.thangtm.menuportal.entity;

import java.nio.charset.StandardCharsets;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="META")
public class Meta {
	
	@Id
	@Column(name = "MD_SEQ")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long mdSeq;
	
	@Column(name = "D_SEQ")
	private long dSeq;
	
	@Column(name = "MD_PSEQ")
	private long mdPSeq;
	
	@Column(name = "MD_DATE")
	private String mdDate;
	
	@Column(name = "S_SEQ")
	private long sSeq;
	
	@Column(name = "MD_SITENAME")
	private String mdSiteName;
	
	@Column(name = "MD_MENUNAME")
	private String mdMenuName;
	
	@Column(name = "MD_TITLE")
	private String mdTitle;
	
	@Column(name = "MD_URL")
	private String mdURL;
	
	@Column(name = "MD_SAME_COUNT")
	private int mdSameCount;
	
	@Column(name = "MD_ISSUE_YN")
	private int mdIssueYN;

	
	public Meta() {
		super();
	}


	public long getMdSeq() {
		return mdSeq;
	}


	public void setMdSeq(long mdSeq) {
		this.mdSeq = mdSeq;
	}


	public long getdSeq() {
		return dSeq;
	}


	public void setdSeq(long dSeq) {
		this.dSeq = dSeq;
	}


	public long getMdPSeq() {
		return mdPSeq;
	}


	public void setMdPSeq(long mdPSeq) {
		this.mdPSeq = mdPSeq;
	}


	public long getsSeq() {
		return sSeq;
	}


	public void setsSeq(long sSeq) {
		this.sSeq = sSeq;
	}


	public String getMdSiteName() {
		return mdSiteName;
	}


	public void setMdSiteName(String mdSiteName) {
		byte[] byteToChange = mdSiteName.getBytes(StandardCharsets.UTF_8);
		this.mdSiteName = new String( byteToChange, StandardCharsets.UTF_8 );
	}


	public String getMdMenuName() {
		return mdMenuName;
	}


	public void setMdMenuName(String mdMenuName) {
		byte[] byteToChange = mdMenuName.getBytes(StandardCharsets.UTF_8);
		this.mdMenuName = new String( byteToChange, StandardCharsets.UTF_8 );
	}


	public String getMdTitle() {
		return mdTitle;
	}


	public void setMdTitle(String mdTitle) {
		byte[] byteToChange = mdTitle.getBytes(StandardCharsets.UTF_8);
		this.mdTitle = new String( byteToChange, StandardCharsets.UTF_8 );
	}


	public String getMdURL() {
		return mdURL;
	}


	public void setMdURL(String mdURL) {
		this.mdURL = mdURL;
	}


	public int getMdSameCount() {
		return mdSameCount;
	}


	public void setMdSameCount(int mdSameCount) {
		this.mdSameCount = mdSameCount;
	}


	public int getMdIssueYN() {
		return mdIssueYN;
	}


	public void setMdIssueYN(int mdIssueYN) {
		this.mdIssueYN = mdIssueYN;
	}


	public String getMdDate() {
		return mdDate;
	}


	public void setMdDate(String mdDate) {
		this.mdDate = mdDate;
	}
	
	
}
