package peak.app.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FEATURES")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ENTERED_DATE")
    private LocalDate dateEntered;

    @Column(name = "ACCEPTED_DATE")
    private LocalDate dateAccepted;

    @Column(name = "COMPLETED_DATE")
    private LocalDate dateCompleted;

    @ManyToOne
    User user;

    private String name;
    @Lob
    private String description;

    @Column(columnDefinition = "tinyint default false")
    boolean accepted;
    @Column(columnDefinition = "tinyint default false")
    boolean completed;

    @ManyToMany
    @JoinTable(name = "FEATURE_VOTES", joinColumns = @JoinColumn(name = "FEATURE_ID"), inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    private List<User> users;

    protected Feature()
    {
    }

    public Feature(String name, String description)
    {
        this.name = name;
        this.description = description;
        dateEntered = LocalDate.now();
        accepted = false;
        completed = false;
    }

    public int getNumberVotes()
    {
        System.out.println("Is users list null? " + this.users == null ? "yes" : "no");
        return this.users == null ? 0 : this.users.size();
    }

    public boolean hasUserVoted(User user)
    {
        return users == null ? false : users.contains(user);
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

    public boolean isAccepted()
    {
        return accepted;
    }

    public void setAccepted(boolean accepted)
    {
        this.accepted = accepted;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }

    public LocalDate getDateAccepted()
    {
        return dateAccepted;
    }

    public void setDateAccepted(LocalDate dateAccepted)
    {
        this.dateAccepted = dateAccepted;
    }

    public LocalDate getDateCompleted()
    {
        return dateCompleted;
    }

    public void setDateCompleted(LocalDate dateCompleted)
    {
        this.dateCompleted = dateCompleted;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "Feature [dateEntered=" + dateEntered + ", dateAccepted=" + dateAccepted + ", dateCompleted="
                + dateCompleted + ", user=" + user + ", name=" + name + ", description=" + description + ", accepted="
                + accepted + ", completed=" + completed + ", users=" + users + "]";
    }

}
