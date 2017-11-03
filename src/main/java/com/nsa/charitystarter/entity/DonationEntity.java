package com.nsa.charitystarter.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by c1618453 on 02/11/2017.
 */
@Entity
@Table(name = "donation", schema = "donations", catalog = "")
public class DonationEntity {
    private Integer id;
    private Integer amountInPence;
    private Date donationDate;
    private Integer isOwnMoney;
    private Integer hasNoBenefitToDonor;
    private Integer wishesToGiftAid;
    private DonorEntity donorByDonorId;
    private Integer donorId;
    private Integer sponsorFormId;
    private Integer charityId;
    private SponsorFormEntity sponsorFormBySponsorFormId;
    private CharityEntity charityByCharityId;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "amount_in_pence", nullable = false)
    public Integer getAmountInPence() {
        return amountInPence;
    }

    public void setAmountInPence(Integer amountInPence) {
        this.amountInPence = amountInPence;
    }

    @Basic
    @Column(name = "donation_date", nullable = false)
    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    @Basic
    @Column(name = "is_own_money", nullable = false)
    public Integer getIsOwnMoney() {
        return isOwnMoney;
    }

    public void setIsOwnMoney(Integer isOwnMoney) {
        this.isOwnMoney = isOwnMoney;
    }

    @Basic
    @Column(name = "has_no_benefit_to_donor", nullable = false)
    public Integer getHasNoBenefitToDonor() {
        return hasNoBenefitToDonor;
    }

    public void setHasNoBenefitToDonor(Integer hasNoBenefitToDonor) {
        this.hasNoBenefitToDonor = hasNoBenefitToDonor;
    }

    @Basic
    @Column(name = "wishes_to_gift_aid", nullable = false)
    public Integer getWishesToGiftAid() {
        return wishesToGiftAid;
    }

    public void setWishesToGiftAid(Integer wishesToGiftAid) {
        this.wishesToGiftAid = wishesToGiftAid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DonationEntity that = (DonationEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (amountInPence != null ? !amountInPence.equals(that.amountInPence) : that.amountInPence != null)
            return false;
        if (donationDate != null ? !donationDate.equals(that.donationDate) : that.donationDate != null) return false;
        if (isOwnMoney != null ? !isOwnMoney.equals(that.isOwnMoney) : that.isOwnMoney != null) return false;
        if (hasNoBenefitToDonor != null ? !hasNoBenefitToDonor.equals(that.hasNoBenefitToDonor) : that.hasNoBenefitToDonor != null)
            return false;
        if (wishesToGiftAid != null ? !wishesToGiftAid.equals(that.wishesToGiftAid) : that.wishesToGiftAid != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (amountInPence != null ? amountInPence.hashCode() : 0);
        result = 31 * result + (donationDate != null ? donationDate.hashCode() : 0);
        result = 31 * result + (isOwnMoney != null ? isOwnMoney.hashCode() : 0);
        result = 31 * result + (hasNoBenefitToDonor != null ? hasNoBenefitToDonor.hashCode() : 0);
        result = 31 * result + (wishesToGiftAid != null ? wishesToGiftAid.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "donor_id", referencedColumnName = "id", nullable = false)
    public DonorEntity getDonorByDonorId() {
        return donorByDonorId;
    }

    public void setDonorByDonorId(DonorEntity donorByDonorId) {
        this.donorByDonorId = donorByDonorId;
    }

    @Basic
    @Column(name = "donor_id", nullable = false)
    public Integer getDonorId() {
        return donorId;
    }

    public void setDonorId(Integer donorId) {
        this.donorId = donorId;
    }

    @Basic
    @Column(name = "sponsor_form_id", nullable = true)
    public Integer getSponsorFormId() {
        return sponsorFormId;
    }

    public void setSponsorFormId(Integer sponsorFormId) {
        this.sponsorFormId = sponsorFormId;
    }


    public void setCharityId(Integer charityId) {
        this.charityId = charityId;
    }

    @ManyToOne
    @JoinColumn(name = "sponsor_form_id", referencedColumnName = "id")
    public SponsorFormEntity getSponsorFormBySponsorFormId() {
        return sponsorFormBySponsorFormId;
    }

    public void setSponsorFormBySponsorFormId(SponsorFormEntity sponsorFormBySponsorFormId) {
        this.sponsorFormBySponsorFormId = sponsorFormBySponsorFormId;
    }

    @ManyToOne
    @JoinColumn(name = "charity_id", referencedColumnName = "id", nullable = false)
    public CharityEntity getCharityByCharityId() {
        return charityByCharityId;
    }

    public void setCharityByCharityId(CharityEntity charityByCharityId) {
        this.charityByCharityId = charityByCharityId;
    }
}
