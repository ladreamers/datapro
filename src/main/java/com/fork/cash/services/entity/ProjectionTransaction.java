package com.fork.cash.services.entity;

public class ProjectionTransaction {

    private String projection_dt;
    private Float amt_qc;
    private Float amt_pc;
    private Float amt_usd;
    private Float amount;
    private Long transaction_summary_id;


    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Long getTransaction_summary_id() {        return transaction_summary_id;    }
    public void setTransaction_summary_id(Long transaction_summary_id) { this.transaction_summary_id = transaction_summary_id;  }

    public String getProjection_dt() {
        return projection_dt;
    }
    public void setProjection_dt(String projection_dt) {
        this.projection_dt = projection_dt;
    }

    public Float getAmt_qc() {
        return amt_qc;
    }
    public void setAmt_qc(Float amt_qc) {
        this.amt_qc = amt_qc;
    }

    public Float getAmt_pc() {
        return amt_pc;
    }
    public void setAmt_pc(Float amt_pc) {
        this.amt_pc = amt_pc;
    }

    public Float getAmt_usd() {
        return amt_usd;
    }
    public void setAmt_usd(Float amt_usd) {
        this.amt_usd = amt_usd;
    }

}
