package ci.boobacool.projetPiloteJAVA.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
@Entity
@Table(name="task")
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String date;
	@NotEmpty 
	private String startTime;
	@NotEmpty
	private String stopTime;
	@NotEmpty
	private String description;
	@ManyToOne
	@JoinColumn(name="user_email")
	private User user;
	
	
	public Task() {
		
	}
	
	
	public Task(String date, String startTime, String stopTime, String description, User user) {

		this.date = date;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.description = description;
		this.user = user;
	}


	public Task(String date, String startTime, String stopTime, String description) {

		this.date = date;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getStopTime() {
		return stopTime;
	}
	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	 

}
