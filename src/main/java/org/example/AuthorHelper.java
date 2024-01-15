package org.example;

import Enitys.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AuthorHelper {

    private SessionFactory sessionFactory;

    {

        sessionFactory = new HibGen().getSessionFactory();

    }

    public void createAdd200Authors(){

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        for (int i =0; i<200; i++){
            session.persist(new Author("Name" +i, "LastName" + i));
            if(i%10==0){
                session.flush();
                System.out.println("flush for 10 objects");
            }
        }

        session.getTransaction().commit();
        System.out.println("Adding 200 completed");
        session.close();

    }

    public void updateAuthorInf(int id){

        Session session = sessionFactory.openSession();


        Author a = session.get(Author.class, id);
        a.setName("NewName");
        a.setLastName("NewLastName");
        session.beginTransaction();
        session.persist(a);
        session.getTransaction().commit();
        session.close();

        System.out.println("author "+ a.getId() + " updated");

    }

}
