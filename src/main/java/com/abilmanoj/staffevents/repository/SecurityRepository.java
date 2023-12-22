package com.abilmanoj.staffevents.repository;

import com.abilmanoj.staffevents.entity.SecurityKey;
import com.abilmanoj.staffevents.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecurityRepository extends JpaRepository<SecurityKey,Integer> {
    Optional<SecurityKey> findBySecurityKey(String securityKey);
}
