package br.edu.ifpb.analyserTitle.stackExchangeAPI.entities.types;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Answer {

    @SerializedName("answer_id")
    private int id;

    private boolean accepted;
    private int awardedBountyAmount;
    private List<ShallowUser> awardedBountyUsers;
    private String body;
    private String bodyMarkdown;
    private boolean canFlag;
    private int commentCount;
    private List<Comment> comments;
    private Date communityOwnedDate;
    private Date creationDate;
    private Date lastActivityDate;
    private Date lastEditDate;
    private ShallowUser lastEditor;
    private String link;
    private Date lockedDate;
    private ShallowUser owner;
    private int questionId;
    private int score;
    private String shareLink;
    private List<String> tags;
    private String title;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	public int getAwardedBountyAmount() {
		return awardedBountyAmount;
	}
	public void setAwardedBountyAmount(int awardedBountyAmount) {
		this.awardedBountyAmount = awardedBountyAmount;
	}
	public List<ShallowUser> getAwardedBountyUsers() {
		return awardedBountyUsers;
	}
	public void setAwardedBountyUsers(List<ShallowUser> awardedBountyUsers) {
		this.awardedBountyUsers = awardedBountyUsers;
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
	public Date getCommunityOwnedDate() {
		return communityOwnedDate;
	}
	public void setCommunityOwnedDate(Date communityOwnedDate) {
		this.communityOwnedDate = communityOwnedDate;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastActivityDate() {
		return lastActivityDate;
	}
	public void setLastActivityDate(Date lastActivityDate) {
		this.lastActivityDate = lastActivityDate;
	}
	public Date getLastEditDate() {
		return lastEditDate;
	}
	public void setLastEditDate(Date lastEditDate) {
		this.lastEditDate = lastEditDate;
	}
	public ShallowUser getLastEditor() {
		return lastEditor;
	}
	public void setLastEditor(ShallowUser lastEditor) {
		this.lastEditor = lastEditor;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Date getLockedDate() {
		return lockedDate;
	}
	public void setLockedDate(Date lockedDate) {
		this.lockedDate = lockedDate;
	}
	public ShallowUser getOwner() {
		return owner;
	}
	public void setOwner(ShallowUser owner) {
		this.owner = owner;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getShareLink() {
		return shareLink;
	}
	public void setShareLink(String shareLink) {
		this.shareLink = shareLink;
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
    
    

}
