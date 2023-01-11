package enums;

import interfaces.IFeature;

public enum Length implements IFeature {
    LONG("длинное"),
    MIDDLE("средний"),
    SHORT("короткий");

    private final static String type = "lt1";
    private final String text;
    Length(String text) {
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
