package jianxin.psyExperiment.entity;

public class Application {
    private Integer id;

    private Integer experimentId;

    private Integer userId;

    private String timePeriod;

    private String testerSchedule;

    private String userSchedule;

    private String checkStatus;

    private Integer signTimestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(Integer experimentId) {
        this.experimentId = experimentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod == null ? null : timePeriod.trim();
    }

    public String getTesterSchedule() {
        return testerSchedule;
    }

    public void setTesterSchedule(String testerSchedule) {
        this.testerSchedule = testerSchedule == null ? null : testerSchedule.trim();
    }

    public String getUserSchedule() {
        return userSchedule;
    }

    public void setUserSchedule(String userSchedule) {
        this.userSchedule = userSchedule == null ? null : userSchedule.trim();
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus == null ? null : checkStatus.trim();
    }

    public Integer getSignTimestamp() {
        return signTimestamp;
    }

    public void setSignTimestamp(Integer signTimestamp) {
        this.signTimestamp = signTimestamp;
    }
}