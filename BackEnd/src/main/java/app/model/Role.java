package app.model;

import javax.persistence.*;

@Entity //Specifies that the class is an entity.
@Table(name = "roles") //specify the table name for the database.
public class Role {
    //enum for customer, worker and admin roles
    public enum ERole {
        ROLE_CUSTOMER,
        ROLE_WORKER,
        ROLE_ADMIN
    }

    @Id //generate primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Use enum roles
    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private ERole name;

    //empty constructor for role
    public Role() {}

    //constructor with name field
    public Role(ERole name) { this.name = name; }

    //getter for id
    public long getId() {
        return id;
    }
    //setter for id
    public void setId(long id) {
        this.id = id;
    }
    //getter for name of the role
    public ERole getName() {
        return name;
    }
    //setter for name of the role
    public void setName(ERole name) {
        this.name = name;
    }
}