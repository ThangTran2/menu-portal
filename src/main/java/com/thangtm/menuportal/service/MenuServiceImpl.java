package com.thangtm.menuportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thangtm.menuportal.entity.Menu;
import com.thangtm.menuportal.repository.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
	private MenuRepository repository;
	
	@Override
	public Menu create(Menu menu) {
		return repository.save(menu);
	}

	@Override
	public Menu delete(int seq) {
		Menu menu = findByMenuSeq(seq);
		if(menu != null)
			repository.delete(menu);
		return menu;
	}

	@Override
	public List<Menu> findAll() {
		return repository.findAll();
	}

	@Override
	public Menu findByMenuSeq(int seq) {
		return repository.findByMenuSeq(seq);
	}

	@Override
	public Menu update(Menu menu) {
		return repository.save(menu);
	}

}
