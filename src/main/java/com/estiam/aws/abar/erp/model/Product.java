package com.estiam.aws.abar.erp.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.estiam.aws.abar.erp.view.CustomerView;
import com.estiam.aws.abar.erp.view.OrderView;
import com.estiam.aws.abar.erp.view.ProductView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({ProductView.class, OrderView.class, CustomerView.class})
    private Long id;

    @JsonView({ProductView.class, OrderView.class, CustomerView.class})
    private String name;

    @JsonView({ProductView.class, OrderView.class, CustomerView.class})
    private String description;

    @JsonView({ProductView.class, OrderView.class, CustomerView.class})
    private BigDecimal pricePerCubicMeter;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();
}
