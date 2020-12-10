package com.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import sun.plugin.com.event.COMEventHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtilsTest {

    private static ComboPooledDataSource dataSource;

    static {
        dataSource = new ComboPooledDataSource("testc3p0");
    }

    public static void main(String[] args) {

        List<Student> students=findByDBUtils();
        System.out.println(students);
    }

    public static List<Student> findByDBUtils() {
        Connection connection =null;
        String sql = "select  * from t_users";
        try {
            connection = dataSource.getConnection();
            QueryRunner queryRunner=new QueryRunner();
            List<Student> students=queryRunner.query(connection,sql,new BeanListHandler<Student>(Student.class));
            Object test=queryRunner.query(connection,sql,new MyResultSetHandler());
            System.out.println(test);
            return  students;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static List<Student> findByDBUtils(Integer id) {
        Connection connection =null;
        String sql = "select  * from t_users where id=?";
        try {
            connection = dataSource.getConnection();
            QueryRunner queryRunner=new QueryRunner();
            List<Student> students=queryRunner.query(connection,sql,new BeanListHandler<Student>(Student.class ),id);
            return  students;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static List<Student> findByYuanSheng() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Student> students = new ArrayList<>();
        try {
            connection = dataSource.getConnection();
            String sql = "select  * from t_users";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            Student student =  null;
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String school = resultSet.getString(3);
                String t1 = resultSet.getString(4);
                String t2 = resultSet.getString(5);
                student = new Student(id, name, school, t1, t2);
                students.add(student);
            }
            return students;
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
        return null;
    }
}
