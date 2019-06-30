package com.example.demo.excel;

import com.example.demo.common.excel.ExcelUtil;
import com.example.demo.common.excel.enumeration.ExcelTypeEnum;
import com.example.demo.common.excel.model.TestModel;
import com.example.demo.common.excel.param.OneSheetExcelData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OneSheetExcelExportTest
{
	@Autowired
	private ExcelUtil excelUtil;

	@Test
	public void test()
	{
		TestModel model1 = new TestModel("1", "shit1", "男", new Date());
		TestModel model2 = new TestModel("2", "shit2", "男", new Date());
		TestModel model3 = new TestModel("3", "shit3", "男", new Date());

		//可别这样写，这样这个list是不允许被删除的
		//		List<TestModel> models = Arrays.asList(model1, model2, model3);
		List<TestModel> models = new ArrayList<>();
		models.add(model1);
		models.add(model2);
		models.add(model3);
		OneSheetExcelData<TestModel> excelData = new OneSheetExcelData<>();
		excelData.setTitle("学生信息");
		excelData.setEntityClass(TestModel.class);
		excelData.setRows(models);
		excelData.setSheetName("学生信息页");
		String path = System.getProperty("user.dir");
		String excelName = "test1_" + System.currentTimeMillis();
		excelUtil.exportExcel2Local(path, excelName, ExcelTypeEnum.XLS_03, excelData);
	}
}
