package jianxin.psyExperiment.mapper;

import jianxin.psyExperiment.entity.RatingScale;
import org.apache.ibatis.jdbc.SQL;

public class RatingScaleSqlProvider {
    public String insertSelective(RatingScale record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("rating_scale");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getExperimentId() != null) {
            sql.VALUES("experiment_id", "#{experimentId,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getTesterId() != null) {
            sql.VALUES("tester_id", "#{testerId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getScore() != null) {
            sql.VALUES("score", "#{score,jdbcType=INTEGER}");
        }
        
        if (record.getTimestamp() != null) {
            sql.VALUES("timestamp", "#{timestamp,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RatingScale record) {
        SQL sql = new SQL();
        sql.UPDATE("rating_scale");
        
        if (record.getExperimentId() != null) {
            sql.SET("experiment_id = #{experimentId,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getTesterId() != null) {
            sql.SET("tester_id = #{testerId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getScore() != null) {
            sql.SET("score = #{score,jdbcType=INTEGER}");
        }
        
        if (record.getTimestamp() != null) {
            sql.SET("timestamp = #{timestamp,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}