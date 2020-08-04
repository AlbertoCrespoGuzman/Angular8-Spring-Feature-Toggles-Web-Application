package code.challenge.featuretoggles.models;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "feature_toggles")
public class FeatureToggle {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "technical_name", nullable = false, unique=true)
    private String technicalName;

    @Column(name = "expires_on")
    private Timestamp expiresOn;

    @Column(name = "description")
    private String description;

    @Column(name = "inverted")
    private boolean inverted;

    @Column(name = "archived")
    private boolean archived;

    @ElementCollection
    @Column(name = "customer_ids")
    private Set<String> customerIds = new HashSet<>();

    public FeatureToggle(String displayName, String technicalName, Timestamp expiresOn, String description, boolean inverted, boolean archived, Set<String> customerIds) {
        this.displayName = displayName;
        this.technicalName = technicalName;
        this.expiresOn = expiresOn;
        this.description = description;
        this.inverted = inverted;
        this.archived = archived;
        this.customerIds = customerIds;
    }

    public FeatureToggle() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Set<String> getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(Set<String> customerIds) {
        this.customerIds = customerIds;
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

    @Override
    public String toString() {
        return "FeatureToggle{" +
                "id=" + id +
                ", displayName='" + displayName + '\'' +
                ", technicalName='" + technicalName + '\'' +
                ", expiresOn=" + expiresOn +
                ", description='" + description + '\'' +
                ", inverted=" + inverted +
                ", archived=" + archived +
                ", customerIds=" + customerIds +
                '}';
    }
}
