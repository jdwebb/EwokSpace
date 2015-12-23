//Jim Webb
//Feb 3, 2015
//SER

import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;


public class Book implements Comparable<Book>{

	private String title, author, publisher, borrower;
	private int publicationYear;
	private Calendar borrowedDate, returnedDate;
	private boolean status;

	public Book(String title, String author, String publisher, int publicationYear, String borrower, Calendar borrowedDate, Calendar returnedDate, Boolean status){
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publicationYear = publicationYear;
		this.borrower = borrower;
		this.borrowedDate = borrowedDate;
		this.returnedDate = returnedDate;
		this.status = status;
	}
	public void setTitle(String toSet) {
		title = toSet;
	}

	public String getTitle() {
		return title;
	}

	public void setAuthor(String toSet) {
		author = toSet;
	}

	public String getAuthor() {
		return author;
	}

	public void setPublisher(String toSet) {
		publisher = toSet;		
	}

	public String getPublisher() {
		return publisher;
	}

	public void setBorrower(String toSet) {
		borrower = toSet;		
	}

	public String getBorrower() {
		return borrower;
	}

	public void setPublishedYear(int toSet) {
		publicationYear = toSet;		
	}

	public int getPublishedYear() {
		return publicationYear;	
	}

	public void setStatus(boolean toSet) {
		status = toSet;
	}

	public boolean getStatus(){  //false is in library... true if the book is gone
		return status;
	}

	public Calendar getBorrowedDate(){
		return borrowedDate;
	}

	public void setBorrowedDate(Calendar toSet){
		borrowedDate = toSet;
	}

	public void setReturnedDate(Calendar toSet){
		returnedDate = toSet;
	}

	public Calendar getReturnedDate(){
		return returnedDate;
	}

	public String toString(){
		if (this.status == false){
			return("\n Title: " + this.title + "\n Author: " + this.author + "\n Publisher: " + this.publisher + "\n Published Year: " + this.publicationYear + "\n Status: " + this.status);
		}
		return("\n Title: " + this.title + "\n Author: " + this.author + "\n Publisher: " + this.publisher + "\n Published Year: " + this.publicationYear + "\n Borrower: " + this.borrower + "\n Borrowed Date: " + this.borrowedDate.getTime() + "\n Returned Date: " + this.returnedDate.getTime() + "\n Status: " + this.status);
	}

	public int compareTo(Book bookToCompare) {  //compares the titles of two books
		if (this.title.compareTo(bookToCompare.getTitle()) == 0) {  //there are two of the same books
			return 0;
		}
		return 1;
	}

}//end of Book class















