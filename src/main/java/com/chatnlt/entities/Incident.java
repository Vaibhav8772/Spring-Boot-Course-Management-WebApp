package com.chatnlt.entities;




import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="user_incident_table")
public class Incident {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer incidentid;
	private String department;
	private String symptoms;
	@Column(length = 1000)
	private String description;
	private String filter;
	private String attachment;
	private String remark;
	private String severity;
	private String impact;
	private String category;
	
	@ManyToOne()
	private User user;
	
	 @Transient
	    private MultipartFile attachmentFile;
	
	
	public MultipartFile getAttachmentFile() {
		return attachmentFile;
	}
	public void setAttachmentFile(MultipartFile attachmentFile) {
		this.attachmentFile = attachmentFile;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getIncidentid() {
		return incidentid;
	}
	public void setIncidentid(Integer incidentid) {
		this.incidentid = incidentid;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getImpact() {
		return impact;
	}
	public void setImpact(String impact) {
		this.impact = impact;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
	
	
	
	
	
	
}
