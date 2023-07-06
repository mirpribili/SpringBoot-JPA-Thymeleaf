package com.example.librarymanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}
	// Create Entity and Repository

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
 */
