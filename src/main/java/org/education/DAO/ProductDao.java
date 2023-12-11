package org.education.DAO;

import org.education.DAO.exception.DatabaseQueryException;
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

    /**
     * Sets a discount for a specific product.
     * @param productId The ID of the product for which the discount is to be set.
     * @param discountSize The discount percentage to be set.
     * @throws DatabaseQueryException if there's an error while setting the discount.
     */
    boolean SetDiscount(int productId, int discountSize) throws DatabaseQueryException;

    /**
     * Adds a new product to the database.
     * @param name The name of the product.
     * @param price The price of the product.
     * @param category The category of the product.
     * @param file InputStream representing the image file of the product.
     * @throws DatabaseQueryException if there's an error while adding the product.
     */
    boolean AddProduct(String name, String price, String category, InputStream file) throws DatabaseQueryException;

    /**
     * Retrieves a product by its ID.
     * @param id The ID of the product to retrieve.
     * @return The product corresponding to the given ID.
     * @throws DatabaseQueryException if there's an error while fetching the product.
     */
    ProductEnt GetProductById(int id) throws DatabaseQueryException;
}
