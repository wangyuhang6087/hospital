package com.zhiyou100.model;

public class UserRole {


	private Integer id;

    private Integer user_id;

    private Integer role_id;
    
    private Role role;

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", user_id=" + user_id + ", role_id=" + role_id + ", role=" + role + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}