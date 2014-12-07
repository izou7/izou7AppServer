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
@Table(name = "i_activity_message")
public class ActivityMessage {


	@Id
	@GeneratedValue
	private Integer id;
	
	/**
	 * 活动
	 */
	private Integer activity;
	
	@ManyToOne
	@JoinColumn(name="user")
	private User user;
	/**
	 * 发邀请排名
	 */
	private String message;
	
	@Column(name="create_time")
	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getActivity() {
		return activity;
	}

	public void setActivity(Integer activity) {
		this.activity = activity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
