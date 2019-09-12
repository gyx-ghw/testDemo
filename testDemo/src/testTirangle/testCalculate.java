package testTirangle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tirangle.tirCalculate;

public class testCalculate {
	 private static tirCalculate cal = new tirCalculate();
	    @Test
	    
	     public void testTriangle(){
	        cal.triangle(-5, 5, 5);
	        assertEquals(0, cal.getReuslt());
	        cal.triangle(5, 5, 5);
	        assertEquals(3, cal.getReuslt());
	        cal.triangle(5, 5, 6);
	        assertEquals(2, cal.getReuslt());
	        cal.triangle(3, 4, 5);
	        assertEquals(1, cal.getReuslt());
	        cal.triangle(12, 5, 5);
	        assertEquals(0, cal.getReuslt());
	        cal.triangle(10, 5, 5);
	        assertEquals(0, cal.getReuslt());
	        cal.triangle(11, 5, 5);
	        assertEquals(3, cal.getReuslt());
	        
	        }
}
