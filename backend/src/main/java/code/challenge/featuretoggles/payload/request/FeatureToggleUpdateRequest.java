package code.challenge.featuretoggles.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class FeatureToggleUpdateRequest {

    private String displayName;

    @NotBlank
    private String technicalName;

    private Timestamp expiresOn;

    private String description;

    private boolean inverted;

    private boolean archived;

    private Set<String> customerIds = new HashSet<>();

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getTechnicalName() {
        return technicalName;
    }

    public void setTechnicalName(String technicalName) {
        this.technicalName = technicalName;
    }

    public Timestamp getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(Timestamp expiresOn) {
        this.expiresOn = expiresOn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isInverted() {
        return inverted;
    }

    public void setInverted(boolean inverted) {
        this.inverted = inverted;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public Set<String> getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(Set<String> customerIds) {
        this.customerIds = customerIds;
    }

    @Override
    public String toString() {
        return "FeatureToggleUpdateRequest{" +
                "displayName='" + displayName + '\'' +
                ", technicalName='" + technicalName + '\'' +
                ", expiresOn=" + expiresOn +
                ", description='" + description + '\'' +
                ", inverted=" + inverted +
                ", archived=" + archived +
                ", customerIds=" + customerIds +
                '}';
    }
}
