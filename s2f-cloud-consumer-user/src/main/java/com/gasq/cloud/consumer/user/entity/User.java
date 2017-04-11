package com.gasq.cloud.consumer.user.entity;

import java.util.Date;

/**
 * @author tangmin
 * @version V1.0
 * @Title: User.java
 * @Package com.gasq.cloud.consumer.user.entity
 * @Description: 待重构
 * @date 2017-04-11 23:03:17
 */
public class User{

    private Long id;

    private String name;

    private Date createTime;

    private String remark;

    private String sex;

    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}