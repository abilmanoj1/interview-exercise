package com.abilmanoj.staffevents.controller;

import com.abilmanoj.staffevents.entity.SecurityKey;
import com.abilmanoj.staffevents.entity.Teacher;
import com.abilmanoj.staffevents.repository.SecurityRepository;
import com.abilmanoj.staffevents.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private SecurityRepository securityRepository;

    @PostMapping("/addteacher")         //API to add teacher data
    public Teacher addTeacherData(@RequestBody Teacher teacherData){
        return teacherService.addTeacherDetails(teacherData);
    }

    @GetMapping("/search-teacher/{id}")     //API to search fpr teacher data by id
    public Teacher getTeacherDataById(@PathVariable Integer id){
        return teacherService.getTeacherDetails(id);
    }

    @PostMapping("/add-security-key")
    public void addSecurityKey(){
        SecurityKey securityKey = new SecurityKey();
        securityKey.setSecurityKey("aopir-23jrt-wwerty-dekvyd");
        securityRepository.save(securityKey);
    }

}
