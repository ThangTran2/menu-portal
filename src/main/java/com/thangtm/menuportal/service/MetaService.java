package com.thangtm.menuportal.service;

import java.util.List;

import com.thangtm.menuportal.entity.Meta;

public interface MetaService {
	
	Meta create(Meta meta);
	
	Meta delete(int seq);
	
	List<Meta> findAll();
	
	Meta findByMdSeq(int seq);
	
	Meta update(Meta meta);
	
}
