package jianxin.psyExperiment.mapper;

import jianxin.psyExperiment.entity.ExperimentUserLike;
import org.apache.ibatis.jdbc.SQL;

public class ExperimentUserLikeSqlProvider {
    public String insertSelective(ExperimentUserLike record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("experiment_user_like");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getExperimentId() != null) {
            sql.VALUES("experiment_id", "#{experimentId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ExperimentUserLike record) {
        SQL sql = new SQL();
        sql.UPDATE("experiment_user_like");
        
        if (record.getExperimentId() != null) {
            sql.SET("experiment_id = #{experimentId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}