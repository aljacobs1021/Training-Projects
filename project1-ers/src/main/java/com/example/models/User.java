package com.example.models;

@Entity
@Table(name = "ers_users")
public class User {
    // private int id;
    // private String first; //first name
    // private String last; //last name
    // private String username;
    // private String email;
    // private String pass; //password
    private String role; // account type: manager or employee

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "first_name", nullable = false)
    private String first; // first name

    @Column(name = "last_name", nullable = false)
    private String last; // last name

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String pass; // password

    @Column(name = "role", nullable = false)
    private

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)

    public User() {
    }

    public User(int id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = firstName + lastName + (new Random().nextInt(9000) + 1000);
        this.email = email;
        this.password = password;
        // this.posts = new ArrayList<Post>();
    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = firstName + lastName + (new Random().nextInt(9000) + 1000);
        this.email = email;
        this.password = password;
        // this.posts = new ArrayList<Post>();
    }

    public User(int id, String firstName, String lastName, String email, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        // this.posts = new ArrayList<Post>();
    }

    public User(String firstName, String lastName, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        // this.posts = new ArrayList<Post>();
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getFirst() {
        return this.first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getLast() {
        return this.last;
    }

    public void setUsername(String user) {
        this.username = user;
    }

    public String getUsername() {
        return this.username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return this.pass;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}