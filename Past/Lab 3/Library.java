//package library;

//Jim Webb
//Feb 3, 2015
//SER

import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class Library {

	static int choice ; //user choice
	static Scanner userInput = new Scanner(System.in); //scanner object for reading input
	public BooksManager bookManager = new BooksManager();
    
    /**
		* This method displays the main menu
	 **/
	public static void displayMenu(){
		System.out.println(">########################################################################");
		System.out.println("> Choose one of the options below by typing the corresponding number: ");
		System.out.println(">====================================================================");
		System.out.println("1- Display library list.");
		System.out.println("2- Add a book to the Library.");
		System.out.println("3- Borrow a book.");
		System.out.println("4- Return a book.");
		System.out.println("5- Delete a book.");
		System.out.println("6- Back to menu.");
		System.out.println("7- Display and sort by author name.");
		System.out.println("8- Display and sort by return date.");
		System.out.println("0- Exit.");
		System.out.println(">########################################################################");
		System.out.println("> Enter your option here: ");
		choice = userInput.nextInt();//User inputs a choice (integer).

	}


    /**
		* This method will read user input to create an instance of Book
	 **/
	public void createBook(){
		userInput.nextLine();
		System.out.println("> Enter the title of the book: ");
		String title = userInput.nextLine();

		System.out.println("> Enter the author of the book: ");
		String author = userInput.nextLine();

		System.out.println("> Enter the publisher of the book: ");
		String publisher = userInput.nextLine();

		System.out.println("> Enter the publication year of the book: ");
		String publicationYear = userInput.nextLine();

		String borrower = "nobody";
		Calendar borrowDate = null;
		Calendar returnDate = null;
		Boolean status = true;


		bookManager.addBook(new Book(title, author, publisher, Integer.parseInt(publicationYear), borrower, borrowDate, returnDate, false));	
	}

    /**
		* Main application loop
	 **/

	public void run(){

		System.out.println("Loading list of Books");
		bookManager.readBooks();
		//TODO Load list of books (library cannot be empty)
		this.displayMenu();//Displays the main menu and ask for choice.


			while(choice != 0){
					//Choice 1:
					if(choice == 1){
						bookManager.displayLibraryList();
					}

					//Choice 2:
					if(choice == 2){
						System.out.println("Adding a new Book \n");
						createBook();

					}
				//Choice 3:
					if(choice == 3){
						//ask user to enter book information
						userInput.nextLine();
						System.out.println("Enter title of the book you would like to borrow: \n");
						String title = userInput.nextLine();
						
						System.out.println("Enter the name of borrower: ");
						String borrowName = userInput.nextLine();
						
						System.out.println("Enter the date to return: ");
						System.out.println("Enter month: ");
						int month = Integer.parseInt(userInput.nextLine());
						
						System.out.println("Enter day: ");
						int day = Integer.parseInt(userInput.nextLine());
						
						System.out.println("Enter year: ");
						int year = Integer.parseInt(userInput.nextLine());
						
						Calendar returnDate = Calendar.getInstance();
						returnDate.set(month, day, year);
						
						bookManager.borrowBook(title, borrowName, returnDate);
					}
					//Choice 4:
					if(choice == 4){
						userInput.nextLine();
						System.out.println("Enter the book title that is being returned: "); 
						String returnTitle = userInput.nextLine();
						
						bookManager.returnBook(returnTitle);
					}
					//Choice 5:
					if(choice == 5){
						userInput.nextLine();
						System.out.println("Enter the book title to be deleted: ");
						String deleteTitle = userInput.nextLine();
						bookManager.deleteBook(deleteTitle);
					}
					//Choice 6:
					if(choice == 6){
						this.displayMenu();
					}
					//Choice 7:  sort by author name
					if(choice == 7){
						bookManager.authorSort();
						bookManager.displayLibraryList();

						this.displayMenu();
					}
					//Choice 8:  sort by return dates
					if(choice == 8){
						bookManager.returnDateSort();

						this.displayMenu();
					}
					//Choice 0:
					if(choice == 0){
						System.exit(0);;
					}
					this.displayMenu();

			}//end of while loop.

		System.out.println("####  You have Exited the Library!  ####");

		}//End of run() method.


	/**
	 * ===================================================================================================
	 * End of Class Methods.
	 * ===================================================================================================
	 */

	public static void main(String[] args){

		System.out.println("> Welcome to the library!");

		Library lib = new Library();
		lib.run();

	}//End of Main Method.

}