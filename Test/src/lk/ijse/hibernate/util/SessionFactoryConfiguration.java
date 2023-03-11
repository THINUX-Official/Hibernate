package lk.ijse.hibernate.util;

/*
    @author THINUX
    @created 18-Feb-23
*/

import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.entity.Orders;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfiguration {

    private static SessionFactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private SessionFactoryConfiguration(){
        /*sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure().build()).addAnnotatedClass(Customer.class).getMetadataBuilder().
                applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build().getSessionFactoryBuilder().build();*/

        sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Orders.class)
                .buildSessionFactory();
    }

    public static SessionFactoryConfiguration getInstance() {
        return (null == factoryConfiguration) ?
                factoryConfiguration = new SessionFactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession() throws HibernateException {
        // creating the service registry
//        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

        // creating the metadata object
        /*Metadata metadata = new MetadataSources(serviceRegistry).addAnnotatedClass(Customer.class).getMetadataBuilder().
                applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build();*/

//        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

       /* sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure().build()).addAnnotatedClass(Customer.class).getMetadataBuilder().
                applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build().getSessionFactoryBuilder().build();*/

        Session session = sessionFactory.openSession();

        return session;
    }

}
