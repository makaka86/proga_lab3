package enums;

import interfaces.IFeature;

public enum Emote implements IFeature {
    JOYFUL("радостная"),
    CALM("cпокойная"),
    SAD("унылая"),
    AGGRIEVED("обиженная");

    private final static String type = "et1";
    private final String text;
    Emote(String text) {
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
