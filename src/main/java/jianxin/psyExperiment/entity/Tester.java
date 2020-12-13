package jianxin.psyExperiment.entity;

public class Tester {
    private Integer id;

    private String openId;

    private String username;

    private String identity;

    private String faceUrl;

    private String college;

    private String major;

    private Short grade;

    private String phone;

    private String sex;

    private Float duration;

    private Integer sno;

    private Float performanceScore;

    private Float creditScore;

    private Integer coins;

    private String wechat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl == null ? null : faceUrl.trim();
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public Short getGrade() {
        return grade;
    }

    public void setGrade(Short grade) {
        this.grade = grade;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public Float getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(Float performanceScore) {
        this.performanceScore = performanceScore;
    }

    public Float getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Float creditScore) {
        this.creditScore = creditScore;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public String getWechat() {
        return wechat;
    }

    @Override
    public String toString() {
        return "Tester{" +
                "id=" + id +
                ", openId='" + openId + '\'' +
                ", username='" + username + '\'' +
                ", identity='" + identity + '\'' +
                ", faceUrl='" + faceUrl + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", grade=" + grade +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", duration=" + duration +
                ", sno=" + sno +
                ", performanceScore=" + performanceScore +
                ", creditScore=" + creditScore +
                ", coins=" + coins +
                ", wechat='" + wechat + '\'' +
                '}';
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }
}