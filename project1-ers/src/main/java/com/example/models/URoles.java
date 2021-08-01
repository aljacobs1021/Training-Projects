package com.example.models;

@Entity
@Table(name = "ers_users")
public class User {
    //private int id;
    //private String first; //first name
    //private String last; //last name
    //private String username;
    //private String email;
    //private String pass; //password
    private String role; //account type: manager or employee

    @Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="first_name", nullable=false)
	private String first; // first name

}
