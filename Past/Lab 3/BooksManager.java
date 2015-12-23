//Jim Webb
//Feb 3, 2015
//SER

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;
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
	
	public void authorSort(){				//sort by author date

		Collections.sort(books, new Comparator<Book>(){
			public int compare(Book book1, Book book2 ){
				return book1.getAuthor().compareTo(book2.getAuthor());
			}
		});
	} //end of authorSort



		public void returnDateSort(){					//Sort by return date

		Collections.sort(books, new Comparator<Book>(){
			public int compare(Book book1, Book book2 ){
				return book1.getBorrowedDate().compareTo(book2.getBorrowedDate());
			}
		});
		for( Book b: books){
			if (b.getStatus() == true){
				System.out.println(b.toString());
			}
			else {
				System.out.println(b.toString());
			}
		}
	} //end of returnDateSort
	


	public void displayLibraryList() {     //Goes through the array of lists and returns each book
		System.out.println("Books: ");
		for (Book b: books) {
			System.out.print(b.toString());
		}
		System.out.println("\n \n");
	}



}//end of BooksManager class