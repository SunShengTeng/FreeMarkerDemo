package cn.sst.freemarker.pojo;

import java.util.Date;

/**
 * FreeMarder的测试Pojo
 * @ClassName: Person 
 * @Description: TODO
 * @author: sunshengteng
 * @date: 2018年4月19日 下午4:36:15
 */
public class Person {

	
	private int id;
	private String name;
	private String phone;
	private String address;
	private Date birthday;
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Person(){
		
	}
	public Person(int id, String name, String phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	public Person(int id, String name, String phone, String address, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
	}
	
}
