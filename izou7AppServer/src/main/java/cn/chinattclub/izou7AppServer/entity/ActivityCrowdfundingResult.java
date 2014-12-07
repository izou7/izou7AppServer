package cn.chinattclub.izou7AppServer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.chinattclub.izou7AppServer.enumeration.CrowdfundingStatus;


/**
 * 活动众筹设置实体类
 * 
 * @author ZY
 * 
 */
@Entity
@Table(name = "i_activity_crowdfunding_result")
public class ActivityCrowdfundingResult {

	@Id
	@GeneratedValue
	private Integer id;
	
	/**
	 * 活动
	 */
	@ManyToOne
	@JoinColumn(name="user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="crowdfunding")
	private ActivityCrowdfundingRewardSetting crowdfunding;
	
	@Column(name="account_info")
	String accountInfo;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}




	public ActivityCrowdfundingRewardSetting getCrowdfunding() {
		return crowdfunding;
	}


	public void setCrowdfunding(ActivityCrowdfundingRewardSetting crowdfunding) {
		this.crowdfunding = crowdfunding;
	}


	public String getAccountInfo() {
		return accountInfo;
	}


	public void setAccountInfo(String accountInfo) {
		this.accountInfo = accountInfo;
	}
	
	
}
