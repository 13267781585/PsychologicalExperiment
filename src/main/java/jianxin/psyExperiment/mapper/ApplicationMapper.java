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


    /*
         接口
         "keWord":""  关键字搜索
         "check_status":""  审核状态
         "pageNum":""   分页开始位置
         "pageSize":""     一页的记录数
       */
    @SelectProvider(type=ApplicationSqlProvider.class,method = "selectUserByExample")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="experiment_id", property="experimentId", jdbcType=JdbcType.INTEGER),
            @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
            @Result(column="time_period", property="timePeriod", jdbcType=JdbcType.VARCHAR),
            @Result(column="tester_schedule", property="testerSchedule", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_schedule", property="userSchedule", jdbcType=JdbcType.VARCHAR),
            @Result(column="check_status", property="checkStatus", jdbcType=JdbcType.VARCHAR),
            @Result(column="sign_timestamp", property="signTimestamp", jdbcType=JdbcType.INTEGER),
            @Result(column="id", property="user.id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="open_id", property="user.openId", jdbcType=JdbcType.VARCHAR),
            @Result(column="username", property="user.username", jdbcType=JdbcType.VARCHAR),
            @Result(column="identity", property="user.identity", jdbcType=JdbcType.VARCHAR),
            @Result(column="face_url", property="user.faceUrl", jdbcType=JdbcType.VARCHAR),
            @Result(column="college", property="user.college", jdbcType=JdbcType.VARCHAR),
            @Result(column="major", property="user.major", jdbcType=JdbcType.VARCHAR),
            @Result(column="grade", property="user.grade", jdbcType=JdbcType.SMALLINT),
            @Result(column="phone", property="user.phone", jdbcType=JdbcType.VARCHAR),
            @Result(column="sex", property="user.sex", jdbcType=JdbcType.VARCHAR),
            @Result(column="duration", property="user.duration", jdbcType=JdbcType.REAL),
            @Result(column="sno", property="user.sno", jdbcType=JdbcType.INTEGER),
            @Result(column="performance_score", property="user.performanceScore", jdbcType=JdbcType.REAL),
            @Result(column="credit_score", property="user.creditScore", jdbcType=JdbcType.REAL),
            @Result(column="coins", property="user.coins", jdbcType=JdbcType.INTEGER),
            @Result(column="wechat", property="user.wechat", jdbcType=JdbcType.VARCHAR)
    })
    List<Application> selectUserByExample(Map<String,String> param);

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