package lk.ijse.hibernate;

/*
    @author THINUX
    @created 18-Feb-23
*/

import lk.ijse.hibernate.embendded.CustName;
import lk.ijse.hibernate.embendded.MobileNo;
import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.repository.CustomerRepository;
import lk.ijse.hibernate.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AppInitializer {
    public static void main(String[] args) {

        // Save Customer
        CustomerRepository customerRepository = new CustomerRepository();
        Customer customer=getCustomerEntity();
        customerRepository.saveCustomer(customer);

        // Update Customer
        /*CustomerRepository customerRepository = new CustomerRepository();
        Customer customer = customerRepository.getCustomer(1L);
        System.out.println("Customer id: " + customer.getId());

        customer.setAddress("Matara");

        boolean isUpdated = customerRepository.updateCustomer(customer);
        if (isUpdated) {
            System.out.println("Customer " + customer.getId() + "Updated Successfully!");
        } else {
            System.out.println("Customer " + customer.getId() + "Not Updated!");
        }*/

        // Delete Customer
        /*CustomerRepository customerRepository = new CustomerRepository();
        Customer customer = getCustomerEntity();
        customerRepository.deleteCustomer(customer);*/

      /*Customer customer = new Customer();
        customer.setId(3L);

        CustName custName = new CustName();
        custName.setFirstName("Thinusha");
        custName.setMiddleName("Supun");
        custName.setLastName("Dilhara");

        customer.setName(custName);

        customer.setAddress("Galle");
        customer.setSalary(50000.00);
        customer.setAge(23);

        List<MobileNo> phoneNo = new ArrayList<>();
        phoneNo.add(new MobileNo("MOBILE", "0774002633"));
        phoneNo.add(new MobileNo("HOME", "0915474568"));
        customer.setPhoneNos(phoneNo);


        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();*/
    }

    private static Customer getCustomerEntity() {
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

        List<MobileNo> phoneNo = new ArrayList<>();
        phoneNo.add(new MobileNo("MOBILE", "0774002633"));
        phoneNo.add(new MobileNo("HOME", "0915474568"));
        customer.setPhoneNos(phoneNo);


        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();

        return customer;
    }
}
