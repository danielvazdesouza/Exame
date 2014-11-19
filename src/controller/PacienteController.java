/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Paciente;

/**
 *
 * @author Daniel
 */
public class PacienteController extends ControllerSuper implements InterfaceExame<Paciente> {

    @Override
    public boolean incluir(Paciente obj) {
        int linhas = 0;
        // Cria Query
        String query = "INSERT INTO Paciente(CodPaciente, Cpf, Nome, Endereco, Cidade, Uf, dtNascimento, Peso, Altura) VALUES(" + obj.getCodPaciente() + ",'" + obj.getCpf() + "','"
                + obj.getNome() + "','" + obj.getEndereco() + "','" + obj.getCidade() + "','" + obj.getUf() + "','" + obj.getDtNascimento() + "',"
                + obj.getPeso() + "," + obj.getAltura() + ")";
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
    public boolean excluir(Paciente obj) {
        int linhas = 0;
        // Cria Query
        String query = "DELETE from Paciente WHERE CodPaciente =" + obj.getCodPaciente();
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
    public boolean alterar(Paciente obj, int id) {
        conecta();
        int linhas = 0;

        // Cria Query
        String query = "UPDATE Paciente SET Cpf ='" + obj.getCpf() + "', Nome='" + obj.getNome() + "', Endereco='"
                + obj.getEndereco() + "', Cidade='" + obj.getCidade() + "', Uf='" + obj.getUf()
                + "', DtNascimento='" + obj.getDtNascimento() + "', Peso=" + obj.getPeso() + ", Altura=" + obj.getAltura() + " WHERE CodPaciente =" + obj.getCodPaciente();
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
    public ArrayList<Paciente> consultar() {
        conecta();
        ArrayList<Paciente> ret = new ArrayList();

        // Cria Query
        String query = "SELECT CodPaciente, Cpf, Nome, Endereco, Cidade, Uf, DtNascto, Peso, Altura from Paciente"; 

        try {
            // Preenche retorno
            ResultSet set = cmd.executeQuery(query);
            while (set.next()) {

                Paciente p = new Paciente();
                p.setCodPaciente(set.getInt("CodPaciente"));
                p.setCpf(set.getString("Cpf"));
                p.setNome(set.getString("Nome"));
                p.setEndereco(set.getString("Endereco"));
                p.setCidade(set.getString("Cidade"));
                p.setUf(set.getString("Uf"));
                p.setDtNascimento(set.getDate("DtNascto"));
                p.setPeso(set.getDouble("Peso"));
                p.setAltura(set.getDouble("Altura"));

                ret.add(p);
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
