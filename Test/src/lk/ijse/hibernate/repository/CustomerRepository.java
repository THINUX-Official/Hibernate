package lk.ijse.hibernate.repository;

/*
    @author THINUX
    @created 25-Feb-23
*/

import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerRepository {
    private final Session session;

    public CustomerRepository(){
        session = SessionFactoryConfiguration.getInstance().getSession();
    }

    // Transaction Handling part
    public Long saveCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();
        /*Integer id = (Integer) session.save(customer);
        transaction.commit();*/

        try {
            Long id = (Long) session.save(customer);
            transaction.commit();
            return id;
        } catch (Exception ex) {
            transaction.rollback();
            System.out.println(ex);
            ex.printStackTrace();
            return -1L;
        }
//        return id;
    }

    public boolean updateCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();
        try {
            session.update(customer);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
            session.close();
            return false;
        }
    }

    public Customer getCustomer(long id ){
        try {
            return session.get(Customer.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public boolean deleteCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(customer);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            return false;
        }
    }
}
