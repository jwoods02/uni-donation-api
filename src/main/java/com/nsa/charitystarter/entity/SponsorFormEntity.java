package com.nsa.charitystarter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

/**
 * Created by c1618453 on 07/11/2017.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sponsor_form")
public class SponsorFormEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fundraiser_name")
    private String fundraiserName;

    @Column(name = "fundraising_action")
    private String fundraisingAction;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "first_valid_day")
    private Date firstValidDay;

    @Column(name = "last_valid_day")
    private Date lastValidDay;

    @Column(name = "furl")
    private String furl;

    @OneToMany(mappedBy = "sponsorForm")
    private List<DonationEntity> donations;

    @ManyToOne
    @JoinColumn(name = "charity_id")
    private CharityEntity charity;

}
