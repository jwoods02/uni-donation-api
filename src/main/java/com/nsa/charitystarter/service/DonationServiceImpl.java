package com.nsa.charitystarter.service;

import com.nsa.charitystarter.entity.DonationEntity;
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
    private Double donationTotal;

    @Autowired
    public DonationServiceImpl(DonationRepository aRepo) {
        donationRepository = aRepo;
    }

    @Override
    public Double getDonationTotal(Integer id) {

        donationTotal = new Double(0.00);

        List<DonationEntity> donationEntityList = donationRepository.findAllByCharityId(id);
        System.out.println(donationEntityList);
        for(DonationEntity donation: donationEntityList) {
             int currentDonation = donation.getAmountInPence();
             Double currentDonationPounds = (double) (currentDonation / 100);
             donationTotal += currentDonationPounds;
        }

        return donationTotal;
    }
}
