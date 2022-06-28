package com.shipping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shipping.entities.ShippingCompany;

@Repository
public interface ShippingCompanyRepository extends JpaRepository<ShippingCompany, Long>{

}
