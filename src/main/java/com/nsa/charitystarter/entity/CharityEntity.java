package com.nsa.charitystarter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by James on 06/11/2017.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="charity", schema="donations")
public class CharityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "registration_id")
    private Integer registrationId;

    @Column(name = "name")
    private String name;

    @Column(name = "purpose")
    private String purpose;

    @OneToMany(mappedBy = "charity")
    private List<DonationEntity> donations;

    @OneToMany(mappedBy = "charity")
    private List<SponsorFormEntity> sponsorForms;

}
