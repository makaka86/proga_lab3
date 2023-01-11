package enums;

import interfaces.IFeature;

public enum Size implements IFeature {
    BIG("большой"),
    MIDDLE("средний"),
    TINY("маленький");

    private final static String type = "st1";
    private final String text;

    Size(String text) {
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
