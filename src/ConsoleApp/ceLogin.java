package ConsoleApp;

import java.util.Scanner;
import DataAccess.DAO.ceUsuarioDAO;
import DataAccess.DTO.ceUsuarioDTO;
import Infrastructure.ceAppMSG;
import Infrastructure.ceCMD;

public class ceLogin {

    public boolean ceAutenticar() {
        Scanner ceScanner = new Scanner(System.in);
        int ceIntentos = 0;
        final int ceMAX_INTENTOS = 3;

        while (ceIntentos < ceMAX_INTENTOS) {
            System.out.print("Ingrese Cedula o en dado caso su Username: ");
            String ceUser = ceScanner.nextLine();

            System.out.print("Ingrese Clave: ");
            String cePass = ceScanner.nextLine();

            ceUsuarioDAO ceDao = new ceUsuarioDAO();
            ceUsuarioDTO ceDto = ceDao.ceLogin(ceUser, cePass);

            if (ceDto != null) {
                ceCMD.ceImprimir(ceAppMSG.ceMSG_LOGIN_EXITO);
                return true;
            } else {
                ceCMD.ceImprimir(ceAppMSG.ceMSG_LOGIN_FALLO);
                ceIntentos++;
                System.out.println("Intentos restantes: " + (ceMAX_INTENTOS - ceIntentos));
            }
        }

        return false;
    }
}
