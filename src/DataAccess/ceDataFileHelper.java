package DataAccess;

import Infrastructure.ceAppConfig;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ceDataFileHelper {
    private static final String ceFILE_PATH = ceAppConfig.cePATH_MUNISION;

    public static String ceBuscarMunicion(String ceArmaNombre) {
    
        try (BufferedReader ceBr = new BufferedReader(new FileReader(ceFILE_PATH))) {
            String ceLine;
            while ((ceLine = ceBr.readLine()) != null) {
            
                String[] ceParts = ceArmaNombre.split("/");
                for (String cePart : ceParts) {
                    if (ceLine.contains(cePart.trim())) {
                        return ceLine.trim(); 
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
