package com.example.classWork.repository;

import com.example.classWork.model.StudentDataModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class StudentDataRepo {
    private Map<Integer, StudentDataModel> studentDataMap;

    public StudentDataRepo() {
        studentDataMap = new HashMap<>();
    }

    public ArrayList<StudentDataModel> getStudentByUniversity(final String uni) {
        ArrayList<StudentDataModel> ans = new ArrayList<>();
        for (Map.Entry<Integer, StudentDataModel> entry : studentDataMap.entrySet()) {
            if (entry.getValue().getUniversity().equals(uni)) {
                ans.add(entry.getValue());
            }
        }
        return ans;
    }

    public StudentDataModel getStudentById(final int id) {
        return studentDataMap.getOrDefault(id, null);
    }

    public ArrayList<StudentDataModel> getAllStudents() {
        return new ArrayList<>(studentDataMap.values());
    }

    public StudentDataModel createStudent(final int id, final String name, final int age, final long adhar, final String university) {
        StudentDataModel newStudent = new StudentDataModel(name, age, adhar, university);
        studentDataMap.put(id, newStudent);
        return newStudent;
    }
}
