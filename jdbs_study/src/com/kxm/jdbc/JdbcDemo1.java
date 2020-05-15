package com.kxm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * jdbc快速入门
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "258369");
        String sql="update account set balance=1000 where id=1";
        Statement statement = conn.createStatement();
        int i = statement.executeUpdate(sql);
        System.out.println("受影响的有"+i+"行");
        conn.close();
        statement.close();
    }
}
