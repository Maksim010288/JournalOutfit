package voe.company.OutfitsCompletedLog.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_details")
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;

    public UsersEntity(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UsersEntity(){}

}
