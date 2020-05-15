package com.kxm.jdbc;

import com.kxm.entity.Student;
import com.kxm.utils.JdbcUtil;

import java.sql.*;
import java.util.Date;
import java.util.List;

public class JdbcDemo3 {
    public static void main(String[] args) {
        Connection connection = JdbcUtil.getConnection();
        Statement statement = null;
        ResultSet rs=null;
        String sql="select * from students";
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()){
                Student student = new Student();
                String name = rs.getString("name");
                int age=rs.getInt("age");
                Date birthday=rs.getDate("birthday");
                Date inserTime=rs.getDate("insert_time");
                Double score=rs.getDouble("score");
                System.out.println(name+"-----"+age+"-----"+birthday+"-----"+inserTime+"-----"+score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(statement,connection);
        }
        /*Connection conn=null;
        Statement statement=null;
        List<Student> list=null;
        Student student=null;
        ResultSet resultSet=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql:///db1","root","258369");
            statement=conn.createStatement();
            String sql="select * from students";
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                String name = resultSet.getString("name");
                int age=resultSet.getInt("age");
                Date birthday=resultSet.getDate("birthday");
                Date insertTime=resultSet.getDate("insert_time");
                Double score=resultSet.getDouble("score");
                System.out.println(name+"....."+age+"....."+birthday+"....."+insertTime+"....."+score);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
        }*/
    }
}
