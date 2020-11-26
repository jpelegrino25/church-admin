package com.julioluis.churchadmin.repositories;

import com.julioluis.churchadmin.entities.MemberPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberPositionRepository extends JpaRepository<MemberPosition,Long> {
}
