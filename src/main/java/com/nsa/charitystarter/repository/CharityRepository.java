package com.nsa.charitystarter.repository;

import com.nsa.charitystarter.entity.Charity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by c1618453 on 31/10/2017.
 */
public interface CharityRepository  extends JpaRepository<Charity, Long> {

    List<Charity> findAll();
    Optional<Charity> findById(Long id);

}
