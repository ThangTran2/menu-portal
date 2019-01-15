package com.thangtm.menuportal.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "MEMBER")
public class Member {
	@Id
    @Column(name = "M_SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mSeq;
	
	@Column(name = "M_NAME")
	private String mName;
	
	@Column(name = "M_ID")
	private String mId;
	
	@Column(name = "M_PASS")
	private String mPass;
	
	@Column(name = "M_USEYN")
	private int mUseyn;
	
	@Column(name = "M_REGDATE")
	private String mRegDate;
	
	@Column(name = "MG_Seq")
	private int mgSeq;

	public Member() {
		super();
	}
	
	
	
	public Member(int mSeq, String mName, String mId, String mPass, int mUseyn, String mRegDate, int mgSeq) {
		super();
		this.mSeq = mSeq;
		this.mName = mName;
		this.mId = mId;
		this.mPass = mPass;
		this.mUseyn = mUseyn;
		this.mRegDate = mRegDate;
		this.mgSeq = mgSeq;
	}

	public int getmSeq() {
		return mSeq;
	}

	public void setmSeq(int mSeq) {
		this.mSeq = mSeq;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmPass() {
		return mPass;
	}

	public void setmPass(String mPass) {
		this.mPass = mPass;
	}

	public int getmUseyn() {
		return mUseyn;
	}

	public void setmUseyn(int mUseyn) {
		this.mUseyn = mUseyn;
	}

	public String getmRegDate() {
		return mRegDate;
	}

	public void setmRegDate(String mRegDate) {
		this.mRegDate = mRegDate;
	}

	public int getMgSeq() {
		return mgSeq;
	}

	public void setMgSeq(int mgSeq) {
		this.mgSeq = mgSeq;
	}
	
//	public Member(int mSeq, String mName, String mId, String mPass, int mUseyn, int mgSeq) {
//		super();
//		this.mSeq = mSeq;
//		this.mName = mName;
//		this.mId = mId;
//		this.mPass = mPass;
//		this.mUseyn = mUseyn;
//		this.mgSeq = mgSeq;
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//		Date date = new Date();
//		regDate = dateFormat.format(date);
//	}

}
