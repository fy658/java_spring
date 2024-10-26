package com.fy658.javaspring;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.fy658.javaspring.service.User;
import com.fy658.javaspring.service.UserService;

public class Main {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = context.getBean(UserService.class);
        User user = userService.login("bob@163.com", "ss12345");
        System.out.println(user.getName());
    }
}

