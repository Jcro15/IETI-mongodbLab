package eci.ieti;

import eci.ieti.data.CustomerRepository;
import eci.ieti.data.ProductRepository;
import eci.ieti.data.TodoRepository;
import eci.ieti.data.UserRepository;
import eci.ieti.data.model.Customer;
import eci.ieti.data.model.Product;

import eci.ieti.data.model.Todo;
import eci.ieti.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        customerRepository.deleteAll();

        customerRepository.save(new Customer("Alice", "Smith"));
        customerRepository.save(new Customer("Bob", "Marley"));
        customerRepository.save(new Customer("Jimmy", "Page"));
        customerRepository.save(new Customer("Freddy", "Mercury"));
        customerRepository.save(new Customer("Michael", "Jackson"));


        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        
        customerRepository.findAll().stream().forEach(System.out::println);

        productRepository.deleteAll();

        productRepository.save(new Product(1L, "Samsung S8", "All new mobile phone Samsung S8"));
        productRepository.save(new Product(2L, "Samsung S8 plus", "All new mobile phone Samsung S8 plus"));
        productRepository.save(new Product(3L, "Samsung S9", "All new mobile phone Samsung S9"));
        productRepository.save(new Product(4L, "Samsung S9 plus", "All new mobile phone Samsung S9 plus"));
        productRepository.save(new Product(5L, "Samsung S10", "All new mobile phone Samsung S10"));
        productRepository.save(new Product(6L, "Samsung S10 plus", "All new mobile phone Samsung S10 plus"));
        productRepository.save(new Product(7L, "Samsung S20", "All new mobile phone Samsung S20"));
        productRepository.save(new Product(8L, "Samsung S20 plus", "All new mobile phone Samsung S20 plus"));
        productRepository.save(new Product(9L, "Samsung S20 ultra", "All new mobile phone Samsung S20 ultra"));
        
        System.out.println("Paginated search of products by criteria:");
        System.out.println("-------------------------------");
        
        productRepository.findByDescriptionContaining("plus", PageRequest.of(0, 2)).stream()
        	.forEach(System.out::println);
   
        System.out.println();
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        todoRepository.save(new Todo(1L,"description1",1, format.parse("01/10/2020"),"test1@mail.com", "status"));
        todoRepository.save(new Todo(2L,"description2",2, format.parse("02/10/2020"),"test2@mail.com", "status"));
        todoRepository.save(new Todo(3L,"description3",3, format.parse("03/10/2020"),"test3@mail.com", "status"));
        todoRepository.save(new Todo(4L,"description4",4, format.parse("04/10/2020"),"test4@mail.com", "status"));
        todoRepository.save(new Todo(5L,"description5",5, format.parse("05/10/2020"),"test5@mail.com", "status"));
        todoRepository.save(new Todo(6L,"description6",6, format.parse("06/10/2020"),"test6@mail.com", "status"));
        todoRepository.save(new Todo(7L,"description7",7, format.parse("07/10/2020"),"test7@mail.com", "status"));
        todoRepository.save(new Todo(8L,"description8",8, format.parse("08/10/2020"),"test8@mail.com", "status"));
        todoRepository.save(new Todo(9L,"description9",9, format.parse("09/10/2020"),"test9@mail.com", "status"));
        todoRepository.save(new Todo(10L,"description10",10, format.parse("10/10/2020"),"test10@mail.com", "status"));
        todoRepository.save(new Todo(11L,"description11",11, format.parse("11/10/2020"),"test1@mail.com", "status"));
        todoRepository.save(new Todo(12L,"description12",12, format.parse("12/10/2020"),"test2@mail.com", "status"));
        todoRepository.save(new Todo(13L,"description13",13, format.parse("13/10/2020"),"test3@mail.com", "status"));
        todoRepository.save(new Todo(14L,"description14",14, format.parse("14/10/2020"),"test4@mail.com", "status"));
        todoRepository.save(new Todo(15L,"description15",15, format.parse("15/10/2020"),"test5@mail.com", "status"));
        todoRepository.save(new Todo(16L,"description16",16, format.parse("16/11/2020"),"test6@mail.com", "status"));
        todoRepository.save(new Todo(17L,"description17",17, format.parse("17/11/2020"),"test7@mail.com", "status"));
        todoRepository.save(new Todo(18L,"description18",18, format.parse("18/11/2020"),"test8@mail.com", "status"));
        todoRepository.save(new Todo(19L,"description19",19, format.parse("19/11/2020"),"test9@mail.com", "status"));
        todoRepository.save(new Todo(20L,"description20",20, format.parse("20/11/2020"),"test10@mail.com", "status"));
        todoRepository.save(new Todo(21L,"description21",21, format.parse("21/11/2020"),"test1@mail.com", "status"));
        todoRepository.save(new Todo(22L,"description22",22, format.parse("22/11/2020"),"test2@mail.com", "status"));
        todoRepository.save(new Todo(23L,"description23",23, format.parse("23/11/2020"),"test3@mail.com", "status"));
        todoRepository.save(new Todo(24L,"description24",24, format.parse("24/11/2020"),"test4@mail.com", "status"));
        todoRepository.save(new Todo(25L,"description25fhffjtfytyftftffytytyftftyfftytfftyfyftyfytfytyfmnbgfhfhgfhgfhgfjg",25, format.parse("25/11/2020"),"test5@mail.com", "status"));

        userRepository.save(new User(1L,"name1","test1@mail.com"));
        userRepository.save(new User(2L,"name2","test2@mail.com"));
        userRepository.save(new User(3L,"name3","test3@mail.com"));
        userRepository.save(new User(4L,"name4","test4@mail.com"));
        userRepository.save(new User(5L,"name5","test5@mail.com"));
        userRepository.save(new User(6L,"name6","test6@mail.com"));
        userRepository.save(new User(7L,"name7","test7@mail.com"));
        userRepository.save(new User(8L,"name8","test8@mail.com"));
        userRepository.save(new User(9L,"name9","test9@mail.com"));
        userRepository.save(new User(10L,"name10","test10@mail.com"));


        todoRepository.findByResponsible("responsible1",PageRequest.of(0,2)).stream().forEach(System.out::println);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");

        Query query = new Query();
        query.addCriteria(Criteria.where("firstName").is("Alice"));
        Customer customer = mongoOperation.findOne(query, Customer.class);
        System.out.println(customer);
        System.out.println("----------Todos where the dueDate has expired------------");
        query= new Query();
        query.addCriteria(Criteria.where("dueDate").lt(new Date()));
        List<Todo>todos=mongoOperation.find(query,Todo.class);
        System.out.println(todos);
        System.out.println("--------");
        System.out.println(todoRepository.findByDueDateBefore(new Date()));
        System.out.println("----------Todos that are assigned to given user and have priority greater equal to 5-----------");
        query= new Query();
        query.addCriteria(Criteria.where("responsible").is("test2@mail.com").and("priority").gte(5));
        todos=mongoOperation.find(query,Todo.class);
        System.out.println(todos);
        System.out.println("--------");
        System.out.println(todoRepository.findByResponsibleEqualsAndPriorityIsGreaterThanEqual("test2@mail.com",5));
        System.out.println("----------Todos that contains a description with a length greater than 30 characters-----------");
        query= new Query();
        query.addCriteria(Criteria.where("description").regex("^.{30,}$"));
        todos=mongoOperation.find(query,Todo.class);
        System.out.println(todos);
        System.out.println("--------");
        System.out.println(todoRepository.findByDescriptionMatchesRegex("^.{30,}$"));





    }

}