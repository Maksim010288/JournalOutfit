package voe.company.OutfitsCompletedOfLog.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voe.company.OutfitsCompletedOfLog.security.entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
