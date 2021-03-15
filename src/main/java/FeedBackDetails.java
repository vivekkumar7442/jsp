import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedBackDetails implements
 Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String feedbackId;

	private Integer id;

	private String type;

	private String subject;

	private String content;

	private String status;

	private Date createdTime;

	private Date oicCreatedTime;

	private String oicRemarks;

	private String oicId;

	private UserDetails userDetail;

	public UserDetails getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetails userDetail) {
		this.userDetail = userDetail;
	}

	public String getOicId() {
		return oicId;
	}

	public void setOicId(String oicId) {
		this.oicId = oicId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getOicCreatedTime() {
		return oicCreatedTime;
	}

	public void setOicCreatedTime(Date oicCreatedTime) {
		this.oicCreatedTime = oicCreatedTime;
	}

	public String getOicRemarks() {
		return oicRemarks;
	}

	public void setOicRemarks(String oicRemarks) {
		this.oicRemarks = oicRemarks;
	}

}
