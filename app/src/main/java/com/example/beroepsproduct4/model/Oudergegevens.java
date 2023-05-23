package com.example.beroepsproduct4.model;

public class Oudergegevens {
    public String oudernaam;
    public String bsn;
    public Zorgcentrum zorgcentrum;

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
