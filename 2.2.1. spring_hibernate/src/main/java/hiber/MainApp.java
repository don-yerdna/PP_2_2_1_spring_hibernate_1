package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = (User) context.getBean("user");
        user1.setFirstName("User1");
        user1.setLastName("Lastname1");
        user1.setEmail("user1@mail.ru");

        User user2 = (User) context.getBean("user");
        user2.setFirstName("User2");
        user2.setLastName("Lastname2");
        user2.setEmail("user2@mail.ru");

        User user3 = (User) context.getBean("user");
        user3.setFirstName("User3");
        user3.setLastName("Lastname3");
        user3.setEmail("user3@mail.ru");

        User user4 = (User) context.getBean("user");
        user4.setFirstName("User4");
        user4.setLastName("Lastname4");
        user4.setEmail("user4@mail.ru");

        Car car1 = (Car) context.getBean("car");
        car1.setModel("model1");
        car1.setSeries(1);

        Car car2 = (Car) context.getBean("car");
        car2.setModel("model2");
        car2.setSeries(2);

        Car car3 = (Car) context.getBean("car");
        car3.setModel("model3");
        car3.setSeries(3);

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

        User userCar = userService.findByCar(car3);
        System.out.println(userCar.toString());

        context.close();
    }
}
