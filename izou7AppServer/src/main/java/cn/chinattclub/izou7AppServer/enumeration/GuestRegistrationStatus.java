package cn.chinattclub.izou7AppServer.enumeration;
/**
 * 
 * 嘉宾申请状态枚举
 *
 * @author zhangying.
 *         Created 2014-11-13.
 */
public enum GuestRegistrationStatus {

	UNSEND(0,"未发申请"),
	/**
	 * 已发申请
	 */
	SEND(1,"已发申请"),
	
	/**
	 * 通过
	 */
	PASSED(2,"通过"),
	
	/**
	 * 拒绝
	 */
	REFUSED(3,"拒绝");
	
	
	private int value;
	
	private String name;
	
	GuestRegistrationStatus(int value,String name){
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

