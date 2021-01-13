package com.idealo.checkout.entities;

import com.idealo.checkout.data.BaseEntity;
import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Products")
public class ProductEntity extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "STOCK_KEEPING_UNITS", unique = true, nullable = false)
    private String SKU;
    @Column(name = "PRODUCT_ID", unique = true, nullable = false)
    private String productId;
    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;
    @Column(name = "MADE_IN")
    private String madeIn;
    @Column(name = "BRAND")
    private String brand;
    @Column(name = "UNIT_PRICE", nullable = false)
    private int unitPrice;
    @Column(name = "QUANTITY", nullable = false)
    private int quantity;
    @Column(name = "SUPPLIER_NAME")
    private String supplierName;
    @Column(name = "INSERTED_AT")
    private String insertedAt;
    @Column(name = "UPDATED_AT")
    private String updatedAt;
}
