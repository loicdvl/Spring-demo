package com.loicdev.springdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loicdev.springdemo.domain.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

}
