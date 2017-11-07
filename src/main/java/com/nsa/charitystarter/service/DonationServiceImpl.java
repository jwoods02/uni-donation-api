package com.nsa.charitystarter.service;

import com.nsa.charitystarter.data.Activity;
import com.nsa.charitystarter.entity.CharityEntity;
import com.nsa.charitystarter.entity.DonationEntity;
import com.nsa.charitystarter.repository.CharityRepository;
import com.nsa.charitystarter.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        List<DonationEntity> donationList = charity.getDonation();

        for(DonationEntity donation: donationList) {
            donationTotal += donation.getAmountInPence();
        }


        return donationTotal / 100;
    }

    @Override
    public List<Activity> getRecentActivities(Integer id) {
        return null;
    }


}
