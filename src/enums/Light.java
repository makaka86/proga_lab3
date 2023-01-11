package enums;

import interfaces.IFeature;

public enum Light implements IFeature {

    BRIGHT("яркий"),
    MODERATE("умеренный"),
    DIM("тусклый");

    private final static String type = "lit1";
    private final String text;
    Light(String text) {
        this.text = text;
    }

    @Override
    public String toString(){
        return text;
    }

    @Override
    public String getFutureType() {
        return type;
    }

    @Override
    public String getFutureName() {
        return text;
    }
}
