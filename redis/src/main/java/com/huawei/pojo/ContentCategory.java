package com.huawei.pojo;


import java.io.Serializable;

/****
 * @Author:admin
 * @Description:ContentCategory构建
 * @Date 2019/6/14 19:13
 *****/

public class ContentCategory implements Serializable{


	private Long id;//类目ID


	private String name;//分类名称



	//get方法
	public Long getId() {
		return id;
	}

	//set方法
	public void setId(Long id) {
		this.id = id;
	}
	//get方法
	public String getName() {
		return name;
	}

	//set方法
	public void setName(String name) {
		this.name = name;
	}


}
