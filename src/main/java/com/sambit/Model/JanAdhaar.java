package com.sambit.Model;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
@Table
public class JanAdhaar {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String janadhaarId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJanadhaarId() {
        return janadhaarId;
    }

    public void setJanadhaarId(String janadhaarId) {
        this.janadhaarId = janadhaarId;
    }


    @Override
    public String toString() {
        return "JanAdhaar{" +
                "id=" + id +
                ", janadhaarId='" + janadhaarId + '\'' +
                '}';
    }
}
