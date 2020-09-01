package org.edziennik;

import org.edziennik.entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {
    private static SessionFactory sessionFactory;

    static {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(getHibernateConfig().getProperties()).build();
        sessionFactory = getHibernateConfig().buildSessionFactory(registry);
    }


    private static Configuration getHibernateConfig() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:hsqldb:file:db-data/mydatabase");
        configuration.setProperty("hibernate.connection.username", "admin123");
        configuration.setProperty("hibernate.connection.password", "admin123");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbc.JDBCDriver");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.show_sql", "true");


        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Teacher.class);
        configuration.addAnnotatedClass(Grade.class);
        configuration.addAnnotatedClass(Note.class);
        configuration.addAnnotatedClass(Subject.class);

        return configuration;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}


