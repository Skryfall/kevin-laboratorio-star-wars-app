import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.apache.http.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Interfaz {

    private static final Logger logger = LoggerFactory.getLogger(Interfaz.class);

    public void makeTable(List<List<String>> data){        
        logger.debug("Inicio del Programa");
        logger.debug("Obteniendo personajes de Star Wars...");
        logger.debug("Personajes obtenidos!");
        
        logger.debug("Generando Tabla...");
        JFrame f = new JFrame();
        String columns[] = {"Nombre", "Altura (m)", "Año de Nacimiento"};   

        String[][] array = new String[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            List<String> row = data.get(i);
            array[i] = row.toArray(new String[row.size()]);
        }

        JTable jt = new JTable(array, columns);
        jt.setBounds(100, 40, 200, 300);          
        JScrollPane sp = new JScrollPane(jt);    
        f.add(sp);          
        f.setSize(300,400); 

        logger.debug("Finalizado, mostrando tabla.");
        f.setVisible(true);
    }
}