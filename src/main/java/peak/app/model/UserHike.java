package peak.app.model;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.time.LocalDate;
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
    
    private LocalDate date;
    
    private double mileage;
    
    private int elevation;

    public UserHike() {
		super();
	}  

	public UserHike(LocalDate hikeDate, double mileage, int elevation) {
		super();
		this.date = hikeDate;
		this.mileage = mileage;
		this.elevation = elevation;
	}

	public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public double getMileage()
    {
        return mileage;
    }

    public void setMileage(double mileage)
    {
        this.mileage = mileage;
    }
    
    public int getElevation()
    {
    	return elevation;
    }
    
    public void setElevation(int elevation)
    {
    	this.elevation = elevation;
    }

}
