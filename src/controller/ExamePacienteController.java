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

        String query = "INSERT INTO Exame_Paciente(codExame, codPaciente, codMedico, dtExame, qtdExame, ValorExame, total )"
                                    + " VALUES("+obj.getCodExame()+", "+obj.getCodPaciente()+", "+obj.getCodMedico()+", '" + obj.getDtExame() + "'," + obj.getQtdExame() + "," + obj.getValorExame() + "," + obj.getTotal() + ")";
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
        String query = "DELETE from Exame_Paciente WHERE  codExame = "+obj.getCodExame()+" && codPaciente = "+obj.getCodPaciente()+" && codMedico = " + obj.getCodMedico();
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
        String query = "UPDATE Exame_Paciente SET dtExame = '" + obj.getDtExame() + "', QtdExame="
                + obj.getQtdExame() + ", ValorExame=" + obj.getValorExame() + ", Total=" + obj.getTotal()
                + " WHERE  codExame = "+obj.getCodExame()+" && codPaciente = "+obj.getCodPaciente()+" && codMedico = " + obj.getCodMedico();
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
        String query = "SELECT codExame,codPaciente,codMedico, dtExame, qtdExame, ValorExame, total from Exame_Paciente";
        try {
            // Preenche retorno
            ResultSet set = cmd.executeQuery(query);
            while (set.next()) {

                ExamePaciente ep = new ExamePaciente();
                ep.setCodExame(set.getInt("codExame"));
                ep.setCodMedico(set.getInt("codMedico"));
                ep.setCodPaciente(set.getInt("codPaciente"));
                ep.setDtExame(set.getDate("dtExame"));
                ep.setQtdExame(set.getInt("qtdExame"));
                ep.setValorExame(set.getDouble("ValorExame"));
                ep.setTotal(set.getDouble("total"));
                
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
