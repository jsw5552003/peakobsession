package peak.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOUNTAINS")
public class Mountain implements Comparable<Mountain> {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    private int elevation;
    
    public Mountain()
    {
        super();
    }
    
    public Mountain(Long id)
    {
        this.id = id;
    }

    public Mountain(String name, int elevation)
    {
        super();
        this.name = name;
        this.elevation = elevation;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getElevation()
    {
        return elevation;
    }

    public void setElevation(int elevation)
    {
        this.elevation = elevation;
    }

    @Override
    public String toString()
    {
        return "Mountain Name: " + name + " Elevation: " + elevation;
    }

    @Override
    public int compareTo(Mountain mountain)
    {
        return mountain.elevation - this.elevation;
    }

    @Override
    public boolean equals(Object mountain)
    {
        if (mountain != null && mountain instanceof Mountain)
            if (((Mountain) mountain).getName().equals(this.getName())
                    && ((Mountain) mountain).getElevation() == this.getElevation())
                return true;
        return false;
    }
}
