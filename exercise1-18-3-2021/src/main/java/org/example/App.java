package org.example;

import org.example.model.Instructor;
import org.example.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Instructor.class).buildSessionFactory();
        Session session = factory.openSession();
        Instructor tempInstructor = new Instructor( "Darby");
        Student tempStudent =
                new Student("Supriya");
        tempInstructor.setStudent(tempStudent);
        session.getTransaction().begin();
        session.save(tempInstructor);
        session.getTransaction().commit();
        System.out.println(tempInstructor);
        System.out.println(tempStudent);
    }
}
