/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Daniel
 */
public class ExamePaciente {
    private Date dtExame;
    private int qtdExame;
    private double valorExame;
    private double total;
    private int codExame;
    private int codPaciente;
    private int codMedico;

    /**
     * @return the dtExame
     */
    public Date getDtExame() {
        return dtExame;
    }

    /**
     * @param dtExame the dtExame to set
     */
    public void setDtExame(Date dtExame) {
        this.dtExame = dtExame;
    }

    /**
     * @return the qtdExame
     */
    public int getQtdExame() {
        return qtdExame;
    }

    /**
     * @param qtdExame the qtdExame to set
     */
    public void setQtdExame(int qtdExame) {
        this.qtdExame = qtdExame;
    }

    /**
     * @return the valorExame
     */
    public double getValorExame() {
        return valorExame;
    }

    /**
     * @param valorExame the valorExame to set
     */
    public void setValorExame(double valorExame) {
        this.valorExame = valorExame;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

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
     * @return the codPaciente
     */
    public int getCodPaciente() {
        return codPaciente;
    }

    /**
     * @param codPaciente the codPaciente to set
     */
    public void setCodPaciente(int codPaciente) {
        this.codPaciente = codPaciente;
    }

    /**
     * @return the codMedico
     */
    public int getCodMedico() {
        return codMedico;
    }

    /**
     * @param codMedico the codMedico to set
     */
    public void setCodMedico(int codMedico) {
        this.codMedico = codMedico;
    }
}
