package voe.company.OutfitsCompletedLog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voe.company.OutfitsCompletedLog.entity.UsersEntity;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long> {
}
