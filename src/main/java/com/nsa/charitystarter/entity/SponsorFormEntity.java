package com.nsa.charitystarter.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by c1618453 on 02/11/2017.
 */
@Entity
@Table(name = "sponsor_form", schema = "donations", catalog = "")
public class SponsorFormEntity {
    private Integer id;
    private String fundraiserName;
    private String fundraisingAction;
    private Date dateCreated;
    private Date firstValidDay;
    private Date lastValidDay;
    private String furl;
    private Integer charityId;
    private Collection<DonationEntity> donationsById;
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
    @Column(name = "fundraiser_name", nullable = false, length = 200)
    public String getFundraiserName() {
        return fundraiserName;
    }

    public void setFundraiserName(String fundraiserName) {
        this.fundraiserName = fundraiserName;
    }

    @Basic
    @Column(name = "fundraising_action", nullable = false, length = 1000)
    public String getFundraisingAction() {
        return fundraisingAction;
    }

    public void setFundraisingAction(String fundraisingAction) {
        this.fundraisingAction = fundraisingAction;
    }

    @Basic
    @Column(name = "date_created", nullable = false)
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Basic
    @Column(name = "first_valid_day", nullable = false)
    public Date getFirstValidDay() {
        return firstValidDay;
    }

    public void setFirstValidDay(Date firstValidDay) {
        this.firstValidDay = firstValidDay;
    }

    @Basic
    @Column(name = "last_valid_day", nullable = false)
    public Date getLastValidDay() {
        return lastValidDay;
    }

    public void setLastValidDay(Date lastValidDay) {
        this.lastValidDay = lastValidDay;
    }

    @Basic
    @Column(name = "furl", nullable = false, length = 50)
    public String getFurl() {
        return furl;
    }

    public void setFurl(String furl) {
        this.furl = furl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SponsorFormEntity that = (SponsorFormEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (fundraiserName != null ? !fundraiserName.equals(that.fundraiserName) : that.fundraiserName != null)
            return false;
        if (fundraisingAction != null ? !fundraisingAction.equals(that.fundraisingAction) : that.fundraisingAction != null)
            return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;
        if (firstValidDay != null ? !firstValidDay.equals(that.firstValidDay) : that.firstValidDay != null)
            return false;
        if (lastValidDay != null ? !lastValidDay.equals(that.lastValidDay) : that.lastValidDay != null) return false;
        if (furl != null ? !furl.equals(that.furl) : that.furl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fundraiserName != null ? fundraiserName.hashCode() : 0);
        result = 31 * result + (fundraisingAction != null ? fundraisingAction.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (firstValidDay != null ? firstValidDay.hashCode() : 0);
        result = 31 * result + (lastValidDay != null ? lastValidDay.hashCode() : 0);
        result = 31 * result + (furl != null ? furl.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "charity_id", nullable = false)
    public Integer getCharityId() {
        return charityId;
    }

    public void setCharityId(Integer charityId) {
        this.charityId = charityId;
    }

    @OneToMany(mappedBy = "sponsorFormBySponsorFormId")
    public Collection<DonationEntity> getDonationsById() {
        return donationsById;
    }

    public void setDonationsById(Collection<DonationEntity> donationsById) {
        this.donationsById = donationsById;
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
