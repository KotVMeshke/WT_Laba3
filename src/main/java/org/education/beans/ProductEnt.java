package org.education.beans;

import jakarta.persistence.*;
import lombok.*;

import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product", schema = "mydb", catalog = "")
public class ProductEnt {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pro_id")
    private int proId;
    @Basic
    @Column(name = "pro_name")
    private String proName;
    @Basic
    @Column(name = "pro_price")
    private String proPrice;
    @Basic
    @Column(name = "pro_discount")
    private Integer proDiscount;
    @Basic
    @Column(name = "pro_cat")
    private int proCat;
    @Basic
    @Column(name = "pro_image")
    private byte[] proImage;
    @OneToMany(mappedBy = "opOrder")
    private Collection<OrderProductEnt> orderProductsByProId;

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProPrice() {
        return proPrice;
    }

    public void setProPrice(String proPrice) {
        this.proPrice = proPrice;
    }

    public Integer getProDiscount() {
        return proDiscount;
    }

    public void setProDiscount(Integer proDiscount) {
        this.proDiscount = proDiscount;
    }

    public int getProCat() {
        return proCat;
    }

    public void setProCat(int proCat) {
        this.proCat = proCat;
    }

    public String getProImage() {
        return Base64.getEncoder().encodeToString(proImage);
    }

    public void setProImage(byte[] proImage) {
        this.proImage = proImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductEnt that = (ProductEnt) o;

        if (proId != that.proId) return false;
        if (proCat != that.proCat) return false;
        if (proName != null ? !proName.equals(that.proName) : that.proName != null) return false;
        if (proPrice != null ? !proPrice.equals(that.proPrice) : that.proPrice != null) return false;
        if (proDiscount != null ? !proDiscount.equals(that.proDiscount) : that.proDiscount != null) return false;
        if (!Arrays.equals(proImage, that.proImage)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = proId;
        result = 31 * result + (proName != null ? proName.hashCode() : 0);
        result = 31 * result + (proPrice != null ? proPrice.hashCode() : 0);
        result = 31 * result + (proDiscount != null ? proDiscount.hashCode() : 0);
        result = 31 * result + proCat;
        result = 31 * result + Arrays.hashCode(proImage);
        return result;
    }

    public Collection<OrderProductEnt> getOrderProductsByProId() {
        return orderProductsByProId;
    }

    public void setOrderProductsByProId(Collection<OrderProductEnt> orderProductsByProId) {
        this.orderProductsByProId = orderProductsByProId;
    }
}
