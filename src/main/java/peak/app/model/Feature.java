package peak.app.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "FEATURES")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ENTERED_DATE")
    private LocalDate dateEntered;

    private String name;
    @Lob
    private String description;

    @Column(columnDefinition = "tinyint default false")
    boolean accepted;
    @Column(columnDefinition = "tinyint default false")
    boolean complete;

    protected Feature()
    {
    }

    public Feature(String name, String description)
    {
        this.name = name;
        this.description = description;
        dateEntered = LocalDate.now();
        accepted = false;
        complete = false;
    }

    public LocalDate getDateEntered()
    {
        return dateEntered;
    }

    public void setDateEntered(LocalDate dateEntered)
    {
        this.dateEntered = dateEntered;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Boolean getAccepted()
    {
        return accepted;
    }

    public void setAccepted(Boolean accepted)
    {
        this.accepted = accepted;
    }

    public boolean isComplete()
    {
        return complete;
    }

    public void setComplete(boolean complete)
    {
        this.complete = complete;
    }

}
