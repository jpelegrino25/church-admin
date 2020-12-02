package com.julioluis.churchadmin;

import com.julioluis.churchadmin.dto.ResponseDto;
import com.julioluis.churchadmin.entities.MemberPosition;
import com.julioluis.churchadmin.entities.MemberPositionId;
import com.julioluis.churchadmin.repositories.MemberPositionRepository;
import com.julioluis.churchadmin.services.impl.MemberPositionServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MemberPositionServiceTest {

    @Mock
    private MemberPositionRepository memberPositionRepository;
    @InjectMocks
    private MemberPositionServiceImpl memberPositionService;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveAdminStaff() {
        List<MemberPosition> memberPositions=new ArrayList<>();
        MemberPosition memberPosition=new MemberPosition();
        MemberPositionId id=new MemberPositionId();
        id.setMemberId(1L);
        id.setPositionId(1L);
        memberPosition.setMemberPositionId(id);

        memberPosition=new MemberPosition();
        MemberPositionId id2=new MemberPositionId();
        id2.setMemberId(2L);
        id2.setPositionId(2L);
        memberPosition.setMemberPositionId(id2);

        memberPositions.add(memberPosition);

        when(memberPositionRepository.saveAll(anyCollection())).thenReturn(memberPositions);
        ResponseDto<List<MemberPosition>> response =memberPositionService.saveAdminStaff(memberPositions);

        assertEquals(true,response.isSuccess());


    }

}
