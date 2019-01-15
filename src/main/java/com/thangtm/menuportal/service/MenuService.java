package com.thangtm.menuportal.service;

import java.util.List;

import com.thangtm.menuportal.entity.Menu;

public interface MenuService {
	Menu create(Menu menu);

    Menu delete(int seq);

    List<Menu> findAll();

    Menu findByMenuSeq(int seq);

    Menu update(Menu menu);
}
