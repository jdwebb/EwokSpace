// Jim Webb
//
// SER 210
//
// February 18, 2015
// Take Home Lab 3

public class rectangle2 extends rectangleBase {

	public int areaMath(){
		area = (Math.abs(height) * Math.abs(width));
		return area;
	}


	public int perimeterMath(){
		perimeter = (Math.abs(height*2) + Math.abs(width*2));
		return perimeter;
	}

	public String toString(){
		return("You entered the point (" + x1 + "," + y1 + ") with a Width of " + width + " and a Height of " + height + "\n The perimeter was " + perimeter + " and the area was " + area + "\n");
	}
}