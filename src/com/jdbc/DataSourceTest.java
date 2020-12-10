package com.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceTest {
    public static void main(String[] args) {
        try {
            //创建一个 C3P0
            ComboPooledDataSource dataSource=new ComboPooledDataSource();
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
            dataSource.setUser("root");
            dataSource.setPassword("bill");
            //设置初始化连接个数
            dataSource.setInitialPoolSize(20);
            //设置最大连接数
            dataSource.setMaxPoolSize(40);
            //当连接对象不够时，再次申请得连接对象个数
            dataSource.setAcquireIncrement(5);
            //设置最小连接数  空闲的最小连接数
            dataSource.setMinPoolSize(2);
            Connection  connection= dataSource.getConnection();
            System.out.println(connection);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
