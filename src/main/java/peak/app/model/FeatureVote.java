package peak.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FEATURE_VOTES")
public class FeatureVote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "USER_ID")
    private long userId;

    @Column(name = "FEATURE_ID")
    private long featureId;

    public FeatureVote(long user_id, long feature_id)
    {
        super();
        this.userId = user_id;
        this.featureId = feature_id;
    }

    public FeatureVote()
    {
        super();
    }

    public long getUserId()
    {
        return userId;
    }

    public void setUserId(long user_id)
    {
        this.userId = user_id;
    }

    public long getFeatureId()
    {
        return featureId;
    }

    public void setFeatureId(long feature_id)
    {
        this.featureId = feature_id;
    }

}
