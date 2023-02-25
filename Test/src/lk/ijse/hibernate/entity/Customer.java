package lk.ijse.hibernate.entity;

import lk.ijse.hibernate.embendded.CustName;
import lk.ijse.hibernate.embendded.MobileNo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
    @author THINUX
    @created 18-Feb-23
*/
@Entity(name = "customer")
public class Customer {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @Column(name = "customer_name")
    private CustName name;
    @Column(name = "customer_address")
    private String address;

    @Column(name = "customer_salary")
    private double salary;

    @Column(name = "customer_age", columnDefinition = "SMALLINT")
    private int age;

    @ElementCollection
    @CollectionTable(
            name = "customer_mobile_no",
            joinColumns = @JoinColumn(name = "customer_id"))
    private List<MobileNo> phoneNos = new ArrayList<>(); // If you did not assign this to ArrayList, u will face a NULL POINT EXCEPTION.

    public Customer() {
    }

    public Customer(long id, CustName name, String address, double salary, int age, List<MobileNo> phoneNos) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.age = age;
        this.phoneNos = phoneNos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CustName getName() {
        return name;
    }

    public void setName(CustName name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<MobileNo> getPhoneNos() {
        return phoneNos;
    }

    public void setPhoneNos(List<MobileNo> phoneNos) {
        this.phoneNos = phoneNos;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name=" + name +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", phoneNos=" + phoneNos +
                '}';
    }
}
