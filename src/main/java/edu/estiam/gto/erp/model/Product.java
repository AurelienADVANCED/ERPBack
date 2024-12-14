package edu.estiam.gto.erp.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.estiam.gto.erp.view.CustomerView;
import edu.estiam.gto.erp.view.OrderView;
import edu.estiam.gto.erp.view.ProductView;
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
