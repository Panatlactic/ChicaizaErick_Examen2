package DataAccess.DTO;

public class ceUsuarioDTO {
    private int ceIdUsuario;
    private String ceNombre;
    private String ceUsername;
    private String cePassword;

    public ceUsuarioDTO() {}

    public ceUsuarioDTO(int ceIdUsuario, String ceNombre, String ceUsername, String cePassword) {
        this.ceIdUsuario = ceIdUsuario;
        this.ceNombre = ceNombre;
        this.ceUsername = ceUsername;
        this.cePassword = cePassword;
    }

    public int ceGetIdUsuario() {
        return ceIdUsuario;
    }

    public void ceSetIdUsuario(int ceIdUsuario) {
        this.ceIdUsuario = ceIdUsuario;
    }

    public String ceGetNombre() {
        return ceNombre;
    }

    public void ceSetNombre(String ceNombre) {
        this.ceNombre = ceNombre;
    }

    public String ceGetUsername() {
        return ceUsername;
    }

    public void ceSetUsername(String ceUsername) {
        this.ceUsername = ceUsername;
    }

    public String ceGetPassword() {
        return cePassword;
    }

    public void ceSetPassword(String cePassword) {
        this.cePassword = cePassword;
    }
}
