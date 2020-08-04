package code.challenge.featuretoggles.repositories;

import code.challenge.featuretoggles.models.FeatureToggle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeatureToggleRepository extends JpaRepository<FeatureToggle, Long> {
    List<FeatureToggle> findByTechnicalNameIn(List<String> technicalNames);
}
