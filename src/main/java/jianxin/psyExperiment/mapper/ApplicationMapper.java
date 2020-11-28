package jianxin.psyExperiment.mapper;

import jianxin.psyExperiment.entity.Application;
import jianxin.psyExperiment.entity.ExperimentUserLike;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

@Mapper
public interface ApplicationMapper {
    @SelectProvider(type=ApplicationSqlProvider.class,method = "selectByExample")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="experiment_id", property="experimentId", jdbcType=JdbcType.INTEGER),
            @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
            @Result(column="time_period", property="timePeriod", jdbcType=JdbcType.VARCHAR),
            @Result(column="tester_schedule", property="testerSchedule", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_schedule", property="userSchedule", jdbcType=JdbcType.VARCHAR),
            @Result(column="check_status", property="checkStatus", jdbcType=JdbcType.VARCHAR),
            @Result(column="sign_timestamp", property="signTimestamp", jdbcType=JdbcType.INTEGER),
            @Result(column="id", property="experiment.id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="tester_id", property="experiment.testerId", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="experiment.type", jdbcType=JdbcType.VARCHAR),
            @Result(column="name", property="experiment.name", jdbcType=JdbcType.VARCHAR),
            @Result(column="content", property="experiment.content", jdbcType=JdbcType.VARCHAR),
            @Result(column="duration", property="experiment.duration", jdbcType=JdbcType.REAL),
            @Result(column="reward", property="experiment.reward", jdbcType=JdbcType.SMALLINT),
            @Result(column="place", property="experiment.place", jdbcType=JdbcType.VARCHAR),
            @Result(column="requirement", property="experiment.requirement", jdbcType=JdbcType.VARCHAR),
            @Result(column="time", property="experiment.time", jdbcType=JdbcType.SMALLINT),
            @Result(column="send_timestamp", property="experiment.sendTimestamp", jdbcType=JdbcType.INTEGER),
            @Result(column="page_view", property="experiment.pageView", jdbcType=JdbcType.INTEGER),
            @Result(column="enrollment", property="experiment.enrollment", jdbcType=JdbcType.INTEGER),
            @Result(column="total_likes", property="experiment.totalLikes", jdbcType=JdbcType.INTEGER),
            @Result(column="score", property="experiment.score", jdbcType=JdbcType.REAL),
            @Result(column="tag", property="experiment.tag", jdbcType=JdbcType.CHAR),
            @Result(column="status", property="experiment.status", jdbcType=JdbcType.CHAR),
            @Result(column="date_start", property="experiment.dateStart", jdbcType=JdbcType.CHAR),
            @Result(column="date_end", property="experiment.dateEnd", jdbcType=JdbcType.CHAR),
            @Result(column="time_periods", property="experiment.timePeriods", jdbcType=JdbcType.VARCHAR)
    })
    List<Application> selectByExample(Map<String,String> param);

    @Delete({
        "delete from application",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into application (id, experiment_id, ",
        "user_id, time_period, ",
        "tester_schedule, user_schedule, ",
        "check_status, sign_timestamp)",
        "values (#{id,jdbcType=INTEGER}, #{experimentId,jdbcType=INTEGER}, ",
        "#{userId,jdbcType=INTEGER}, #{timePeriod,jdbcType=VARCHAR}, ",
        "#{testerSchedule,jdbcType=VARCHAR}, #{userSchedule,jdbcType=VARCHAR}, ",
        "#{checkStatus,jdbcType=VARCHAR}, #{signTimestamp,jdbcType=INTEGER})"
    })
    int insert(Application record);

    @InsertProvider(type=ApplicationSqlProvider.class, method="insertSelective")
    int insertSelective(Application record);

    @Select({
        "select",
        "id, experiment_id, user_id, time_period, tester_schedule, user_schedule, check_status, ",
        "sign_timestamp",
        "from application",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="experiment_id", property="experimentId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="time_period", property="timePeriod", jdbcType=JdbcType.VARCHAR),
        @Result(column="tester_schedule", property="testerSchedule", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_schedule", property="userSchedule", jdbcType=JdbcType.VARCHAR),
        @Result(column="check_status", property="checkStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign_timestamp", property="signTimestamp", jdbcType=JdbcType.INTEGER)
    })
    Application selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ApplicationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Application record);

    @Update({
        "update application",
        "set experiment_id = #{experimentId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "time_period = #{timePeriod,jdbcType=VARCHAR},",
          "tester_schedule = #{testerSchedule,jdbcType=VARCHAR},",
          "user_schedule = #{userSchedule,jdbcType=VARCHAR},",
          "check_status = #{checkStatus,jdbcType=VARCHAR},",
          "sign_timestamp = #{signTimestamp,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Application record);

    @Select({
            "select *",
            "from application"
    })
    List<Application> selectAll();

    @Select({
            "select",
            "id, experiment_id, user_id, time_period, tester_schedule, user_schedule, check_status, ",
            "sign_timestamp",
            "from application",
            "where experiment_id = #{experimentId,jdbcType=INTEGER}" ,
            " and user_id = #{userId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="experiment_id", property="experimentId", jdbcType=JdbcType.INTEGER),
            @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
            @Result(column="time_period", property="timePeriod", jdbcType=JdbcType.VARCHAR),
            @Result(column="tester_schedule", property="testerSchedule", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_schedule", property="userSchedule", jdbcType=JdbcType.VARCHAR),
            @Result(column="check_status", property="checkStatus", jdbcType=JdbcType.VARCHAR),
            @Result(column="sign_timestamp", property="signTimestamp", jdbcType=JdbcType.INTEGER)
    })
    List<Application> selectByRecord(Application record);


    @Select({
            "select *",
            "from application",
            "where experiment_id = #{experimentId,jdbcType=INTEGER}"
    })
    @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true)
    List<Application> selectByExperimentId(Integer experimentId);


}