package code.challenge.featuretoggles.payload.request;

import java.util.HashSet;
import java.util.Set;

public class QueryFeaturesRequest {

    FeatureRequest featureRequest;

    public FeatureRequest getFeatureRequest() {
        return featureRequest;
    }

    public void setFeatureRequest(FeatureRequest featureRequest) {
        this.featureRequest = featureRequest;
    }

    @Override
    public String toString() {
        return "QueryFeaturesRequest{" +
                "featureRequest=" + featureRequest +
                '}';
    }

    public static class FeatureRequest {

        String customerId;

        Set<Name> features = new HashSet<>();

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public Set<Name> getFeatures() {
            return features;
        }

        public void setFeatures(Set<Name> features) {
            this.features = features;
        }


        @Override
        public String toString() {
            return "QueryFeaturesRequest{" +
                    "customerId='" + customerId + '\'' +
                    ", features=" + features +
                    '}';
        }
    }

    public static class Name {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Name{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
