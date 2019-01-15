package com.thangtm.menuportal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.thangtm.menuportal.entity.Menu;

public interface MenuRepository extends CrudRepository<Menu, Integer>{
	void delete(Menu menu);
	
	List<Menu> findAll();
	
	Menu save(Menu menu);
	
	Menu findByMenuSeq(int seq);
}
