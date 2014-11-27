package cn.chinattclub.izou7AppServer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 投票嘉宾关系实体类
 * 
 * @author ZY
 * 
 */
@Entity
@Table(name = "i_activity_guests_vote")
public class ActivityGuestsVote {


	@Id
	@GeneratedValue
	private Integer id;
	
	/**
	 * 用户
	 */
	@ManyToOne
	private User user;
	
	/**
	 * 嘉宾
	 */
	@ManyToOne
	@JoinColumn(name="activity_guests")
	private ActivityGuests guests;
	
	/**
	 * 投票类型
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
	 * Returns the value of the field called 'guests'.
	 * @return Returns the guests.
	 */
	public ActivityGuests getGuests() {
		return this.guests;
	}

	/**
	 * Sets the field called 'guests' to the given value.
	 * @param guests The guests to set.
	 */
	public void setGuests(ActivityGuests guests) {
		this.guests = guests;
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
