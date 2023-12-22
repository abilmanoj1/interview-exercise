package com.abilmanoj.staffevents.service;

import com.abilmanoj.staffevents.entity.Teacher;

public interface TeacherService {
    Teacher addTeacherDetails(Teacher teacher);
    Teacher getTeacherDetails(Integer teacherId);
}
