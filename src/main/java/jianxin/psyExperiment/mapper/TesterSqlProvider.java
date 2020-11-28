package jianxin.psyExperiment.mapper;

import jianxin.psyExperiment.entity.Tester;
import org.apache.ibatis.jdbc.SQL;

public class TesterSqlProvider {
    public String insertSelective(Tester record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("tester");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getOpenId() != null) {
            sql.VALUES("open_id", "#{openId,jdbcType=VARCHAR}");
        }
        
        if (record.getUsername() != null) {
            sql.VALUES("username", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getIdentity() != null) {
            sql.VALUES("identity", "#{identity,jdbcType=VARCHAR}");
        }
        
        if (record.getFaceUrl() != null) {
            sql.VALUES("face_url", "#{faceUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getCollege() != null) {
            sql.VALUES("college", "#{college,jdbcType=VARCHAR}");
        }
        
        if (record.getMajor() != null) {
            sql.VALUES("major", "#{major,jdbcType=VARCHAR}");
        }
        
        if (record.getGrade() != null) {
            sql.VALUES("grade", "#{grade,jdbcType=SMALLINT}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.VALUES("sex", "#{sex,jdbcType=VARCHAR}");
        }
        
        if (record.getDuration() != null) {
            sql.VALUES("duration", "#{duration,jdbcType=REAL}");
        }
        
        if (record.getSno() != null) {
            sql.VALUES("sno", "#{sno,jdbcType=INTEGER}");
        }
        
        if (record.getPerformanceScore() != null) {
            sql.VALUES("performance_score", "#{performanceScore,jdbcType=REAL}");
        }
        
        if (record.getCreditScore() != null) {
            sql.VALUES("credit_score", "#{creditScore,jdbcType=REAL}");
        }
        
        if (record.getCoins() != null) {
            sql.VALUES("coins", "#{coins,jdbcType=INTEGER}");
        }
        
        if (record.getWechat() != null) {
            sql.VALUES("wechat", "#{wechat,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Tester record) {
        SQL sql = new SQL();
        sql.UPDATE("tester");
        
        if (record.getOpenId() != null) {
            sql.SET("open_id = #{openId,jdbcType=VARCHAR}");
        }
        
        if (record.getUsername() != null) {
            sql.SET("username = #{username,jdbcType=VARCHAR}");
        }
        
        if (record.getIdentity() != null) {
            sql.SET("identity = #{identity,jdbcType=VARCHAR}");
        }
        
        if (record.getFaceUrl() != null) {
            sql.SET("face_url = #{faceUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getCollege() != null) {
            sql.SET("college = #{college,jdbcType=VARCHAR}");
        }
        
        if (record.getMajor() != null) {
            sql.SET("major = #{major,jdbcType=VARCHAR}");
        }
        
        if (record.getGrade() != null) {
            sql.SET("grade = #{grade,jdbcType=SMALLINT}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.SET("sex = #{sex,jdbcType=VARCHAR}");
        }
        
        if (record.getDuration() != null) {
            sql.SET("duration = #{duration,jdbcType=REAL}");
        }
        
        if (record.getSno() != null) {
            sql.SET("sno = #{sno,jdbcType=INTEGER}");
        }
        
        if (record.getPerformanceScore() != null) {
            sql.SET("performance_score = #{performanceScore,jdbcType=REAL}");
        }
        
        if (record.getCreditScore() != null) {
            sql.SET("credit_score = #{creditScore,jdbcType=REAL}");
        }
        
        if (record.getCoins() != null) {
            sql.SET("coins = #{coins,jdbcType=INTEGER}");
        }
        
        if (record.getWechat() != null) {
            sql.SET("wechat = #{wechat,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}