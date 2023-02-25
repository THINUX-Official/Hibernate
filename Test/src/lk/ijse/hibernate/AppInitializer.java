package lk.ijse.hibernate;

/*
    @author THINUX
    @created 18-Feb-23
*/

import lk.ijse.hibernate.embendded.CustName;
import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer {
    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setId(3L);

        CustName custName = new CustName();
        custName.setFirstName("Thinusha");
        custName.setMiddleName("Supun");
        custName.setLastName("Dilhara");

        customer.setName(custName);

        customer.setAddress("Galle");
        customer.setSalary(50000.00);
        customer.setAge(23);

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }
}
