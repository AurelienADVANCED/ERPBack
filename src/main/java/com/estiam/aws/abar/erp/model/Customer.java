package com.estiam.aws.abar.erp.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.estiam.aws.abar.erp.view.CustomerView;
import com.estiam.aws.abar.erp.view.OrderView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({CustomerView.class, OrderView.class})
    private Long id;

    @JsonView({CustomerView.class, OrderView.class})
    private String name;

    @JsonView({CustomerView.class, OrderView.class})
    private String email;

    @JsonView({CustomerView.class, OrderView.class})
    private String phoneNumber;

    @JsonView({CustomerView.class, OrderView.class})
    private String address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonView({CustomerView.class})
    private List<Order> orders = new ArrayList<>();
}
