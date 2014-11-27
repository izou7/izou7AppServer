package cn.chinattclub.izou7AppServer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "i_user_info")

public class UserInfo {
	@Id
	@GeneratedValue
    private int id;
	
	@Column(name = "real_name")
	private String realName;
	
	private String phone;
	
	private String email;
	
	private String qq;
	
	@Column(name = "head_picture")
	private String headPicture;
	
	@Column(name = "head_picture_url")
	private String headPictureUrl;
	
	/**
	 * 出生日期
	 */
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	private boolean sex;
	
	@Column(name = "career_info")
	private String careerInfo;
	
	private String introduction;
	
	@Column(name = "praise_number")
	private int praiseNumber;
	
	@Column(name = "bad_number")
	private int badNumber;
	
	@Column(name = "create_time")
	private Date createTime;
	
	@Column(name = "update_time")
	private Date updateTime;
	
	@Column(name = "user_Data")
	private String userData;

	@Column(name = "interest_field")
	private String interestField;
	
	@Column(name = "interest_career")
	private String interestCareer;
	
	@ManyToOne
	@JoinColumn(name="city")
	private City city;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getHeadPicture() {
		return headPicture;
	}

	public void setHeadPicture(String headPicture) {
		this.headPicture = headPicture;
	}

	public String getHeadPictureUrl() {
		return headPictureUrl;
	}

	public void setHeadPictureUrl(String headPictureUrl) {
		this.headPictureUrl = headPictureUrl;
	}


	/**
	 * Returns the value of the field called 'birthday'.
	 * @return Returns the birthday.
	 */
	public Date getBirthday() {
		return this.birthday;
	}

	/**
	 * Sets the field called 'birthday' to the given value.
	 * @param birthday The birthday to set.
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getCareerInfo() {
		return careerInfo;
	}

	public void setCareerInfo(String careerInfo) {
		this.careerInfo = careerInfo;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public int getPraiseNumber() {
		return praiseNumber;
	}

	public void setPraiseNumber(int praiseNumber) {
		this.praiseNumber = praiseNumber;
	}

	public int getBadNumber() {
		return badNumber;
	}

	public void setBadNumber(int badNumber) {
		this.badNumber = badNumber;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUserData() {
		return userData;
	}

	public void setUserData(String userData) {
		this.userData = userData;
	}

	public String getInterestField() {
		return interestField;
	}

	public void setInterestField(String interestField) {
		this.interestField = interestField;
	}

	public String getInterestCareer() {
		return interestCareer;
	}

	public void setInterestCareer(String interestCareer) {
		this.interestCareer = interestCareer;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	
	
}
