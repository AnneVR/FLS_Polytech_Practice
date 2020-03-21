package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.beans.ConstructorProperties;

@Entity
@Table(name = "departments")
@EntityListeners(AuditingEntityListener.class)
public class Department {

    /**
     *  Entity description
    **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    // public getters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Public setters
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


}
