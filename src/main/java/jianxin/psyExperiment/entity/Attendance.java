package jianxin.psyExperiment.entity;

public class Attendance {
    private Integer id;

    private Integer userId;

    private Integer timestamp;

    private Byte days;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public Byte getDays() {
        return days;
    }

    public void setDays(Byte days) {
        this.days = days;
    }
}