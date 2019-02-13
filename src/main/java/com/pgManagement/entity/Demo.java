package com.pgManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.pgManagement.entity.master.MasterBaseEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "DEMO_TABLE")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Demo")
public class Demo extends MasterBaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_THIS")
	@SequenceGenerator(name = "SEQ_THIS", sequenceName = "DEMO_SEQ", allocationSize = 1, initialValue = 50000)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "col_1", length = 255)
	private String col_1;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCol_1() {
		return col_1;
	}

	public void setCol_1(String col_1) {
		this.col_1 = col_1;
	}
	
	

}
