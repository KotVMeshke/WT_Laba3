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
@Table(name = "category", schema = "mydb", catalog = "")
public class CategoryEnt {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cat_id")
    private int catId;
    @Basic
    @Column(name = "cat_name")
    private String catName;
    @Basic
    @Column(name = "cat_table_name")
    private String catTableName;

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

    public String getCatTableName() {
        return catTableName;
    }

    public void setCatTableName(String catTableName) {
        this.catTableName = catTableName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEnt that = (CategoryEnt) o;

        if (catName != null ? !catName.equals(that.catName) : that.catName != null) return false;
        if (catTableName != null ? !catTableName.equals(that.catTableName) : that.catTableName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = catId;
        result = 31 * result + (catName != null ? catName.hashCode() : 0);
        result = 31 * result + (catTableName != null ? catTableName.hashCode() : 0);
        return result;
    }

}
