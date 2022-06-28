package com.transport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.entities.ShippingCompany;
import com.transport.exceptions.EntityNotFoundException;
import com.transport.repositories.ShippingCompanyRepository;

@Service
public class ShippingCompanyService {

	@Autowired
	private ShippingCompanyRepository shippingCompany;

	public List<ShippingCompany> findAll() {
		return shippingCompany.findAll();
	}

	public ShippingCompany findById(Long id) {
		return shippingCompany.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id not found: " + id));
		
	}

	public ShippingCompany save(ShippingCompany company) {
		return shippingCompany.save(company);
	}
	
	// If the company doesn't exist, throw a EntityNotFoundException
	public void delete(Long id) {
		if (shippingCompany.findById(id).isEmpty()) {
			throw new EntityNotFoundException("Id not found " + id);
		}
		shippingCompany.deleteById(id);
	}
	
	public void update(ShippingCompany company) {
		shippingCompany.findById(company.getId());
		shippingCompany.save(company);
	}
}
