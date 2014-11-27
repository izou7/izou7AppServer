package cn.chinattclub.izou7AppServer.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cn.chinattclub.izou7AppServer.enumeration.GuestRegistrationStatus;


/**
 * 活动嘉宾实体类
 * 
 * @author ZY
 * 
 */
@Entity
@Table(name = "i_activity_guests")
public class ActivityGuests {


	@Id
	@GeneratedValue
	private Integer id;
	
	/**
	 * 活动
	 */
	@ManyToOne
	private Activity activity;
	
	/**
	 * 发邀请排名
	 */
	private Integer rank;
	
	/**
	 * 用户
	 */
	@ManyToMany
	@JoinTable(
	   name="i_activity_guests_vote",
	   joinColumns=@JoinColumn(name="activity_guests"),
	   inverseJoinColumns=@JoinColumn(name="user")
	   )
	private List<User> users;
	
	/**
	 * 嘉宾姓名
	 */
	private String name;
	
	/**
	 * 职位
	 */
	private String position;
	
	/**
	 * 公司
	 */
	private String company;
	
	/**
	 * 研究方向
	 */
	@Column(name="research_area")
	private String researchArea;
	
	/**
	 * 手机
	 */
	private String phone;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 出生日期
	 */
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	/**
	 * 性别
	 */
	private Boolean sex = Boolean.FALSE;
	
	/**
	 * 自我介绍
	 */
	private String introduction;
	
	/**
	 * 嘉宾来源
	 */
	private Boolean source;
	
	/**
	 * 嘉宾被赞的次数
	 */
	@Column(name="praise_number")
	private Integer praiseNumber;
	
	/**
	 * 嘉宾被差评的次数
	 */
	@Column(name="bad_number")
	private Integer badNumber;
	
	/**
	 * 嘉宾申请状态
	 */
	@Enumerated(EnumType.ORDINAL)
	private GuestRegistrationStatus status; 
	
	/**
	 * 合作类型（0：申请 1：邀请）
	 */
	private Integer type;
	
	/** 
	 *  创建时间
	 */
	@Column(name = "create_time")
	private Date createTime;
	
	/** 
	 * 更新时间 
	 */
	@Column(name = "update_time", insertable = false, updatable = false)
	private Date updateTime;

	/**
	 * Returns the value of the field called 'id'.
	 * @return Returns the id.
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Sets the field called 'id' to the given value.
	 * @param id The id to set.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Returns the value of the field called 'activity'.
	 * @return Returns the activity.
	 */
	public Activity getActivity() {
		return this.activity;
	}

	/**
	 * Sets the field called 'activity' to the given value.
	 * @param activity The activity to set.
	 */
	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	/**
	 * Returns the value of the field called 'name'.
	 * @return Returns the name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the field called 'name' to the given value.
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the value of the field called 'position'.
	 * @return Returns the position.
	 */
	public String getPosition() {
		return this.position;
	}

	/**
	 * Sets the field called 'position' to the given value.
	 * @param position The position to set.
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * Returns the value of the field called 'company'.
	 * @return Returns the company.
	 */
	public String getCompany() {
		return this.company;
	}

	/**
	 * Sets the field called 'company' to the given value.
	 * @param company The company to set.
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * Returns the value of the field called 'researchArea'.
	 * @return Returns the researchArea.
	 */
	public String getResearchArea() {
		return this.researchArea;
	}

	/**
	 * Sets the field called 'researchArea' to the given value.
	 * @param researchArea The researchArea to set.
	 */
	public void setResearchArea(String researchArea) {
		this.researchArea = researchArea;
	}

	/**
	 * Returns the value of the field called 'phone'.
	 * @return Returns the phone.
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * Sets the field called 'phone' to the given value.
	 * @param phone The phone to set.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Returns the value of the field called 'email'.
	 * @return Returns the email.
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Sets the field called 'email' to the given value.
	 * @param email The email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
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

	/**
	 * Returns the value of the field called 'sex'.
	 * @return Returns the sex.
	 */
	public Boolean getSex() {
		return this.sex;
	}

	/**
	 * Sets the field called 'sex' to the given value.
	 * @param sex The sex to set.
	 */
	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	/**
	 * Returns the value of the field called 'introduction'.
	 * @return Returns the introduction.
	 */
	public String getIntroduction() {
		return this.introduction;
	}

	/**
	 * Sets the field called 'introduction' to the given value.
	 * @param introduction The introduction to set.
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	/**
	 * Returns the value of the field called 'source'.
	 * @return Returns the source.
	 */
	public Boolean getSource() {
		return this.source;
	}

	/**
	 * Sets the field called 'source' to the given value.
	 * @param source The source to set.
	 */
	public void setSource(Boolean source) {
		this.source = source;
	}

	/**
	 * Returns the value of the field called 'praiseNumber'.
	 * @return Returns the praiseNumber.
	 */
	public Integer getPraiseNumber() {
		return this.praiseNumber;
	}

	/**
	 * Sets the field called 'praiseNumber' to the given value.
	 * @param praiseNumber The praiseNumber to set.
	 */
	public void setPraiseNumber(Integer praiseNumber) {
		this.praiseNumber = praiseNumber;
	}

	/**
	 * Returns the value of the field called 'badNumber'.
	 * @return Returns the badNumber.
	 */
	public Integer getBadNumber() {
		return this.badNumber;
	}

	/**
	 * Sets the field called 'badNumber' to the given value.
	 * @param badNumber The badNumber to set.
	 */
	public void setBadNumber(Integer badNumber) {
		this.badNumber = badNumber;
	}

	/**
	 * Returns the value of the field called 'createTime'.
	 * @return Returns the createTime.
	 */
	public Date getCreateTime() {
		return this.createTime;
	}

	/**
	 * Sets the field called 'createTime' to the given value.
	 * @param createTime The createTime to set.
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * Returns the value of the field called 'updateTime'.
	 * @return Returns the updateTime.
	 */
	public Date getUpdateTime() {
		return this.updateTime;
	}

	/**
	 * Sets the field called 'updateTime' to the given value.
	 * @param updateTime The updateTime to set.
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * Returns the value of the field called 'status'.
	 * @return Returns the status.
	 */
	public GuestRegistrationStatus getStatus() {
		return this.status;
	}

	/**
	 * Sets the field called 'status' to the given value.
	 * @param status The status to set.
	 */
	public void setStatus(GuestRegistrationStatus status) {
		this.status = status;
	}

	/**
	 * Returns the value of the field called 'users'.
	 * @return Returns the users.
	 */
	public List<User> getUsers() {
		return this.users;
	}

	/**
	 * Sets the field called 'users' to the given value.
	 * @param users The users to set.
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * Returns the value of the field called 'type'.
	 * @return Returns the type.
	 */
	public Integer getType() {
		return this.type;
	}

	/**
	 * Sets the field called 'type' to the given value.
	 * @param type The type to set.
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * Returns the value of the field called 'rank'.
	 * @return Returns the rank.
	 */
	public Integer getRank() {
		return this.rank;
	}

	/**
	 * Sets the field called 'rank' to the given value.
	 * @param rank The rank to set.
	 */
	public void setRank(Integer rank) {
		this.rank = rank;
	}
}
