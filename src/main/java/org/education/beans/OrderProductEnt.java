package org.education.beans;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_product", schema = "mydb", catalog = "")
@IdClass(OrderProductEntPK.class)
public class OrderProductEnt {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "op_product")
    private int opProduct;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "op_order")
    private int opOrder;
    @Basic
    @Column(name = "op_amount")
    private Integer opAmount;

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

    public Integer getOpAmount() {
        return opAmount;
    }

    public void setOpAmount(Integer opAmount) {
        this.opAmount = opAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderProductEnt that = (OrderProductEnt) o;

        if (opProduct != that.opProduct) return false;
        if (opOrder != that.opOrder) return false;
        if (opAmount != null ? !opAmount.equals(that.opAmount) : that.opAmount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = opProduct;
        result = 31 * result + opOrder;
        result = 31 * result + (opAmount != null ? opAmount.hashCode() : 0);
        return result;
    }
}
