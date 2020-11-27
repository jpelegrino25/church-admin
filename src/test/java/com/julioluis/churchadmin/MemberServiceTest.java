package com.julioluis.churchadmin;

import com.julioluis.churchadmin.dto.ResponseDto;
import com.julioluis.churchadmin.entities.Member;
import com.julioluis.churchadmin.repositories.MemberRepository;
import com.julioluis.churchadmin.services.impl.MemberServiceImpl;
import com.julioluis.churchadmin.utils.BusinessException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MemberServiceTest {
    @Mock
    private MemberRepository memberRepository;
    @InjectMocks
    private MemberServiceImpl memberService;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveMember() {

        Member member=new Member();

        when(memberRepository.save(any())).thenReturn(member);
        ResponseDto<Member> response=memberService.saveMember(member);

        assertEquals(true,response.isSuccess());
        verify(memberRepository).save(any());

    }

    @Test
    public void testFindAll() {
        List<Member> members= Arrays.asList(new Member());
        Long status=1L;
        when(memberRepository.findAllByStatus(anyLong())).thenReturn(members);

        ResponseDto<List<Member>> response=memberService.findAll(status);

        assertEquals(true,response.isSuccess());
        verify(memberRepository).findAllByStatus(anyLong());
    }

    @Test
    public void testUnLinkMember() {
        Member member=new Member();
        member.setEndDate(new Date());
        member.setStatus(0L);
        Optional<Member> optionalMember=Optional.of(member);
        Long id=1L;

        when(memberRepository.findById(anyLong())).thenReturn(optionalMember);
        when(memberRepository.save(any())).thenReturn(member);
        ResponseDto<Member> response=memberService.unLinkMember(id);

        assertEquals(true,response.isSuccess());
        assertNotNull(response.getResult().getEndDate());
        assertEquals(0,response.getResult().getStatus());

        verify(memberRepository).save(any());

    }

    @Test
    public void testFindById() throws BusinessException {
        Long id=1L;
        Member member=new Member();
        Optional<Member> optionalMember=Optional.of(member);
        when(memberRepository.findById(anyLong())).thenReturn(optionalMember);

        ResponseDto<Member> response=memberService.findMemberById(id);
        assertEquals(true,response.isSuccess());
        verify(memberRepository).findById(anyLong());
    }
}
