package cn.chinattclub.izou7AppServer.dto;

import java.util.List;

public class MyInfoDto {
	String name;
	String company;
	String city;
	String careerInfo;
	List<PersonDto> browser;
	int myConcern;
	int concernMe;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCareerInfo() {
		return careerInfo;
	}
	public void setCareerInfo(String careerInfo) {
		this.careerInfo = careerInfo;
	}
	public List<PersonDto> getBrowser() {
		return browser;
	}
	public void setBrowser(List<PersonDto> browser) {
		this.browser = browser;
	}
	public int getMyConcern() {
		return myConcern;
	}
	public void setMyConcern(int myConcern) {
		this.myConcern = myConcern;
	}
	public int getConcernMe() {
		return concernMe;
	}
	public void setConcernMe(int concernMe) {
		this.concernMe = concernMe;
	}
	
	
}
