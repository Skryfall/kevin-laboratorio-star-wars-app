import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.ParseException;

public class Main {

    public static List<List<String>> main(String[] args) throws ParseException, IOException {        
        Logic logic = new Logic();
        return(logic.getData());
    }
}