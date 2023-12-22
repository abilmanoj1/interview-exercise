package com.abilmanoj.staffevents.repository;

import com.abilmanoj.staffevents.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    Optional<Teacher> findByTeacherEmail(String teacherEmail);
}
