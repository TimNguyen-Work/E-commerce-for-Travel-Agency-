package com.example.demo.entities;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity

@Getter
@Setter
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id; // Primary key

    @Column(name = "address")
    private String address;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "customer_first_name")
    private String firstName;

    @Column(name = "customer_last_name")
    private String lastName;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @Column(name = "phone")
    private String phone;

    @Column(name = "postal_code")
    private String postal_code;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "division_id")
    private Division division; // Foreign key to the 'divisions' table

   @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
   private Set<Cart> carts = new HashSet<>();

    public void add(Cart cart){
        if (cart != null){
            if (carts == null){
                carts = new HashSet<>();
            }
            carts.add(cart);
            cart.setCustomer(this);
        }



    }

    public Customer(Long id, String address, String firstName, String lastName, String phone, String postal_code, Division division) {
        this.id = id;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.postal_code = postal_code;
        this.division = division;
    }

    public Customer() {

    }
}
