package cn.chinattclub.izou7AppServer.enumeration;
/**
 * 
 * 嘉宾报名状态枚举
 *
 * @author zhangying.
 *         Created 2014-11-13.
 */
public enum GuestApplyStatus {

	/**
	 * 未发邀请
	 */
	NOTSEND(0,"未发邀请"),
	
	/**
	 * 已发送邀请
	 */
	SEND(1,"已发送邀请"),
	
	/**
	 * 回复同意要求
	 */
	AGREED(2,"同意"),
	
	/**
	 * 拒绝邀请或超过期限
	 */
	REFUSED(3,"拒绝");
	
	
	private int value;
	
	private String name;
	
	GuestApplyStatus(int value,String name){
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

