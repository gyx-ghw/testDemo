package tirangle;

public class tirCalculate {
	private static int tri =0;
    public void triangle(int a,int b, int c)
    {
        if(a<=0||b<=0||c<=0)
        {
            tri=0;
        }
        else
        {
            if(((a+b)>c) && ((a+c)>b && (b+c)>a))
            {
                if((a == b) &&(a == c))
                {
                  tri = 3;//equilateral
                }
                if((a==b && a!=c)||(a==c && a!=b)||(b==c && a!=b))
                {
                    tri = 2;//isosceles
                    
                }
                if(a!=b && a!=c && b!=c)
                {
                    tri = 1;//scalene
                }
            }
            else
            {
                tri=0;//三边长度无法构成三角形
            }
        }        
    }
    
    public int getReuslt(){
        return tri;
    }
        
     public void clear(){
         tri = 0;
    }
}
