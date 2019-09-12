package testTirangle;

public class Triangle {

	private int side1;
	private int side2;
	private int side3;
	
	public Triangle()
	{
		this(1,1,1);
	}
	
	public Triangle(int a,int b,int c)
	{
		this.side1 = a;
		this.side2 = b;
		this.side3 = c;
	}
	
	/**
	 * 获取三角形类型
	 * @return
	 * @throws Exception
	 */
	public String GetTriangleType() throws Exception
	{
		if(side1<1||side1>100||side2<1||side2>100||side3<1||side3>100)
			return "边取值超出范围";
		if(side1+side2<=side3||side1+side3<=side2||side2+side3<=side1)
			throw new Exception("不构成三角形");
		if(side1==side2&&side2==side3)//等边三角形
			return "等边三角形";
		else if(side1==side2||side2==side3||side1==side3)//等腰三角形
		{
			return "等腰三角形";
		}
		else if(IsRtTriangle(side1,side2,side3))
			return "直角三角形";
		else//一般三角形
			return "一般三角形";
	}
	
	/**
	 * 判断是否为直角三角形
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	private boolean IsRtTriangle(int a,int b,int c)
	{
		int a_2 = a*a;
		int b_2 = b*b;
		int c_2 = c*c;
		if(a_2+b_2==c_2||a_2+c_2==b_2||b_2+c_2==a_2)
			return true;
		return false;
	}

	public static void main(String[] args) {
    	Triangle tr = new Triangle(11,11,11);
    	try
    	{
    		System.out.println(tr.GetTriangleType());
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
}