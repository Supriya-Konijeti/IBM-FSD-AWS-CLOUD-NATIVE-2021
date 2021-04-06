package org.example.Dao;

import java.util.List;
import java.util.Scanner;

import org.example.entity.Instructor;
import org.example.entity.InstructorDetails;
import org.example.exception.InstructorNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class InstructorDaoImpl implements InstructorDao {

    private SessionFactory sessionFactory;
    Scanner scanner = new Scanner(System.in);

    public InstructorDaoImpl() {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        sessionFactory = context.getBean("sessionFactory", SessionFactory.class);
    }

    @Override
    public Instructor createInstructor(Instructor instructor) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(instructor);
        session.getTransaction().commit();
        return instructor;
    }

    @Override
    public List<Instructor> getAllInstructors() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Instructor ");
        return query.getResultList();
    }

    @Override
    public Instructor updateInstructor(int instructorId) throws InstructorNotFoundException {
        Session session = sessionFactory.openSession();
        Instructor instructor = session.get(Instructor.class, instructorId);
        if (instructor == null) {
            throw new InstructorNotFoundException("no customer found.");
        }
        System.out.print("First NAME: ");
        String name = scanner.next();
        instructor.setFirstName(name);
        System.out.print("Last NAME: ");
        String name1 = scanner.next();
        instructor.setLastName(name1);
        System.out.print("Email: ");
        String email = scanner.next();
        instructor.setEmail(email);
        session.getTransaction().begin();
        session.merge(instructor);
        session.getTransaction().commit();
        return instructor;
    }

    @Override
    public Instructor removeInstructor(int instructorId) throws InstructorNotFoundException {
        Session session = sessionFactory.openSession();
        Instructor instructor2 = session.get(Instructor.class, instructorId);
        if (instructor2 == null) {
            throw new InstructorNotFoundException("no instructor found.");
        }
        Transaction tx = session.beginTransaction();
        session.delete(instructor2);
        tx.commit();
        if (instructor2 == null) {
            return null;
        }
        return instructor2;
    }

    @Override
    public InstructorDetails createInstructorDetails(InstructorDetails instructorDetails) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(instructorDetails);
        session.getTransaction().commit();
        return instructorDetails;
    }
}
