package com.tms.product.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by RAVI KALUARACHCHI on 12/12/2017.
 */

@Entity
@Table (name = "product")
public class Product  {

    @Id
    @GeneratedValue (strategy= GenerationType.AUTO)
    @Column (name = "product_id")
    private Integer productId;
    @Column (name = "product_category")
    private String productCategory;
    @Column (name = "Description")
    private String productDescription;
    @Column (name = "weight")
    private Integer productWeight;
    @Column (name = "product_name")
    private String productName;
    @Column (name = "porfit_per_unit")
    private BigDecimal productProfit;
    @Column (name = "product_status")
    private String productStatus;

    public Integer getProductId() { return productId; }

    public String getProductCategory() { return productCategory; }

    public String getProductDescription() { return productDescription; }

    public Integer getProductWeight() { return productWeight; }

    public String getProductName() { return productName; }

    public BigDecimal getProductProfit() { return productProfit; }

    public String getProductStatus() { return productStatus; }

    public void setProductId(Integer productId) { this.productId = productId; }

    public void setProductCategory(String productCategory) { this.productCategory = productCategory; }

    public void setProductDescription(String productDescription) { this.productDescription = productDescription; }

    public void setProductWeight(Integer productWeight) { this.productWeight = productWeight; }

    public void setProductName(String productName) { this.productName = productName; }

    public void setProductProfit(BigDecimal productProfit) { this.productProfit = productProfit; }

    public void setProductStatus(String productStatus) { this.productStatus = productStatus; }
}
