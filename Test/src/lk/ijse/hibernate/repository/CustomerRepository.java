package lk.ijse.hibernate.repository;

/*
    @author THINUX
    @created 25-Feb-23
*/

import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;

public class CustomerRepository {
    private final Session session;

    public CustomerRepository(){
        session = SessionFactoryConfiguration.getInstance().getSession();
    }

    // Transaction Handling part
    public Integer saveCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();
        /*Integer id = (Integer) session.save(customer);
        transaction.commit();*/

        try {
            Integer id = (Integer) session.save(customer);
            transaction.commit();
            return id;
        } catch (Exception ex) {
            transaction.rollback();
            System.out.println(ex);
            ex.printStackTrace();
            return -1;
        }
//        return id;

    }
}
