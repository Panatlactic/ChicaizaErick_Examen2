package DataAccess.DTO;

public class ceExobotDTO {
    private int IdExobot;
    private int IdTipoExobot;
    private int IdUsuario;
    private boolean Entrenado;
    private int NumeroAccion;
    private int IdArma;

    public ceExobotDTO() {}

    public ceExobotDTO(int IdExobot, int IdTipoExobot, int IdUsuario, boolean Entrenado, int NumeroAccion, int IdArma) {
        this.IdExobot = IdExobot;
        this.IdTipoExobot = IdTipoExobot;
        this.IdUsuario = IdUsuario;
        this.Entrenado = Entrenado;
        this.NumeroAccion = NumeroAccion;
        this.IdArma = IdArma;
    }

    public int GetIdExobot() { return IdExobot; }
    public void SetIdExobot(int IdExobot) { this.IdExobot = IdExobot; }

    public int GetIdTipoExobot() { return IdTipoExobot; }
    public void SetIdTipoExobot(int IdTipoExobot) { this.IdTipoExobot = IdTipoExobot; }

    public int GetIdUsuario() { return IdUsuario; }
    public void SetIdUsuario(int IdUsuario) { this.IdUsuario = IdUsuario; }

    public boolean IsEntrenado() { return Entrenado; }
    public void SetEntrenado(boolean Entrenado) { this.Entrenado = Entrenado; }

    public int GetNumeroAccion() { return NumeroAccion; }
    public void SetNumeroAccion(int NumeroAccion) { this.NumeroAccion = NumeroAccion; }

    public int GetIdArma() { return IdArma; }
    public void SetIdArma(int IdArma) { this.IdArma = IdArma; }
}
