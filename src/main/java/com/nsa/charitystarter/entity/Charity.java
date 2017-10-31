package com.nsa.charitystarter.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by c1618453 on 31/10/2017.
 */
@Data
@Entity
@Table(name = "charity")
public class Charity {

    public Charity() {
        registrationId = "";
        name = "";
        purpose = "";
        logoFileName = "";
    }
    public Charity(Long id, String registrationId, String name, String purpose, String logoFileName) {
        this.id = id;
        this.registrationId = registrationId;
        this.name = name;
        this.purpose = purpose;
        this.logoFileName = logoFileName;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name="registration_id")
    String registrationId;

    @Column(name="name")
    String name;

    @Column(name="purpose")
    String purpose;

    @Column(name="logo_file_name")
    String logoFileName;

}