package peak.app.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="MOUNTAIN_LISTS")
public class MountainList extends HikeList {
    
    @ManyToMany
    @JoinTable(name="MOUNTAIN_LISTS_MOUNTAINS",
            joinColumns=@JoinColumn(name="MOUNTAIN_LIST_ID"),
            inverseJoinColumns=@JoinColumn(name="MOUNTAIN_ID"))
    private List<Mountain> mountains;
    
   

    public List<Mountain> getMountains()
    {
        return mountains;
    }
}
