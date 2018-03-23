package peak.app.model;

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

    public UserHike() {
		super();
	}  

	public UserHike(LocalDate hikeDate, double mileage) {
		super();
		this.date = hikeDate;
		this.mileage = mileage;
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
    
    
    
    

}
