package org.education.DAO.impl;

import org.education.DAO.ProductDao;
import org.education.DAO.exception.DatabaseQueryException;
import org.education.beans.ProductEnt;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of ProductDao handling product-related database operations.
 */
@Component
public class SQLProductDAO implements ProductDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public SQLProductDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Retrieves a list of products by category name from the database.
     * @param category The category name.
     * @return The list of products in the specified category.
     * @throws DatabaseQueryException if there's an error retrieving the products.
     */
    @Override
    public List<ProductEnt> GetProductListByCat(String category) throws DatabaseQueryException {
        return null;
//        List<ProductEnt> list = new ArrayList<>();
//        ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
//        PreparedStatement ps = null;
//        Connection con = null;
//        ResultSet rs = null;
//        try {
//            con = connectionPool.getConnection();
//            ps = con.prepareStatement(GetProductsByCat);
//            ps.setString(1, category);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                Blob blob = rs.getBlob("pro_image");
//                if (blob == null)
//                    continue;
//                list.add(new Product(rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getInt(4),
//                        rs.getString(5),
//                        blob.getBytes(1,(int)blob.length())));
//            }
//        } catch (SQLException e) {
//            ConnectionPool.rollbackQuery(con);
//            throw new DatababaseQueryException("Sql error",e);
//        } finally {
//            try{
//                connectionPool.releaseConnection(con);
//                ConnectionPool.closeResultSet(rs);
//                ConnectionPool.closePreparedStatement(ps);
//            } catch (SQLException e) {
//                throw new DatababaseQueryException("SQl connection close error", e);
//            }
//        }
//        return list;
    }

    /**
     * Retrieves all products from the database.
     * @return The list of all products.
     * @throws DatabaseQueryException if there's an error retrieving the products.
     */
    @Override
    public List<ProductEnt> GetAllProduct() throws DatabaseQueryException {
        return sessionFactory.fromTransaction(session -> session.createSelectionQuery("from ProductEnt ", ProductEnt.class).getResultList());
//        List<Product> list = new ArrayList<>();
//        ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
//        Connection con = null;
//        Statement st = null;
//        ResultSet rs = null;
//        try {
//            con = connectionPool.getConnection();
//            st = con.createStatement();
//            rs = st.executeQuery(GetAllProducts);
//            while (rs.next()) {
//                Blob blob = rs.getBlob("pro_image");
//                if (blob == null)
//                    continue;
//                list.add(new Product(rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getInt(4),
//                        rs.getString(5),
//                        blob.getBytes(1,(int)blob.length())));
//            }
//        } catch (SQLException e) {
//            ConnectionPool.rollbackQuery(con);
//            throw new DatababaseQueryException("Sql error",e);
//        } finally {
//            try{
//                connectionPool.releaseConnection(con);
//                ConnectionPool.closeResultSet(rs);
//                ConnectionPool.closeStatement(st);
//            } catch (SQLException e) {
//                throw new DatababaseQueryException("SQl connection close error", e);
//            }
//        }
//        return list;
    }
    /**
     * Sets the discount for a product in the database.
     * @param productId The ID of the product.
     * @param discountSize The discount to set for the product.
     * @throws DatabaseQueryException if there's an error setting the discount.
     */
    @Override
    public boolean SetDiscount(int productId, int discountSize) throws DatabaseQueryException {
        return true;
    }
//        ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
//        PreparedStatement ps = null;
//        Connection con = null;
//        try {
//            con = connectionPool.getConnection();
//            ps = con.prepareStatement(AddDiscount);
//            ps.setInt(1, discountSize);
//            ps.setInt(2, productId);
//            int rowNumber = ps.executeUpdate();
//            if (rowNumber == 0) {
//                throw new DatababaseQueryException("Discount add exception");
//            }
//        } catch (SQLException e) {
//            ConnectionPool.rollbackQuery(con);
//            throw new DatababaseQueryException("Sql error",e);
//        } finally {
//            try{
//
//                connectionPool.releaseConnection(con);
//                ConnectionPool.closePreparedStatement(ps);
//            } catch (SQLException e) {
//                throw new DatababaseQueryException("SQl connection close error", e);
//            }
//        }
//        return true;
    /**
     * Adds a new product to the database.
     * @param name The name of the product.
     * @param price The price of the product.
     * @param category The category of the product.
     * @param file The image file of the product.
     * @throws DatabaseQueryException if there's an error adding the product.
     */
    @Override
    public boolean AddProduct(String name,String price, String category, InputStream file) throws DatabaseQueryException {
        return true;
//        ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
//        PreparedStatement ps = null;
//        Connection con = null;
//        ResultSet rs = null;
//        int categoryNumber;
//        try {
//            con = connectionPool.getConnection();
//            ps = con.prepareStatement(GetCategoryByName);
//            ps.setString(1,category);
//            rs = ps.executeQuery();
//            if (rs.next()){
//                categoryNumber = rs.getInt(1);
//            }else {
//                throw new DatababaseQueryException("Incorrect category name");
//            }
//            ps = con.prepareStatement(AddProduct);
//            ps.setString(1,name);
//            ps.setString(2,price);
//            ps.setInt(3,categoryNumber);
//            ps.setBlob(4,file);
//            int rowNumber = ps.executeUpdate();
//            if (rowNumber == 0) {
//                throw new DatababaseQueryException("Product add exception");
//            }
//        } catch (SQLException e) {
//            ConnectionPool.rollbackQuery(con);
//            throw new DatababaseQueryException("Sql error",e);
//        } finally {
//            try{
//                connectionPool.releaseConnection(con);
//                ConnectionPool.closeResultSet(rs);
//                ConnectionPool.closePreparedStatement(ps);
//            } catch (SQLException e) {
//                throw new DatababaseQueryException("SQl connection close error", e);
//            }
//        }
//        return true;
    }
    /**
     * Retrieves a product by its ID from the database.
     * @param id The ID of the product.
     * @return The product with the specified ID.
     * @throws DatabaseQueryException if there's an error retrieving the product.
     */
    @Override
    public ProductEnt GetProductById(int id) throws DatabaseQueryException {
        return null;
//        ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
//        PreparedStatement ps = null;
//        Connection con = null;
//        ResultSet rs = null;
//        Product product = null;
//        try {
//            con = connectionPool.getConnection();
//            ps = con.prepareStatement(GetProductById);
//            ps.setInt(1, id);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                product = new Product(rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getInt(4),
//                        rs.getString(5),
//                        rs.getBytes(6));
//            }
//        } catch (SQLException e) {
//            ConnectionPool.rollbackQuery(con);
//            throw new DatababaseQueryException("Sql error",e);
//        } finally {
//            try{
//                ConnectionPool.closeResultSet(rs);
//                ConnectionPool.closePreparedStatement(ps);
//                connectionPool.releaseConnection(con);
//            } catch (SQLException e) {
//                throw new DatababaseQueryException("SQl connection close error", e);
//            }
//        }
//        return product;
    }
}
