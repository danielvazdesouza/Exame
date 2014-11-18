/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Exame;

/**
 *
 * @author Daniel
 */
public class ExameController extends ControllerSuper implements InterfaceExame<Exame> {

    @Override
    public boolean incluir(Exame obj) {
        conecta();
        int linhas = 0;
        // Cria Query
        String query = "INSERT INTO Exame(CodExame, DescExame, Valorunit ) VALUES('" + obj.getCodExame() + "','" + obj.getDescExame() + "','" + obj.getValorUnit() + "')";
        // Executa
        try {
            linhas = cmd.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            desconecta();
        }
        return linhas > 0;
    }

    @Override
    public boolean excluir(Exame obj) {
        conecta();
        int linhas = 0;
        // Cria Query
        String query = "DELETE from Exame WHERE CodExame =" + obj.getCodExame();
        // Executa
        try {
            linhas = cmd.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            desconecta();
        }
        return linhas > 0;
    }

    @Override
    public boolean alterar(Exame obj, int id) {
        conecta();
        int linhas = 0;

        // Cria Query
        String query = "UPDATE Exame SET DescExame ='" + obj.getDescExame()
                + "'ValorUnit='" + obj.getValorUnit() + "' WHERE CodExame =" + obj.getCodExame();
        // Executa
        try {
            linhas = cmd.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            desconecta();
        }

        return linhas > 0;
    }

    public ArrayList<Exame> consultar() {
        conecta();
        ArrayList<Exame> ret = new ArrayList();
        // Cria Query
        String query = "SELECT CodExame, DescExame, Valorunit from Exame";
        try {
            // Preenche retorno
            ResultSet set = cmd.executeQuery(query);
            while (set.next()) {
                Exame e = new Exame();
                e.setCodExame(set.getInt("CodExame"));
                e.setDescExame(set.getString("DescExame"));
                e.setValorUnit(set.getDouble("ValorUnit"));
                ret.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            desconecta();
        }
        // Retorna
        return ret;
    }

}
