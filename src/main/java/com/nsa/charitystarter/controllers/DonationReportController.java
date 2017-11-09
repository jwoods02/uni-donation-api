package com.nsa.charitystarter.controllers;

import com.nsa.charitystarter.data.Activity;
import com.nsa.charitystarter.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "/api")
public class DonationReportController {

    private DonationService donationService;

    @Autowired
    public DonationReportController (DonationService aDonationService) {
        this.donationService = aDonationService;
    }

    @RequestMapping(path = "/charity/{id}/donationTotal")
    public Double getDonationTotal(@PathVariable Integer id) {

        //hard coded-replace with a set of delegations through to the database.

        return donationService.getDonationTotal(id);


    }

    @RequestMapping(path = "/charity/{id}/recentActivity")
    public List<Activity> getRecentActivity(@PathVariable Long id) {

        //hard-coded

        //Activity uses the new Java LocalDateTime class.  Be aware of how this is translated into JSON
        //This should be part of your design.  Should the API return a DateTime JSON or a formatted String containing a
        //nicely formatted date and time?

        //Should the API always return 10 items, or should it be configurable via a parameter?
        //If so, what sort of parameter?
        //Should it be able to show donations, sponsor forms or both?
        //Again, could this be a parameter?

        //What should the controller sort out?  What should be delegated to the service?
        //What business event is the controller receiving?

//        List<Activity> activities = new ArrayList<>();
//
//        Activity donation1=new Activity("John", "Gave £10", LocalDateTime.of(2017, Month.OCTOBER,30,16,30));
//        Activity donation2=new Activity("Peter", "Gave £20", LocalDateTime.of(2017, Month.OCTOBER,20,12,30));
//        Activity donation3=new Activity("Sarah", "Gave £15", LocalDateTime.of(2017, Month.OCTOBER,18,12,45));
//        Activity donation4=new Activity("Jess", "Gave £10", LocalDateTime.of(2017, Month.OCTOBER,17,10,12));
//        Activity donation5=new Activity("Dave", "Gave £5", LocalDateTime.of(2017, Month.OCTOBER,15,18,10));
//        Activity donation6=new Activity("Niamh", "Gave £100", LocalDateTime.of(2017, Month.OCTOBER,5,21,8));
//
//        Activity sponsorForm1=new Activity("Joe", "created a sponsor form", LocalDateTime.of(2017, Month.OCTOBER,23,21,8));
//        Activity sponsorForm2=new Activity("Clare", "created a sponsor form", LocalDateTime.of(2017, Month.OCTOBER,19,21,8));
//        Activity sponsorForm3=new Activity("Helen", "created a sponsor form", LocalDateTime.of(2017, Month.OCTOBER,14,21,8));
//        Activity sponsorForm4=new Activity("Rob", "created a sponsor form", LocalDateTime.of(2017, Month.OCTOBER,7,21,8));
//
//        activities.add(donation1);
//        activities.add(sponsorForm1);
//        activities.add(donation2);
//        activities.add(sponsorForm2);
//        activities.add(donation3);
//        activities.add(donation4);
//        activities.add(donation5);
//        activities.add(sponsorForm3);
//        activities.add(sponsorForm4);
//        activities.add(donation6);
//
//        return activities;

        return donationService.getRecentActivities(Math.toIntExact(id));

    }




}
