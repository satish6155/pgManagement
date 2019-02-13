package com.pgManagement.entity.master;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "District")
public class District extends MasterBaseEntity {

	@Transient
	private static final long serialVersionUID = -1232395859408322328L;

	@Override
	public String toString() {
		return "District [getId()=" + getId() + ", getActiveFlag()="
				+ getActiveFlag() + "]";
	}

		
	

}
