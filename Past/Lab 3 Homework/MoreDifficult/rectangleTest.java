// Jim Webb
//
// SER 210
//
// February 18, 2015
// Take Home Lab 3

public class rectangleTest {

	public static void main (String[] args){

		rectangle1 alfa = new rectangle1();

		alfa.setX1(0);
		alfa.setY1(12);
		alfa.setX2(7);
		alfa.setY2(0);
		alfa.areaMath();
		alfa.perimeterMath();
		System.out.println(alfa.toString());


		rectangle2 bravo = new rectangle2();

		bravo.setX1(0);
		bravo.setY1(12);
		bravo.setHeight(12);
		bravo.setWidth(7);
		bravo.areaMath();
		bravo.perimeterMath();
		System.out.println(bravo.toString());



		rectangle3 charlie = new rectangle3();

		charlie.setX1(4);
		charlie.setY1(6);
		charlie.setHeight(12);
		charlie.setWidth(7);
		charlie.areaMath();
		charlie.perimeterMath();
		System.out.println(charlie.toString());





	}//end of main

}//end of testing class