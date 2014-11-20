/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 * @param <T>
 */
public interface InterfaceExame<T> {

    boolean incluir(T obj);

    boolean excluir(T obj);

    boolean alterar(T obj, int id);
    
    ArrayList<T> consultar();
}
