package com.example.demo.common.excel.enumeration;

import com.example.demo.common.excel.exporter.ExcelExporter;
import com.example.demo.common.excel.exporter.impl.OneSheetExcelExporter;
import com.example.demo.common.excel.param.BaseExcelData;

/**
 * 枚举类，记录excelExporter，感觉不大好用
 */
@Deprecated
public enum ExcelExporterEnum
{
	ONE_SHEET_EXPORTER(new OneSheetExcelExporter());

	ExcelExporter excelExporter;

	ExcelExporterEnum(ExcelExporter excelExporter)
	{
		this.excelExporter = excelExporter;
	}

	public static ExcelExporter getExporter(BaseExcelData data)
	{
		for (ExcelExporterEnum exporterEnum : ExcelExporterEnum.values())
		{
			if (exporterEnum.excelExporter.supports(data))
			{
				return exporterEnum.excelExporter;
			}
		}
		throw new RuntimeException("ExcelExporterEnum: no supports exporter.");
	}

}
