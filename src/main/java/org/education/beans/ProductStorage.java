package org.education.beans;

public class ProductStorage {
    ProductEnt product;
    ProductCategoryEnt category;

    public ProductStorage(ProductEnt product, ProductCategoryEnt category) {
        this.product = product;
        this.category = category;
    }

    public ProductEnt getProduct() {
        return product;
    }

    public void setProduct(ProductEnt product) {
        this.product = product;
    }

    public ProductCategoryEnt getCategory() {
        return category;
    }

    public void setCategory(ProductCategoryEnt category) {
        this.category = category;
    }
}
