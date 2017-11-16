package com.marvelsix.jpa.repository;

import com.marvelsix.jpa.Entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

/**
 * 【MarvelSix x17 intellij】
 * Author: 小小文
 * Date: 2017-11-12 - 22:40
 * Project: tspringdatajpa
 * Ref: [ https://github.com/judasn/IntelliJ-IDEA-Tutorial ]
 */
public interface MyUserRepository extends JpaRepository<MyUser, Integer> {
    public MyUser findBySsaTag(String ssa_tag);
}
