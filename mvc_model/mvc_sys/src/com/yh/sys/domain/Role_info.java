package com.yh.sys.domain;

public class Role_info {

	private Integer role_id;
	private String role_name;
	private String role_desc;
	private String role_mark;
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_desc() {
		return role_desc;
	}
	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}
	public String getRole_mark() {
		return role_mark;
	}
	public void setRole_mark(String role_mark) {
		this.role_mark = role_mark;
	}
	@Override
	public String toString() {
		return "role_info [role_id=" + role_id + ", role_name=" + role_name + ", role_desc=" + role_desc
				+ ", role_mark=" + role_mark + "]";
	}
	
}
