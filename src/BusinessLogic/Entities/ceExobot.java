package BusinessLogic.Entities;

import BusinessLogic.ceIAEXO;

public abstract class ceExobot extends ceIAEXO {
    protected int ceIdExobot;
    protected String ceTipoExobot;
    protected boolean ceEntrenado;
    protected int ceNumeroAccion;
    protected String ceArmaNombre;

    public ceExobot(String ceTipoExobot) {
        this.ceTipoExobot = ceTipoExobot;
        this.ceNumeroAccion = 0;
        this.ceEntrenado = false;
    }

    public abstract String ceRealizarAccion();

    public int ceGetIdExobot() {
        return ceIdExobot;
    }

    public void ceSetIdExobot(int id) {
        this.ceIdExobot = id;
    }

    public String ceGetTipoExobot() {
        return ceTipoExobot;
    }

    public boolean ceIsEntrenado() {
        return ceEntrenado;
    }

    public void ceSetEntrenado(boolean entrenado) {
        this.ceEntrenado = entrenado;
    }

    public int ceGetNumeroAccion() {
        return ceNumeroAccion;
    }

    public void ceIncrementarAccion() {
        this.ceNumeroAccion++;
    }

    public String ceGetArmaNombre() {
        return ceArmaNombre;
    }

    public void ceSetArmaNombre(String arma) {
        this.ceArmaNombre = arma;
    }
}
