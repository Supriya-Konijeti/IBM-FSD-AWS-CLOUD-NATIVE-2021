package com.example.demo;

import com.example.demo.model.Instructor;
import com.example.demo.model.InstructorDetail;
import com.example.demo.repo.InstructorDetailRepository;
import com.example.demo.repo.InstructorRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercise2Application implements CommandLineRunner {
    private InstructorRepository instructorRepository;
private InstructorDetailRepository instructorDetailRepository;

public Exercise2Application(InstructorDetailRepository instructorDetailRepository){
    this.instructorDetailRepository=instructorDetailRepository;
}
    @Autowired
    public Exercise2Application(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(Exercise2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
        Session session = factory.openSession();
        Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
        InstructorDetail tempInstructorDetail =
                new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");
        tempInstructor.setInstructorDetail(tempInstructorDetail);
        session.getTransaction().begin();
        session.save(tempInstructor);
        session.getTransaction().commit();
        System.out.println(tempInstructor);
        System.out.println(tempInstructorDetail);*/
        instructorRepository.save(new Instructor("John", "Doe", "john@email.com"));
        instructorDetailRepository.save(new InstructorDetail("chdhcgd","lgcuyge"));
    }
}

