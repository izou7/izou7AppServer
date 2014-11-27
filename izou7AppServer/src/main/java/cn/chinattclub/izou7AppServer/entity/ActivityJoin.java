package cn.chinattclub.izou7AppServer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 活动用户实体类
 * 
 * @author ZY
 * 
 */
@Entity
@Table(name = "i_activity_join")
public class ActivityJoin {

	@Id
	@GeneratedValue
	private Integer id;
	
	/**
	 * 活动
	 */
	@ManyToOne
	private Activity activity;
	
	/**
	 * 活动
	 */
	@ManyToOne
	private User user;
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
	 * Returns the value of the field called 'user'.
	 * @return Returns the user.
	 */
	public User getUser() {
		return this.user;
	}

	/**
	 * Sets the field called 'user' to the given value.
	 * @param user The user to set.
	 */
	public void setUser(User user) {
		this.user = user;
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
