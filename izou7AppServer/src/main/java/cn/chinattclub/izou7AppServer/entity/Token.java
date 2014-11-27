package cn.chinattclub.izou7AppServer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * 用户实体类
 * 
 * @author ZY
 * 
 */
@Entity
@Table(name = "i_token")
public class Token {

	@Id
	@GeneratedValue
	private Integer id;
	/**
	 * token
	 */
	private String token;

	@OneToOne
	@JoinColumn(name="user")
	private User user;
	
	@Column(name = "create_time")
	private Date createTime;
	
	/**
	 * 过期时间
	 */
	@Column(name = "exceed_time")
	private Date exceedTime;

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
	 * Returns the value of the field called 'token'.
	 * @return Returns the token.
	 */
	public String getToken() {
		return this.token;
	}

	/**
	 * Sets the field called 'token' to the given value.
	 * @param token The token to set.
	 */
	public void setToken(String token) {
		this.token = token;
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
	 * Returns the value of the field called 'exceedTime'.
	 * @return Returns the exceedTime.
	 */
	public Date getExceedTime() {
		return this.exceedTime;
	}

	/**
	 * Sets the field called 'exceedTime' to the given value.
	 * @param exceedTime The exceedTime to set.
	 */
	public void setExceedTime(Date exceedTime) {
		this.exceedTime = exceedTime;
	}

	
}
