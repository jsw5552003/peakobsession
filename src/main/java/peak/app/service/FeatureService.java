package peak.app.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import peak.app.model.Feature;
import peak.app.repository.FeatureRepository;

@Service
public class FeatureService {

    @Autowired
    FeatureRepository featureRepository;

    private static final Logger logger = LoggerFactory.getLogger(FeatureService.class);

    public List<Feature> getAllFeatures()
    {
        logger.info("Get all features.");
        ArrayList<Feature> featureList = new ArrayList<>();
        Iterable<Feature> featureIter = featureRepository.findAll();
        featureIter.forEach(featureList::add);
        return featureList;
    }

    public void addFeature(Feature feature)
    {
        logger.info("Adding a feature with name: " + feature.getName());
        featureRepository.save(feature);
    }
}
