import org.junit.*;

public class Day02_JUnitAnnotation {

    /*
    * so far we were using Main Method
    *we no longer need Main Method as we are going to use @Test
    * @Test is use to create Test cASE
    NOTE : at ALL @Test, methods MUST be VOID coz there won't be any return or type anything

    * @Before : Runs BEFORE each @Test class.This is used to run repeated pre conditions.
    *  For example, setup, create driver, maximize window
    * @After :  Runs AFTER each @Test class. This is used to run repeated after condition
    *  For example, driver quit, report generation
    *  @BeforeClass : Runs before each CLASS only ONCE. This method must be static
    * AfterClass   : Runs after each CLASS only ONCE. This method must be static
    * @Ignor : it will igonre the Test and will not run it
     */

    @BeforeClass
    public static void setUpClass(){
        System.out.println("Before Class Runs before the entire class ONCE");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("After Class Runs after the entire class ONCE");
    }

    @Before
    public  void setup(){
        System.out.println("Before Method Runs before each @Test annotation");
    }

    @After
    public void tearDown(){
        System.out.println("After Method Runs after each @Test annotation");
    }

  @Test
  public void test1(){
      System.out.println("Test 1");

  }

    @Test
    public void test2(){
        System.out.println("Test2");

    }

    @Test @Ignore
    public void test3(){
        System.out.println("Test3");

    }

    @Test
    public void test4(){
        System.out.println("Test 4");

    }

    @Test
    public void test5(){
        System.out.println("Test 5");

    }














}
