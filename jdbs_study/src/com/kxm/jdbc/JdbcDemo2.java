package com.kxm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo2 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "258369");
            String sql="insert into account values(null,"+"'lisi',"+"1000)";
            statement = conn.createStatement();
            int i = statement.executeUpdate(sql);
            System.out.println(i);
            if(i>0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
