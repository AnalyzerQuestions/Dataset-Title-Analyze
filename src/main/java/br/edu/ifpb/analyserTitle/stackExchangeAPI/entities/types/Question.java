package br.edu.ifpb.analyserTitle.stackExchangeAPI.entities.types;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Question {

	@SerializedName("question_id")
	private int questionId;
	private int acceptedAnswerId;
	private int answerCount;
	private List<Answer> answers;
	private String body; 
	private boolean canClosed;
	private Date closedDate;
	private int commentCount;
	private List<Comment> comments;
	private Date creationDate;
	private boolean isAnswered;
	private Date lastEditDate;
	private int score;
	private List<String> tags;
	private String title;
	private int viewCount;
	private String bodyMarkdown;
	private int downVoteCount;
	private boolean downVoted;
	private int upVoteCount;
	private int deleteVoteCount;
	private boolean upVoted;
	
	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getAcceptedAnswerId() {
		return acceptedAnswerId;
	}

	public void setAcceptedAnswerId(int acceptedAnswerId) {
		this.acceptedAnswerId = acceptedAnswerId;
	}

	public int getAnswerCount() {
		return answerCount;
	}

	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public boolean isCanClosed() {
		return canClosed;
	}

	public void setCanClosed(boolean canClosed) {
		this.canClosed = canClosed;
	}

	public Date getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isAnswered() {
		return isAnswered;
	}

	public void setAnswered(boolean isAnswered) {
		this.isAnswered = isAnswered;
	}

	public Date getLastEditDate() {
		return lastEditDate;
	}

	public void setLastEditDate(Date lastEditDate) {
		this.lastEditDate = lastEditDate;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public String getBodyMarkdown() {
		return bodyMarkdown;
	}

	public void setBodyMarkdown(String bodyMarkdown) {
		this.bodyMarkdown = bodyMarkdown;
	}

	public int getDownVoteCount() {
		return downVoteCount;
	}

	public void setDownVoteCount(int downVoteCount) {
		this.downVoteCount = downVoteCount;
	}

	public int getUpVoteCount() {
		return upVoteCount;
	}

	public void setUpVoteCount(int upVoteCount) {
		this.upVoteCount = upVoteCount;
	}

	public boolean isDownVoted() {
		return downVoted;
	}

	public void setDownVoted(boolean downVoted) {
		this.downVoted = downVoted;
	}

	public int getDeleteVoteCount() {
		return deleteVoteCount;
	}

	public void setDeleteVoteCount(int deleteVoteCount) {
		this.deleteVoteCount = deleteVoteCount;
	}

	public boolean isUpVoted() {
		return upVoted;
	}

	public void setUpVoted(boolean upVoted) {
		this.upVoted = upVoted;
	}
	

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", acceptedAnswerId="
				+ acceptedAnswerId + ", answerCount=" + answerCount
				+ ", answers=" + answers + ", canClosed=" + canClosed
				+ ", closedDate=" + closedDate + ", commentCount="
				+ commentCount + ", comments=" + comments + ", creationDate="
				+ creationDate + ", isAnswered=" + isAnswered
				+ ", lastEditDate=" + lastEditDate + ", score=" + score
				+ ", tags=" + tags + ", title=" + title + ", viewCount="
				+ viewCount + ", bodyMarkdown=" + bodyMarkdown
				+ ", downVoteCount=" + downVoteCount + ", upVoteCount="
				+ upVoteCount + "]";
	}

}
