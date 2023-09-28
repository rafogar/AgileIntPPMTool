package io.agileintelligence.ppmtool.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
	@NotBlank(message = "Project name is required")
	private String projectName;	
	@NotBlank(message = "Project Identifier is required")
	@Size(min=4, max=5, message = "Please use 4 to 5 characters")
	@Column(updatable = false, unique = true)
	private String projectIdentifier;	
	@NotBlank(message = "Project description is required")
	private String description;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date start_date;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date end_date;	
	
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date created_At;	
	@JsonFormat(pattern = "yyyy-mm-dd")
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
