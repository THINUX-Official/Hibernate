package lk.ijse.gdse.hibernate;

import lk.ijse.gdse.hibernate.entity.Customer;
import lk.ijse.gdse.hibernate.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UpdateVsMerge {
    public static void main(String[] args) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class, 1L);
        customer.setAddress("LA");

        session.merge(customer);
        transaction.commit();
        session.close();
    }
}
