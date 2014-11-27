package cn.chinattclub.izou7AppServer.enumeration;
/**
 * 
 * 众筹状态枚举
 *
 * @author zhangying.
 *         Created 2014-11-13.
 */
public enum CrowdfundingStatus {

	/**
	 * 已发起
	 */
	SPONSORED(0,"已发起"),
	
	/**
	 * 已发送邀请
	 */
	SUCCESSED(1,"已成功"),
	
	/**
	 * 回复同意要求
	 */
	FAILED(2,"已失败");
	
	private int value;
	
	private String name;
	
	CrowdfundingStatus(int value,String name){
		this.name = name;
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

