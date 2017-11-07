package com.nsa.charitystarter.service;

import com.nsa.charitystarter.data.Activity;

import java.util.List;

/**
 * Created by c1618453 on 03/11/2017.
 */
public interface DonationService {

    Double getDonationTotal(Integer id);

    List<Activity> getRecentActivities(Integer id);
}
