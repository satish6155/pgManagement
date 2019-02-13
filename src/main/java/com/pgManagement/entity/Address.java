package com.pgManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.pgManagement.entity.master.GenericParameter;
import com.pgManagement.entity.master.ZipCode;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Address")
public class Address extends BaseEntity {

	@Transient
	private static final long serialVersionUID = -1232395859408322328L;

	@Column(columnDefinition = "NUMBER(1)")
	private Integer activeAddress;

	@Column(length = 255)
	private String addressLine1;

	@Column(length = 255)
	private String addressLine2;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "zip_code")
	private ZipCode zipCode;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "address_type")
	private GenericParameter addresstype;

	public GenericParameter getAddresstype() {
		return addresstype;
	}

	public void setAddresstype(GenericParameter addresstype) {
		this.addresstype = addresstype;
	}

	public Integer getActiveAddress() {
		return activeAddress;
	}

	public void setActiveAddress(Integer activeAddress) {

		if (activeAddress == null) {
			activeAddress = 1;
		}
		this.activeAddress = activeAddress;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public ZipCode getZipCode() {
		return zipCode;
	}

	public void setZipCode(ZipCode zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [activeAddress=" + activeAddress + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2
				+ ", zipCode=" + zipCode + ", addresstype=" + addresstype
				+ ", getId()=" + getId() + ", getStatus()=" + getStatus()
				+ ", getCreationTimeStamp()=" + getCreationTimeStamp()
				+ ", getLastUpdatedTimeStamp()=" + getLastUpdatedTimeStamp()
				+ ", getCreatedBy()=" + getCreatedBy()
				+ ", getLastUpdatedBy()=" + getLastUpdatedBy() + "]";
	}

}