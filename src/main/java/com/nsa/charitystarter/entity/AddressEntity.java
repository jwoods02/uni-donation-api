package com.nsa.charitystarter.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by c1618453 on 02/11/2017.
 */
@Entity
@Table(name = "address", schema = "donations", catalog = "")
public class AddressEntity {
    private Integer id;
    private String buildingName;
    private Integer buildingNumber;
    private String street;
    private String district;
    private String city;
    private String postalCode;
    private String countryIsoCode;
    private Collection<DonorEntity> donorsById;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "building_name", nullable = true, length = 45)
    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    @Basic
    @Column(name = "building_number", nullable = true)
    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    @Basic
    @Column(name = "street", nullable = true, length = 100)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "district", nullable = true, length = 100)
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 100)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "postal_code", nullable = false, length = 12)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Basic
    @Column(name = "country_iso_code", nullable = false, length = 4)
    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressEntity that = (AddressEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (buildingName != null ? !buildingName.equals(that.buildingName) : that.buildingName != null) return false;
        if (buildingNumber != null ? !buildingNumber.equals(that.buildingNumber) : that.buildingNumber != null)
            return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (district != null ? !district.equals(that.district) : that.district != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (postalCode != null ? !postalCode.equals(that.postalCode) : that.postalCode != null) return false;
        if (countryIsoCode != null ? !countryIsoCode.equals(that.countryIsoCode) : that.countryIsoCode != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (buildingName != null ? buildingName.hashCode() : 0);
        result = 31 * result + (buildingNumber != null ? buildingNumber.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (countryIsoCode != null ? countryIsoCode.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "addressByAddressId")
    public Collection<DonorEntity> getDonorsById() {
        return donorsById;
    }

    public void setDonorsById(Collection<DonorEntity> donorsById) {
        this.donorsById = donorsById;
    }
}
