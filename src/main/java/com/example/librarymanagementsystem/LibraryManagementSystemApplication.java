package com.example.librarymanagementsystem;

import com.example.librarymanagementsystem.entity.Book;
import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class LibraryManagementSystemApplication implements ApplicationRunner {

	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		List<Book> books = bookService.findAllBooks();
		if(books != null && books.isEmpty()) {
			Book book1 = Book.builder().name("Book 1").description("description of book 1").price(12.5).build();
			Book book2 = Book.builder().name("Book 2").description("description of book 2").price(15).build();
			Book book3 = Book.builder().name("Book 3").description("description of book 3").price(20).build();

			Arrays.asList(book1, book2, book3).forEach(b -> bookService.createBook(b));
			System.out.println("New books added in database");
		}
	}
}
/**
 * install postgreSQL & pgadmin4:
 * sudo apt update
 * sudo apt install postgresql -y
 * sudo -i -u postgres
 * psql
 * ALTER USER postgres PASSWORD 'pass';
 * \q
 * exit
 *
 * curl -fsS https://www.pgadmin.org/static/packages_pgadmin_org.pub | sudo gpg --dearmor -o /usr/share/keyrings/packages-pgadmin-org.gpg
 * sudo sh -c 'echo "deb [signed-by=/usr/share/keyrings/packages-pgadmin-org.gpg] https://ftp.postgresql.org/pub/pgadmin/pgadmin4/apt/$(lsb_release -cs) pgadmin4 main" > /etc/apt/sources.list.d/pgadmin4.list && apt update'
 * sudo apt install pgadmin4 -y
 *
 * GUI pgadmin4 -- Databases add DB: libraryDB
 *
 * install postman
 * sudo snap install postman
 */
