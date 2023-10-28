package voe.company.OutfitsCompletedLog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import voe.company.OutfitsCompletedLog.entity.JournalEntity;

import java.util.List;

@Repository
public interface MagazineRepository extends JpaRepository<JournalEntity, Long> {
    @Query(value = "select * from outfits_journal where date = ?", nativeQuery = true)
    List<JournalEntity> findByDate(String date);

    @Query(value = "select * from outfits_journal where performer = ?", nativeQuery = true)
    List<JournalEntity> findByName(String name);
}
