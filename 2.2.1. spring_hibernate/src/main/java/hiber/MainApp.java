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

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      User user1 = new User("Kolya", "Orlov", "kolya@mail.ru");
      User user2 = new User("Igor", "Kamalov", "igor@mail.ru");
      User user3 = new User("Vasya", "mamaev", "vasya@mail.ru");
      User user4 = new User("Rusik", "Ibragimov", "rusik@mail.ru");
      User user5 = new User("Ligmat", "Ligmatov", "user1ligmat.ru");

//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

      Car car1 = new Car("lamdo",332);
      Car car2 = new Car("fera",224);
      Car car3 = new Car("chetirka",112);
      Car car4 = new Car("semera",211);
      Car car5 = new Car("beshka",556);

      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));
      userService.add(user5.setCar(car5).setUser(user5));

//      for(User user : userService.listUsers()){
//         System.out.println(user + ": " + user.getCar() + "\n"
//                 + "--------------------------------------------------------");
//      }

//      System.out.println(user1.setCar(car1).setUser(user1));

//      try {
//         User user = userService.getUserToCar("semera",211);
//      }catch (NoResultException e){
//         System.out.println("Error");
//      }

      System.out.println(userService.getUserToCar("lambo",332));

      context.close();
   }
}
