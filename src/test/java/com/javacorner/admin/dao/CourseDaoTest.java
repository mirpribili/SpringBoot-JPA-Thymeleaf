package com.javacorner.admin.dao;

import com.javacorner.admin.AbstractTest;
import com.javacorner.admin.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest // used to test the jpa repository; default use the in-memory test
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(scripts = {"file:src/test/resources/db/clearAll.sql","file:src/test/resources/db/javacorner-admin-db.sql"})
class CourseDaoTest extends AbstractTest {
    /**
     * If you need the Docker
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
     */
    @Autowired
    private CourseDao courseDao;

    @Test
    void findCoursesByCourseNameContains() {
        List<Course> courses = courseDao.findCoursesByCourseNameContains("Spring");
        int expectResult = 2;
        assertEquals(expectResult, courses.size());
    }

    @Test
    void getCoursesByStudentId() {
    }
}