package io.agileintelligence.ppmtool.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String projectName;	
	private String projectIdentifier;	
	private String description;	
	private Date start_date;	
	private Date end_date;
	
	
	private Date created_At;	
	private Date updated_At;
	
	@PrePersist
	protected void onCreate() {
		this.created_At = new Date();
		
	}
	
	@PreUpdate
	protected void onUpdated() {
		this.updated_At = new Date();
	}
	

}
