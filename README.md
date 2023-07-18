# SpringBoot-JPA-Thymeleaf
Developing a Full-Stack App : SpringBoot + JPA + Thymeleaf

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
