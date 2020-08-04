package code.challenge.featuretoggles.controllers;

import code.challenge.featuretoggles.models.FeatureToggle;
import code.challenge.featuretoggles.models.User;
import code.challenge.featuretoggles.payload.request.FeatureToggleCreateRequest;
import code.challenge.featuretoggles.payload.request.FeatureToggleUpdateRequest;
import code.challenge.featuretoggles.payload.response.MessageResponse;
import code.challenge.featuretoggles.repositories.FeatureToggleRepository;
import code.challenge.featuretoggles.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("")
public class FeatureController {

    @Autowired
    private FeatureToggleRepository featureToggleRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/features")
    public List<FeatureToggle> getAllFeatureToggles() {
        return featureToggleRepository.findAll();
    }
    @GetMapping("/features/{featureId}")
    public FeatureToggle getFeatureToggle(@PathVariable("featureId") long featureId) {
        return featureToggleRepository.findById(featureId)
                .orElseThrow(() -> new RuntimeException("Error: The feature doesn't exist."));
    }
    @PostMapping("/features")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createFeatureToggle(@Valid @RequestBody FeatureToggleCreateRequest featureToggleCreateRequest) {

        FeatureToggle featureToggle = new FeatureToggle(featureToggleCreateRequest.getDisplayName(),
                                                        featureToggleCreateRequest.getTechnicalName(),
                                                        featureToggleCreateRequest.getExpiresOn(),
                                                        featureToggleCreateRequest.getDescription(),
                                                        featureToggleCreateRequest.isInverted(),
                                                        featureToggleCreateRequest.isArchived(),
                                                        featureToggleCreateRequest.getCustomerIds());
        
        featureToggleRepository.save(featureToggle);

        return ResponseEntity.ok(new MessageResponse("Feature created successfully!"));
    }

    @PutMapping("/features/{featureId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateFeatureToggle(@PathVariable("featureId") long featureId, @Valid @RequestBody FeatureToggleUpdateRequest featureToggleUpdateRequest) {


        FeatureToggle featureToggle = featureToggleRepository.findById(featureId)
                .orElseThrow(() -> new RuntimeException("Error: The feature doesn't exist."));

        featureToggle.setDisplayName(featureToggleUpdateRequest.getDisplayName());
        featureToggle.setTechnicalName(featureToggleUpdateRequest.getTechnicalName());
        featureToggle.setDescription(featureToggleUpdateRequest.getDescription());
        featureToggle.setExpiresOn(featureToggleUpdateRequest.getExpiresOn());
        featureToggle.setInverted(featureToggleUpdateRequest.isInverted());
        featureToggle.setArchived(featureToggleUpdateRequest.isArchived());
        featureToggle.setCustomerIds(featureToggleUpdateRequest.getCustomerIds());

        featureToggleRepository.save(featureToggle);

        return ResponseEntity.ok(new MessageResponse("User updated successfully!"));
    }

    @DeleteMapping("/features/{featureId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> archiveFeatureToggle(@PathVariable("featureId") long featureId, @Valid @RequestBody FeatureToggleUpdateRequest featureToggleUpdateRequest) {


        FeatureToggle featureToggle = featureToggleRepository.findById(featureId)
                .orElseThrow(() -> new RuntimeException("Error: The feature doesn't exist."));

        featureToggle.setArchived(true);
        featureToggleRepository.save(featureToggle);

        return ResponseEntity.ok(new MessageResponse("Feature archived successfully!"));
    }
    
    @PostMapping("/features2")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createFeatureToggle2(@Valid @RequestBody FeatureToggleCreateRequest featureToggleCreateRequest) {
        FeatureToggle featureToggle = new FeatureToggle(featureToggleCreateRequest.getDisplayName(),
                featureToggleCreateRequest.getTechnicalName(),
                featureToggleCreateRequest.getExpiresOn(),
                featureToggleCreateRequest.getDescription(),
                featureToggleCreateRequest.isInverted(),
                featureToggleCreateRequest.isArchived(),
                featureToggleCreateRequest.getCustomerIds());
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

}
