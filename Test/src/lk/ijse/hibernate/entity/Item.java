package lk.ijse.hibernate.entity;

/*
    @author THINUX
    @created 11-Mar-23 - 13:12 
*/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "item")
public class Item {
    @Id
    @Column(name = "item_code")
    private long itemCode;

    @Column(name = "itme_description")
    private String desc;

    @Column(name = "item_quantity")
    private int qty;

    @Column(name = "item_unitPrice")
    private double unitPrice;
}
