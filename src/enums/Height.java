package enums;

import interfaces.IFeature;

public enum Height implements IFeature {
    HIGH("высокий"),
    LOW("низкое");

    private final static String type = "ht1";
    private final String text;
    Height(String text) {
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
