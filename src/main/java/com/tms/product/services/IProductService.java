package com.tms.product.services;

import com.tms.product.dto.ProductDTO;

import java.util.List;

/**
 * Created by RAVI KALUARACHCHI on 12/12/2017.
 */
public interface IProductService {

    List<ProductDTO> getAllProducts();

    ProductDTO getProductByName(String productNme);

    boolean saveProduct(ProductDTO productDTO);

    boolean updateProduct(ProductDTO productDTO);

    boolean deleteProduct(ProductDTO productDTO);



    }
