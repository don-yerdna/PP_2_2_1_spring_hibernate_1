package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.net.CacheRequest;
import java.util.List;

public interface UserDao {
    void add(User user);

    void addCar(User user, Car car);

    User findByFirstName(String firstName);

    User findByCar(Car car);

    List<User> listUsers();
}
