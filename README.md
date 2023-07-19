# SpringBoot-JPA-Thymeleaf
* Developing a Full-Stack App : SpringBoot + JPA + Thymeleaf

## Spring Data JPA
### Implementing Model Layer using Spring Data JPA
#### TODO
1. Create a Spring Boot Initializer.
2. Choose Application Maven Dependencies.
3. Create Entities & Relationships.
4. Add database configurations in application.properties.
5. Implementation JPA Repositories Interfaces.
6. Developing Helper Class to Test the Functionalities.
7. Create the Application Database in phpMyAdmin (MySQL).
8. Generate the Database tables from Application ORM.

## Spring Service
### Implementing Business Layer using Spring Service
#### TODO
1. Use Spring Data JPA project.
2. Remove Utility Package.
3. Create Service Interfaces & their implementations.
4. Add @Service & @Transactional Annotations to Services.
5. Update application.properties file.
6. Write from Application to Database & Test.

##  Unit & Integration Testing
### Implementing Testing Layer using SpringBoot Testing. 
#### TODO
1. Use Spring Service Project.
2. Creating Unit Tests for Service Layer using Junit-5 & Mockito-4.
3. Configuring Test Containers for Integration Test.
4. Testing Repositories using TestContainers & DataJpaTest.

## Spring MVC & Thymeleaf
### Implementing Front-End Layer using Thymeleaf
#### TODO
1. Use Testing Project
2. Add Required Dependencies to pom.xml.
3. Create 'Course' Controller & Views.
4. Create 'Instructor' Controller & Views.
5. Create 'Student' Controller & Views.

## Spring Security
### Implementing Front-End Layer using Thymeleaf
#### TODO
1. Use Spring MVC Project.
2. Add security dependencies to the pom.xml.
3. Create Security Configuration Class.
4. Implement User Detail Service.
5. Encode password using BCryptPasswordEncoder.
6. Adding role base restriction to Course Controller & Views.
7. Adding role base restriction to Instructor Controller & Views.
8. Adding role base restriction to Student Controller & Views.
9. Testing Application based on roles.


* If you need the Docker
* =============================
* sudo apt update
* sudo apt install curl software-properties-common ca-certificates apt-transport-https -y
* curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg
* echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
* sudo apt update
* apt-cache policy docker-ce
* cmd:
* docker-ce:
*   Installed: (none)
*   Candidate: 5:20.10.14~3-0~ubuntu-jammy
*   Version table:
*      5:20.10.14~3-0~ubuntu-jammy 500
*         500 https://download.docker.com/linux/ubuntu jammy/stable amd64 Packages
* sudo apt install docker-ce -y
* sudo systemctl status docker
*  Active: active (running)
*  sudo usermod -aG docker ${USER}
*  sudo usermod -aG docker $USER
*  sudo usermod -aG docker detour
*
*  su - ${USER}
*  groups
*  circumventing adm cdrom sudo dip plugdev lpadmin lxd sambashare docker
* docker run hello-world
* systemctl start docker
* sudo gpasswd -a ${USER} docker
* sudo gpasswd -a detour docker
* --------------------
* NEED RESTART
* --------------------
* If need to install the MySQL
* =============================
* sudo apt update && sudo apt upgrade
* sudo apt install mysql-server -y
* sudo apt install apache2 -y
* sudo mysql
* mysql > alter user 'root'@'localhost' identified with mysql_native_password by 'admin';
* exit
* mysql_secure_installation
* > pass admin >y >0 >n >y*4
* mysql -u root -p
* > admin
* > create database lerningDb;
* > show schemas;
* > exit
* sudo apt install php -y
* sudo apt install phpmyadmin -y
* > apach > no
* firefox: localhost
* f: localhost/phpmyadmin (if need login:root pass:admin)
* error: sudo nano /etc/apache2/apache2.conf
* file: add line> Include /etc/phpmyadmin/apache.conf
* sudo service apache2 restart
* --------------------
* If you need the java
* =============================
* java -version
* sudo apt install default-jre -y
* java -version
* sudo apt install default-jdk -y
* javac -version
*
* ----------------------
* mysql -V
* mysql  Ver 8.0.33-0ubuntu0.22.04.2 for Linux on x86_64 ((Ubuntu))
* docker --version
* Docker version 24.0.4, build 3713ee1
* javac -version
* javac 11.0.19
* java -version
* openjdk version "11.0.19" 2023-04-18
* --------------
