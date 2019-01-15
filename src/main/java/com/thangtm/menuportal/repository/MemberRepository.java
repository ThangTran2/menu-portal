package com.thangtm.menuportal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.thangtm.menuportal.entity.Member;

public interface MemberRepository extends CrudRepository<Member, Integer> {
	void delete(Member member);
	
	List<Member> findAll();
	
	Member findByMSeq(int id);
	
	Member save(Member member);
}
