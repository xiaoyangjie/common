package com.example.demo.common.excel.exporter;

import com.example.demo.common.excel.param.BaseExcelData;

import java.io.OutputStream;

public interface ExcelExporter
{
	boolean export(BaseExcelData<?> data, OutputStream os);

	boolean supports(BaseExcelData<?> data);
}
