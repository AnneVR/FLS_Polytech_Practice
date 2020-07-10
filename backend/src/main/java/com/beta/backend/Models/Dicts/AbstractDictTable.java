package com.beta.backend.Models.Dicts;


import javax.persistence.*;

@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractDictTable {
    @Id
    @GeneratedValue
    private long key;

    @Column
    private String value;

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
