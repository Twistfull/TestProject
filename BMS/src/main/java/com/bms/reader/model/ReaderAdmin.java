package com.bms.reader.model;

import java.io.Serializable;

public class ReaderAdmin implements Serializable{
    /**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 主键
     */
    private String id;

    /**
     * 管理员姓名
     */
    private String adminName;

    /**
     * 用户主键
     */
    private String userId;

    public ReaderAdmin(String id, String adminName, String userId) {
        this.id = id;
        this.adminName = adminName;
        this.userId = userId;
    }

    public ReaderAdmin() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
