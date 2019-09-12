package tirangle;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import testTirangle.Triangle;

/*
 * 测试Triangle.java中异常
 */
//step3 类的参数化注释
@RunWith(Parameterized.class)
public class TriangleTestException {
	private Triangle t;
	private int s1;
	private int s2;
	private int s3;
	private String exp_type;
	private boolean excepted;
	
	//step4 写新的传参构造方法
	public TriangleTestException(int s1,int s2,int s3,boolean excepted,String type) 
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
	@Parameters
	public static Collection data(){
		Object[][] object = {
				{1,2,3,false,"不构成三角形"},
				{2,3,1,false,"不构成三角形"},
				{3,1,2,false,"不构成三角形"}};
				
		return Arrays.asList(object);
		
	}
  /**
   * 三条边构不成三角形而抛出异常
   * 公用测试方法
   * @throws Exception
   */
	//step1
	@Test(expected=Exception.class)
	public void testGetTriangleTypeException() throws Exception{
		t.GetTriangleType();
		
	}

}