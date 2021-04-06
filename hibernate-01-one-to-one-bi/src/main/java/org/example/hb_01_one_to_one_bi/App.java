package org.example.hb_01_one_to_one_bi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.example.entity.Instructor;
import org.example.entity.InstructorDetails;
import org.example.exception.InstructorNotFoundException;
import org.example.service.InstructorService;
import org.example.service.InstructorServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

    // public static void main(String[] args) {


    //try {

    // }
       /* catch (Exception exc) {
            exc.printStackTrace();
        }*/
        /*SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
        Session session = factory.openSession();
        Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
        InstructorDetails tempInstructorDetail =
                new InstructorDetails("http://www.luv2code.com/youtube", "Luv 2 code!!!");
        tempInstructor.setInstructorDetail(tempInstructorDetail);
        session.getTransaction().begin();
        session.save(tempInstructor);
        session.getTransaction().commit();
        System.out.println(tempInstructor);
        System.out.println(tempInstructorDetail);*/
    public App() {
        instructorService = new InstructorServiceImpl();
    }

    private static InstructorService instructorService = new InstructorServiceImpl();

    public static void main(String[] args) throws InstructorNotFoundException, SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-bi";
        String user = "root";
        String pass = "root";
        System.out.println("Connecting to database: " + jdbcUrl);

        Connection myConn =
                DriverManager.getConnection(jdbcUrl, user, pass);

        System.out.println("Connection successful!!!");

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {

            System.out.println("1.Create.");
            System.out.println("2.Display.");
            System.out.println("3.Update.");
            System.out.println("4.Remove.");
            System.out.println("0.Exit.");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    App app = new App();
                    SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
                    Session session = factory.openSession();

                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    System.out.print("First Name: ");
                    String fname = scanner.next();
                    System.out.print("Last Name: ");
                    String lname = scanner.next();
                    System.out.println("Email: ");
                    String email = scanner.next();
                    Instructor c = app.instructorService.createInstructor(new Instructor(fname, lname, email));
                    System.out.println(c);

                    System.out.print("You tube channel: ");
                    String ytc = scanner.next();
                    System.out.print("hobby: ");
                    String hobby = scanner.next();
                    InstructorDetails tempInstructorDetail =
                            app.instructorService.createInstructorDetails(new InstructorDetails(ytc, hobby));
                    c.setInstructorDetail(tempInstructorDetail);
                    break;
                case 2:

                    List<Instructor> list = instructorService.getAllInstructors();
                    Iterator<Instructor> iterator = list.listIterator();
                    while (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }
                    break;
                case 3:
                    App app1 = new App();
                    System.out.print("ID: ");
                    id = scanner.nextInt();
                    Instructor instructor1 = app1.instructorService.updateInstructor(id);
                    System.out.println("updation done.\n" + instructor1);
                    break;
                case 4:
                    App app2 = new App();
                    System.out.println("Enter Id to be deleted: ");
                    id = scanner.nextInt();
                    Instructor instructor2 = app2.instructorService.removeInstructor(id);
                    System.out.println("Deletion Done." + instructor2);
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
