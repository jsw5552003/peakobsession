package peak.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FRIENDS")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // the name you the user wants the friend known by.
    private String name;

    @Column(name = "USER_ID")
    private User user;

    @Column(name = "FRIEND_USER_ID")
    private User friendUser;

}
