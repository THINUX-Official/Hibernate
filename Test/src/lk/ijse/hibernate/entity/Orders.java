package lk.ijse.hibernate.entity;

/*
    @author THINUX
    @created 11-Mar-23 - 11:17 
*/

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @Column(name = "order_id")
    private long oid;

    @Column(name = "order_date")
    private Timestamp oDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Orders() {
    }

    public Orders(long oid, Timestamp oDate, Customer customer) {
        this.oid = oid;
        this.oDate = oDate;
        this.customer = customer;
    }

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public Timestamp getoDate() {
        return oDate;
    }

    public void setoDate(Timestamp oDate) {
        this.oDate = oDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oid=" + oid +
                ", oDate=" + oDate +
                ", customer=" + customer +
                '}';
    }
}
