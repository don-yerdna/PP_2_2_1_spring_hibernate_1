package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car car1 = new Car();
        car1.setModel("model1");
        car1.setSeries(1);
        Car car2 = new Car();
        car2.setModel("model2");
        car2.setSeries(2);
        Car car3 = new Car();
        car3.setModel("model3");
        car3.setSeries(3);
        Car car4 = new Car();
        car4.setModel("model4");
        car4.setSeries(4);



        User user1 = new User();
        user1.setFirstName("User1");
        user1.setLastName("Lastname1");
        user1.setEmail("user1@mail.ru");
        User user2 = new User();
        user2.setFirstName("User2");
        user2.setLastName("Lastname2");
        user2.setEmail("user2@mail.ru");
        User user3 = new User();
        user3.setFirstName("User3");
        user3.setLastName("Lastname3");
        user3.setEmail("user3@mail.ru");
        User user4 = new User();
        user4.setFirstName("User4");
        user4.setLastName("Lastname4");
        user4.setEmail("user4@mail.ru");

        user1.setCar(car2);
        user2.setCar(car3);
        user3.setCar(car1);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println(user.toString());
        }

        User userCar = userService.findByCar(car4);
        System.out.println(userCar!=null?userCar.toString():"Not found!");

        context.close();
    }
}
