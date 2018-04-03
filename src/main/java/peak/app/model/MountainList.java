package peak.app.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="MOUNTAIN_LISTS")
public class MountainList {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
    
    @ManyToMany
    @JoinTable(name="MOUNTAIN_LISTS_MOUNTAINS",
            joinColumns=@JoinColumn(name="MOUNTAIN_LIST_ID"),
            inverseJoinColumns=@JoinColumn(name="MOUNTAIN_ID"))
    private List<Mountain> mountains;
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Mountain> getMountains()
    {
        return mountains;
    }
}
