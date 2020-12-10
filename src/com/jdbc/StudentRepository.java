package com.jdbc;

import javax.xml.stream.events.StartDocument;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        //使用jdbc
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
            String user = "root";
            String password = "bill";
            connection = DriverManager.getConnection(url, user, password);
            String sql = "select * from t_users";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            Student student = null;
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String school = resultSet.getString(3);
                String t1 = resultSet.getString(4);
                String t2 = resultSet.getString(5);
                student = new Student(id, name, school, t1, t2);
                students.add(student);
            }
            System.out.println(resultSet);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return students;
    }

    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
        System.out.println(studentRepository.findAll());
    }

    public void add(){

    }
}
