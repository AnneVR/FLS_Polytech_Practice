package com.beta.backend.Models.Analytics;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

public abstract class Analytics
{
    @Id
    @GeneratedValue
    private long key;

    @Column
    private int value;

    public long getKey()
    {
        return key;
    }

    public void setKey(long key)
    {
        this.key = key;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}


