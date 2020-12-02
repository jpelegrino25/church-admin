package com.julioluis.churchadmin.services.impl;

import com.julioluis.churchadmin.dto.ResponseDto;
import com.julioluis.churchadmin.entities.MemberPosition;
import com.julioluis.churchadmin.repositories.MemberPositionRepository;
import com.julioluis.churchadmin.services.MemberPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberPositionServiceImpl implements MemberPositionService {

    @Autowired
    private MemberPositionRepository memberPositionRepository;

    @Override
    public ResponseDto<List<MemberPosition>> saveAdminStaff(List<MemberPosition> memberPositions) {
        ResponseDto<List<MemberPosition>> response=new ResponseDto();
        try {
            List<MemberPosition> memberStaff=memberPositionRepository.saveAll(memberPositions);
            response.setResult(memberStaff);
            response.setSuccess(Boolean.TRUE);
            return response;
        }catch (Exception ex) {
            response.setSuccess(Boolean.FALSE);
            response.setMessage(ex.getMessage());
            return response;
        }

    }
}
