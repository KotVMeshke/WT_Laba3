package org.education.beans;

public class CartItem {
    public ProductEnt product;

    public int amount;

    public CartItem(ProductEnt prod, int amount) {
        product = prod; // Cloning the product to avoid issues with modifying the original object
        this.amount = amount;
    }

    public ProductEnt getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }
}
