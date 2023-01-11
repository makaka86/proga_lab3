package features;

import interfaces.IFeature;

public class ThinkFeature implements IFeature {
    private final static String type = "et1";
    private final String thinkString;

    public ThinkFeature(String thinkString) {
        this.thinkString = thinkString;
    }

    @Override
    public String getFutureType() {
        return type;
    }

    @Override
    public String getFutureName() {
        return thinkString;
    }

    @Override
    public String toString(){
        return thinkString;
    }
}
