package com.julioluis.churchadmin.services;

import com.julioluis.churchadmin.dto.ResponseDto;
import com.julioluis.churchadmin.entities.MemberPosition;

import java.util.List;

public interface MemberPositionService {
    ResponseDto<List<MemberPosition>> saveAdminStaff(List<MemberPosition> memberPositions);
}
