import com.github.javafaker.Faker;
import org.junit.Test;

public class Day05_JavaFaker {
/*
  TEST DATA : username, password, URL, test enviroment, address etc....

  where do we get our TEST DATA ?
  - Company's BA (Business Analyst)  or
  - Test lead  or
  _ Manual Tester  or
  - From Database   or From API(Documentation)
                            Mock data ==> Java Faker is for practice
 */
@Test
    public void javaFaker(){
    // first need to creat JavaFaker object
    Faker faker = new Faker();

    //2nd Step: Create fake Data
    // generating firstName
    String firstName = faker.name().firstName();
    System.out.println("firstName = " + firstName);// will give us randum first name

    //generating lastName
    String lastName = faker.name().lastName();
    System.out.println("lastName = " + lastName);

    //generating username
    String username = faker.name().username();
    System.out.println("username = " + username);

    //generating title
    String title = faker.name().title();
    System.out.println("title = " + title);

    //fullAddress
    String fullAddress = faker.address().fullAddress();
    System.out.println("fullAddress = " + fullAddress);

    //cellPhone
    String cellPhone = faker.phoneNumber().cellPhone();
    System.out.println("cellPhone = " + cellPhone);

    //numberBetween
    int numberBetween = faker.number().numberBetween(1,5);
    System.out.println("numberBetween = " + numberBetween);





}


}
