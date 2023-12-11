package org.education.DAO;

import org.education.DAO.exception.DatabaseQueryException;
import org.education.beans.CategoryEnt;
import org.education.beans.ProductCategoryEnt;
import org.education.beans.ProductEnt;

import java.io.InputStream;
import java.util.List;

/**
 * Interface handling product-related database operations.
 */
public interface ProductDao {

    /**
     * Retrieves a list of products by category.
     * @param category The category of products to retrieve.
     * @return List of products belonging to the specified category.
     * @throws DatabaseQueryException if there's an error while fetching products.
     */
    List<ProductEnt> GetProductListByCat(String category) throws DatabaseQueryException;

    /**
     * Retrieves all products available in the database.
     * @return List of all available products.
     * @throws DatabaseQueryException if there's an error while fetching products.
     */
    List<ProductEnt> GetAllProduct() throws DatabaseQueryException;

    ProductCategoryEnt GetCatByCatName(String name) throws DatabaseQueryException;

    boolean SetDiscount(ProductEnt product) throws DatabaseQueryException;


    boolean AddProduct(ProductEnt productEnt) throws DatabaseQueryException;

    /**
     * Retrieves a product by its ID.
     * @param id The ID of the product to retrieve.
     * @return The product corresponding to the given ID.
     * @throws DatabaseQueryException if there's an error while fetching the product.
     */
    ProductEnt GetProductById(int id) throws DatabaseQueryException;
}
