package br.edu.ifpb.analyserTitle.stackExchangeAPI.entities.types;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Comment {

	private String body;
	private String bodyMarkdown;
	private boolean canFlag;
	private int commentId;
	private Date creationDate;
	private boolean edited;
	private String link;
	private ShallowUser owner;
	private int postId;
	private Type postType;
	private ShallowUser replyToUser;
	private int score;
	private boolean upvoted;

	public enum Type {
		@SerializedName("question")
		QUESTION, @SerializedName("answer")
		ANSWER,
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getBodyMarkdown() {
		return bodyMarkdown;
	}

	public void setBodyMarkdown(String bodyMarkdown) {
		this.bodyMarkdown = bodyMarkdown;
	}

	public boolean isCanFlag() {
		return canFlag;
	}

	public void setCanFlag(boolean canFlag) {
		this.canFlag = canFlag;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isEdited() {
		return edited;
	}

	public void setEdited(boolean edited) {
		this.edited = edited;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public ShallowUser getOwner() {
		return owner;
	}

	public void setOwner(ShallowUser owner) {
		this.owner = owner;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public Type getPostType() {
		return postType;
	}

	public void setPostType(Type postType) {
		this.postType = postType;
	}

	public ShallowUser getReplyToUser() {
		return replyToUser;
	}

	public void setReplyToUser(ShallowUser replyToUser) {
		this.replyToUser = replyToUser;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isUpvoted() {
		return upvoted;
	}

	public void setUpvoted(boolean upvoted) {
		this.upvoted = upvoted;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Comment [body=" + body + ", bodyMarkdown=" + bodyMarkdown + ", canFlag=" + canFlag + ", commentId="
				+ commentId + ", creationDate=" + creationDate + ", edited=" + edited + ", link=" + link + ", owner="
				+ owner + ", postId=" + postId + ", postType=" + postType + ", replyToUser=" + replyToUser + ", score="
				+ score + ", upvoted=" + upvoted + "]";
	}
	
	

}
