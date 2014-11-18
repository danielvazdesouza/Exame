/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Daniel
 */
public interface InterfaceExame {

    String driverJDBC = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String host = "jdbc:sqlserver://localhost;databaseName=Cantina";
    String usuario = "sa";
    String senha = "12345";

    boolean incluir();

    boolean excluir();

    boolean alterar();
}
