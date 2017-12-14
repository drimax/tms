package com.tms.product.adaptor;

import com.tms.common.adaptor.BasicAdaptor;
import com.tms.product.dto.ProductDTO;
import com.tms.product.model.Product;

/**
 * Created by RAVI KALUARACHCHI on 12/12/2017.
 */
public class ProductAdaptor extends BasicAdaptor <Product, ProductDTO> {

@Override
public Product toModel(ProductDTO dto) {
    Product product = new Product();
    product.setProductId(dto.getProductId());
    product.setProductCategory(dto.getProductCategory());
    product.setProductDescription(dto.getProductDescription());
    product.setProductName(dto.getProductName());
    product.setProductWeight(dto.getProductWeight());
    product.setProductProfit(dto.getProductProfit());
    product.setProductStatus(dto.getProductStatus());

    return  product;
}

    public ProductDTO toDTO (Product model) {
        ProductDTO dto = new ProductDTO();

        dto.setProductId(model.getProductId());
        dto.setProductCategory(model.getProductCategory());
        dto.setProductDescription(model.getProductDescription());
        dto.setProductName(model.getProductName());
        dto.setProductWeight(model.getProductWeight());
        dto.setProductProfit(model.getProductProfit());
        dto.setProductStatus(model.getProductStatus());

        return  dto;

    }

}
