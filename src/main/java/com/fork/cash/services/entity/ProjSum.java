package com.fork.cash.services.entity;

import java.io.Serializable;
import java.util.List;

public class ProjSum implements Serializable {

    private String account_symbol;
    private String as_of_dt;
    private String level1_cd;
    private String level2_cd;
    private String level3_cd;
    private String level1_nm;
    private String level2_nm;
    private String level3_nm;
    private Integer display_order;
    private String currency_cd;
    private String portfolio_currency_cd;
    private String projection_level_id;
    private String projection_level_identifier;
    private String account_nm;
    private String nsp_account_id;
    private List<ProjectionTransaction> projections;

    public List<ProjectionTransaction> getProjections() {
        return projections;
    }

    public void setProjections(List<ProjectionTransaction> projections) {
        this.projections = projections;
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



//    class Projections{
//        private String projection_dt;
//        private Float amt_qc;
//        private Float amt_pc;
//        private Float amt_usd;
//
//        public String getProjection_dt() {
//            return projection_dt;
//        }
//
//        public void setProjection_dt(String projection_dt) {
//            this.projection_dt = projection_dt;
//        }
//
//        public Float getAmt_qc() {
//            return amt_qc;
//        }
//
//        public void setAmt_qc(Float amt_qc) {
//            this.amt_qc = amt_qc;
//        }
//
//        public Float getAmt_pc() {
//            return amt_pc;
//        }
//
//        public void setAmt_pc(Float amt_pc) {
//            this.amt_pc = amt_pc;
//        }
//
//        public Float getAmt_usd() {
//            return amt_usd;
//        }
//
//        public void setAmt_usd(Float amt_usd) {
//            this.amt_usd = amt_usd;
//        }
//    }

}