package com.pgManagement.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.pgManagement.entity.master.GenericParameter;

@Entity
@Table(name = "PG_USER")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "User")
public class User extends BaseEntity {

	@Transient
	private static final long serialVersionUID = -1232395859408322328L;

	@Column(nullable = false, length = 20, unique = true)
	private String username;

	@Column(nullable = false, length = 20)
	private String password;

	@Column(nullable = false, length = 255)
	private String firstName;

	@Column(nullable = false, length = 255)
	private String lastName;

	private long mobileNumber;

	@Column(columnDefinition = "NUMBER(3)")
	private Integer age;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "gender")
	private GenericParameter gender;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ROLE")
	private GenericParameter role;

	@Column(length = 50)
	private String email;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "PG_USER")
	private List<Address> addresses;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long i) {
		this.mobileNumber = i;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public GenericParameter getGender() {
		return gender;
	}

	public void setGender(GenericParameter gender) {
		this.gender = gender;
	}

	public GenericParameter getRole() {
		return role;
	}

	public void setRole(GenericParameter role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", age=" + age
				+ ", gender=" + gender + ", role=" + role + ", email=" + email
				+ ", addresses=" + addresses + ", toString()="
				+ super.toString() + "]";
	}

	
}
