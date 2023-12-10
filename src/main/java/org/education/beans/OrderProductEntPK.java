package org.education.beans;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class OrderProductEntPK implements Serializable {
    @Column(name = "op_product")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int opProduct;
    @Column(name = "op_order")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int opOrder;

    public int getOpProduct() {
        return opProduct;
    }

    public void setOpProduct(int opProduct) {
        this.opProduct = opProduct;
    }

    public int getOpOrder() {
        return opOrder;
    }

    public void setOpOrder(int opOrder) {
        this.opOrder = opOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderProductEntPK that = (OrderProductEntPK) o;

        if (opProduct != that.opProduct) return false;
        if (opOrder != that.opOrder) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = opProduct;
        result = 31 * result + opOrder;
        return result;
    }
}
