package mms.member.vo;
//2. 회원 한명의 정보를 저정하는 클래스
public class Member {
	
//    id number constraint member_id_seq NOT NULL primary key,
//    name varchar2(12) unique NOT NULL,
//    addr varchar2(50) NOT NULL,
//    nation varchar2(12) NOT NULL,
//    email varchar2(30) NOT NULL,
//    age number
	
	private int id;
	private String name; //식별값
	private String addr;
	private String nation;
	private String email;
	private int age;
	
	
	public Member(String name, String addr, String nation, String email, int age) {
		
//		this.id = id; // id 제외(seq니까)
		this.name = name;
		this.addr = addr;
		this.nation = nation;
		this.email = email;
		this.age = age;
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


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public String getNation() {
		return nation;
	}


	public void setNation(String nation) {
		this.nation = nation;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	
	@Override
	public String toString() {
		String result = "name = " +name + "addr= " + addr +"nation + " +nation+ "email=" + email + "age + " + age;
		return result;
	}













	
	}
