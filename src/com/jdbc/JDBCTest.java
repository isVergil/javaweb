package com.jdbc;

import javax.sql.DataSource;
import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) {
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
            String user = "root";
            String password = "bill";
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection);
            //创建 statement 对象，执行sql语句
            //String sql = "insert into t_users(name,school,t1,t2) values('周六','清华大学','','')";
            String sql = "select * from t_users";
            System.out.println(sql);
            Statement statement = connection.createStatement();
            //int result= statement.executeUpdate()
            ResultSet resultSet = statement.executeQuery(sql);
            //System.out.println(result);
            //ResultSet resultSet=statement.getResultSet();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String school = resultSet.getString(3);
                System.out.println(name + "-" + school);
            }
            System.out.println(resultSet);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
