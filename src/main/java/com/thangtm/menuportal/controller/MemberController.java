package com.thangtm.menuportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thangtm.menuportal.entity.Member;
import com.thangtm.menuportal.service.MemberService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/members"})
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@PostMapping
	public Member Create(@RequestBody Member member) {
		return memberService.create(member);
	}
	
	@GetMapping(path = {"/{id}"})
	public Member findById(@PathVariable("id") int seq) {
		//System.out.println(seq);
		return memberService.findByMSeq(seq);
	}
	
	@PatchMapping(path = {"/{id}"})
    public Member update(@PathVariable("id") int m_seq, @RequestBody Member member){
		//System.out.println(m_seq);
        member.setMgSeq(m_seq);
//        Member memberOld = memberService.findByMSeq(m_seq);
//        memberOld = member;
        return memberService.update(member);
    }

    @DeleteMapping(path ={"/{id}"})
    public Member delete(@PathVariable("id") int m_seq) {
        return memberService.delete(m_seq);
    }

    @GetMapping
    public List<Member> findAll(){
        return memberService.findAll();
    }
}

