package org.education.beans;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_category", schema = "mydb", catalog = "")
public class ProductCategoryEnt {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cat_id")
    private int catId;
    @Basic
    @Column(name = "cat_name")
    private String catName;
    @Basic
    @Column(name = "cat_parent")
    private String catParent;
    @OneToMany(mappedBy = "proCat")
    private Collection<ProductEnt> productsByCatId;

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatParent() {
        return catParent;
    }

    public void setCatParent(String catParent) {
        this.catParent = catParent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductCategoryEnt that = (ProductCategoryEnt) o;

        if (catId != that.catId) return false;
        if (catName != null ? !catName.equals(that.catName) : that.catName != null) return false;
        if (catParent != null ? !catParent.equals(that.catParent) : that.catParent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = catId;
        result = 31 * result + (catName != null ? catName.hashCode() : 0);
        result = 31 * result + (catParent != null ? catParent.hashCode() : 0);
        return result;
    }

    public Collection<ProductEnt> getProductsByCatId() {
        return productsByCatId;
    }

    public void setProductsByCatId(Collection<ProductEnt> productsByCatId) {
        this.productsByCatId = productsByCatId;
    }
}
