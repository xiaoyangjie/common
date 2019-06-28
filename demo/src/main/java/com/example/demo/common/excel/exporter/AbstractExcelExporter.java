package com.example.demo.common.excel.exporter;

import com.example.demo.common.excel.param.BaseExcelData;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;

public abstract class AbstractExcelExporter implements ExcelExporter
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean export(BaseExcelData<?> data, OutputStream os)
	{
		Workbook workbook = createWorkbook(data);
		try
		{
			workbook.write(os);
		}
		catch (IOException e)
		{
			logger.error("AbstractExcelExporter: write workbook failed:" + e);
			return false;
		}
		return true;
	}

	protected abstract Workbook createWorkbook(BaseExcelData<?> data);
}
