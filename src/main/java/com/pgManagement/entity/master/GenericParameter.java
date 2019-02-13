package com.pgManagement.entity.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GenericParameter")
public class GenericParameter extends MasterBaseEntity {

	@Transient
	private static final long serialVersionUID = -1232395859408322328L;

	@Column(name = "CODE", nullable = false, length = 255)
	private String code;

	@Column(name = "Description", nullable = false, length = 255)
	private String description;

	@Column(name = "dtype", nullable = false, length = 50)
	private String dtype;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	@Override
	public String toString() {
		return "GenericParameter [code=" + code + ", description="
				+ description + ", dtype=" + dtype + ", getId()=" + getId()
				+ ", getActiveFlag()=" + getActiveFlag() + "]";
	}

}
