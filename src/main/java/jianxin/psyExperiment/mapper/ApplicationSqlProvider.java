package jianxin.psyExperiment.mapper;

import jianxin.psyExperiment.entity.Application;
import jianxin.psyExperiment.support.util.ComUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class ApplicationSqlProvider {
    public String selectByExample(Map<String,String> param)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("select a.*,e.* from application a left join experiment e on a.experiment_id=e.id where a.user_id=");
        sb.append(param.get("userId"));
        if(!ComUtils.isEmpty(param.get("checkStatus")))
            sb.append(" and a.check_status=").append("'").append(param.get("checkStatus")).append("' ");
        sb.append(" order by a.sign_timestamp");
        System.out.println(sb.toString());
        return sb.toString();
    }

    public String selectUserByExample(Map<String,String> param)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("select a.*,e.* from application a left join user e on a.user_id=e.id where a.experiment_id=");
        sb.append(param.get("experimentId"));
        if(!ComUtils.isEmpty(param.get("keyWord")))
            sb.append(" and e.username like '%").append(param.get("keyWord")).append("%' ");
        if(!ComUtils.isEmpty(param.get("checkStatus")))
            sb.append(" and a.check_status=").append("'").append(param.get("checkStatus")).append("' ");
        sb.append(" order by a.sign_timestamp");
        System.out.println(sb.toString());
        return sb.toString();
    }

    public String insertSelective(Application record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("application");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getExperimentId() != null) {
            sql.VALUES("experiment_id", "#{experimentId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getTimePeriod() != null) {
            sql.VALUES("time_period", "#{timePeriod,jdbcType=VARCHAR}");
        }
        
        if (record.getTesterSchedule() != null) {
            sql.VALUES("tester_schedule", "#{testerSchedule,jdbcType=VARCHAR}");
        }
        
        if (record.getUserSchedule() != null) {
            sql.VALUES("user_schedule", "#{userSchedule,jdbcType=VARCHAR}");
        }
        
        if (record.getCheckStatus() != null) {
            sql.VALUES("check_status", "#{checkStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getSignTimestamp() != null) {
            sql.VALUES("sign_timestamp", "#{signTimestamp,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Application record) {
        SQL sql = new SQL();
        sql.UPDATE("application");
        
        if (record.getExperimentId() != null) {
            sql.SET("experiment_id = #{experimentId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getTimePeriod() != null) {
            sql.SET("time_period = #{timePeriod,jdbcType=VARCHAR}");
        }
        
        if (record.getTesterSchedule() != null) {
            sql.SET("tester_schedule = #{testerSchedule,jdbcType=VARCHAR}");
        }
        
        if (record.getUserSchedule() != null) {
            sql.SET("user_schedule = #{userSchedule,jdbcType=VARCHAR}");
        }
        
        if (record.getCheckStatus() != null) {
            sql.SET("check_status = #{checkStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getSignTimestamp() != null) {
            sql.SET("sign_timestamp = #{signTimestamp,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}