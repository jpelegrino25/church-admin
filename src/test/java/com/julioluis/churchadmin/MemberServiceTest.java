package com.julioluis.churchadmin;

import com.julioluis.churchadmin.dto.ResponseDto;
import com.julioluis.churchadmin.entities.Member;
import com.julioluis.churchadmin.repositories.MemberRepository;
import com.julioluis.churchadmin.services.impl.MemberServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

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
}
