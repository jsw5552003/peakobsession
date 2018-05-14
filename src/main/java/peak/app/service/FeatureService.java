package peak.app.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import peak.app.model.Feature;
import peak.app.model.FeatureVote;
import peak.app.repository.FeatureRepository;
import peak.app.repository.FeatureVoteRepository;

@Service
public class FeatureService {

    @Autowired
    FeatureRepository featureRepository;

    @Autowired
    FeatureVoteRepository voteRepository;

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

    public void voteForFeature(long userId, long featureId)
    {
        logger.info("Adding a vote with user ID: " + userId + " and feature id: " + featureId);
        FeatureVote vote = new FeatureVote();
        vote.setFeatureId(featureId);
        vote.setUserId(userId);
        voteRepository.save(vote);
    }

    public long getNumberFeatureVotes(long featureId)
    {
        logger.info("Get the number of votes for feature: " + featureId);
        return voteRepository.countByFeatureId(featureId);
    }

    public Feature getFeature(long featureId)
    {
        logger.info("Get feature with id: " + featureId);
        return featureRepository.findOne(featureId);
    }

    public void saveFeature(Feature feature)
    {
        logger.info("Saving a feature with name " + feature.getName());
        featureRepository.save(feature);
    }
}
