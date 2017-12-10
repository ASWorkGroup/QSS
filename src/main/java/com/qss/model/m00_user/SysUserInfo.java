package com.qss.model.m00_user;

/**
 * Created by YuanAiQing on 2017/12/6.
 */
public class SysUserInfo {
    private String ID;
    private String NAME;
    private int ENABLE;
    private String PASSWORD;
    private String COMPANY;
    private String EMAIL;
    private String LANGUAGE;
    private String DEFAULTCOUNTRYREGION;
    private int PREFERREDTIMEZONE;
    private int RECVERSION;
    private int RECID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public int getENABLE() {
        return ENABLE;
    }

    public void setENABLE(int ENABLE) {
        this.ENABLE = ENABLE;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getCOMPANY() {
        return COMPANY;
    }

    public void setCOMPANY(String COMPANY) {
        this.COMPANY = COMPANY;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getLANGUAGE() {
        return LANGUAGE;
    }

    public void setLANGUAGE(String LANGUAGE) {
        this.LANGUAGE = LANGUAGE;
    }

    public String getDEFAULTCOUNTRYREGION() {
        return DEFAULTCOUNTRYREGION;
    }

    public void setDEFAULTCOUNTRYREGION(String DEFAULTCOUNTRYREGION) {
        this.DEFAULTCOUNTRYREGION = DEFAULTCOUNTRYREGION;
    }

    public int getPREFERREDTIMEZONE() {
        return PREFERREDTIMEZONE;
    }

    public void setPREFERREDTIMEZONE(int PREFERREDTIMEZONE) {
        this.PREFERREDTIMEZONE = PREFERREDTIMEZONE;
    }

    public int getRECVERSION() {
        return RECVERSION;
    }

    public void setRECVERSION(int RECVERSION) {
        this.RECVERSION = RECVERSION;
    }

    public int getRECID() {
        return RECID;
    }

    public void setRECID(int RECID) {
        this.RECID = RECID;
    }
}
