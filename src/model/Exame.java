/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Daniel
 */
public class Exame {
    private int codExame;
    private String descExame;
    private double valorUnit;

    /**
     * @return the codExame
     */
    public int getCodExame() {
        return codExame;
    }

    /**
     * @param codExame the codExame to set
     */
    public void setCodExame(int codExame) {
        this.codExame = codExame;
    }

    /**
     * @return the descExame
     */
    public String getDescExame() {
        return descExame;
    }

    /**
     * @param descExame the descExame to set
     */
    public void setDescExame(String descExame) {
        this.descExame = descExame;
    }

    /**
     * @return the valorUnit
     */
    public double getValorUnit() {
        return valorUnit;
    }

    /**
     * @param valorUnit the valorUnit to set
     */
    public void setValorUnit(double valorUnit) {
        this.valorUnit = valorUnit;
    }
}
