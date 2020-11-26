package com.julioluis.churchadmin.repositories;

import com.julioluis.churchadmin.entities.MoneyRaise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyRaiseRepository extends JpaRepository<MoneyRaise,Long> {
}
