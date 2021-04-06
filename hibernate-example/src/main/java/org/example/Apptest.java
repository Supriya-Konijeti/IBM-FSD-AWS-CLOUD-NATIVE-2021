package org.example;

import org.example.entity.customer;
import org.example.exception.CustomerNotFoundException;
import org.example.service.CustomerService;
import org.example.service.CustomerServiceImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Apptest {
    private static Scanner scanner = new Scanner(System.in);
    private static CustomerService customerService;

    static {
        customerService = new CustomerServiceImpl();

    }
    public static void main( String[] args ) throws CustomerNotFoundException {
        int choice=0;
        do{

            System.out.println("1.Create.");
            System.out.println("2.Display.");
            System.out.println("3.Find By Id.");
            System.out.println("4.Find by name.");
            System.out.println("5.Update by ID.");
            System.out.println("6.Remove by Id.");
            System.out.println("0.Exit");
            System.out.println("Enter your choice: ");
            choice= scanner.nextInt();

            /*SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(customer.class).buildSessionFactory();
            Session session=factory.openSession();
            session.getTransaction().begin();
            session.save(new customer(1,"John"));
            session.getTransaction().commit();
            System.out.println("customer created.");*/
            switch (choice){
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    System.out.print("NAME: ");
                    String name= scanner.next();
                    customerService.createCustomer(new customer(id,name));
                    System.out.print("customer created.");
                    break;
                case 2:

                    List<customer> list=customerService.getAllCustomer();
                    Iterator<customer> iterator=list.listIterator();
                    while(iterator.hasNext())
                    {
                        System.out.println(iterator.next());
                    }
                    break;
                case 3:
                    System.out.println("Enter the id to display: ");
                    id = scanner.nextInt();
                    customer customer=customerService.getCustomerById(id);

                    if (customer==null) {
                        throw new CustomerNotFoundException("No customer with this id.."+id);
                    }
                    System.out.println(customer);
                    break;
                case 4:
                    System.out.print("NAME: ");
                    name = scanner.next();
                    List<customer> customers= customerService.getCustomerByName(name);
                    if(customers.isEmpty())
                    {
                        throw new CustomerNotFoundException("customer not found");
                    }
                    for(customer c: customers)
                    {
                        System.out.println(c);
                    }
                    break;
                case 5:
                    System.out.print("ID: ");
                    id = scanner.nextInt();
                    customer customer1=customerService.updateCustomer(id);
                    System.out.println("updation done.\n"+customer1);
                    break;
                case 6:
                    System.out.println("Enter Id to be deleted: ");
                    id=scanner.nextInt();
                    customer customer2=customerService.removeCustomer(id);
                    System.out.println("Deletion Done."+customer2);
                    break;
                case 0:
                    System.out.println("Bye....!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
                    break;
            }

        } while (choice != 0);
    }
}
