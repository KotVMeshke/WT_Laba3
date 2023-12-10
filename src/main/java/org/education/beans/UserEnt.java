package org.education.beans;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user", schema = "mydb", catalog = "")
public class UserEnt {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idUser")
    private int idUser;
    @Basic
    @Column(name = "UserLogin")
    private String userLogin;
    @Basic
    @Column(name = "UserPasswordHash")
    private String userPasswordHash;
    @Basic
    @Column(name = "role")
    private Role role;
    @Basic
    @Column(name = "ban")
    private Byte ban = 0;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPasswordHash() {
        return userPasswordHash;
    }

    public void setUserPasswordHash(String userPasswordHash) {
        this.userPasswordHash = userPasswordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Byte getBan() {
        return ban;
    }

    public void setBan(Byte ban) {
        this.ban = ban;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEnt userEnt = (UserEnt) o;

        if (idUser != userEnt.idUser) return false;
        if (userLogin != null ? !userLogin.equals(userEnt.userLogin) : userEnt.userLogin != null) return false;
        if (userPasswordHash != null ? !userPasswordHash.equals(userEnt.userPasswordHash) : userEnt.userPasswordHash != null)
            return false;
        if (role != null ? !role.equals(userEnt.role) : userEnt.role != null) return false;
        if (ban != null ? !ban.equals(userEnt.ban) : userEnt.ban != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + (userLogin != null ? userLogin.hashCode() : 0);
        result = 31 * result + (userPasswordHash != null ? userPasswordHash.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (ban != null ? ban.hashCode() : 0);
        return result;
    }
}
