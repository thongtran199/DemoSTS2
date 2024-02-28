package com.sgu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import com.sgu.constant.TenParamsCuaProcedure;
import com.sgu.constant.TenProcedures;

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name="User.FindListLikedByVideoHref",
			procedureName = TenProcedures.FIND_USERS_LIKED_VIDEO_BY_VIDEO_HREF,
			resultClasses = {User.class},
			parameters = @StoredProcedureParameter(mode = ParameterMode.IN, name = TenParamsCuaProcedure.FIND_USERS_LIKED_VIDEO_BY_VIDEO_HREF, type= String.class)
			)
})

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private int userID;

    @Column(name = "UserName")
    private String userName;

    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "Image", columnDefinition = "TEXT")
    private String image;
    
    @Column(name = "Password")
    private String password;

    @Column(name = "Email")
    private String email;

	@Column(name = "IsActive")
	private Boolean isActive;
	
    public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public String getShipCity() {
		return shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	public String getShipState() {
		return shipState;
	}

	public void setShipState(String shipState) {
		this.shipState = shipState;
	}

	@Column(name = "TelNumber")
    private String telNumber;

    @Column(name = "Role")
    private Integer role;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "ShipAddress")
    private String shipAddress;

    @Column(name = "ShipCity")
    private String shipCity;

    @Column(name = "ShipState")
    private String shipState;

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", telNumber=" + telNumber + ", role=" + role + ", fullName=" + fullName + ", shipAddress="
				+ shipAddress + ", shipCity=" + shipCity + ", shipState=" + shipState + "]";
	}

	public User(int userID, String userName, String password, String email, String telNumber, Integer role,
			String fullName, String shipAddress, String shipCity, String shipState) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.telNumber = telNumber;
		this.role = role;
		this.fullName = fullName;
		this.shipAddress = shipAddress;
		this.shipCity = shipCity;
		this.shipState = shipState;
	}

    public User() {
    	
    }
	
}
