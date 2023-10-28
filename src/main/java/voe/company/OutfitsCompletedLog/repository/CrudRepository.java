package voe.company.OutfitsCompletedLog.repository;

import voe.company.OutfitsCompletedLog.entity.JournalEntity;

import java.util.List;
import java.util.Optional;

public interface CrudRepository {
    void edit(JournalEntity journal);
    void addEntry(JournalEntity journal);
    void deleteById(Long index);
    void deleteAll();
    List<JournalEntity> getAll();
    List<JournalEntity> findBy(String data);
    Optional<JournalEntity> findById(Long index);
}
