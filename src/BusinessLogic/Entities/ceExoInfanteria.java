package BusinessLogic.Entities;

public class ceExoInfanteria extends ceExobot {
    public ceExoInfanteria() {
        super("ExoInfanteria");
        this.ceArmaNombre = "Misil/Mortero";
    }

    @Override
    public String ceRealizarAccion() {
        return "Disparar (Munición)";
    }
}
