package com.example.demo.common.excel;

import com.example.demo.common.excel.enumeration.ExcelExporterEnum;
import com.example.demo.common.excel.enumeration.ExcelTypeEnum;
import com.example.demo.common.excel.exporter.ExcelExporter;
import com.example.demo.common.excel.exporter.supports.ExcelExporterSupports;
import com.example.demo.common.excel.param.BaseExcelData;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * 导入、导出通用工具类
 * 一般自定义exceldata的同时，需实现一个如何解析数据的excelExporter，建议继承AbstractExcelExporter
 */
@Component
public class ExcelUtil
{
	private Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

	@Autowired
	private ExcelExporterSupports exporterSupports;

	public boolean exportExcel2Local(String directory, String excelName, ExcelTypeEnum type, BaseExcelData<?> data)
	{
		ExcelExporter excelExporter = exporterSupports.getExporter(data);
		return exportExcel2Local(directory, excelName, type, data, excelExporter);
	}

	public boolean exportExcel2Local(String directory, String excelName, ExcelTypeEnum type, BaseExcelData<?> data,
			ExcelExporter selfDefineExporter)
	{
		String fileName = excelName + type.getFileSuffix();
		String completePath = directory + File.separator + fileName;
		return exportExcel2Local(completePath, data, selfDefineExporter);
	}

	public boolean exportExcel2Local(String completePath, BaseExcelData<?> data, ExcelExporter excelExporter)
	{
		if (excelExporter == null)
		{
			logger.error("ExcelUtil.exportExcel2Local error: No supports excel exporter.");
			return false;
		}
		OutputStream os = null;
		try
		{
			File excelFile = new File(completePath);
			os = new FileOutputStream(excelFile);
			return excelExporter.export(data, os);
		}
		catch (FileNotFoundException e)
		{
			logger.error("ExcelUtil.exportExcel2Local error:" + e);
		}
		finally
		{
			IOUtils.closeQuietly(os);
		}
		return false;
	}

	/**
	 * 根据传入数据找到合适的导出工具类
	 *
	 * @param data
	 * @return
	 */
	@Deprecated
	private ExcelExporter getExporter(BaseExcelData<?> data)
	{
		return ExcelExporterEnum.getExporter(data);
	}
}
