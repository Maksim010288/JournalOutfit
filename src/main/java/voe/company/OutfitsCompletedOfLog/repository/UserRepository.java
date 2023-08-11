package voe.company.OutfitsCompletedOfLog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import voe.company.OutfitsCompletedOfLog.entity.UsersEntity;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long> {

    @Query(value = "select l from userDet l where l.last_name = ?", nativeQuery = true)
    UsersEntity findByName(String userName);
}
