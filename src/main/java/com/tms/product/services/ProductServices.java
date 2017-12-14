package com.tms.product.services;

import com.tms.product.adaptor.ProductAdaptor;
import com.tms.product.dao.IProductDAO;
import com.tms.product.dto.ProductDTO;
import com.tms.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RAVI KALUARACHCHI on 12/12/2017.
 */
@Service

public class ProductServices implements IProductService {

    @Autowired
    IProductDAO productDAO;

    @Override
    public List<ProductDTO> getAllProducts() {

        ProductAdaptor adaptor = new ProductAdaptor();
        List<ProductDTO> dtoList = new ArrayList<>();
        List<Product> productList = productDAO.getAllProducts();
        if(productList != null & !productList.isEmpty()){
            for(Product product : productList){
                dtoList.add(adaptor.toDTO(product));
            }
        }
        return dtoList;
    }

    @Override
    public ProductDTO getProductByName(String productNme) {
        ProductAdaptor adaptor = new ProductAdaptor();
        Product product = productDAO.getProductByName(productNme);
        if(product != null){
            return adaptor.toDTO(product);
        } else {
            return null;
        }
    }

    @Override
    public boolean saveProduct(ProductDTO productDTO) {
        ProductAdaptor adaptor = new ProductAdaptor();
        Product product = adaptor.toModel(productDTO);
        return productDAO.saveProduct(product);
    }

    @Override
    public boolean updateProduct(ProductDTO productDTO) {
        ProductAdaptor adaptor = new ProductAdaptor();
        Product product = adaptor.toModel(productDTO);
        Product existingProduct = productDAO.getProductById(product.getProductId());
        if(existingProduct != null){
            existingProduct.setProductCategory(product.getProductCategory());
            existingProduct.setProductStatus(product.getProductStatus());
            return productDAO.updateProduct(existingProduct);
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteProduct(ProductDTO productDTO) {
        ProductAdaptor adaptor = new ProductAdaptor();
        Product product = adaptor.toModel(productDTO);
        Product existingProduct = productDAO.getProductById(product.getProductId());
        if(existingProduct != null){
            return productDAO.deleteProduct(existingProduct);
        } else {
            return false;
        }
    }

}
