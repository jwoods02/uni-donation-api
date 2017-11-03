package com.nsa.charitystarter.repository;

import com.nsa.charitystarter.entity.DonationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by c1618453 on 03/11/2017.
 */
public interface DonationRepository extends JpaRepository<DonationEntity, Long> {

    List<DonationEntity> findAllByCharityId(Integer id);
}
