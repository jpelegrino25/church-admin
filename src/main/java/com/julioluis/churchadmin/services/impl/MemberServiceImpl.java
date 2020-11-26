package com.julioluis.churchadmin.services.impl;

import com.julioluis.churchadmin.dto.ResponseDto;
import com.julioluis.churchadmin.entities.Member;
import com.julioluis.churchadmin.repositories.MemberRepository;
import com.julioluis.churchadmin.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public ResponseDto<Member> saveMember(Member member) {
        ResponseDto<Member> response=new ResponseDto<>();

        try {
            Member memberSaved=memberRepository.save(member);
            response.setSuccess(Boolean.TRUE);
            response.setResult(memberSaved);
            return response;

        }catch (Exception ex) {
            response.setSuccess(Boolean.FALSE);
            response.setMessage(ex.getMessage());

            return response;
        }


    }
}
