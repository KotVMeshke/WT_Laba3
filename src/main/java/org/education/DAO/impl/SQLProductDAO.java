package org.education.DAO.impl;

import org.education.DAO.ProductDao;
import org.education.DAO.exception.DatabaseQueryException;
import org.education.beans.CategoryEnt;
import org.education.beans.ProductCategoryEnt;
import org.education.beans.ProductEnt;
import org.education.beans.UserEnt;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public ProductCategoryEnt GetCatByCatName(String catName) throws DatabaseQueryException{
        return sessionFactory.fromTransaction(session -> {
            var query = session.createSelectionQuery("from ProductCategoryEnt where catName = :name", ProductCategoryEnt.class);
            query.setParameter("name",catName);
            ProductCategoryEnt cat = query.getSingleResultOrNull();
            if (cat == null) return null;
            else return cat;
        });
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

    @Override
    public boolean SetDiscount(ProductEnt product) throws DatabaseQueryException {
        sessionFactory.inTransaction(session -> session.merge(product));
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
    @Override
    public boolean AddProduct(ProductEnt productEnt) throws DatabaseQueryException {
        sessionFactory.inTransaction(session -> session.merge(productEnt));
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
        return sessionFactory.fromTransaction(session -> {
            var query = session.createSelectionQuery("from ProductEnt where proId = :id", ProductEnt.class);
            query.setParameter("id",id);
            ProductEnt prod = query.getSingleResultOrNull();
            if (prod == null) return null;
            else return prod;
        });
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
