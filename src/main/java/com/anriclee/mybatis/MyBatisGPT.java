package com.anriclee.mybatis;

import cn.hutool.core.util.StrUtil;

import java.sql.*;

public class MyBatisGPT {
    public static void generate(String host, String schema, String tableName, String username, String password) throws SQLException, ClassNotFoundException {
        String driverClassName = "com.mysql.cj.jdbc.Driver";
        String url = String.format("jdbc:mysql://%s/%s?characterEncoding=utf-8&serverTimezone=Asia/Shanghai", host, schema);
        String query = String.format("SELECT COLUMN_NAME,COLUMN_COMMENT FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = '%s' AND TABLE_NAME = '%s';", schema, tableName);
        // Load driver class
        Class.forName(driverClassName);
        Connection con = DriverManager.getConnection(url, username, password);
        Statement st = con.createStatement();
        st.execute(query);
        ResultSet resultSet = st.getResultSet();
        while (resultSet.next()) {
            String columnName = resultSet.getString("COLUMN_NAME");
            String columnComment = resultSet.getString("COLUMN_COMMENT");
            String ans = StrUtil.toCamelCase(columnName.trim());
//            System.out.printf("#{material.%s},\n", ans);
            System.out.println(columnName + "//" + columnComment);
        }

        resultSet.close();
        st.close();
        con.close();
    }
}
