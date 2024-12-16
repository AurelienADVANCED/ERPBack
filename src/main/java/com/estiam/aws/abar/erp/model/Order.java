package com.estiam.aws.abar.erp.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.estiam.aws.abar.erp.view.CustomerView;
import com.estiam.aws.abar.erp.view.OrderView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({OrderView.class, CustomerView.class})
    private Long id;

    @JsonView({OrderView.class, CustomerView.class})
    private LocalDateTime orderDate;

    @JsonView({OrderView.class, CustomerView.class})
    private LocalDateTime deliveryDate;

    @JsonView({OrderView.class, CustomerView.class})
    private String status;

    @JsonView({OrderView.class, CustomerView.class})
    private Double quantity;

    @JsonView({OrderView.class, CustomerView.class})
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonView({OrderView.class})
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @JsonView({OrderView.class, CustomerView.class})
    private Product product;
}
