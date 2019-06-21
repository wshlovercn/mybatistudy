package com.wshlovercn.mybatistudy.jdbc;

import java.sql.*;

public class App {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String user = "root";
        String password = "123456";
        try {
            connection = DriverManager.getConnection(url, user, password);
            String sql = "select * from user where id = ?";
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, 3);

            rs = prepareStatement.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (prepareStatement != null) {
                try {
                    prepareStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
