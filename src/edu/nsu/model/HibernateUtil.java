package edu.nsu.model;

import org.hibernate.SessionFactory;
import java.util.Properties;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

        private static SessionFactory sessionFactory;
        public static SessionFactory buildSessionFactory() {
            if(sessionFactory == null) {
                try {

                    Configuration configuration = new Configuration();
                    Properties settings = new Properties();

                    settings.put(Environment.DRIVER, "org.postgresql.Driver");

                    settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/phonebook");

                    settings.put(Environment.USER, "postgres");

                    settings.put(Environment.PASS, "infosec@MCAR611");

                    settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL92Dialect");

                    settings.put(Environment.SHOW_SQL, "true");

                    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");


                    configuration.setProperties(settings);

                    configuration.addAnnotatedClass(Contact.class);
                    configuration.addAnnotatedClass(User.class);

                    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            return sessionFactory;

    }

        public static SessionFactory getSessionFactory(){
            return buildSessionFactory();
        }

//        public static void shutdown(){getSessionFactory().close();}

}
