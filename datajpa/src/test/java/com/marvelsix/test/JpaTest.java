package com.marvelsix.test;

import com.marvelsix.jpa.Entity.MyUser;
import com.marvelsix.jpa.repository.MyUserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * 【MarvelSix x17 intellij】
 * Author: 小小文
 * Date: 2017-11-09 - 23:02
 * Project: tspringdatajpa
 * Ref: [ https://github.com/judasn/IntelliJ-IDEA-Tutorial ]
 */
public class JpaTest {

    private ApplicationContext context = null;
    private MyUserRepository myUserRepository = null;

    @Before
    public void init(){
        System.out.println("init");
        context = new ClassPathXmlApplicationContext("beans.xml");
        myUserRepository = context.getBean(MyUserRepository.class);

    }

    @After
    public void release(){
        System.out.println("release");
        context = null;
    }

    @Test
    public void test(){

        for (int i = 0; i < 5; i++) {
            MyUser myUser = new MyUser();
            myUser.setSsaTag("x-0"+i);
            myUser.setSsaName("大毛："+i);
            myUser.setSsaDate(new Date());
            myUserRepository.save(myUser);
        }

//        MyUser myUser = myUserRepository.findBySsaTag("x17");
//        System.out.println(myUser.toString());
//        myUser = myUserRepository.findBySsaTag("x21");
//        System.out.println(myUser.toString());
//        myUser = myUserRepository.findBySsaTag("x11");
//        System.out.println(myUser==null?"null":myUser.toString());

    }

}
