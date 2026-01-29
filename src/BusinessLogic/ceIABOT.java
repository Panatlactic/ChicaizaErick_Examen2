package BusinessLogic;

import BusinessLogic.Entities.ceExobot;
import BusinessLogic.Entities.ceSoldadoExperto;

public class ceIABOT {

    public void ceEntrenar(ceExobot gjExobot, ceSoldadoExperto gjSoldado) {
        if (gjExobot != null) {
            gjExobot.ceSetEntrenado(true);
        }
    }
}
