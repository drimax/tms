package com.tms.product.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by RAVI KALUARACHCHI on 12/12/2017.
 */
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 7526472295222276142L;

    private Integer productID;
    private String productCategory;
    private String productDescription;
    private Integer productWeight;
    private String productName;
    private BigDecimal productProfit;
    private String productStatus;

    public static long getSerialVersionUID() { return serialVersionUID; }

    public Integer getProductId() { return productID; }

    public String getProductCategory() { return productCategory; }

    public String getProductDescription() { return productDescription; }

    public Integer getProductWeight() { return productWeight; }

    public String getProductName() { return productName; }

    public BigDecimal getProductProfit() { return productProfit; }

    public String getProductStatus() { return productStatus; }

    public void setProductId(Integer productID) { this.productID = productID; }

    public void setProductCategory(String productCategory) { this.productCategory = productCategory; }

    public void setProductDescription(String productDescription) { this.productDescription = productDescription; }

    public void setProductWeight(Integer productWeight) { this.productWeight = productWeight; }

    public void setProductName(String productName) { this.productName = productName; }

    public void setProductProfit(BigDecimal productProfit) { this.productProfit = productProfit; }

    public void setProductStatus(String productStatus) { this.productStatus = productStatus; }
}
