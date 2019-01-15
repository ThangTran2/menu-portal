package com.thangtm.menuportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thangtm.menuportal.entity.MemberGroup;
import com.thangtm.menuportal.repository.MemberGroupRepository;

@Service
public class MemberGroupServiceImpl implements MemberGroupService{
	@Autowired
	private MemberGroupRepository repository;
	@Override
	public MemberGroup create(MemberGroup memberGroup) {
		return repository.save(memberGroup);
	}

	@Override
	public MemberGroup delete(int seq) {
		MemberGroup memberGroup = findByMgSeq(seq);
		if(memberGroup != null) 
			repository.delete(memberGroup);
		return memberGroup;
	}

	@Override
	public List<MemberGroup> findAll() {
		return repository.findAll();
	}

	@Override
	public MemberGroup findByMgSeq(int seq) {
		return repository.findByMgSeq(seq);
	}

	@Override
	public MemberGroup update(MemberGroup memberGroup) {
		return repository.save(memberGroup);
	}
}
