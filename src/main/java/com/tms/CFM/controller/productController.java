package com.tms.CFM.controller;

import com.tms.common.dto.Response;
import com.tms.product.dto.ProductDTO;
import com.tms.product.model.Product;
import com.tms.product.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RAVI KALUARACHCHI on 12/12/2017.
 */

@Controller
@RequestMapping ("product")
public class productController {

    @Autowired
    IProductService productService;

    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    @ResponseBody
    public Response saveProduct(final ProductDTO productDTO) {
        Response response = new Response();
        boolean saveSuccess = productService.saveProduct(productDTO);
        response.setSuccess(saveSuccess);
        return response;

    }

    @RequestMapping(value = "/getAllProducts", method = RequestMethod.POST)
    @ResponseBody
    public Response getAllProducts(String productName) {
        Response<ProductDTO> response = new Response();
        List<ProductDTO> products = new ArrayList<>();
        if(productName !=  null && productName != ""){
            ProductDTO product = productService.getProductByName(productName);
            if(product != null){
                products.add(product);
            }
        } else {
            products = productService.getAllProducts();
        }

        response.setTableData(products);
        response.setSuccess(true);
        return response;

    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    @ResponseBody
    public Response updateProduct(final ProductDTO productDTO) {
        Response response = new Response();
        boolean saveSuccess = productService.updateProduct(productDTO);
        response.setSuccess(saveSuccess);
        return response;
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
    @ResponseBody
    public Response deleteProduct(final ProductDTO productDTO) {
        Response response = new Response();
        boolean saveSuccess = productService.deleteProduct(productDTO);
        response.setSuccess(saveSuccess);
        return response;
    }



}
