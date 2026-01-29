
package UserInterface;

import BusinessLogic.Entities.*;
import BusinessLogic.ceIABOT;
import DataAccess.ceDataFileHelper;
import Infrastructure.ceCMD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ceExoTrooperForm extends JFrame {
    private JComboBox<String> ceCbxTipoExobot;
    private JTable ceTable;
    private DefaultTableModel ceTableModel;
    private JButton ceBtnAgregar;
    private JButton ceBtnBuscar;
    private JButton ceBtnEntrenar;
    private JButton ceBtnAccion;

    
    private List<ceExobot> ceExobotList;
    private TableRowSorter<DefaultTableModel> ceSorter;

    public ceExoTrooperForm() {
        ceExobotList = new ArrayList<>();

        setTitle("ExoTrooper");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

       
        JPanel ceTopPanel = new JPanel();
        ceTopPanel.setLayout(new BoxLayout(ceTopPanel, BoxLayout.Y_AXIS));
        ceTopPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));

        JLabel ceLblHeader = new JLabel("Alumno(s):");
        ceLblHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
        ceTopPanel.add(ceLblHeader);

        JPanel ceStudentInfoPanel = new JPanel(new GridLayout(2, 2));
        ceStudentInfoPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        ceStudentInfoPanel.setBackground(Color.WHITE);
       
        ceStudentInfoPanel.add(new JLabel("  1756172894"));
        ceStudentInfoPanel.add(new JLabel("Erick Sebastián Chicaiza Diaz "));
        ceStudentInfoPanel.add(new JLabel("  Cédula "));
        ceStudentInfoPanel.add(new JLabel("Nombre "));
        ceTopPanel.add(ceStudentInfoPanel);

        add(ceTopPanel, BorderLayout.NORTH);

        
        JPanel ceCenterPanel = new JPanel(new BorderLayout(5, 5));
        ceCenterPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        // Controls: Combo | Agregar | Buscar
        JPanel ceControlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));

        ceCbxTipoExobot = new JComboBox<>(new String[] {
                "ExoAsalto", "ExoExplorador", "ExoInfanteria", "ExoMedico", "ExoComando"
        });
        ceCbxTipoExobot.setPreferredSize(new Dimension(120, 30));

        ceBtnAgregar = new JButton("Agregar");
        ceBtnAgregar.setBackground(new Color(220, 220, 220)); // Light Gray

        ceBtnBuscar = new JButton("Buscar");
        ceBtnBuscar.setBackground(Color.WHITE);

        ceControlPanel.add(ceCbxTipoExobot);
        ceControlPanel.add(ceBtnAgregar);
        ceControlPanel.add(ceBtnBuscar);

        ceCenterPanel.add(ceControlPanel, BorderLayout.NORTH);

        // tabla
        String[] ceColNames = { "IdExobot", "TipoExobot", "Entreno", "No. Accion" };
        ceTableModel = new DefaultTableModel(ceColNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ceTable = new JTable(ceTableModel);
        ceTable.setRowHeight(25);

        
        JTableHeader ceHeader = ceTable.getTableHeader();
        ceHeader.setBackground(new Color(2, 48, 32)); //verde oscuro 
        ceHeader.setForeground(Color.WHITE);
        ceHeader.setFont(new Font("SansSerif", Font.BOLD, 12));

        ceSorter = new TableRowSorter<>(ceTableModel);
        ceTable.setRowSorter(ceSorter);

        ceCenterPanel.add(new JScrollPane(ceTable), BorderLayout.CENTER);

        add(ceCenterPanel, BorderLayout.CENTER);

        // --- BOTTOM PANEL: Actions ---
        JPanel ceBottomPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        ceBottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        ceBtnEntrenar = new JButton("Entrenar \"AcciónArma\"");
        ceBtnAccion = new JButton("\"Acción_TipoArma\"");

        ceBottomPanel.add(ceBtnEntrenar);
        ceBottomPanel.add(ceBtnAccion);

        add(ceBottomPanel, BorderLayout.SOUTH);

        // --- EVENT LISTENERS ---
        ceBtnAgregar.addActionListener(e -> ceHandleAgregar());
        ceBtnEntrenar.addActionListener(e -> ceHandleEntrenar());
        ceBtnAccion.addActionListener(e -> ceHandleAccion());
        ceBtnBuscar.addActionListener(e -> ceHandleBuscar());
    }

    private void ceHandleAgregar() {
        String ceSelected = (String) ceCbxTipoExobot.getSelectedItem();
        ceExobot ceNewBot;

        switch (ceSelected) {
            case "ExoAsalto":
                ceNewBot = new ceExoAsalto();
                break;
            case "ExoExplorador":
                ceNewBot = new ceExoExplorador();
                break;
            case "ExoInfanteria":
                ceNewBot = new ceExoInfanteria();
                break;
            case "ExoMedico":
                ceNewBot = new ceExoMedico();
                break;
            case "ExoComando":
                ceNewBot = new ceExoComando();
                break;
            default:
                ceNewBot = new ceExoAsalto();
        }

        ceNewBot.ceSetIdExobot(ceExobotList.size() + 1);
        ceExobotList.add(ceNewBot);

        ceTableModel.addRow(new Object[] {
                ceNewBot.ceGetIdExobot(),
                ceNewBot.ceGetTipoExobot(),
                "NO",
                "0"
        });
    }

    private ceExobot ceGetSelectedBot() {
        int ceRow = ceTable.getSelectedRow();
        if (ceRow != -1) {

            int ceModelRow = ceTable.convertRowIndexToModel(ceRow);

            int ceId = (int) ceTableModel.getValueAt(ceModelRow, 0);
            return ceExobotList.stream().filter(b -> b.ceGetIdExobot() == ceId).findFirst().orElse(null);
        }
        return null;
    }

    private void ceHandleEntrenar() {
        ceExobot ceCurrentBot = ceGetSelectedBot();
        if (ceCurrentBot != null) {

            ceSoldadoExperto ceSoldado = new ceSoldadoExperto(
                    "SoldadoExperto-" + ceCurrentBot.ceGetArmaNombre().split("/")[0]);
            new ceIABOT().ceEntrenar(ceCurrentBot, ceSoldado);

            ceUpdateTableRow(ceCurrentBot);

            String ceLog = "GOOD : " + ceSoldado.ceGetNombre() + " " + ceCurrentBot.ceGetArmaNombre() + " "
                    + ceCurrentBot.ceRealizarAccion();
            ceCMD.ceImprimir(ceLog);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un Exobot de la tabla.");
        }
    }

    private void ceHandleAccion() {
        ceExobot ceCurrentBot = ceGetSelectedBot();

        if (ceCurrentBot != null) {
            if (ceCurrentBot.ceIsEntrenado()) {
                String ceMunicion = ceDataFileHelper.ceBuscarMunicion(ceCurrentBot.ceGetArmaNombre());
                ceCurrentBot.ceIncrementarAccion();

                ceUpdateTableRow(ceCurrentBot);

                String ceLog = "GOOD : " + ceCurrentBot.ceGetArmaNombre() + " " + ceCurrentBot.ceRealizarAccion() + " "
                        + (ceMunicion != null ? ceMunicion : "No Municion");
                ceCMD.ceImprimir(ceLog);
            } else {
                String ceLog = "ERROR: " + ceCurrentBot.ceGetTipoExobot() + " No Entrenado.";
                ceCMD.ceImprimir(ceLog);
                JOptionPane.showMessageDialog(this, "El Exobot no está entrenado.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un Exobot de la tabla.");
        }
    }

    private void ceUpdateTableRow(ceExobot ceBot) {
        for (int i = 0; i < ceTableModel.getRowCount(); i++) {
            int ceId = (int) ceTableModel.getValueAt(i, 0);
            if (ceId == ceBot.ceGetIdExobot()) {
                ceTableModel.setValueAt(ceBot.ceIsEntrenado() ? "SI" : "NO", i, 2);
                ceTableModel.setValueAt(ceBot.ceGetNumeroAccion(), i, 3);
                break;
            }
        }
    }

    private void ceHandleBuscar() {
        String ceSelected = (String) ceCbxTipoExobot.getSelectedItem();
        if (ceSelected != null && !ceSelected.isEmpty()) {
            ceSorter.setRowFilter(RowFilter.regexFilter(ceSelected, 1));
        } else {
            ceSorter.setRowFilter(null);
        }
    }
}
