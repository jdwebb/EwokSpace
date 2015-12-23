// Jim Webb
//
// SER 210
//
// February 18, 2015
// Take Home Lab 3

public class rectangle1 extends rectangleBase {

	public int areaMath(){
			height = y2 - y1;
			width = x2 - x1;
			area = (Math.abs(height) * Math.abs(width));
			return area;
	}

	public int perimeterMath(){
		perimeter = (Math.abs(height*2) + Math.abs(width*2));
		return perimeter;
	}

	public String toString(){
		return("You entered the point (" + x1 + "," + y1 + ") and (" + x2 + "," + y2 + ")\n The perimeter was " + perimeter + " and the area was " + area + "\n");
	}
}
