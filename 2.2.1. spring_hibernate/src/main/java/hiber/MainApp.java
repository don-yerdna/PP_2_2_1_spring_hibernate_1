package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User5", "Lastname5", "user5@mail.ru"));
        userService.add(new User("User6", "Lastname6", "user6@mail.ru"));
        userService.add(new User("User7", "Lastname7", "user7@mail.ru"));
        userService.add(new User("User8", "Lastname8", "user8@mail.ru"));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }
        userService.addCar(userService.findByFirstName("User7"), new Car("model1", 1));
        userService.addCar(userService.findByFirstName("User6"), new Car("model2", 2));
        userService.addCar(userService.findByFirstName("User8"), new Car("model1", 1));
        User userscar = userService.findByCar(new Car("Model2", 2));
        System.out.println(userscar.toString());
        context.close();
    }
}
