package com.abilmanoj.staffevents.service.implementation;

import com.abilmanoj.staffevents.entity.Teacher;
import com.abilmanoj.staffevents.repository.TeacherRepository;
import com.abilmanoj.staffevents.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherServiceImplementation implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Override
    public Teacher addTeacherDetails(Teacher teacher) {
        teacherRepository.save(teacher);        //save teacher data to repository
        return teacher;
    }

    @Override
    public Teacher getTeacherDetails(Integer teacherId) {
        Optional<Teacher> teacherData = teacherRepository.findById(teacherId);  //fid teacher data in repository by id
        if(teacherData.isPresent())
            return teacherData.get();
        return null;
    }
}
