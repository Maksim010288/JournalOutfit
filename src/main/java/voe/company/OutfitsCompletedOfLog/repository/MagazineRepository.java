package voe.company.OutfitsCompletedOfLog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voe.company.OutfitsCompletedOfLog.entity.JournalEntity;

@Repository
public interface MagazineRepository extends JpaRepository<JournalEntity, Long> {
}
