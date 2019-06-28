package com.example.demo.common.excel.exporter.supports;

import com.example.demo.common.excel.exporter.ExcelExporter;
import com.example.demo.common.excel.param.BaseExcelData;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

@Component
public class ExcelExporterSupports
{
	@Autowired
	private Map<String, ExcelExporter> exporterMaps;

	/**
	 * 根据ExcelData找对应的exporter
	 * @param excelData
	 * @return
	 */
	public ExcelExporter getExporter(BaseExcelData<?> excelData)
	{
		if (MapUtils.isEmpty(exporterMaps))
		{
			return null;
		}
		Collection<ExcelExporter> exporters = exporterMaps.values();
		if (CollectionUtils.isEmpty(exporters))
		{
			return null;
		}
		for (ExcelExporter exporter : exporters)
		{
			if (exporter.supports(excelData))
			{
				return exporter;
			}
		}
		return null;
	}
}
