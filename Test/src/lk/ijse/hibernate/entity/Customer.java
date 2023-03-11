package lk.ijse.hibernate.entity;

/*
    @author THINUX
    @created 11-Mar-23 - 11:15 
*/

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customer_id")
    private long id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_address")
    private String address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
    private List<Orders> orders = new ArrayList<>();

    public Customer() {
    }

    public Customer(long id, String name, String address, List<Orders> orders) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", orders=" + orders +
                '}';
    }
}
