package com.example.classWork.resource;

import com.example.classWork.model.StudentDataModel;
import com.example.classWork.repository.StudentDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/student")
public class Student {
    @Autowired
    private StudentDataRepo studentRepo;
    @GetMapping("/get/{university}")
    public ArrayList<StudentDataModel> getUniversity(@PathVariable String uni) throws Exception{
        ArrayList<StudentDataModel> studentDataModel = studentRepo.getStudentByUniversity(uni);
        return studentDataModel;
    }

    @PostMapping("/create/{name}/{age}/{adhar}/{university}")
    public StudentDataModel createStudent(@PathVariable String name, @PathVariable int age, @PathVariable long adhar, @PathVariable String University){
        int id = Integer.parseInt(UUID.randomUUID().toString());
        return studentRepo.createStudent(id,name,age,adhar,University);
    }
    @GetMapping("/get/allstudents")
    public ArrayList<StudentDataModel> getAllStudents(){
        return studentRepo.getAllStudents();
    }
    @GetMapping("/get/student/{id}")
    public StudentDataModel getStudent(@PathVariable int id){
        return studentRepo.getStudentById(id);
    }


}
