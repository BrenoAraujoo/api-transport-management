package com.shipping.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.shipping.entities.enums.TransportType;

@Entity
@Table(name = "tb_transport")
public class Transport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "value_transport")
	@Positive(message = "value must be greater then 0")
	private Double value;
	
	@JsonFormat(shape = Shape.STRING,pattern = "yyyy-MM-dd")
	private Date date;
	private String observation;
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	private ShippingCompany company;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@NotNull(message = "User cannot be null or empty")
	private User user;
	@NotNull(message = "Transport type cannot be null or empty")
	private Integer transportType;

	public Transport() {
	}

	public Transport(Long id, Double value, Date date, String observation, 
			ShippingCompany company, TransportType transportType) {
		super();
		this.id = id;
		this.value = value;
		this.date = date;
		this.observation = observation;
		this.company = company;
		setTransportType(transportType);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}
	

	public ShippingCompany getCompany() {
		return company;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

	public TransportType getTransportType() {
		return TransportType.valueOf(transportType);
	}

	public void setTransportType(TransportType transportType) {
		if(transportType != null) {
			this.transportType = transportType.getCode();
		}
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(company, date, id, observation, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transport other = (Transport) obj;
		return Objects.equals(company, other.company) && Objects.equals(date, other.date)
				&& Objects.equals(id, other.id) && Objects.equals(observation, other.observation)
				&& Objects.equals(value, other.value);
	}

	
	
}
