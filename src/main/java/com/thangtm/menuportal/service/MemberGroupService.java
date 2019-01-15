package com.thangtm.menuportal.service;

import java.util.List;

import com.thangtm.menuportal.entity.MemberGroup;

public interface MemberGroupService {
	MemberGroup create(MemberGroup memberGroup);

    MemberGroup delete(int seq);

    List<MemberGroup> findAll();

    MemberGroup findByMgSeq(int seq);

    MemberGroup update(MemberGroup memberGroup);
}
