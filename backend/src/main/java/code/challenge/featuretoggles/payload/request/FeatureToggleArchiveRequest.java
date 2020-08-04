package code.challenge.featuretoggles.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class FeatureToggleArchiveRequest {

    @NotNull
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FeatureToggleArchiveRequest{" +
                "id=" + id +
                '}';
    }
}
