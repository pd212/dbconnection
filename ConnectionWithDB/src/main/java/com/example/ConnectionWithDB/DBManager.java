package com.example.ConnectionWithDB;

import org.springframework.stereotype.Component;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBManager {

    DBManager() throws SQLException{
        connection =  getConnection();
        createTable();
    }

    public static Connection connection;

    public static Connection getConnection() throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentDB","root","Pranav@13579");

        }
        return connection;
    }

    public void createTable() throws SQLException {
        String sql = "create table if not exists student_info(id INT PRIMARY KEY AUTO_INCREMENT,age INT,name VARCHAR(30))";

        Statement st = connection.createStatement();

        st.execute(sql);
       // st.executeQuery(sql);
       // st.executeUpdate(sql);


    }

    public void insertInfo(student student) throws SQLException {
        String sql = "insert into student_info(name,age) values('"+student.getName()+"',"+student.getAge()+");";

        Statement st = connection.createStatement();

        int rows = st.executeUpdate(sql);

        System.out.println("no rows affected"+rows);
    }
    public List<String> getInfo() throws SQLException {
        String sql = "select*from student_info";

        Statement st = connection.createStatement();

       ResultSet resultSet = st.executeQuery(sql);

        List<String>studentsList = new ArrayList<>();

        while(resultSet.next()){

            String str = resultSet.getString(1);
            studentsList.add(str);
        }
        return studentsList;

    }
}
