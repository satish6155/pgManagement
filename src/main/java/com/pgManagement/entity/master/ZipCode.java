package com.pgManagement.entity.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ZipCode")
public class ZipCode extends MasterBaseEntity {
	
	@Transient
	private static final long serialVersionUID = -1232395859408322328L;

	private String placeName;

	@Column(unique = true)
	private Integer zipCode;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CITY")
	private City city;


	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "ZipCode [placeName=" + placeName + ", zipCode=" + zipCode
				+ ", city=" + city + ", getId()=" + getId()
				+ ", getActiveFlag()=" + getActiveFlag() + "]";
	}

	
	

}
