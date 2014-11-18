/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ExamePaciente;

/**
 *
 * @author Daniel
 */
public class ExamePacienteController extends ControllerSuper implements InterfaceExame<ExamePaciente> {

    @Override
    public boolean incluir(ExamePaciente obj) {
        int linhas = 0;
        // Cria Query

        String query = "INSERT INTO ExamePaciente(dtExame, qtdExame, ValorExame, total ) VALUES('" + obj.getDtExame() + "','" + obj.getQtdExame() + "','"
                + obj.getValorExame() + "','" + obj.getTotal() + "')";
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
    public boolean excluir(ExamePaciente obj) {
        int linhas = 0;
        // Cria Query
        String query = "DELETE from Paciente WHERE DtExame =" + obj.getDtExame();
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
    public boolean alterar(ExamePaciente obj, int id) {
        conecta();
        int linhas = 0;

        // Cria Query    
        String query = "UPDATE ExamePaciente SET dtExame = " + obj.getDtExame() + "',QtdExame='"
                + obj.getQtdExame() + "'ValorExame='" + obj.getValorExame() + "'Total=,'" + obj.getTotal() + "')";
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
    public ArrayList<ExamePaciente> consultar() {
        conecta();
        ArrayList<ExamePaciente> ret = new ArrayList();
        // Cria Query
        String query = "SELECT dtExame, qtdExame, ValorExame, total from ExamePaciente";
        try {
            // Preenche retorno
            ResultSet set = cmd.executeQuery(query);
            while (set.next()) {

                ExamePaciente ep = new ExamePaciente();
                ep.setDtExame(set.getDate("dtExame"));
                ep.setQtdExame(set.getInt("qtdExame"));
                ep.setValorExame(set.getDouble("ValorExame"));
                ep.setTotal(set.getDouble("Total"));
                ret.add(ep);
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
