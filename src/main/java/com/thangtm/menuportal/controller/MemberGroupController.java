package com.thangtm.menuportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thangtm.menuportal.entity.MemberGroup;
import com.thangtm.menuportal.service.MemberGroupService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/membergroups"})
public class MemberGroupController {
	@Autowired
	private MemberGroupService memberGroupService;
	
	@PostMapping
	public MemberGroup Create(@RequestBody MemberGroup memberGroup) {
		return memberGroupService.create(memberGroup);
	}
	
	@GetMapping(path = {"/{id}"})
	public MemberGroup findById(@PathVariable("id") int m_seq ) {
		return memberGroupService.findByMgSeq(m_seq);
	}
	
	@PatchMapping(path = {"/{id}"})
    public MemberGroup update(@PathVariable("id") int mg_seq, @RequestBody MemberGroup memberGroup){
        memberGroup.setMgSeq(mg_seq);
        MemberGroup mgOld = memberGroupService.findByMgSeq(mg_seq);
        mgOld = memberGroup;
        return memberGroupService.update(mgOld);
    }

    @DeleteMapping(path ={"/{id}"})
    public MemberGroup delete(@PathVariable("id") int mg_seq) {
        return memberGroupService.delete(mg_seq);
    }

    @GetMapping
    public List<MemberGroup> findAll(){
        return memberGroupService.findAll();
    }
}
