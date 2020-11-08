package jianxin.psyExperiment.mapper;

import jianxin.psyExperiment.entity.CancelTimePeriod;
import org.apache.ibatis.jdbc.SQL;

public class CancelTimePeriodSqlProvider {
    public String insertSelective(CancelTimePeriod record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("cancel_time_period");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTimePeriod() != null) {
            sql.VALUES("time_period", "#{timePeriod,jdbcType=VARCHAR}");
        }
        
        if (record.getTesterId() != null) {
            sql.VALUES("tester_id", "#{testerId,jdbcType=INTEGER}");
        }
        
        if (record.getExperimentId() != null) {
            sql.VALUES("experiment_id", "#{experimentId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CancelTimePeriod record) {
        SQL sql = new SQL();
        sql.UPDATE("cancel_time_period");
        
        if (record.getTimePeriod() != null) {
            sql.SET("time_period = #{timePeriod,jdbcType=VARCHAR}");
        }
        
        if (record.getTesterId() != null) {
            sql.SET("tester_id = #{testerId,jdbcType=INTEGER}");
        }
        
        if (record.getExperimentId() != null) {
            sql.SET("experiment_id = #{experimentId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}