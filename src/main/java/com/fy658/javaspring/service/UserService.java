package com.fy658.javaspring.service;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private MailService mailService;

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }
    /*
    private List<User> users：声明了一个私有的List，其元素类型为User。这意味着这个List只能在声明它的类内部被访问。

new ArrayList<>()：创建了一个新的ArrayList实例。ArrayList是Java中一个常用的可变数组实现，允许动态地增加和删除元素。

List.of()：这是一个静态工厂方法，用于创建一个不可变的列表。这个方法是在Java 9中引入的，它允许你以一种简洁的方式创建一个包含指定元素的列表。例如，List.of(1, 2, 3)将创建一个包含元素1、2、3的不可变列表。

List.of()后面没有参数，所以它创建了一个空的不可变列表。这意味着你不能向这个列表添加或删除元素。
     */
    private List<User> users = new ArrayList<>(List.of(
            new User(1,"bob@163.com", "ss12345","Bob"),
            new User(2, "alice@example.com", "password", "Alice"), // alice
            new User(3, "tom@example.com", "password", "Tom")
    ));

    public User login(String email, String password){
        for (User user: users){
            if (user.getEmail().equalsIgnoreCase(email)&&user.getPassword().equals(password)){
                mailService.snedLoginMail(user);
                return user;
            }
        }
        throw  new RuntimeException("login failed");
    }

    public User getUser(long id) {
        return this.users.stream().filter(user -> user.getId() == id).findFirst().orElseThrow();
    }

    public User register(String email, String password, String name) {
        users.forEach((user) -> {
            if (user.getEmail().equalsIgnoreCase(email)) {
                throw new RuntimeException("email exist.");
            }
        });
        User user = new User(users.stream().mapToLong(u -> u.getId()).max().getAsLong(), email, password, name);
        users.add(user);
        mailService.sendRegistrationMail(user);
        return user;
    }


}

