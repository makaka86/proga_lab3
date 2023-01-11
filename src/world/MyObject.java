package world;

import interfaces.IFeaturable;
import interfaces.IFeature;

import java.util.*;
import java.util.stream.Collectors;

public abstract class MyObject implements IFeaturable<MyObject> {

    private final String objectName;
    private HashMap<String, IFeature> features = new HashMap<>();


    protected MyObject(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectName() {
        return objectName;
    }


   public abstract String getType();

    @Override
    public MyObject applyFeature(IFeature feature) {
        if (features.containsKey(feature.getFutureType())) {
            IFeature iFeature = features.get(feature.getFutureType());
            System.out.println("Свойство " + iFeature.getFutureName() +
                    " имеет такой же тип как и у " + feature.getFutureName() + ", свойство заменено новым значением");
            features.replace(feature.getFutureType(), feature);
        } else {
            System.out.println("Объекту " + this.toString() + " добавлено свойство " + feature.toString());
            features.put(feature.getFutureType(), feature);
        }
        return this;
    }

    @Override
    public List<IFeature> getFeatures() {
        List<IFeature> collect = new ArrayList<>(features.values());
        return Collections.unmodifiableList(collect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectName);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        String futures = features.values().stream()
                .map(IFeature::getFutureName)
                .collect(Collectors.joining(", "));
        return objectName + " " + futures;
    }
}
