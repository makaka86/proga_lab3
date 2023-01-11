package enums;

import interfaces.IFeature;

public enum Material implements IFeature {
    GLASS("стеклянный"),
    GOLD("золотой"),
    WOOD("деревянный"),
    IRON("железный");

    private final static String type = "mt1";
    private final String text;
    Material(String text) {
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
