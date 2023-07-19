package voe.company.OutfitsCompletedOfLog.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "userDet")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "state")
    private boolean state;
    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEntity")
    private List<RoleEntity> roleList;

    public UserEntity() {
    }

    public UserEntity(String firstName, String lastName, boolean state, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
        this.password = password;
    }
}
