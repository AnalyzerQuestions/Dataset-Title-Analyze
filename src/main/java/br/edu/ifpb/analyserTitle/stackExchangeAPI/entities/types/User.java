package br.edu.ifpb.analyserTitle.stackExchangeAPI.entities.types;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class User extends ShallowUser {

    @SerializedName("account_id")
    protected int id;

    protected String aboutMe;
    protected int age;
    protected int answerCount;
    protected Date creationDate;
    protected int downVoteCount;
    protected boolean isEmployee;
    protected Date lastAccessDate;
    protected Date lastModifiedDate;
    protected String location;
    protected int questionCount;
    protected int reputationChangeDay;
    protected int reputationChangeMonth;
    protected int reputationChangeQuarter;
    protected int reputationChangeWeek;
    protected int reputationChangeYear;
    protected Date timedPenaltyDate;
    protected int upVoteCount;
    protected int viewCount;
    protected String websiteUrl;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAnswerCount() {
		return answerCount;
	}
	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public int getDownVoteCount() {
		return downVoteCount;
	}
	public void setDownVoteCount(int downVoteCount) {
		this.downVoteCount = downVoteCount;
	}
	public boolean isEmployee() {
		return isEmployee;
	}
	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}
	public Date getLastAccessDate() {
		return lastAccessDate;
	}
	public void setLastAccessDate(Date lastAccessDate) {
		this.lastAccessDate = lastAccessDate;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getQuestionCount() {
		return questionCount;
	}
	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}
	public int getReputationChangeDay() {
		return reputationChangeDay;
	}
	public void setReputationChangeDay(int reputationChangeDay) {
		this.reputationChangeDay = reputationChangeDay;
	}
	public int getReputationChangeMonth() {
		return reputationChangeMonth;
	}
	public void setReputationChangeMonth(int reputationChangeMonth) {
		this.reputationChangeMonth = reputationChangeMonth;
	}
	public int getReputationChangeQuarter() {
		return reputationChangeQuarter;
	}
	public void setReputationChangeQuarter(int reputationChangeQuarter) {
		this.reputationChangeQuarter = reputationChangeQuarter;
	}
	public int getReputationChangeWeek() {
		return reputationChangeWeek;
	}
	public void setReputationChangeWeek(int reputationChangeWeek) {
		this.reputationChangeWeek = reputationChangeWeek;
	}
	public int getReputationChangeYear() {
		return reputationChangeYear;
	}
	public void setReputationChangeYear(int reputationChangeYear) {
		this.reputationChangeYear = reputationChangeYear;
	}
	public Date getTimedPenaltyDate() {
		return timedPenaltyDate;
	}
	public void setTimedPenaltyDate(Date timedPenaltyDate) {
		this.timedPenaltyDate = timedPenaltyDate;
	}
	public int getUpVoteCount() {
		return upVoteCount;
	}
	public void setUpVoteCount(int upVoteCount) {
		this.upVoteCount = upVoteCount;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public String getWebsiteUrl() {
		return websiteUrl;
	}
	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", aboutMe=" + aboutMe + ", age=" + age
				+ ", answerCount=" + answerCount + ", creationDate="
				+ creationDate + ", downVoteCount=" + downVoteCount
				+ ", isEmployee=" + isEmployee + ", lastAccessDate="
				+ lastAccessDate + ", lastModifiedDate=" + lastModifiedDate
				+ ", location=" + location + ", questionCount=" + questionCount
				+ ", reputationChangeDay=" + reputationChangeDay
				+ ", reputationChangeMonth=" + reputationChangeMonth
				+ ", reputationChangeQuarter=" + reputationChangeQuarter
				+ ", reputationChangeWeek=" + reputationChangeWeek
				+ ", reputationChangeYear=" + reputationChangeYear
				+ ", timedPenaltyDate=" + timedPenaltyDate + ", upVoteCount="
				+ upVoteCount + ", viewCount=" + viewCount + ", websiteUrl="
				+ websiteUrl + "]";
	}
    
    

}
