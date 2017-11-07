package com.nsa.charitystarter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by James on 06/11/2017.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="donation", schema="donations")
public class DonationEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "amount_in_pence", nullable = false)
    private Integer amountInPence;

    @Column(name = "donation_date", nullable = false)
    private Date donationDate;

    @Column(name = "is_own_money", nullable = false)
    private Integer isOwnMoney;

    @Column(name = "has_no_benefit_to_donor", nullable = false)
    private Integer hasNoBenefitToDonor;

    @Column(name = "wishes_to_gift_aid", nullable = false)
    private Integer wishesToGiftAid;

    @ManyToOne
    @JoinColumn(name="charity")
    private Library library;

}
