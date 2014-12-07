package cn.chinattclub.izou7AppServer.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cn.chinattclub.izou7AppServer.enumeration.CrowdfundingStatus;


/**
 * 活动众筹设置实体类
 * 
 * @author ZY
 * 
 */
@Entity
@Table(name = "i_activity_crowdfunding_setting")
public class ActivityCrowdfundingSetting {

	@Id
	@GeneratedValue
	private Integer id;
	
	/**
	 * 活动
	 */
	@ManyToOne
	private Activity activity;
	
	/**
	 * 众筹总金额
	 */
	private Integer amount;
	
	/**
	 * 众筹金额上限
	 */
	@Column(name="high_lines")
	private Integer highLines;
	
	/**
	 * 已筹到的金额
	 */
	@Column(name="got_amount")
	private Integer gotAmount;
	
	/**
	 * 众筹天数
	 */
	private Integer days;
	
	/**
	 * 收款人姓名
	 */
	@Column(name="account_name")
	private String accountName;
	
	/**
	 * 收款人账号
	 */
	@Column(name="account_number")
	private String accountNumber;
	
	/**
	 * 银行表id
	 */
	@Column(name="account_bank")
	private Integer accountBank;
	
	/**
	 * 支行
	 */
	@Column(name="sub_bank")
	private String subBank;
	
	/**
	 * 众筹状态
	 */
	@Enumerated(EnumType.ORDINAL)
	private CrowdfundingStatus status;
	
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

	
	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getHighLines() {
		return highLines;
	}

	public void setHighLines(Integer highLines) {
		this.highLines = highLines;
	}

	public Integer getGotAmount() {
		return gotAmount;
	}

	public void setGotAmount(Integer gotAmount) {
		this.gotAmount = gotAmount;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getAccountBank() {
		return accountBank;
	}

	public void setAccountBank(Integer accountBank) {
		this.accountBank = accountBank;
	}

	public String getSubBank() {
		return subBank;
	}

	public void setSubBank(String subBank) {
		this.subBank = subBank;
	}

	public CrowdfundingStatus getStatus() {
		return status;
	}

	public void setStatus(CrowdfundingStatus status) {
		this.status = status;
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


	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Returns the value of the field called 'id'.
	 * @return Returns the id.
	 */
	public Integer getId() {
		return this.id;
	}
	
}
