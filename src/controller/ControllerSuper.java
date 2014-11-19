package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * Classe pai dos Controller's; cria e fecha conex�es
 *
 * @author Rafael Simor / Daniel Limberger / Daniel Vaz.
 */
abstract class ControllerSuper {

    protected Connection con;
    protected Statement cmd;

    /**
     * Construtor
     */
    public ControllerSuper() {
        String conStr = "-------------";
        try {
            con = DriverManager.getConnection(conStr, "user", "senha");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    /**
     * Cria a conex�o com o banco de dados
     */
    protected void conecta() {
        try {
            cmd = con.createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    /**
     * Fecha a conex�o com o banco de dados
     */
    protected void desconecta() {
        try {
            if (!con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}