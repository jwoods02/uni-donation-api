package com.nsa.charitystarter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by c1618453 on 07/11/2017.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="donor", schema="donations")
public class DonorEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

}
