package org.example.dao;

import org.example.entity.customer;
import org.example.exception.CustomerNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class CustomerDaoImpl implements CustomerDao{
    private SessionFactory sessionFactory;
    Scanner scanner = new Scanner(System.in);
    private Session session;
    {
        sessionFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(customer.class).buildSessionFactory();
    }

    @Override
    public void createCustomer(customer customer) {

        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            session.save(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("duplicate id.");
        }
    }
    @Override
    public customer getCustomerById(int customerId) {
        session=sessionFactory.openSession();
        customer customer=session.find(customer.class,customerId);
        if(customer==null)
        {
            return null;
        }
        return customer;
    }

    @Override
    public List<customer> getCustomerByName(String name) {
        session=sessionFactory.openSession();
        Query query=session.createQuery("FROM customer c where c.name=?1");
        query.setParameter(1,name);
        return query.getResultList();
    }

    @Override
    public customer updateCustomer(int customerId) throws CustomerNotFoundException {
        session=sessionFactory.openSession();
        customer customer=session.get(customer.class,customerId);
        if(customer==null)
        {
            throw new CustomerNotFoundException("no customer found.");
        }
        System.out.print("NAME: ");
        String name = scanner.next();
        customer.setCustomerName(name);
        session.getTransaction().begin();
        session.merge(customer);
        session.getTransaction().commit();
        return customer;
    }

    @Override
    public customer removeCustomer(int cusromerId) {
        session=sessionFactory.openSession();
        customer customer2=session.get(customer.class,cusromerId);
        Transaction tx=session.beginTransaction();
        session.delete(customer2);
        tx.commit();
        if(customer2==null){
            return null;
        }
        return customer2;
    }

    @Override
    public List<customer> getAllCustomer() {
        session=sessionFactory.openSession();
        Query query=session.createQuery("FROM customer");
        return query.getResultList();
    }
}

