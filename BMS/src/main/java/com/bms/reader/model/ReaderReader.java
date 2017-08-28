package com.bms.reader.model;

import java.io.Serializable;

public class ReaderReader implements Serializable{
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
     * 读者姓名
     */
    private String readerName;

    /**
     * 读者性别
     */
    private String sex;

    /**
     * 用户主键
     */
    private String userId;
      
    /**
     * 联系方式
     */
    private String phone;
    /**
     * 邮箱
     */
    
   private String email;
   
   /**
    * 头像
    */
   
  private String avatar;
    


	public String getAvatar() {
	return avatar;
   }

    public void setAvatar(String avatar) {
	  this.avatar = avatar;
    }

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}



	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public ReaderReader() {
        super();
    }
	public ReaderReader(String id,  String userId,String readerName, String sex,String phone,String email,String avatar) {
        this.id = id;
        this.readerName = readerName;
        this.sex = sex;
        this.userId = userId;
        this.phone=phone;
        this.email=email;
        this.avatar=avatar;
    }




}
