/**
 * 
  <p>
 * <b> Analyser Title </b>
 * </p>
 *
 * <p>
 * todos os direitos reservados
 * </p>
 * 
 * @author <a href="https://github.com/JoseRafael97">Rafael Feitosa</a>
 */
package br.edu.ifpb.analyserTitle.extractYh.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * <p>
 * <b> {@link QuestionYh} </b>
 * </p>
 *
 * <p>
 * Entidade que representa um pergunta.
 * </p>
 * 
 * @author <a href="https://github.com/JoseRafael97">Rafael Feitosa</a>
 */
public class QuestionYh implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private String body;
	private String link;
	private boolean acceptedAnswers;
	private Integer answersNumber;
	private List<String> tags;
	private Date createDate;
	private Date firstAnswer;
	private Long timeInHourForFisrtAnswer;
	
	public QuestionYh() {
	}

	public QuestionYh(String title, String body, String link, Integer answersNumber, boolean acceptedAnswers,
			List<String> tags, Date createDate) {
		this.title = title;
		this.body = body;
		this.link = link;
		this.tags = tags;
		this.answersNumber = answersNumber;
		this.acceptedAnswers = acceptedAnswers;
		this.createDate = createDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	

	
	/**
	 * @return the tags
	 */
	public List<String> getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	/**
	 * @return the answersNumber
	 */
	public Integer getAnswersNumber() {
		return answersNumber;
	}

	/**
	 * @param answersNumber the answersNumber to set
	 */
	public void setAnswersNumber(Integer answersNumber) {
		this.answersNumber = answersNumber;
	}
	
	

	/**
	 * @return the acceptedAnswers
	 */
	public boolean isAcceptedAnswers() {
		return acceptedAnswers;
	}

	/**
	 * @param acceptedAnswers the acceptedAnswers to set
	 */
	public void setAcceptedAnswers(boolean acceptedAnswers) {
		this.acceptedAnswers = acceptedAnswers;
	}
	
	

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	

	public Date getFirstAnswer() {
		return firstAnswer;
	}

	public void setFirstAnswer(Date firstAnswer) {
		this.firstAnswer = firstAnswer;
	}

	public Long getTimeInHourForFisrtAnswer() {
		return timeInHourForFisrtAnswer;
	}

	public void setTimeInHourForFisrtAnswer(Long timeInHourForFisrtAnswer) {
		this.timeInHourForFisrtAnswer = timeInHourForFisrtAnswer;
	}

	
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", body=" + body + ", link=" + link + ", acceptedAnswers="
				+ acceptedAnswers + ", answersNumber=" + answersNumber + ", tags=" + tags + ", createDate=" + createDate
				+ ", firstAnswer=" + firstAnswer + ", timeInHourForFisrtAnswer=" + timeInHourForFisrtAnswer + "]";
	}
	
}
