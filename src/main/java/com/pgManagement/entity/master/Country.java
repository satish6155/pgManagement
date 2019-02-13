package com.pgManagement.entity.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Country")
public class Country extends MasterBaseEntity {
	
	@Transient
	private static final long serialVersionUID = -1232395859408322328L;

	private Integer countryIsdCode;

	@Column(length = 50)
	private String countryIsoCode;

	@Column(length = 255, unique = true)
	private String countryName;

	@Column(length = 255)
	private String nationality;

	public Integer getCountryIsdCode() {
		return countryIsdCode;
	}

	public void setCountryIsdCode(Integer countryIsdCode) {
		this.countryIsdCode = countryIsdCode;
	}

	public String getCountryIsoCode() {
		return countryIsoCode;
	}

	public void setCountryIsoCode(String countryIsoCode) {
		this.countryIsoCode = countryIsoCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return "Country [countryIsdCode=" + countryIsdCode
				+ ", countryIsoCode=" + countryIsoCode + ", countryName="
				+ countryName + ", nationality=" + nationality + ", getId()="
				+ getId() + ", getActiveFlag()=" + getActiveFlag() + "]";
	}

}
