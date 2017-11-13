package com.marvelsix.jpa.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 【MarvelSix x17 intellij】
 * Author: 小小文
 * Date: 2017-11-09 - 23:06
 * Project: tspringdatajpa
 * Ref: [ https://github.com/judasn/IntelliJ-IDEA-Tutorial ]
 */
@Entity
public class MyUser {

    @GeneratedValue
    @Column(name="ssa_id")
    @Id
    private Integer ssaId;

    @Column(name="ssa_name",length=20)
    private String ssaName;

    @Column(name="ssa_tag",length=10)
    private String ssaTag;

    @Column(name="ssa_date")
    private Date ssaDate;

    @Override
    public String toString() {
        return "MyUser{" +
                "ssaId=" + ssaId +
                ", ssaName='" + ssaName + '\'' +
                ", ssaTag='" + ssaTag + '\'' +
                ", ssaDate=" + ssaDate +
                '}';
    }

    public Integer getSsaId() {
        return ssaId;
    }

    public void setSsaId(Integer ssaId) {
        this.ssaId = ssaId;
    }

    public String getSsaName() {
        return ssaName;
    }

    public void setSsaName(String ssaName) {
        this.ssaName = ssaName;
    }

    public String getSsaTag() {
        return ssaTag;
    }

    public void setSsaTag(String ssaTag) {
        this.ssaTag = ssaTag;
    }

    public Date getSsaDate() {
        return ssaDate;
    }

    public void setSsaDate(Date ssaDate) {
        this.ssaDate = ssaDate;
    }
}
