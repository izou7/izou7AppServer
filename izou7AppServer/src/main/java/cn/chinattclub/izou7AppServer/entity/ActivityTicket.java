package cn.chinattclub.izou7AppServer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 活动票务实体类
 * 
 * @author ZY
 * 
 */
@Entity
@Table(name = "i_activity_ticket")
public class ActivityTicket {

	@Id
	@GeneratedValue
	private Integer id;
	
	/**
	 * 活动
	 */
	@ManyToOne
	private Activity activity;
	
	/**
	 *是否免费 
	 */
	@Column(name="is_free")
	private Boolean free;
	
	/**
	 * 价格
	 */
	private Integer price;
	
	/**
	 * 限额
	 */
	private Integer limit;
	
	/** 
	 *  售票开始时间
	 */
	@Column(name = "ticket_sale_start_time")
	private Date ticketSaleStartTime;
	
	/** 
	 *  售票结束时间
	 */
	@Column(name = "ticket_sale_end_time")
	private Date ticketSaleEndTime;
	
	/** 
	 *  票有效期开始时间
	 */
	@Column(name = "ticket_valid_start_time")
	private Date ticketValidStartTime;
	
	/** 
	 *  票有效期结束时间
	 */
	@Column(name = "ticket_valid_end_time")
	private Date ticketValidEndTime;
	
	/**
	 * 票种说明
	 */
	private String introduction;
	
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
	 * Returns the value of the field called 'free'.
	 * @return Returns the free.
	 */
	public Boolean getFree() {
		return this.free;
	}

	/**
	 * Sets the field called 'free' to the given value.
	 * @param free The free to set.
	 */
	public void setFree(Boolean free) {
		this.free = free;
	}

	/**
	 * Returns the value of the field called 'price'.
	 * @return Returns the price.
	 */
	public Integer getPrice() {
		return this.price;
	}

	/**
	 * Sets the field called 'price' to the given value.
	 * @param price The price to set.
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * Returns the value of the field called 'limit'.
	 * @return Returns the limit.
	 */
	public Integer getLimit() {
		return this.limit;
	}

	/**
	 * Sets the field called 'limit' to the given value.
	 * @param limit The limit to set.
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * Returns the value of the field called 'ticketSaleStartTime'.
	 * @return Returns the ticketSaleStartTime.
	 */
	public Date getTicketSaleStartTime() {
		return this.ticketSaleStartTime;
	}

	/**
	 * Sets the field called 'ticketSaleStartTime' to the given value.
	 * @param ticketSaleStartTime The ticketSaleStartTime to set.
	 */
	public void setTicketSaleStartTime(Date ticketSaleStartTime) {
		this.ticketSaleStartTime = ticketSaleStartTime;
	}

	/**
	 * Returns the value of the field called 'ticketSaleEndTime'.
	 * @return Returns the ticketSaleEndTime.
	 */
	public Date getTicketSaleEndTime() {
		return this.ticketSaleEndTime;
	}

	/**
	 * Sets the field called 'ticketSaleEndTime' to the given value.
	 * @param ticketSaleEndTime The ticketSaleEndTime to set.
	 */
	public void setTicketSaleEndTime(Date ticketSaleEndTime) {
		this.ticketSaleEndTime = ticketSaleEndTime;
	}

	/**
	 * Returns the value of the field called 'ticketValidStartTime'.
	 * @return Returns the ticketValidStartTime.
	 */
	public Date getTicketValidStartTime() {
		return this.ticketValidStartTime;
	}

	/**
	 * Sets the field called 'ticketValidStartTime' to the given value.
	 * @param ticketValidStartTime The ticketValidStartTime to set.
	 */
	public void setTicketValidStartTime(Date ticketValidStartTime) {
		this.ticketValidStartTime = ticketValidStartTime;
	}

	/**
	 * Returns the value of the field called 'ticketValidEndTime'.
	 * @return Returns the ticketValidEndTime.
	 */
	public Date getTicketValidEndTime() {
		return this.ticketValidEndTime;
	}

	/**
	 * Sets the field called 'ticketValidEndTime' to the given value.
	 * @param ticketValidEndTime The ticketValidEndTime to set.
	 */
	public void setTicketValidEndTime(Date ticketValidEndTime) {
		this.ticketValidEndTime = ticketValidEndTime;
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
