package com.julioluis.churchadmin.controllers;

import com.julioluis.churchadmin.dto.RequestDto;
import com.julioluis.churchadmin.dto.ResponseDto;
import com.julioluis.churchadmin.entities.MemberPosition;
import com.julioluis.churchadmin.services.MemberPositionService;
import com.julioluis.churchadmin.utils.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("memberpositions")
public class MemberPositionController {

    @Autowired
    private MemberPositionService memberPositionService;

    @PostMapping
    public ResponseEntity<ResponseDto<List<MemberPosition>>>
    saveStaff(@Valid @RequestBody RequestDto<List<MemberPosition>> request) {
        ResponseDto<List<MemberPosition>> response=memberPositionService.saveAdminStaff(request.getEntity());
        if(response.isSuccess()) {
            return ResponseEntity.ok().body(response);
        }
        throw new UserException(response.getMessage());
    }
}
