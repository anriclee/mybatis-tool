package com.anriclee;

import com.anriclee.mybatis.MyBatisGPT;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MyBatisGPT.generate("localhost:3306", "xxl_job", "xxl_job_info", "root", "123456");
    }
}
