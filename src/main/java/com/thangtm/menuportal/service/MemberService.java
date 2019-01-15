package com.thangtm.menuportal.service;

import java.util.List;

import com.thangtm.menuportal.entity.Member;

public interface MemberService {
	Member create(Member member);

    Member delete(int seq);

    List<Member> findAll();

    Member findByMSeq(int seq);

    Member update(Member member);
}
