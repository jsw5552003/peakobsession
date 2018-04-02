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
@Table(name="HIKE_LISTS")
public class HikeList {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    @ManyToMany
    @JoinTable(name="HIKE_LISTS_MOUNTAINS",
            joinColumns=@JoinColumn(name="HIKE_LIST_ID"),
            inverseJoinColumns=@JoinColumn(name="MOUNTAIN_ID"))
    private List<Mountain> mountains;
}
