package com.fork.cash.services.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.util.Objects;

@Entity
@IdClass(ProjectionKey.class)

public class ProjectionSummary {


//    protected ProjectionSummary() {
//
//    }


    private String account_symbol;
    private String account_nm;

    @Id
    private String nsp_account_id;

    @Id
    private String projection_level_identifier;

    @Id
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private String as_of_dt;

    @Id
    private Integer display_order;

    @Id
    private String currency_cd;
    @Id
    private String portfolio_currency_cd;
    @Id
    private String projection_level_id;

    private String level1_cd;
    private String level2_cd;
    private String level1_nm;
    private String level2_nm;
    private String level3_cd;
    private String level3_nm;
    private Long transaction_summary_id;

    @Id
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private String projection_dt;
    private Float amt_qc;
    private Float amt_pc;
    private Float amt_usd;


    @Transient
    private Float amount;

    @Transient
    private ProjectionKey pKey;

    public ProjectionKey getpKey() {
        return pKey;
    }

    public void setpKey(ProjectionKey pKey) {
        this.pKey = pKey;
    }

//    @Transient
//    private ProjectionTransaction projectionTransaction;
//
//    public ProjectionTransaction getProjectionTransaction() {
//        return projectionTransaction;
//    }
//
//    public void setProjectionTransaction(ProjectionTransaction projectionTransaction) {
//        this.projectionTransaction = projectionTransaction;
//    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectionSummary that = (ProjectionSummary) o;
        return Objects.equals(account_symbol, that.account_symbol) &&
                Objects.equals(account_nm, that.account_nm) &&
                Objects.equals(nsp_account_id, that.nsp_account_id) &&
                Objects.equals(projection_level_identifier, that.projection_level_identifier) &&
                Objects.equals(as_of_dt, that.as_of_dt) &&
                Objects.equals(display_order, that.display_order) &&
                Objects.equals(currency_cd, that.currency_cd) &&
                Objects.equals(portfolio_currency_cd, that.portfolio_currency_cd) &&
                Objects.equals(projection_level_id, that.projection_level_id) ;
    }

    @Override
    public String toString() {
        return "ProjectionSummary{" +
                "account_symbol='" + account_symbol + '\'' +
                ", account_nm='" + account_nm + '\'' +
                ", nsp_account_id='" + nsp_account_id + '\'' +
                ", projection_level_identifier='" + projection_level_identifier + '\'' +
                ", as_of_dt='" + as_of_dt + '\'' +
                ", display_order='" + display_order + '\'' +
                ", currency_cd='" + currency_cd + '\'' +
                ", portfolio_currency_cd='" + portfolio_currency_cd + '\'' +
                ", projection_level_id='" + projection_level_id + '\'' +
                ", level1_cd='" + level1_cd + '\'' +
                ", level2_cd='" + level2_cd + '\'' +
                ", level1_nm='" + level1_nm + '\'' +
                ", level2_nm='" + level2_nm + '\'' +
                ", level3_cd='" + level3_cd + '\'' +
                ", level3_nm='" + level3_nm + '\'' +
                ", transaction_summary_id=" + transaction_summary_id +
                ", projection_dt='" + projection_dt + '\'' +
                ", amt_qc=" + amt_qc +
                ", amt_pc=" + amt_pc +
                ", amt_usd=" + amt_usd +
                ", amount=" + amount +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                nsp_account_id,
                projection_level_identifier,
                as_of_dt,
                display_order,
                currency_cd,
                portfolio_currency_cd,
                projection_level_id);
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }


    public String getAccount_symbol() {
        return account_symbol;
    }
    public void setAccount_symbol(String account_symbol) {
        this.account_symbol = account_symbol;
    }
    public String getAs_of_dt() {
        return as_of_dt;
    }
    public void setAs_of_dt(String as_of_dt) {
        this.as_of_dt = as_of_dt;
    }
    public String getLevel1_cd() {
        return level1_cd;
    }
    public void setLevel1_cd(String level1_cd) {
        this.level1_cd = level1_cd;
    }
    public String getLevel2_cd() {
        return level2_cd;
    }
    public void setLevel2_cd(String level2_cd) {
        this.level2_cd = level2_cd;
    }
    public String getLevel3_cd() {
        return level3_cd;
    }
    public void setLevel3_cd(String level3_cd) {
        this.level3_cd = level3_cd;
    }
    public String getLevel1_nm() {
        return level1_nm;
    }
    public void setLevel1_nm(String level1_nm) {
        this.level1_nm = level1_nm;
    }
    public String getLevel2_nm() {
        return level2_nm;
    }
    public void setLevel2_nm(String level2_nm) {
        this.level2_nm = level2_nm;
    }
    public String getLevel3_nm() {
        return level3_nm;
    }
    public void setLevel3_nm(String level3_nm) {
        this.level3_nm = level3_nm;
    }
    public Integer getDisplay_order() {
        return display_order;
    }
    public void setDisplay_order(Integer display_order) {
        this.display_order = display_order;
    }
    public String getCurrency_cd() {
        return currency_cd;
    }
    public void setCurrency_cd(String currency_cd) {
        this.currency_cd = currency_cd;
    }
    public String getPortfolio_currency_cd() {
        return portfolio_currency_cd;
    }

    public void setPortfolio_currency_cd(String portfolio_currency_cd) {
        this.portfolio_currency_cd = portfolio_currency_cd;
    }

    public String getProjection_level_id() {
        return projection_level_id;
    }
   public void setProjection_level_id(String projection_level_id) {
        this.projection_level_id = projection_level_id;
    }
    public String getProjection_level_identifier() {
        return projection_level_identifier;
    }
    public void setProjection_level_identifier(String projection_level_identifier) {
        this.projection_level_identifier = projection_level_identifier;
    }

    public String getAccount_nm() {
        return account_nm;
    }

    public void setAccount_nm(String account_nm) {
        this.account_nm = account_nm;
    }

    public String getNsp_account_id() {
        return nsp_account_id;
    }

    public void setNsp_account_id(String nsp_account_id) {
        this.nsp_account_id = nsp_account_id;
    }


    public Long getTransaction_summary_id() {
        return transaction_summary_id;
    }

    public void setTransaction_summary_id(Long transaction_summary_id) {
        this.transaction_summary_id = transaction_summary_id;
    }

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