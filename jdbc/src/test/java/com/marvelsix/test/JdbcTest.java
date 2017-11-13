package com.marvelsix.test;

import com.marvelsix.utils.JdbcUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 【MarvelSix x17 intellij】
 * Author: 小小文
 * Date: 2017-11-08 - 21:29
 * Project: tspringdatajpa
 * Ref: [ https://github.com/judasn/IntelliJ-IDEA-Tutorial ]
 */
public class JdbcTest {

    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;
    private String sql = "select * from ssa_user";

    @Before
    public void init(){
        try {
            connection = JdbcUtils.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testJdbc(){
        try{
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                System.out.println(
                        resultSet.getInt("ssa_id")+""+
                        resultSet.getString("ssa_name")+""+
                        resultSet.getString("ssa_tag")+""+
                        resultSet.getTimestamp("ssa_date"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @After
    public void release(){
        JdbcUtils.release(connection,statement,resultSet);
    }

}
