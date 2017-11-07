package com.nsa.charitystarter.controllers;

import com.nsa.charitystarter.entity.CharityEntity;
import com.nsa.charitystarter.entity.DonationEntity;
import com.nsa.charitystarter.repository.DonationRepository;
import com.nsa.charitystarter.service.DonationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by c1618453 on 07/11/2017.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(DonationReportController.class)
public class TestDonationAPI {

    @Autowired
    private MockMvc mvc;

    @MockBean
    DonationService donationService;


    @Test
    public void expectToSeeDonationTotal() throws Exception {


        given(this.donationService.getDonationTotal(1)).willReturn(new Double(12345.67));

        mvc.perform(MockMvcRequestBuilders.get("/api/charity/1/donationTotal").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("12345.67")))
                ;
    }
}

//    CharityEntity aCharity = new CharityEntity();
//        aCharity.setId(Long.valueOf("1"));
//                aCharity.setName("Test Charity");
//
//                List<DonationEntity> donationList = new ArrayList<>();
//        donationList.add(new DonationEntity(1, 10000), );
//        donationList.add(new DonationEntity(1, 20000));
//        donationList.add(new DonationEntity(1, 30000));
//        aCharity.setDonations(donationList);
