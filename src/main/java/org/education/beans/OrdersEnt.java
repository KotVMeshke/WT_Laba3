package org.education.beans;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Collection;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders", schema = "mydb", catalog = "")
public class OrdersEnt {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ord_id")
    private int ordId;
    @Basic
    @Column(name = "ord_price")
    private Double ordPrice;
    @Basic
    @Column(name = "ord_status")
    private Object ordStatus;
    @Basic
    @Column(name = "ord_address")
    private String ordAddress;
    @Basic
    @Column(name = "ord_time_stamp")
    private Timestamp ordTimeStamp;
    @OneToMany(mappedBy = "opProduct")
    private Collection<OrderProductEnt> orderProductsByOrdId;

    public int getOrdId() {
        return ordId;
    }

    public void setOrdId(int ordId) {
        this.ordId = ordId;
    }

    public Double getOrdPrice() {
        return ordPrice;
    }

    public void setOrdPrice(Double ordPrice) {
        this.ordPrice = ordPrice;
    }

    public Object getOrdStatus() {
        return ordStatus;
    }

    public void setOrdStatus(Object ordStatus) {
        this.ordStatus = ordStatus;
    }

    public String getOrdAddress() {
        return ordAddress;
    }

    public void setOrdAddress(String ordAddress) {
        this.ordAddress = ordAddress;
    }

    public Timestamp getOrdTimeStamp() {
        return ordTimeStamp;
    }

    public void setOrdTimeStamp(Timestamp ordTimeStamp) {
        this.ordTimeStamp = ordTimeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEnt ordersEnt = (OrdersEnt) o;

        if (ordId != ordersEnt.ordId) return false;
        if (ordPrice != null ? !ordPrice.equals(ordersEnt.ordPrice) : ordersEnt.ordPrice != null) return false;
        if (ordStatus != null ? !ordStatus.equals(ordersEnt.ordStatus) : ordersEnt.ordStatus != null) return false;
        if (ordAddress != null ? !ordAddress.equals(ordersEnt.ordAddress) : ordersEnt.ordAddress != null) return false;
        if (ordTimeStamp != null ? !ordTimeStamp.equals(ordersEnt.ordTimeStamp) : ordersEnt.ordTimeStamp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ordId;
        result = 31 * result + (ordPrice != null ? ordPrice.hashCode() : 0);
        result = 31 * result + (ordStatus != null ? ordStatus.hashCode() : 0);
        result = 31 * result + (ordAddress != null ? ordAddress.hashCode() : 0);
        result = 31 * result + (ordTimeStamp != null ? ordTimeStamp.hashCode() : 0);
        return result;
    }

    public Collection<OrderProductEnt> getOrderProductsByOrdId() {
        return orderProductsByOrdId;
    }

    public void setOrderProductsByOrdId(Collection<OrderProductEnt> orderProductsByOrdId) {
        this.orderProductsByOrdId = orderProductsByOrdId;
    }
}
