package com.example.demo.common.excel.exporter.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.example.demo.common.excel.exporter.AbstractExcelExporter;
import com.example.demo.common.excel.param.BaseExcelData;
import com.example.demo.common.excel.param.OneSheetExcelData;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OneSheetExcelExporter extends AbstractExcelExporter
{
	@Override
	protected Workbook createWorkbook(BaseExcelData<?> data)
	{
		OneSheetExcelData excelData = (OneSheetExcelData)data;
		String title = excelData.getTitle();
		String sheetName = excelData.getSheetName();
		Class clazz = excelData.getEntityClass();
		List<?> rows = excelData.getRows();

		return ExcelExportUtil.exportExcel(new ExportParams(title, sheetName), clazz, rows);
	}

	@Override
	public boolean supports(BaseExcelData<?> data)
	{
		return data instanceof OneSheetExcelData;
	}
}


