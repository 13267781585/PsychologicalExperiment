package jianxin.psyExperiment.entity;

public class Experiment {
    private Integer id;

    private Integer testerId;

    private String type;

    private String name;

    private String content;

    private Float duration;

    private Short reward;

    private String place;

    private String requirement;

    private Short time;

    private Integer sendTimestamp;

    private Integer pageView;

    private Integer enrollment;

    private Integer totalLikes;

    private Float score;

    private String tag;

    private String status;

    private String dateStart;

    private String dateEnd;

    private String timePeriods;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTesterId() {
        return testerId;
    }

    public void setTesterId(Integer testerId) {
        this.testerId = testerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public Short getReward() {
        return reward;
    }

    public void setReward(Short reward) {
        this.reward = reward;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement == null ? null : requirement.trim();
    }

    public Short getTime() {
        return time;
    }

    public void setTime(Short time) {
        this.time = time;
    }

    public Integer getSendTimestamp() {
        return sendTimestamp;
    }

    public void setSendTimestamp(Integer sendTimestamp) {
        this.sendTimestamp = sendTimestamp;
    }

    public Integer getPageView() {
        return pageView;
    }

    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

    public Integer getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Integer enrollment) {
        this.enrollment = enrollment;
    }

    public Integer getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(Integer totalLikes) {
        this.totalLikes = totalLikes;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart == null ? null : dateStart.trim();
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd == null ? null : dateEnd.trim();
    }

    public String getTimePeriods() {
        return timePeriods;
    }

    public void setTimePeriods(String timePeriods) {
        this.timePeriods = timePeriods == null ? null : timePeriods.trim();
    }
}