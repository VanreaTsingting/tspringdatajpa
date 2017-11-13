package com.marvelsix.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 【MarvelSix x17 intellij】
 * Author: 小小文
 * Date: 2017-11-08 - 21:29
 * Project: tspringdatajpa
 * Ref: [ https://github.com/judasn/IntelliJ-IDEA-Tutorial ]
 */
public class JdbcTest {

    private String sql = "select * from ssa_user";
    private ApplicationContext context = null;

    @Before
    public void init(){
        System.out.println("init");
        context = new ClassPathXmlApplicationContext("beans.xml");

    }

    @After
    public void release(){
        System.out.println("release");
        context = null;
    }

    @Test
    public void testJdbcTemplate(){
        System.out.println("testJdbcTemplate");
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
        Assert.notNull(dataSource);
        final List<String> resultList = new ArrayList<String>();

        jdbcTemplate.query(sql, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                String content = resultSet.getInt("ssa_id")+""+
                        resultSet.getString("ssa_name")+""+
                        resultSet.getString("ssa_tag")+""+
                        resultSet.getTimestamp("ssa_date");
                System.out.println(content);
                resultList.add(content);
            }
        });

    }

}
