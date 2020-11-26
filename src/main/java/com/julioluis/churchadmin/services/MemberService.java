package com.julioluis.churchadmin.services;

import com.julioluis.churchadmin.dto.ResponseDto;
import com.julioluis.churchadmin.entities.Member;

public interface MemberService {
    ResponseDto<Member> saveMember(Member member);
}
