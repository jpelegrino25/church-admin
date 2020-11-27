package com.julioluis.churchadmin.controllers;

import com.julioluis.churchadmin.dto.ResponseDto;
import com.julioluis.churchadmin.entities.Member;
import com.julioluis.churchadmin.services.MemberService;
import com.julioluis.churchadmin.utils.BusinessException;
import com.julioluis.churchadmin.utils.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping(path = "status/{status}")
    public ResponseEntity<ResponseDto<List<Member>>> getAllMember(@PathVariable(name = "status") Long status) {
        ResponseDto<List<Member>> response=memberService.findAll(status);
        if(response.isSuccess()) {
            return ResponseEntity.ok().body(response);
        }
        throw new UserException(response.getMessage());
    }

    @PostMapping
    public ResponseEntity<ResponseDto<Void>> saveMember(@Valid @RequestBody Member member) {
        ResponseDto<Member> response=memberService.saveMember(member);
        if(response.isSuccess()){
            URI uri= ServletUriComponentsBuilder.fromCurrentRequestUri()
                    .path("/{id}").buildAndExpand(response.getResult().getId()).toUri();
            return ResponseEntity.created(uri).build();
        }

        throw  new UserException(response.getMessage());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ResponseDto<Member>> getMemberById(@PathVariable(name = "id") Long id) {
       try {
           ResponseDto<Member> response=memberService.findMemberById(id);
           return ResponseEntity.ok().body(response);
       }catch (BusinessException ex){
           throw new UserException(ex.getMessage());
       }

    }

    @PutMapping(path = "{id}")
    public ResponseEntity<ResponseDto<Member>> unLinkMember(@PathVariable(name = "id") Long id) {
        ResponseDto<Member> response=memberService.unLinkMember(id);
        if(response.isSuccess()) {
            return ResponseEntity.ok().body(response);
        }
        throw new UserException(response.getMessage());
    }
}
