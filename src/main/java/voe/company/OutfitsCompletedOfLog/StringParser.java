package voe.company.OutfitsCompletedOfLog;

import voe.company.OutfitsCompletedOfLog.entity.JournalEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringParser {

    public JournalEntity addParserJournal(String data) {
        JournalEntity journal = new JournalEntity();
        journal.setNumberOutfit(Integer.parseInt(parser(data).get(3)));
        journal.setDate(parser(data).get(5));
        journal.setTypeEac(parser(data).get(9));
        journal.setDispatcherNameEts(Integer.parseInt(parser(data).get(7)));
        journal.setJobDescription(parser(data).get(11));
        journal.setPerformer(parser(data).get(13).replaceFirst(".$", ""));
        return journal;
    }

    private List<String> coma(String data) {
        return Arrays.asList(data.split(","));
    }

    private List<String> parser(String str) {
        List<String> listParser = new ArrayList<>();
        for (String coma : coma(str)) {
            String[] strPars = coma.split("=");
            Collections.addAll(listParser, strPars);
        }
        return listParser;
    }
}
