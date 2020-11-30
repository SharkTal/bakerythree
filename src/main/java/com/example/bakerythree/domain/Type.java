package com.example.bakerythree.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long typeid;
    private String typeName;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    private List<com.example.bakerythree.domain.Bread> breads;

    public Type(){}

    public Type(String typeName) {
        super();
        this.typeName = typeName;
    }

    public long getTypeid() {
        return typeid;
    }

    public void setTypeid(long typeid) {
        this.typeid = typeid;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<com.example.bakerythree.domain.Bread> getBreads() {
        return breads;
    }

    public void setBreads(List<com.example.bakerythree.domain.Bread> breads) {
        this.breads = breads;
    }
}
