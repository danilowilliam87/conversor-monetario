package com.io.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



/**
 * @author Danilo William
 * a classe representa os dados retornados da api de cota�oes
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosRetornoApi {

    private String code;
    private String codein;
    private String name;
    private double high;
    private double low;
    private double varBid;
    private double pctChange;
    private double bid;
    private double ask;
    private String timestamp;
    @JsonProperty(value = "create_date")
    private String createdate;

    public DadosRetornoApi() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodein() {
        return codein;
    }

    public void setCodein(String codein) {
        this.codein = codein;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getVarBid() {
        return varBid;
    }

    public void setVarBid(double varBid) {
        this.varBid = varBid;
    }

    public double getPctChange() {
        return pctChange;
    }

    public void setPctChange(double pctChange) {
        this.pctChange = pctChange;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        return "DadosRetornoApi [code=" + code + ", codeIn=" + codein + ", name=" + name + ", high=" + high + ", low="
                + low + ", varBid=" + varBid + ", ptcChange=" + pctChange + ", bid=" + bid + ", ask=" + ask
                + ", timeStamp=" + timestamp + ", createDate=" + createdate + "]";
    }

}
