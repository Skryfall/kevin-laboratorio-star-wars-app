import bl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.ParseException;


public class InterfazBL extends Logic() {

    public InterfazBL () {}

    List<List<String>> getDataFromBL() throws ParseException, IOException{
        return this.getData();
    }

}