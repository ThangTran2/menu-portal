package com.thangtm.menuportal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MENU")
public class Menu {
	@Id
    @Column(name = "MENU_SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuSeq;
	
	@Column(name = "MENU_NAME")
	private String menuName;

	public Menu() {
		super();
	}

	public Menu(int menuSeq, String menuName) {
		super();
		this.menuSeq = menuSeq;
		this.menuName = menuName;
	}

	public int getMenuSeq() {
		return menuSeq;
	}

	public void setMenuSeq(int menuSeq) {
		this.menuSeq = menuSeq;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	
}
