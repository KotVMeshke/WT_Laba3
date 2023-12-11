package org.education.service.impl;


import org.education.DAO.ProductDao;
import org.education.DAO.exception.DatabaseQueryException;
import org.education.beans.ProductEnt;
import org.education.service.ProductService;
import org.education.service.exception.ServiceException;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }
    @Override
    public List<ProductEnt> GetProductListByCat(String category) throws ServiceException {
//        List<ProductEnt> list = null;
//        try {
//            if (category != null){
//                ProductDao productDao = DAOFactory.getFactory().getProductDao();
//                list = productDao.GetProductListByCat(category);
//
//            }
//        }catch (DAOException ex){
//            throw  new ServiceException(ex);
//        }

        return null;
    }

    @Override
    public List<ProductEnt> GetAllProduct() throws ServiceException {
        try{
            return productDao.GetAllProduct();
        }
        catch (DatabaseQueryException e) {
            throw new ServiceException(e.getMessage());
        }
//        List<Product> list = null;
//        try {
//
//                ProductDao productDao = DAOFactory.getFactory().getProductDao();
//                list = productDao.GetAllProduct();
//
//
//        }catch (DAOException ex){
//            throw  new ServiceException(ex);
//        }
//
    }

    @Override
    public boolean SetDiscount(int productId, int discountSize) throws ServiceException {
       ProductEnt product = GetProductById(productId);
            try {
                product.setProDiscount(discountSize);
                productDao.SetDiscount(product);
            } catch (DatabaseQueryException e) {
                throw new ServiceException(e.getMessage());
            }


        return false;
    }

    @Override
    public boolean AddProduct(String name, String price, String category, InputStream file) throws ServiceException {
//        try {
//            ProductDao productDao = DAOFactory.getFactory().getProductDao();
//            if (name == null || price == null || category == null || file == null){
//                throw new ServiceException("Incorrect value in product add");
//            }
//            productDao.AddProduct(name, price, category, file);
//        }catch (DAOException ex){
//            throw  new ServiceException(ex);
//        }

        return true;
    }

    @Override
    public ProductEnt GetProductById(int id) throws ServiceException {
        try {
            return productDao.GetProductById(id);
        } catch (DatabaseQueryException e) {
            throw new ServiceException(e.getMessage());
        }
//        Product product = null;
//        try {
//            if (id <= 0){
//                throw  new ServiceException("Incorrect id");
//            }
//            ProductDao productDao = DAOFactory.getFactory().getProductDao();
//            product = productDao.GetProductById(id);
//
//        }catch (DAOException ex){
//            throw  new ServiceException(ex);
//        }
    }
}
