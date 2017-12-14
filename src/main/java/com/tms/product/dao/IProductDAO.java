package com.tms.product.dao;

import com.tms.product.model.Product;

import java.util.List;

/**
 * Created by RAVI KALUARACHCHI on 12/12/2017.
 */
public interface IProductDAO {

    List<Product> getAllProducts();

    Product getProductByName(String productNme);

    boolean saveProduct(Product product);

    boolean updateProduct(Product product);

    boolean deleteProduct(Product product);

    Product getProductById(Integer productId);
}
