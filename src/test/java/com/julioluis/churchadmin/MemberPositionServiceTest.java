package com.julioluis.churchadmin;

import com.julioluis.churchadmin.entities.MemberPosition;
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

    }

}
