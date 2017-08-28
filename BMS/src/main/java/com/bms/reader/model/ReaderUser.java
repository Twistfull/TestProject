package com.bms.reader.model;

import java.io.Serializable;

public class ReaderUser implements Serializable{
	private static final long serialVersionUID = 1L;
	/**id*/
    private String id;
    /**用户名*/
    private String username;
    /**密码*/
    private String password;
    /**用户类型，1表示管理员，0表示读者*/
    private String userType;

    public  ReaderUser(String id, String username, String password, String userType) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }
     
    public ReaderUser() {
        super();
    }
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
