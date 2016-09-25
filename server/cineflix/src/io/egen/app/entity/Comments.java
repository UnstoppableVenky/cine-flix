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
@NamedQueries({@NamedQuery(name = "Comments.findAll", query = "SELECT c from Comments c ORDER BY c.userName"),
	  @NamedQuery(name = "Comments.findByImdbId", query = "SELECT c from Comments c where c.imdbId=:pimdbId")
})
public class Comments {

	@Id
	private String cmntId;
	private String userName;
	private Number rating;
	private String comments;
	
	@Column(unique = true)
	private String imdbId;
	
	public Comments(){
		cmntId = UUID.randomUUID().toString();
	}
	public String getCmntId() {
		return cmntId;
	}
	public void setCmntId(String cmntId) {
		this.cmntId = cmntId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Number getRating() {
		return rating;
	}
	public void setRating(Number rating) {
		this.rating = rating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	@Override
	public String toString() {
		return "Comments [cmntId=" + cmntId + ", userName=" + userName + ", rating=" + rating + ", comments=" + comments
				+ ", imdbId=" + imdbId + "]";
	}
	
	
	
}
