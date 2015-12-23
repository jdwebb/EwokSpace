// Jim Webb
//
// SER 210
//
// February 18, 2015
// Take Home Lab 3

public abstract class rectangleBase {

	public int x1;		//top left x,y cords
	public int y1;

	public int x2;		//any other x,y cords used
	public int y2;

	public int height;
	public int width;

	public int area;
	public int perimeter;
	

	public void setX1(int toSet){
		x1 = toSet;
	}
	public int getX1(){
		return x1;
	}

	public void setY1(int toSet){
		y1 = toSet;
	}
	public int getY1(){
		return y1;
	}



	public void setX2(int toSet){
		x2 = toSet;
	}
	public int getX2(){
		return x2;
	}

	public void setY2(int toSet){
		y2 = toSet;
	}
	public int getY2(){
		return y2;
	}




	public void setWidth(int toSet){
		width = toSet;
	}
	public int getWidth(){
		return width;
	}

	public void setHeight(int toSet){
		height = toSet;
	}
	public int getHeight(){
		return height;
	}




	public abstract int areaMath();
		//hollow, no body

	public abstract int perimeterMath();
		//hollow, no body

	public abstract String toString();
		//no body



} //end of rectangleBase class