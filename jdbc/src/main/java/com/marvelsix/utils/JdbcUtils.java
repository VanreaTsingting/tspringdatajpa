package com.marvelsix.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * 【MarvelSix x17 intellij】
 * Author: 小小文
 * Date: 2017-11-08 - 20:34
 * Project: tspringdatajpa
 * Ref: [ https://github.com/judasn/IntelliJ-IDEA-Tutorial ]
 */
public class JdbcUtils {

    public static java.sql.Connection getConnection() throws Exception {

        InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(is);

        String url = properties.getProperty("jdbc.url");
        String user = properties.getProperty("jdbc.user");
        String password = properties.getProperty("jdbc.password");
        String driverClass = properties.getProperty("jdbc.driverClass");

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url,user,password);

        return connection;

    }

    public static void release(Connection connection, Statement statement, ResultSet resultSet){
        try{
            if (resultSet!=null){
                resultSet.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            if (statement!=null){
                statement.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            if (connection!=null){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
