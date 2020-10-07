package jianxin.psyExperiment.mapper;

import jianxin.psyExperiment.entity.User;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {
    public String insertSelective(User record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUsername() != null) {
            sql.VALUES("username", "#{username,jdbcType=VARCHAR}");
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
        
        if (record.getScore() != null) {
            sql.VALUES("score", "#{score,jdbcType=REAL}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(User record) {
        SQL sql = new SQL();
        sql.UPDATE("user");
        
        if (record.getUsername() != null) {
            sql.SET("username = #{username,jdbcType=VARCHAR}");
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
        
        if (record.getScore() != null) {
            sql.SET("score = #{score,jdbcType=REAL}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}