package com.pgManagement.entity.master;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class MasterBaseEntity implements Serializable {
	
	private static final long serialVersionUID = -1232395859408322328L;
	
	@Id
	@GenericGenerator(name="sequencePerEntityGenerator", strategy="com.pgManagement.util.CustomSequenceGenerator", parameters={@org.hibernate.annotations.Parameter(name="prefer_sequence_per_entity", value="true"), @org.hibernate.annotations.Parameter(name="sequence_per_entity_suffix", value="_seq"), @org.hibernate.annotations.Parameter(name="initial_value", value="50000")})
	@GeneratedValue(strategy=GenerationType.AUTO, generator="sequencePerEntityGenerator")
	private Long id;
	
	@Column(columnDefinition = "NUMBER(1)")
	private Integer activeFlag;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Integer activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Override
	public String toString() {
		return "MasterBaseEntity [id=" + id + ", activeFlag=" + activeFlag
				+ "]";
	}
	
	

}
