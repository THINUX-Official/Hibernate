package lk.ijse.hibernate;

/*
    @author THINUX
    @created 04-Mar-23
*/

import lk.ijse.hibernate.embendded.CustName;
import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DetachedState {
    public static void main(String[] args) {

        Session session = SessionFactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();
//        transaction.commit();

        Customer customer = new Customer();

        customer.setAddress("Galle");
        customer.setAge(30);
        customer.setSalary(500000);

        session.save(customer);

        transaction.commit();

        CustName name = new CustName();
        name.setFirstName("Kamal");
        name.setMiddleName("Shantha");
        name.setLastName("Kumara");
        customer.setName(name);

        System.out.println(customer); // Detached State

        session.close();

        Session session2 = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction1 = session2.beginTransaction();

        session2.merge(customer); // Persistence State
        transaction1.commit();

        session2.close();

    }
}
