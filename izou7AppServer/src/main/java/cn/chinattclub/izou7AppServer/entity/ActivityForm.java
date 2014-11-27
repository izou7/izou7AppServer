package cn.chinattclub.izou7AppServer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 活动报名表单实体类
 * 
 * @author ZY
 * 
 */
@Entity
@Table(name = "i_activity_form")
public class ActivityForm {

	@Id
	@GeneratedValue
	private Integer id;
	
	/**
	 * 活动
	 */
	@ManyToOne
	private Activity activity;
	
	/**
	 * 自定义报名信息
	 */
	@Column(name="registration_info")
	private String registrationInfo;
	
	/**
	 * 自定义报名表单
	 */
	@Column(name="registration_form")
	private String registrationForm;
	
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
	 * Returns the value of the field called 'registrationInfo'.
	 * @return Returns the registrationInfo.
	 */
	public String getRegistrationInfo() {
		return this.registrationInfo;
	}

	/**
	 * Sets the field called 'registrationInfo' to the given value.
	 * @param registrationInfo The registrationInfo to set.
	 */
	public void setRegistrationInfo(String registrationInfo) {
		this.registrationInfo = registrationInfo;
	}

	/**
	 * Returns the value of the field called 'registrationForm'.
	 * @return Returns the registrationForm.
	 */
	public String getRegistrationForm() {
		return this.registrationForm;
	}

	/**
	 * Sets the field called 'registrationForm' to the given value.
	 * @param registrationForm The registrationForm to set.
	 */
	public void setRegistrationForm(String registrationForm) {
		this.registrationForm = registrationForm;
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
	
	
}
