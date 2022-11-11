package com.example.ConnectionWithDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.List;

public class StudentController {

    @Autowired
    DBManager dbManagerObj;
    @GetMapping("/get_students")
    List<String>getstudents() throws SQLException {
        return dbManagerObj.getInfo();
    }

    @PostMapping("/create_student")
    public void createStudent(@RequestBody() student student) throws SQLException {
        dbManagerObj.insertInfo(student);
    }


}
