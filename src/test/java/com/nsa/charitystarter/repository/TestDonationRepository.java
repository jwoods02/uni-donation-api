package com.nsa.charitystarter.repository;

import com.nsa.charitystarter.entity.CharityEntity;
import com.nsa.charitystarter.entity.DonationEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by James on 08/11/2017.
 */

// Idea for test from http://www.baeldung.com/spring-boot-testing

        @RunWith(SpringRunner.class)
        @DataJpaTest
        @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
        public class TestDonationRepository {

            @Autowired
            private DonationRepository donationRepository;

            @Autowired
            private CharityRepository charityRepository;

            @Test
            public void expectToReturn10MostRecentDonations() {

                // Given
                CharityEntity testCharity = charityRepository.findById((long) 1);

                // When
                List<DonationEntity> recentDonations = this.donationRepository.findTop10ByCharityOrderByDonationDateDesc(testCharity);

                // Then
                assert recentDonations.get(0).getId().equals(116);
                assert recentDonations.get(9).getId().equals(419);


            }

}
