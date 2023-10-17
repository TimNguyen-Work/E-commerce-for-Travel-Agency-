package com.example.demo.entities;


import java.math.BigDecimal;
import java.util.*;



import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Entity

@Getter
@Setter
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id; // Primary key

    @Column(name = "package_price")
    private BigDecimal package_price;

    @Column(name = "party_size")
    private int party_size;

    @Enumerated(EnumType.STRING)
    @Column(name ="status")
    public StatusType status;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer; // Foreign key to the 'customers' table

   @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
   private Set<CartItem> cartItems = new HashSet<>();


    public void add(CartItem item)
    {
        if (item != null)
        {
         if (cartItems == null)
         {cartItems = new HashSet<>();}
            if (this.getStatus() == StatusType.pending) {
                this.setStatus(StatusType.ordered);
            }
         cartItems.add(item);
         item.setCart(this);
        }

    }


}