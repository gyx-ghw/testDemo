package tirangle;

import static org.junit.Assert.*;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import testTirangle.Triangle;

/** 
 * 参数化测试的类必须有Parameterized测试运行器修饰 
 * 
 */ 

//step3 类的参数化注释
@RunWith(Parameterized.class)
public class TriangleTest {
	private Triangle t;
	private int s1;
	private int s2;
	private int s3;
	private String exp_type;
	private boolean excepted; 

	//step4 写新的传参构造方法
	public TriangleTest(int s1,int s2,int s3,boolean excepted,String type) 
			throws Exception{
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		this.excepted = excepted;
		this.exp_type = type;
	}
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		t = new Triangle(s1,s2,s3);
	}

	@After
	public void tearDown() throws Exception {
	}
	//step2 
	/* 准备测试数据。数据的准备需要在一个方法中进行，该方法需要满足一定的要求： 

        1）该方法必须由Parameters注解修饰 
        2）该方法必须为public static的 
        3）该方法必须返回Collection类型 
        4）该方法的名字不做要求 
        5）该方法没有参数 
	 * @return 
	 */  
	/*将所有测试数据放在object数组对象中 
	 object数组对象可使用任意数据类型
	    实际测试时 自己加入更多的测试数据*/
	@Parameters
	public static Collection data(){
		Object[][] object = {
				{-1,2,3,false,"边取值超出范围"},
				{101,99,99,false,"边取值超出范围"},
				{1,-1,3,false,"边取值超出范围"},
				{99,101,99,false,"边取值超出范围"},
				{1,2,-1,false,"边取值超出范围"},
				{99,99,101,false,"边取值超出范围"},
				{2,2,3,false,"等腰三角形"},
				{2,3,2,false,"等腰三角形"},
				{3,2,2,false,"等腰三角形"},
				{2,2,2,false,"等边三角形"},
				{3,4,5,true,"直角三角形"},
				{4,3,5,true,"直角三角形"},
				{5,3,4,true,"直角三角形"},
				{4,5,3,true,"直角三角形"},
				{2,3,4,false,"一般三角形"},
				{3,2,4,false,"一般三角形"},
				{4,2,3,false,"一般三角形"},
				{3,4,2,false,"一般三角形"},
				};
		return Arrays.asList(object);

	}
	//step1  做一个公用测试方法
	//三角形的类型
	@Test
	public void testGetTriangleType() throws Exception {

		String result_type = t.GetTriangleType();

		assertEquals(exp_type,result_type);
	}

	//是否为直角三角形 测试Triangle.java中的私有方法
	@Test
	public void testIsRtTriangle() throws Exception {
		//获取Class 对象
		Class triangle = t.getClass();
		//获取方法
		Method method = triangle.getDeclaredMethod("IsRtTriangle", 
				new Class[]{int.class,int.class,int.class});
		//将私有设置可访问
		method.setAccessible(true);
		//传值，返回结果对象
		Object actual = method.invoke(t,s1,s2,s3);
		//比较预期和结果
		assertEquals(excepted,actual);
	}


}