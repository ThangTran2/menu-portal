package com.thangtm.menuportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thangtm.menuportal.entity.Meta;
import com.thangtm.menuportal.repository.MetaRepository;

@Service
public class MetaServiceImpl implements MetaService {

	@Autowired
	private MetaRepository repository;
	
	@Override
	public Meta create(Meta meta) {
		return repository.save(meta);
	}

	@Override
	public Meta delete(int seq) {
		Meta meta = findByMdSeq(seq);
		if(meta != null)
			repository.delete(meta);
		return meta;
	}

	@Override
	public List<Meta> findAll() {
		return repository.findAll();
	}

	@Override
	public Meta findByMdSeq(int seq) {
		return repository.findByMdSeq(seq);
	}

	@Override
	public Meta update(Meta meta) {
		return repository.save(meta);
	}

}
