package com.jdbc;

import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyResultSetHandler implements ResultSetHandler {
    @Override
    public Object handle(ResultSet resultSet) throws SQLException {
        return "helloworld";
    }
}
