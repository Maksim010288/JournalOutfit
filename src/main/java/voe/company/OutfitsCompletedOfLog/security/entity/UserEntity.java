package voe.company.OutfitsCompletedOfLog.security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class UserEntity {

    @Id
    private Integer id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "role")
    private String role;
    @Column(name = "password")
    private String password;

    public UserEntity() {
    }

    public UserEntity(String userName, String role, String password) {
        this.userName = userName;
        this.role = role;
        this.password = password;
    }
}
