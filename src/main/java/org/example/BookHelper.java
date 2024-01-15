package org.example;

import Enitys.Author;
import Enitys.Book;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookHelper {

    private SessionFactory sessionFactory;

    {

        sessionFactory = new HibGen().getSessionFactory();

    }

    public void getBookAndAuthor(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);
        root.join("author");
        Query query = session.createQuery(cq);
        List<Book> books = query.getResultList();

        for (Book book:books) {
            System.out.println("This is book");
            System.out.println(book.getId()+" "+ book.getName() + " " + book.getAuthor().getName() + " "+ book.getAuthor().getLastName());
        }

    }

    public void updateInf(int id){

        Session session = sessionFactory.openSession();
        Book b = session.get(Book.class, id);
        b.setName("SomeNewName");
        session.beginTransaction();
        session.persist(b);
        session.getTransaction().commit();
        session.close();

    }

}
