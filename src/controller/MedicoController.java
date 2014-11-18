/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Medico;

/**
 *
 * @author Daniel
 */
public class MedicoController extends ControllerSuper implements InterfaceExame<Medico> {

    @Override
    public boolean incluir(Medico obj) {
        int linhas = 0;
        // Cria Query
        String query = "INSERT INTO Medico(CodMedico, Crm, Nome, Endereco, Cidade, Uf, Email, Telefone) VALUES('" + obj.getCodMedico() + "','" + obj.getCrm() + "','"
                + obj.getNome() + "','" + obj.getEndereco() + "','" + obj.getCidade() + "','" + obj.getUf() + "','" + obj.getEmail() + "','"
                + obj.getTelefone() + "')";
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
    public boolean excluir(Medico obj) {
        int linhas = 0;
        // Cria Query
        String query = "DELETE from Medico WHERE CodMedico =" + obj.getCodMedico();
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
    public boolean alterar(Medico obj, int id) {
        conecta();
        int linhas = 0;

        // Cria Query    
        String query = "UPDATE Medico SET Crm ='" + obj.getCrm() + "'Nome='" + obj.getNome() + "'Endereco='" + obj.getEndereco()
                + "'Cidade='" + obj.getCidade() + "'Uf='" + obj.getUf() + "'Email='" + obj.getEmail() + "'Telefone='"
                + obj.getTelefone() + "' WHERE CodMedico =" + obj.getCodMedico();
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
    public ArrayList<Medico> consultar() {
        conecta();
        ArrayList<Medico> ret = new ArrayList();

        // Cria Query
        String query = "SELECT CodMedico, Crm, Nome, Endereco, Cidade, Uf, Email, Telefone from Medico";

        try {
            // Preenche retorno
            ResultSet set = cmd.executeQuery(query);
            while (set.next()) {

                Medico m = new Medico();
                m.setCodMedico(set.getInt("CodExame"));
                m.setCrm(set.getString("Crm"));
                m.setNome(set.getString("Nome"));
                m.setEndereco(set.getString("Endereco"));
                m.setCidade(set.getString("Cidade"));
                m.setUf(set.getString("Uf"));
                m.setEmail(set.getString("Email"));
                m.setTelefone(set.getString("Telefone"));

                ret.add(m);
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
