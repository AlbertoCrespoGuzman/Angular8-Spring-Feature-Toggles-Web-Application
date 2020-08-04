package code.challenge.featuretoggles.controllers;

import code.challenge.featuretoggles.models.FeatureToggle;
import code.challenge.featuretoggles.payload.request.QueryFeaturesRequest;
import code.challenge.featuretoggles.payload.response.QueryFeaturesResponse;
import code.challenge.featuretoggles.repositories.FeatureToggleRepository;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class ApiToggleController {

	@Autowired
	FeatureToggleRepository featureToggleRepository;


	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@PostMapping("/features")
	public QueryFeaturesResponse queryFeatures(@RequestBody QueryFeaturesRequest queryFeaturesRequest) {

		System.out.println(queryFeaturesRequest.toString());
		List<FeatureToggle> featureToggleList = featureToggleRepository.findByTechnicalNameIn(
				queryFeaturesRequest.getFeatureRequest().getFeatures()
				.stream()
				.map(featureName -> featureName.getName())
				.collect(Collectors.toList()));

		QueryFeaturesResponse queryFeaturesResponse = new QueryFeaturesResponse(featureToggleList);

		return queryFeaturesResponse;
	}

}
