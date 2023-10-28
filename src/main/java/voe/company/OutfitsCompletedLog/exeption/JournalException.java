package voe.company.OutfitsCompletedLog.exeption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import voe.company.OutfitsCompletedLog.entity.JournalEntity;

import java.util.Optional;

@Component
public class JournalException {

    private final Logger LOG = LoggerFactory.getLogger(JournalException.class);

    public void verification(Optional<JournalEntity> optionalJournal){
        if (optionalJournal.isEmpty()){
            LOG.error("Не знайдено жодного запису");
        }
    }
}
