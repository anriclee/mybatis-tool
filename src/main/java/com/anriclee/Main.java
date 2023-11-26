package com.anriclee;

import com.anriclee.mybatis.MyBatisGPT;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MyBatisGPT.generate("xxxx:3306", "xxx", "xxxx", "root", "xxx");
    }
}
