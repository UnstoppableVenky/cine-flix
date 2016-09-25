package io.egen.app.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({@NamedQuery(name = "Users.findAll", query = "SELECT u from Users u ORDER BY u.userName"),
	  @NamedQuery(name = "Users.findByEmail", query = "SELECT u from Users u where u.userEmail=:puserEmail")
})
public class Users {

	@Id
	private String userId;
	private String userName;
	private String userPassword;
	@Column(unique = true)
	private String userEmail;
	
	public Users(){
		userId = UUID.randomUUID().toString();
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userEmail="
				+ userEmail + "]";
	}
	
	
}
