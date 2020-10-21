package jianxin.psyExperiment.mapper;

import jianxin.psyExperiment.entity.Experiment;
import org.apache.ibatis.jdbc.SQL;

public class ExperimentSqlProvider {
    public String insertSelective(Experiment record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("experiment");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTesterId() != null) {
            sql.VALUES("tester_id", "#{testerId,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getDuration() != null) {
            sql.VALUES("duration", "#{duration,jdbcType=REAL}");
        }
        
        if (record.getReward() != null) {
            sql.VALUES("reward", "#{reward,jdbcType=SMALLINT}");
        }
        
        if (record.getPlace() != null) {
            sql.VALUES("place", "#{place,jdbcType=VARCHAR}");
        }
        
        if (record.getRequirement() != null) {
            sql.VALUES("requirement", "#{requirement,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            sql.VALUES("time", "#{time,jdbcType=SMALLINT}");
        }
        
        if (record.getSendTimestamp() != null) {
            sql.VALUES("send_timestamp", "#{sendTimestamp,jdbcType=INTEGER}");
        }
        
        if (record.getPageView() != null) {
            sql.VALUES("page_view", "#{pageView,jdbcType=INTEGER}");
        }
        
        if (record.getEnrollment() != null) {
            sql.VALUES("enrollment", "#{enrollment,jdbcType=INTEGER}");
        }
        
        if (record.getTotalLikes() != null) {
            sql.VALUES("total_likes", "#{totalLikes,jdbcType=INTEGER}");
        }
        
        if (record.getScore() != null) {
            sql.VALUES("score", "#{score,jdbcType=REAL}");
        }
        
        if (record.getTag() != null) {
            sql.VALUES("tag", "#{tag,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getDateStart() != null) {
            sql.VALUES("date_start", "#{dateStart,jdbcType=CHAR}");
        }
        
        if (record.getDateEnd() != null) {
            sql.VALUES("date_end", "#{dateEnd,jdbcType=CHAR}");
        }
        
        if (record.getTimePeriods() != null) {
            sql.VALUES("time_periods", "#{timePeriods,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Experiment record) {
        SQL sql = new SQL();
        sql.UPDATE("experiment");
        
        if (record.getTesterId() != null) {
            sql.SET("tester_id = #{testerId,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getDuration() != null) {
            sql.SET("duration = #{duration,jdbcType=REAL}");
        }
        
        if (record.getReward() != null) {
            sql.SET("reward = #{reward,jdbcType=SMALLINT}");
        }
        
        if (record.getPlace() != null) {
            sql.SET("place = #{place,jdbcType=VARCHAR}");
        }
        
        if (record.getRequirement() != null) {
            sql.SET("requirement = #{requirement,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            sql.SET("time = #{time,jdbcType=SMALLINT}");
        }
        
        if (record.getSendTimestamp() != null) {
            sql.SET("send_timestamp = #{sendTimestamp,jdbcType=INTEGER}");
        }
        
        if (record.getPageView() != null) {
            sql.SET("page_view = #{pageView,jdbcType=INTEGER}");
        }
        
        if (record.getEnrollment() != null) {
            sql.SET("enrollment = #{enrollment,jdbcType=INTEGER}");
        }
        
        if (record.getTotalLikes() != null) {
            sql.SET("total_likes = #{totalLikes,jdbcType=INTEGER}");
        }
        
        if (record.getScore() != null) {
            sql.SET("score = #{score,jdbcType=REAL}");
        }
        
        if (record.getTag() != null) {
            sql.SET("tag = #{tag,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getDateStart() != null) {
            sql.SET("date_start = #{dateStart,jdbcType=CHAR}");
        }
        
        if (record.getDateEnd() != null) {
            sql.SET("date_end = #{dateEnd,jdbcType=CHAR}");
        }
        
        if (record.getTimePeriods() != null) {
            sql.SET("time_periods = #{timePeriods,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}