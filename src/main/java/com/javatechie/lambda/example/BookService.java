package com.javatechie.lambda.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookService {

	/*
	 * ( o1, o2) -> o2.getName().compareTo(o1.getName());
	 *
	 */
	public List<Book> getBooksinSort() {
		List<Book> books = new BookDAO().getBooks();

		/*Collections.sort(books, new Comparator<Book>() {
			@Override
			public int compare(Book book, Book t1) {
				return book.getName().compareTo(t1.getName());
			}
		});*/

		Collections.sort(books, (book, t1) -> book.getName().compareTo(t1.getName()));

		return books;

	}

	public static void main(String[] args) {
		System.out.println(new BookService().getBooksinSort());
	}
}

/*
class MyComparator implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		return o2.getName().compareTo(o1.getName());
	}
}*/
