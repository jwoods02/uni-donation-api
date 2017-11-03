package com.nsa.charitystarter.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by c1618453 on 03/11/2017.
 */
@Entity
@Table(name = "bank_account", schema = "donations", catalog = "")
public class BankAccountEntity {
    private Integer id;
    private Integer charityId;
    private Integer accountNumber;
    private Integer sortCode;
    private Date lastValidDay;
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
    @Column(name = "charity_id", nullable = false)
    public Integer getCharityId() {
        return charityId;
    }

    public void setCharityId(Integer charityId) {
        this.charityId = charityId;
    }

    @Basic
    @Column(name = "account_number", nullable = false)
    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Basic
    @Column(name = "sort_code", nullable = false)
    public Integer getSortCode() {
        return sortCode;
    }

    public void setSortCode(Integer sortCode) {
        this.sortCode = sortCode;
    }

    @Basic
    @Column(name = "last_valid_day", nullable = true)
    public Date getLastValidDay() {
        return lastValidDay;
    }

    public void setLastValidDay(Date lastValidDay) {
        this.lastValidDay = lastValidDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccountEntity that = (BankAccountEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (charityId != null ? !charityId.equals(that.charityId) : that.charityId != null) return false;
        if (accountNumber != null ? !accountNumber.equals(that.accountNumber) : that.accountNumber != null)
            return false;
        if (sortCode != null ? !sortCode.equals(that.sortCode) : that.sortCode != null) return false;
        if (lastValidDay != null ? !lastValidDay.equals(that.lastValidDay) : that.lastValidDay != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (charityId != null ? charityId.hashCode() : 0);
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        result = 31 * result + (sortCode != null ? sortCode.hashCode() : 0);
        result = 31 * result + (lastValidDay != null ? lastValidDay.hashCode() : 0);
        return result;
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
