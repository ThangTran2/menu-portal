package com.thangtm.menuportal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.thangtm.menuportal.entity.MemberGroup;

public interface MemberGroupRepository extends CrudRepository<MemberGroup, Integer> {
	void delete(MemberGroup member);
	
	List<MemberGroup> findAll();
	
	MemberGroup save(MemberGroup member);
	
	MemberGroup findByMgSeq(int id);
}
