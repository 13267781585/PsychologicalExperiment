package jianxin.psyExperiment.mapper;

import jianxin.psyExperiment.entity.Application;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ApplicationMapperExtend {
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="sign_timestamp", property="signTimestamp", jdbcType=JdbcType.INTEGER),
            @Result(column="experiment_id", property="experiment.id", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="experiment.type", jdbcType=JdbcType.VARCHAR),
            @Result(column="duration", property="experiment.duration", jdbcType=JdbcType.FLOAT),
            @Result(column="user_sno", property="user.sno", jdbcType=JdbcType.INTEGER),
            @Result(column="user_username", property="user.username", jdbcType=JdbcType.VARCHAR),
            @Result(column="tester_sno", property="tester.sno", jdbcType=JdbcType.INTEGER),
            @Result(column="tester_username", property="tester.username", jdbcType=JdbcType.VARCHAR),
    })
    @Select({"select al.*,t.sno tester_sno,t.username tester_username from (select a.id,a.sign_timestamp,e.tester_id,e.id experiment_id,e.type," +
            "e.duration,u.sno user_sno,u.username user_username from application a,experiment e,user u where a.experiment_id=e.id and a.user_id=u.id and a.user_schedule='已完成' and a.tester_schedule='已完成') al left join tester t on al.tester_id=t.id"})
    List<Application> selectApplicationByTesterAndUserScheduleFinish();
}
