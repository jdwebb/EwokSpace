// Jim Webb
//
// SER 210
//
// February 18, 2015
// Take Home Lab 3


import java.util.Scanner;
import java.io.*;

public class rectangle {

	static int choice ;
	static Scanner userInput = new Scanner(System.in);

	public int ulX;		//Upper left X cord
	public int ulY;		//Upper left Y cord

	public int lrX;		//Lower right X cord
	public int lrY;		//Lower right Y cord

	public int width;   //width and height variables
	public int height;

	public int centerX;		//center point cordinates
	public int centerY;

	public int perimeter;
	public int area;



	public static void question(){
		System.out.println("1. Upper Left point and lower right point");
		System.out.println("2. Upper Left point the width and the height");
		System.out.println("3. The center point the width and the height");
		choice = userInput.nextInt();
	}

	public void initData(){
		this.question();

			//Choice 1:
			if(choice == 1){
				System.out.println("Enter the X,Y coordinates of the upper left point");
				System.out.println("X:");
				ulX = userInput.nextInt();

				System.out.println("Y:");
				ulY = userInput.nextInt();

				System.out.println("Enter the X,Y coordinates of the lower right point");
				System.out.println("X:");
				lrX = userInput.nextInt();

				System.out.println("Y:");				
				lrY = userInput.nextInt();

				this.areaMath();
				this.perimeterMath();
			}

			//Choice 2:
			if(choice == 2){
				System.out.println("Enter the X,Y coordinates of the upper left point");
				System.out.println("X:");
				ulX = userInput.nextInt();

				System.out.println("Y:");
				ulY = userInput.nextInt();

				System.out.println("Enter the width and the height");
				System.out.println("Width:");
				width = userInput.nextInt();

				System.out.println("Height:");
				height = userInput.nextInt();

				this.areaMath();
				this.perimeterMath();
			}

			//Choice 3:
			if(choice == 3){
				System.out.println("Enter the X,Y coordinates of the center point");
				System.out.println("X:");
				centerX = userInput.nextInt();

				System.out.println("Y:");
				centerY = userInput.nextInt();

				System.out.println("Enter the width and the height");
				System.out.println("Width:");
				width = userInput.nextInt();

				System.out.println("Height:");
				height = userInput.nextInt();

				this.areaMath();
				this.perimeterMath();
			}

			if ((choice < 1) || (choice > 3))  {
				System.out.println("Error please try again later");
			}

	}//end of initdata


	public void areaMath(){
		if (choice == 1){
			height = ulY - lrY;
			width = ulX - lrX;
			area = (Math.abs(height) * Math.abs(width));
		}
		else if (choice == 2){
			area = (Math.abs(height) * Math.abs(width));
		}
		else if (choice == 3){
			area = (height * width);
		}

	}

	public void perimeterMath(){
		if (choice == 1){
			perimeter = (Math.abs(height*2) + Math.abs(width*2));
		}
		else if (choice == 2){
			perimeter = (Math.abs(height*2) + Math.abs(width*2));
		}
		else{
			perimeter = (Math.abs(height*2) + Math.abs(width*2));
		}

	}

	public String toString(){
		if (choice == 1){
			return("You entered the point (" + ulX + "," + ulY + ") and (" + lrX + "," + lrY + ") The perimeter was " + perimeter + " and the area was " + area + "\n");
		}
		else if (choice == 2){
			return("You entered the point (" + ulX + "," + ulY + ") with a Width of " + width + " and a Height of " + height + "\n The perimeter was " + perimeter + " and the area was " + area + "\n");
		}
		else{
			return("You entered the point (" + centerX + "," + centerY + ") with a Width of " + width + " and a Height of " + height + "\n The perimeter was " + perimeter + " and the area was " + area + "\n");
		}
	}




	public static void main(String[] args){

		rectangle square = new rectangle();
		square.initData();
		System.out.println(square.toString());

	}//End of Main Method.


} //end of rectangle class