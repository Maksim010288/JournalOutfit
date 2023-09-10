package voe.company.OutfitsCompletedOfLog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import voe.company.OutfitsCompletedOfLog.JournalException;
import voe.company.OutfitsCompletedOfLog.entity.JournalEntity;

import voe.company.OutfitsCompletedOfLog.repository.CrudRepository;
import voe.company.OutfitsCompletedOfLog.repository.MagazineRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MagazineService implements CrudRepository{
    @Autowired
    private MagazineRepository magazineRepository;
    @Autowired
    private JournalException journalException;

    @Override
    public void save(JournalEntity journal) {
        magazineRepository.save(journal);
    }

    @Override
    public void addNewEntry(JournalEntity journalEntity) {
        journalEntity.setDate(journalEntity.getDate());
        JournalEntity entity = new JournalEntity(journalEntity.getNumberOutfit(),
                journalEntity.getDate(),
                journalEntity.getTypeEac(),
                journalEntity.getDispatcherNameEts(),
                journalEntity.getJobDescription(),
                journalEntity.getPerformer());
       magazineRepository.save(entity);
    }

    @Override
    public List<JournalEntity> getFindAll() {
        return magazineRepository.findAll();
    }

    @Override
    public Optional<JournalEntity> findById(Long index) {
        Optional<JournalEntity> entity = magazineRepository.findById(index);
        journalException.verification(entity);
        return entity;
    }

    @Override
    public List<JournalEntity> findBy(String data) {
        return magazineRepository.findAll().stream()
                .filter(journal -> journal.getNumberOutfit().equals(Integer.parseInt(data)) ||
                        journal.getDispatcherNameEts().equals(Integer.parseInt(data)) ||
                        journal.getDate().equals(data))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteJournalById(Long index) {
        magazineRepository.deleteById(index);
    }

    @Override
    public void deleteAll() {
        magazineRepository.deleteAll();
    }
}