package com.transport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transport.entities.ShippingCompany;

@Repository
public interface ShippingCompanyRepository extends JpaRepository<ShippingCompany, Long>{

}
