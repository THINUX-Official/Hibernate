package lk.ijse.gdse.hibernate;

import lk.ijse.gdse.hibernate.entity.Customer;
import lk.ijse.gdse.hibernate.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GetVsLoad {
    public static void main(String[] args) {
        System.out.println("--------------get()---------------");
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Customer customer = session.get(Customer.class, 1L);

        System.out.println(customer);

        System.out.println();
        System.out.println();


        Session session1 = SessionFactoryConfiguration.getInstance().getSession();
        Customer load = session1.load(Customer.class, 1L);

        System.out.println(load);

    }
}
