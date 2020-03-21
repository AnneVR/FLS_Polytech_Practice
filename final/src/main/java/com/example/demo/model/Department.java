package com.example.demo.model;

import com.google.inject.internal.cglib.core.$ClassNameReader;
import com.google.inject.internal.cglib.core.$GeneratorStrategy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "departments")
@EntityListeners(AuditingEntityListener.class)
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column
    String name;

    /**
     * Gets department Id
     *
     * @return id
     */
    public long getId(){return id;}

    /**
     * Gets department name
     *
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * Sets deprtment id
     *
     * @param id department id
     */
    public void setId(long id){
        this.id = id;
    }

    /**
     * Sets department name
     *
     * @param name department name
     */
    public void setName(String name){
        this.name = name;
    }

}
