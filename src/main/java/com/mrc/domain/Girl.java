package com.mrc.domain;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * Created by Administrator on 2017-06-11.
 */
@Entity
public class Girl {
    @GeneratedValue
    @Id
    private int id;
    private String cupSize;
    @Min(value=18,message = "未成年禁止入内")
    private int age;

    public Girl(){

    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {

        return "name:"+this.getId()+"  size :"+this.getCupSize();
    }
}
