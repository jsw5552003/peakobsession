package peak.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FRIENDS")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // the name the user wants the friend to be known by.
    private String name;

    @JoinColumn(name = "USER_ID")
    @ManyToOne
    private User user;

    @JoinColumn(name = "FRIEND_USER_ID")
    @OneToOne
    private User friendUser;

    public Friend(String name, User user) {
        super();
        this.name = name;
        this.user = user;
    }

    public Friend(Long id) {
        super();
        this.id = id;
    }

    public Friend() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFriendUser() {
        return friendUser;
    }

    public void setFriendUser(User friendUser) {
        this.friendUser = friendUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Name: " + name + " User: [" + (user != null ? user.toString() : "null") + "] Friend User: ["
                + (friendUser != null ? friendUser.toString() : "null") + "]";
    }

}
