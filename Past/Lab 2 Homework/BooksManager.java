//Jim Webb
//Feb 3, 2015
//SER

import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;


public class BooksManager{

	String booksData[];
	ArrayList<Book> books = new ArrayList<Book>();
	
	public void readBooks() {
		String inputLine;
		try {
			Scanner file = new Scanner (new File("library.txt"));  //reads in the text from file library.txt
			while (file.hasNext()) {
				inputLine = file.nextLine();
				booksData = inputLine.split(",");
				addBook(new Book(booksData[0], booksData[1], booksData[2], 0, inputLine, null, null, false));
			}

			file.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File was not found.");
			System.exit(1);
		} 
	}
	
	public boolean addBook(Book addedBook) {		//adds a new book to the library
		for (Book b: books) {
			if (b.compareTo(addedBook) == 0) {
				return false;
			}
		}
		books.add(addedBook);
		return true;
	}
	
	public boolean deleteBook(String bookToRemove) {	//Deletes the book from the library
		for (Book b: books) {
			if (b.getTitle().compareTo(bookToRemove) == 0) {
				books.remove(bookToRemove);
				return true;
			}
		}
		return false; 
	}
	
	public boolean borrowBook(String title, String borrower, Calendar returnedDate) {  //removes book from library (status to true)
		for (Book b: books) {
			if (b.getTitle().compareTo(title) == 0 && b.getStatus() == false) {
					b.setStatus(true);
					b.setBorrower(borrower);
					b.setBorrowedDate(Calendar.getInstance());
					b.setReturnedDate(returnedDate);
				}
			}
		return true;
	}
	
	public boolean returnBook(String returnTitle) {		//returns the book to the library (sets status to false)
		for (Book b: books) {
			if (b.getTitle().compareTo(returnTitle) == 0 && b.getStatus() == true) {
				b.setStatus(false);
				return false;
			}	
		}
		return true;
	}
	
	public void displayLibraryList() {     //Goes through the array of lists and returns each book
		System.out.println("Books: ");
		for (Book b: books) {
			System.out.print(b.toString());
		}
		System.out.println("\n \n");
	}

}//end of BooksManager class