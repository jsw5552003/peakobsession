package peak.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserHike {
    @Id
    private String id;
    private Date date;
    
    

}
