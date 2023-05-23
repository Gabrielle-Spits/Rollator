package com.example.beroepsproduct4.model;

public class Zorgcentrum {
    public String afdeling;
    public String zorgcentrum;

    public Zorgcentrum(String afdeling, String zorcentrum) {
        this.afdeling = afdeling;
        this.zorgcentrum = zorcentrum;
    }

    public Zorgcentrum() {

    }

    public String getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }

    public String getZorgcentrum() {
        return zorgcentrum;
    }

    public void setZorgcentrum(String zorgcentrum) {
        this.zorgcentrum = zorgcentrum;
    }
}
