/*
package lk.ijse.hibernate;

*/
/*
    @author THINUX
    @created 04-Mar-23
*//*


import lk.ijse.hibernate.entity.Customer1;
import lk.ijse.hibernate.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TransientState {
    public static void main(String[] args) {

        Session session = SessionFactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        // This will not go to Database because of this is in the Transient state.
        Customer1 customer = new Customer1();
        customer.setAddress("Transient");
        customer.setAge(23);

        // now this will go to database because of this is in the Persistent state.
        session.save(customer);

        customer.setSalary(100000);

        transaction.commit();
        session.close();
    }
}
*/
