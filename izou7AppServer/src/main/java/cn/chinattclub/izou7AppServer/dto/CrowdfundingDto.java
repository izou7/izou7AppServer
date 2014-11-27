package cn.chinattclub.izou7AppServer.dto;

import java.util.Date;
import java.util.List;

public class CrowdfundingDto {
	float totalAmount;
	float currentAmount;
	Date deadLine;
	List<CrowdfundingDetailDto> detail;
	String registrationInfo;
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public float getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(float currentAmount) {
		this.currentAmount = currentAmount;
	}
	public Date getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}
	public List<CrowdfundingDetailDto> getDetail() {
		return detail;
	}
	public void setDetail(List<CrowdfundingDetailDto> detail) {
		this.detail = detail;
	}
	public String getRegistrationInfo() {
		return registrationInfo;
	}
	public void setRegistrationInfo(String registrationInfo) {
		this.registrationInfo = registrationInfo;
	}
	
	
}
