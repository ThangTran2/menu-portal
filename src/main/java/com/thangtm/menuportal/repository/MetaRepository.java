package com.thangtm.menuportal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.thangtm.menuportal.entity.Meta;

public interface MetaRepository extends CrudRepository<Meta, Integer> {
	
	void delete(Meta meta);
	
	List<Meta> findAll();
	
	Meta save(Meta meta);
	
	Meta findByMdSeq(int seq);
	
}
