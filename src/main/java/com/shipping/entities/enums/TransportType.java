package com.shipping.entities.enums;

public enum TransportType {
	DELIVERY(1), REMOVAL(2);

	private Integer code;

	private TransportType(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	// Covert numeric to enumerated
	public static TransportType valueOf(Integer code) {
		for (TransportType value : TransportType.values()) {
			if (code == value.getCode()) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid TransportType");
	}
	
	
	
}
