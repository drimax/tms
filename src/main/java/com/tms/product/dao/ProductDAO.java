package com.tms.product.dao;

import com.tms.product.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by RAVI KALUARACHCHI on 12/12/2017.
 */

@Transactional
@Repository
public class ProductDAO implements IProductDAO {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Product> getAllProducts() {
        String hql = "FROM  Product as p ORDER BY p.productId";
        return (List<Product>) entityManager.createQuery(hql).getResultList();
    }
    
    @Override
    public Product getProductByName(String productNme) {
        Product product = null;
        String hql = "FROM Product as p WHERE p.productName = :productNe";
        List<Product> products = entityManager.createQuery(hql).setParameter("productNe", productNme).getResultList();
        if(products != null && products.size() > 0 ) {
            product = products.get(0);
        }

        return product;
    }

    @Override
    public boolean saveProduct(Product product) {
        Product persistedProduct = null;
        entityManager.persist(product);
        persistedProduct = getProductByName(product.getProductName());
        if(persistedProduct != null){
            return  true;
        }
        return false;
    }

    @Override
    public Product getProductById(Integer productId) {
        Product product = entityManager.find(Product.class, productId);
        return product;
    }

    @Override
    public boolean updateProduct(Product product) {
        Product persistedProduct = null;
        entityManager.merge(product);
        persistedProduct = getProductByName(product.getProductName());
        if(persistedProduct != null){
            return  true;
        }
        return false;
    }

    @Override
    public boolean deleteProduct(Product product) {
        try{
            entityManager.remove(product);
        }catch (Exception e){
            return false;
        }

        return true;
    }
}
