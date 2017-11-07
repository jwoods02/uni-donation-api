package com.nsa.charitystarter.service;

import com.nsa.charitystarter.data.Activity;
import com.nsa.charitystarter.entity.CharityEntity;
import com.nsa.charitystarter.entity.DonationEntity;
import com.nsa.charitystarter.repository.CharityRepository;
import com.nsa.charitystarter.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by c1618453 on 03/11/2017.
 */

@Service
public class DonationServiceImpl implements DonationService {

    private DonationRepository donationRepository;
    private CharityRepository charityRepository;
    private Double donationTotal;

    @Autowired
    public DonationServiceImpl(DonationRepository aRepo, CharityRepository anotherRepo) {
        donationRepository = aRepo;
        charityRepository = anotherRepo;
    }

    @Override
    public Double getDonationTotal(Integer id) {

        donationTotal = new Double(0.00);

        CharityEntity charity = charityRepository.findById(Long.valueOf(id));

        List<DonationEntity> donationList = charity.getDonations();

        for(DonationEntity donation: donationList) {
            donationTotal += donation.getAmountInPence();
        }


        return donationTotal / 100;
    }

    @Override
    public List<Activity> getRecentActivities(Integer id) {
        List<Activity> recentActivities = new ArrayList<>();
        List<DonationEntity> recentDonations = donationRepository.findTop10ByCharityOrderByDonationDateDesc(charityRepository.findById(Long.valueOf(id)));

        for(DonationEntity donation: recentDonations) {
            recentActivities.add(mapDonationToActivity(donation));
        }
        return recentActivities;
    }

    public Activity mapDonationToActivity(DonationEntity donation) {
        // who (String), what (string), when(LocalDateTime)

        String who = donation.getDonor().getFirstName();
        String what = String.format("Gave £%d", donation.getAmountInPence() / 100);
        LocalDateTime when = convertSqlDateToLocalDateTime(donation.getDonationDate());

        return new Activity(who, what, when);
    }

    // Refrenced from: https://stackoverflow.com/questions/29750861/convert-between-localdate-and-sql-date
    // and https://beginnersbook.com/2017/10/java-convert-localdate-to-localdatetime/
    public LocalDateTime convertSqlDateToLocalDateTime(Date sqlDate) {
        LocalDate date = sqlDate.toLocalDate();
        return date.atStartOfDay();
    }


}
