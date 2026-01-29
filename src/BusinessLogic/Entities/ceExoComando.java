package BusinessLogic.Entities;

public class ceExoComando extends ceExobot {
    public ceExoComando() {
        super("ExoComando");
        this.ceArmaNombre = "Laser/Bayoneta";
    }

    @Override
    public String ceRealizarAccion() {
        return "Disparar (Munición)";
    }

}
