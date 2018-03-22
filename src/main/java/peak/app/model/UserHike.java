package peak.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserHike {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private Date hikeDate;
    
    private float mileage;

    public Date getDate()
    {
        return hikeDate;
    }

    public void setDate(Date date)
    {
        this.hikeDate = date;
    }

    public float getMileage()
    {
        return mileage;
    }

    public void setMileage(float mileage)
    {
        this.mileage = mileage;
    }
    
    
    
    

}
