package interfaces;

import java.util.List;

public interface IFeaturable <T> {
    T applyFeature(IFeature feature);

    List<IFeature> getFeatures();
}
