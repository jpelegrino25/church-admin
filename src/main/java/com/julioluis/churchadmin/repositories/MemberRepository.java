package com.julioluis.churchadmin.repositories;

import com.julioluis.churchadmin.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    List<Member> findAllByStatus(Long status);
}
