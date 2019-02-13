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
@XmlRootElement(name = "City")
public class City extends MasterBaseEntity {

	@Transient
	private static final long serialVersionUID = -1232395859408322328L;

	@Column(nullable = false, unique = true)
	private String cityCode;

	@Column(nullable = false)
	private String cityName;

	private String stdCode;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "STATE")
	private State state;

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStdCode() {
		return stdCode;
	}

	public void setStdCode(String stdCode) {
		this.stdCode = stdCode;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "City [cityCode=" + cityCode + ", cityName=" + cityName
				+ ", stdCode=" + stdCode + ", state=" + state + ", getId()="
				+ getId() + ", getActiveFlag()=" + getActiveFlag() + "]";
	}

}
