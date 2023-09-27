package voe.company.OutfitsCompletedOfLog;

import voe.company.OutfitsCompletedOfLog.entity.JournalEntity;

import java.util.logging.Logger;

public class CheckOut {

    private final Logger logger = Logger.getLogger(CheckOut.class.getName());

    public Throwable check(JournalEntity entity) {
        if (entity.getNumberOutfit().equals(0) || entity.getDate().isEmpty() ||
                entity.getTypeEac().equals("") || entity.getDispatcherNameEts().equals(0) ||
                entity.getJobDescription().equals("") || entity.getPerformer().equals("")){
            logger.info("Заповніть усі поля");
            return new Exception("Заповніть усі поля");
        }
        return new Exception("Успішно добавлено");
    }
}
