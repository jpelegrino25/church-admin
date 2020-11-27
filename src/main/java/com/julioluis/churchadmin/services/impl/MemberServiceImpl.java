package com.julioluis.churchadmin.services.impl;

import com.julioluis.churchadmin.dto.ResponseDto;
import com.julioluis.churchadmin.entities.Member;
import com.julioluis.churchadmin.enums.StatusEnum;
import com.julioluis.churchadmin.repositories.MemberRepository;
import com.julioluis.churchadmin.services.MemberService;
import com.julioluis.churchadmin.utils.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public ResponseDto<Member> saveMember(Member member) {
        ResponseDto<Member> response=new ResponseDto<>();
        member.setStartDate(new Date());

        if(Objects.isNull(member.getStatus()))
        member.setStatus(StatusEnum.ACTIVE.getStatus());

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

    @Override
    public ResponseDto<List<Member>> findAll(Long status) {
        ResponseDto<List<Member>> response=new ResponseDto<>();

        try{
            List<Member> members=memberRepository.findAllByStatus(status);
            response.setResult(members);
            response.setSuccess(Boolean.TRUE);
            return response;
        }catch (Exception ex) {
            response.setSuccess(Boolean.FALSE);
            response.setMessage(ex.getMessage());
            return response;
        }

    }

    @Override
    public ResponseDto<Member> unLinkMember(Long memberId)  {
        ResponseDto<Member> response=new ResponseDto<>();
        try {
            ResponseDto<Member> memberResponse=this.findMemberById(memberId);
            memberResponse.getResult().setEndDate(new Date());
            memberResponse.getResult().setStatus(StatusEnum.INACTIVE.getStatus());
            Member memberUpdate=memberRepository.save(memberResponse.getResult());

            response.setResult(memberUpdate);
            response.setSuccess(Boolean.TRUE);
            return response;
        } catch (BusinessException ex) {
            response.setSuccess(Boolean.FALSE);
            response.setMessage(ex.getMessage());
            return response;
        }catch (Exception ex) {
            response.setSuccess(Boolean.FALSE);
            response.setMessage(ex.getMessage());
            return response;
        }

    }

    @Override
    public ResponseDto<Member> findMemberById(Long id)throws BusinessException {
        ResponseDto<Member> response=new ResponseDto<>();
        Optional<Member> member=memberRepository.findById(id);
        if(member.isPresent()) {
            response.setResult(member.get());
            response.setSuccess(Boolean.TRUE);
            return response;
        }
        throw new BusinessException("There is any row store with that id "+ id);
    }
}
