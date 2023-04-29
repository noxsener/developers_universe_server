package com.codenfast.developersuniverse.model;

public class RaporParametreRequest {
    private Object deger;
    private String parametreAdi;
    private Class<?> parametreClass;

    public RaporParametreRequest() {
    }

    public Object getDeger() {
        return deger;
    }

    public void setDeger(Object deger) {
        this.deger = deger;
    }

    public String getParametreAdi() {
        return parametreAdi;
    }

    public void setParametreAdi(String parametreAdi) {
        this.parametreAdi = parametreAdi;
    }

    public Class<?> getParametreClass() {
        return parametreClass;
    }

    public void setParametreClass(Class<?> parametreClass) {
        this.parametreClass = parametreClass;
    }

    @Override
    public String toString() {
        return "RaporParametre [parametreAdi=" + this.parametreAdi + ", parametreClass=" + this.parametreClass + "]";
    }
}
