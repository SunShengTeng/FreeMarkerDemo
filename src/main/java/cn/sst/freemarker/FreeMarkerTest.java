package cn.sst.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cn.sst.freemarker.pojo.Person;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * FreeMaker使用
 * 
 * @ClassName: FreeMarkerTest
 * @Description: TODO
 * @author: sunshengteng
 * @date: 2018年4月19日 下午4:06:02
 */
public class FreeMarkerTest {
	/**
	 * 获取模版对象 @Title: getConfiguration @Description:
	 * TODO @param @return @param @throws IOException 设定文件 @return Configuration
	 * 返回类型 @throws
	 */
	public Template getTemplate(String templatename) throws IOException {
		// 1、创建一个Configuration对象，用于初始化模版对象
		Configuration configuration = new Configuration(Configuration.getVersion());
		// 2、指定模版文件的存储路径，用于从路径中根据名称获取模版
		configuration.setDirectoryForTemplateLoading(
				new File("/Users/sunshengteng/Java_project/Workspaces/Eclipse/Study/FreeMarker/src/main/java/ftl"));
		// 3、指定模版文件的编码格式，用于模版解析
		configuration.setDefaultEncoding("utf-8");
		// 4、指定模版名称，获取模版对象
		return configuration.getTemplate(templatename);
	}

	/**
	 * 输出文件
	* @Title: outPutFile  
	* @Description: TODO
	* @param @param outPutFileName
	* @param @param data
	* @param @param template
	* @param @throws Exception    设定文件  
	* @return void    返回类型  
	* @throws
	 */
	public void outPutFile(String outPutFileName, Map data,Template template) throws Exception {
		// 6、创建用于输出文件的输出流
		Writer output = new FileWriter(new File(
				"/Users/sunshengteng/Java_project/Workspaces/Eclipse/Study/FreeMarker/src/main/webapps/"+outPutFileName));
		// 7、输出文件
		template.process(data, output);
		// 8、关闭流
		output.close();
	}

	@Test
	public void generateFile() throws Exception {

		// 1、创建一个Configuration对象，用于初始化模版对象
		Configuration configuration = new Configuration(Configuration.getVersion());
		// 2、指定模版文件的存储路径，用于从路径中根据名称获取模版
		configuration.setDirectoryForTemplateLoading(
				new File("/Users/sunshengteng/Java_project/Workspaces/Eclipse/Study/FreeMarker/src/main/java/ftl"));
		// 3、指定模版文件的编码格式，用于模版解析
		configuration.setDefaultEncoding("utf-8");
		// 4、指定模版名称，获取模版对象
		Template template = configuration.getTemplate("hello.ftl");

		// 5、构建模版数据集合
		Map<String, String> data = new HashMap<>();
		data.put("name", "孙大爷");

		// 6、创建用于输出文件的输出流
		Writer output = new FileWriter(new File(
				"/Users/sunshengteng/Java_project/Workspaces/Eclipse/Study/FreeMarker/src/main/webapps/hello.html"));
		// 7、输出文件
		template.process(data, output);
		// 8、关闭流
		output.close();

	}

	/**
	 * Pojo数据
	* @Title: generateHTMLByObject  
	* @Description: TODO
	* @param @throws Exception    设定文件  
	* @return void    返回类型  
	* @throws
	 */
	@Test
	public void generateHTMLByObject() throws Exception {
		Template template = getTemplate("Person.ftl");
		
		Person person = new Person(0, "孙大爷", "18911473005", "北京朝阳望京湖光中街1号");
		HashMap<Object, Object> data = new HashMap<>();
		data.put("person", person);
		
		outPutFile("Person.html", data, template);

	}
	
	/**
	 * List数据
	* @Title: generateHTMLByList  
	* @Description: TODO
	* @param @throws Exception    设定文件  
	* @return void    返回类型  
	* @throws
	 */
	@Test
	public void generateHTMLByList() throws Exception{
		Template template = getTemplate("PersonList.ftl");
		
		ArrayList<Object> personList = new ArrayList<>();
		personList.add(new Person(0, "孙大爷", "18911473005", "北京朝阳望京湖光中街1号",new Date()));
		personList.add(new Person(1, "孙二爷", "18911473005", "北京朝阳望京湖光中街1号",new Date()));
		personList.add(new Person(2, "孙三爷", "18911473005", "北京朝阳望京湖光中街1号",new Date()));
		personList.add(new Person(3, "测试Null", null, "北京朝阳望京湖光中街1号",new Date()));
		personList.add(new Person(4, "测试Date", "131313", "是淡粉色的", new Date()));
		HashMap<Object, Object> data = new HashMap<>();
		data.put("personList", personList);
		data.put("name", "孙大爷");
		outPutFile("PersonList.html", data, template);
	}

}
