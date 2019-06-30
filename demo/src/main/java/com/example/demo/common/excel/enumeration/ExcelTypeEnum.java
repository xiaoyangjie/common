package com.example.demo.common.excel.enumeration;

public enum ExcelTypeEnum
{
	XLS_03(".xls"), XLSX_07(".xlsx");

	private String fileSuffix;
	ExcelTypeEnum(String fileSuffix)
	{
		this.fileSuffix = fileSuffix;
	}

	public String getFileSuffix()
	{
		return fileSuffix;
	}
}
