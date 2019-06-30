package com.example.demo.common.excel.model;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;
import java.util.Date;

public class TestModel implements Serializable
{
	private String id;

	@Excel(name = "学生姓名", height = 20, width = 30, isImportField = "true_st")
	private String name;

	@Excel(name = "学生性别", replace = { "男_1", "女_2" }, suffix = "生", isImportField = "true_st")
	private String sex;

	@Excel(name = "出生日期", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd", isImportField = "true_st", width = 20)
	private Date birthday;

	public TestModel(String id, String name, String sex, Date birthday)
	{
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public Date getBirthday()
	{
		return birthday;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}
}
