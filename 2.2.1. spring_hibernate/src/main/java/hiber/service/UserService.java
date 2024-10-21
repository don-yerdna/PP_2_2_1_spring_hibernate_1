package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    void addCar(User user, Car car);

    User findByFirstName(String firstName);

    User findByCar(Car car);

    List<User> listUsers();
}
