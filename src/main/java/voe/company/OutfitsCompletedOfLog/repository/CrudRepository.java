package voe.company.OutfitsCompletedOfLog.repository;

import voe.company.OutfitsCompletedOfLog.entity.JournalEntity;

import java.util.List;
import java.util.Optional;

public interface CrudRepository {
    void save(JournalEntity journal);
    void addNewEntry(JournalEntity journal);
    void deleteJournalById(Long index);
    void deleteAll();
    List<JournalEntity> getFindAll();
    List<JournalEntity> findBy(String data);
    Optional<JournalEntity> findById(Long index);
}
