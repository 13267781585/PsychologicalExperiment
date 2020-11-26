package jianxin.psyExperiment.mapper;

import jianxin.psyExperiment.entity.Attendance;
import org.apache.ibatis.jdbc.SQL;

public class AttendanceSqlProvider {
    public String insertSelective(Attendance record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("attendance");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getTimestamp() != null) {
            sql.VALUES("timestamp", "#{timestamp,jdbcType=INTEGER}");
        }
        
        if (record.getDays() != null) {
            sql.VALUES("days", "#{days,jdbcType=TINYINT}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Attendance record) {
        SQL sql = new SQL();
        sql.UPDATE("attendance");
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getTimestamp() != null) {
            sql.SET("timestamp = #{timestamp,jdbcType=INTEGER}");
        }
        
        if (record.getDays() != null) {
            sql.SET("days = #{days,jdbcType=TINYINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}