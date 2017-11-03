package com.nsa.charitystarter.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by c1618453 on 02/11/2017.
 */
@Entity
@Table(name = "charity", schema = "donations", catalog = "")
public class CharityEntity {
    private Integer id;
    private String registrationId;
    private String name;
    private String purpose;
    private String logoFileName;
    private Collection<BankAccountEntity> bankAccountsById;
    private Collection<BankAccountTempEntity> bankAccountTempsById;
    private Collection<DonationEntity> donationsById;
    private Collection<SponsorFormEntity> sponsorFormsById;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "registration_id", nullable = false, length = 45)
    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "purpose", nullable = false, length = 500)
    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Basic
    @Column(name = "logo_file_name", nullable = true, length = 100)
    public String getLogoFileName() {
        return logoFileName;
    }

    public void setLogoFileName(String logoFileName) {
        this.logoFileName = logoFileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharityEntity that = (CharityEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (registrationId != null ? !registrationId.equals(that.registrationId) : that.registrationId != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (purpose != null ? !purpose.equals(that.purpose) : that.purpose != null) return false;
        if (logoFileName != null ? !logoFileName.equals(that.logoFileName) : that.logoFileName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (registrationId != null ? registrationId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (purpose != null ? purpose.hashCode() : 0);
        result = 31 * result + (logoFileName != null ? logoFileName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "charityByCharityId")
    public Collection<BankAccountEntity> getBankAccountsById() {
        return bankAccountsById;
    }

    public void setBankAccountsById(Collection<BankAccountEntity> bankAccountsById) {
        this.bankAccountsById = bankAccountsById;
    }

    @OneToMany(mappedBy = "charityByCharityId")
    public Collection<BankAccountTempEntity> getBankAccountTempsById() {
        return bankAccountTempsById;
    }

    public void setBankAccountTempsById(Collection<BankAccountTempEntity> bankAccountTempsById) {
        this.bankAccountTempsById = bankAccountTempsById;
    }

    @OneToMany(mappedBy = "charityByCharityId")
    public Collection<DonationEntity> getDonationsById() {
        return donationsById;
    }

    public void setDonationsById(Collection<DonationEntity> donationsById) {
        this.donationsById = donationsById;
    }

    @OneToMany(mappedBy = "charityByCharityId")
    public Collection<SponsorFormEntity> getSponsorFormsById() {
        return sponsorFormsById;
    }

    public void setSponsorFormsById(Collection<SponsorFormEntity> sponsorFormsById) {
        this.sponsorFormsById = sponsorFormsById;
    }
}
