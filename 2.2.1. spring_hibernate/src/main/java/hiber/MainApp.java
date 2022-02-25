package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {

   public static void main(String[] args) {

      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Kolya", "Orlov", "kolya@mail.ru",
              new Car("lamba",332)));
      userService.add(new User("Igor", "Kamalov", "igor@mail.ru",
              new Car("fera",224)));
      userService.add(new User("Vasya", "mamaev", "vasya@mail.ru",
              new Car("chetirka",112)));
      userService.add(new User("Rusik", "Ibragimov", "rusik@mail.ru",
              new Car("semera",211)));
      userService.add(new User("Ligmat", "Ligmatov", "user1ligmat.ru",
              new Car("beshka",556)));
      List<User> list = userService.listUsers();

      for (User user : list) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("userToCar = " + user.getCar());
         System.out.println("___________________________________________________________________________________");
      }


//      System.out.println(userService.getUserToCar("fera",224).toString());

      context.close();
   }
}
