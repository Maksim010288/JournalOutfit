package voe.company.OutfitsCompletedOfLog;

public class CheckOut {

    public Exception check(Integer numberName,
                        String date,
                        String type_etc,
                        Integer number_etc,
                        String description,
                        String performer) {
        if (numberName == 0 || date.equals("") ||
                type_etc.equals("") || number_etc == 0 ||
                description.equals("") || performer.equals("")){
            return new RuntimeException();
        }
        return new RuntimeException();
    }
}
