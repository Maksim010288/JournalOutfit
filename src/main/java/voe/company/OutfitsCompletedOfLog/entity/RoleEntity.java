package voe.company.OutfitsCompletedOfLog.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "role")
    private String role;

    @ManyToOne
    @JoinColumn(name = "id_userDet")
    private UserEntity userEntity;

    public RoleEntity(){}

    public RoleEntity(String role) {
        this.role = role;
    }
}
