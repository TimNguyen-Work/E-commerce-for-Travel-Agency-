package com.example.demo.dao;

import com.example.demo.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("http://localhost:4200")
public interface CountryRepository extends JpaRepository<Country, Long> {

}
