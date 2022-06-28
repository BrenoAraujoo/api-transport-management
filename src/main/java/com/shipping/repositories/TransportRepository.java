package com.shipping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shipping.entities.Transport;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Long>{

}
