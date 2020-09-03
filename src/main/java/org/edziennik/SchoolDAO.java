package org.edziennik;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SchoolDAO<T> {

    private Session getOpenSession(){
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        return sessionFactory.openSession();
    }

    public T getById(Class<T> classType, int id){
        Session session = getOpenSession();
        T schoolEntity = session.get(classType, id);
        session.close();
        return schoolEntity;
    }

    public void save(T schoolEntity){
        Session session = getOpenSession();
        session.save(schoolEntity);
        session.close();
    }

    public void update(T schoolEntity){
        Session session = getOpenSession();
        session.update(schoolEntity);
        session.close();
    }

    public  void delete(Class<T> classType, int id){
        Session session = getOpenSession();
        T schoolEntity = session.get(classType, id);
        session.delete(schoolEntity);
        session.close();
    }


}
