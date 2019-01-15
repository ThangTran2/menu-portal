package com.thangtm.menuportal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBER_GROUP")
public class MemberGroup {
	
	@Id
    @Column(name = "MG_SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mgSeq;
	
	@Column(name = "MG_NAME")
	private String mgName;
	
	@Column(name = "MENU_SEQ")
	private int menuSeq;
	
	@Column(name = "KXPS")
	private String kxps;
	
	@Column(name = "SG_SEQS")
	private String sqSeqs;

	public MemberGroup() {
		super();
	}

	public MemberGroup(int mgSeq, String mgName, int menuSeq, String kxps, String sqSeqs) {
		super();
		this.mgSeq = mgSeq;
		this.mgName = mgName;
		this.menuSeq = menuSeq;
		this.kxps = kxps;
		this.sqSeqs = sqSeqs;
	}

	public int getMgSeq() {
		return mgSeq;
	}

	public void setMgSeq(int mgSeq) {
		this.mgSeq = mgSeq;
	}

	public String getMgName() {
		return mgName;
	}

	public void setMgName(String mgName) {
		this.mgName = mgName;
	}

	public int getMenuSeq() {
		return menuSeq;
	}

	public void setMenuSeq(int menuSeq) {
		this.menuSeq = menuSeq;
	}

	public String getKxps() {
		return kxps;
	}

	public void setKxps(String kxps) {
		this.kxps = kxps;
	}

	public String getSqSeqs() {
		return sqSeqs;
	}

	public void setSqSeqs(String sqSeqs) {
		this.sqSeqs = sqSeqs;
	}

}
