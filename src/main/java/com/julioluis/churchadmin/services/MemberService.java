package com.julioluis.churchadmin.services;

import com.julioluis.churchadmin.dto.ResponseDto;
import com.julioluis.churchadmin.entities.Member;
import com.julioluis.churchadmin.utils.BusinessException;

import java.util.List;

public interface MemberService {
    ResponseDto<Member> saveMember(Member member);

    ResponseDto<List<Member>> findAll(Long status);

    ResponseDto<Member> unLinkMember(Long member);

    ResponseDto<Member> findMemberById(Long id) throws BusinessException;
}
