package voe.company.OutfitsCompletedOfLog.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import voe.company.OutfitsCompletedOfLog.StringParser;
import voe.company.OutfitsCompletedOfLog.properties.PropertiesConfig;
import voe.company.OutfitsCompletedOfLog.repository.MagazineRepository;

@Component
public class KafkaListeners {
    private final Logger logger = LoggerFactory.getLogger(KafkaListeners.class);

    private final StringParser parser = new StringParser();

    @Autowired
    private MagazineRepository repository;

    @KafkaListener(topics = "maximus", groupId = "foo")
    void listener(String data) {
        logger.info("Added new record = " + parser.addParserJournal(data).toString());
        repository.save(parser.addParserJournal(data));
    }
}

