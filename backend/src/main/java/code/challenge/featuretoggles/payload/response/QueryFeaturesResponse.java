package code.challenge.featuretoggles.payload.response;

import code.challenge.featuretoggles.models.FeatureToggle;

import java.util.*;
import java.util.stream.Collectors;

public class QueryFeaturesResponse {

    Set<Feature> features = new HashSet<>();


    public QueryFeaturesResponse(List<FeatureToggle> featureToggleList) {

        this.features.addAll(featureToggleList.stream().map(featureToggle -> {

            Feature feature = new Feature();

            feature.setName(featureToggle.getTechnicalName());
            feature.setActive(!featureToggle.isArchived() && !Collections.disjoint(featureToggle.getCustomerIds(), featureToggle.getCustomerIds()));
            feature.setExpired(featureToggle.getExpiresOn().before(new Date()));
            feature.setInverted(featureToggle.isInverted());

            return feature;
        }).collect(Collectors.toList()));
    }

    public Set<Feature> getFeatures() {
        return features;
    }



    public void setFeatures(Set<Feature> features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "QueryFeaturesResponse{" +
                "features=" + features +
                '}';
    }




    public class Feature {

        String name;
        boolean active;
        boolean inverted;
        boolean expired;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public boolean isInverted() {
            return inverted;
        }

        public void setInverted(boolean inverted) {
            this.inverted = inverted;
        }

        public boolean isExpired() {
            return expired;
        }

        public void setExpired(boolean expired) {
            this.expired = expired;
        }
    }

}
