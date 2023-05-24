package com.example.beroepsproduct4.model;

public class Oudergegevens {
    private String oudernaam;
    private String bsn;
    private Zorgcentrum zorgcentrum;

    public Oudergegevens(String bsn) {
        this.bsn = bsn;
    }

    public Oudergegevens() {

    }

    public String getOudernaam() {
        return oudernaam;
    }

    public void setOudernaam(String oudernaam) {
        this.oudernaam = oudernaam;
    }

    public String getBsn() {
        return bsn;
    }

    public void setBsn(String bsn) {
        this.bsn = bsn;
    }

    public Zorgcentrum getZorgcentrum() {
        return zorgcentrum;
    }

    public void setZorgcentrum(Zorgcentrum zorgcentrum) {
        this.zorgcentrum = zorgcentrum;
    }
}
