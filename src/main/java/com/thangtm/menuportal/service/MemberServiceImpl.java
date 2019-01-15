package com.thangtm.menuportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thangtm.menuportal.entity.Member;
import com.thangtm.menuportal.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository repository;
	
	@Override
	public Member create(Member member) {
		return repository.save(member);
	}

	@Override
	public Member delete(int m_seq) {
		Member member = findByMSeq(m_seq);
		if (member != null)
			repository.delete(member);
		return member;
	}

	@Override
	public List<Member> findAll() {
		return repository.findAll();
	}

	@Override
	public Member findByMSeq(int seq) {
		return repository.findByMSeq(seq);
	}

	@Override
	public Member update(Member member) {
		return repository.save(member);
	}

}
