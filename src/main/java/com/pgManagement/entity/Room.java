package com.pgManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Room")
public class Room extends BaseEntity {

	@Transient
	private static final long serialVersionUID = -1232395859408322328L;

	@Column(nullable = false, length = 50, unique = true)
	private String code;

	private Integer noOfSeats;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	@Override
	public String toString() {
		return "Room [code=" + code + ", noOfSeats=" + noOfSeats
				+ ", toString()=" + super.toString() + "]";
	}

}
