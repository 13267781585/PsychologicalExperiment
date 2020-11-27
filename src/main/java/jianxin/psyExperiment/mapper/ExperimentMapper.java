package jianxin.psyExperiment.mapper;

import jianxin.psyExperiment.entity.Experiment;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

@Mapper
public interface ExperimentMapper {
    @Delete({
        "delete from experiment",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into experiment (id, tester_id, ",
        "type, name, content, ",
        "duration, reward, ",
        "place, requirement, ",
        "time, send_timestamp, ",
        "page_view, enrollment, ",
        "total_likes, tag, ",
        "status, face_url, ",
        "username, time_periods)",
        "values (#{id,jdbcType=INTEGER}, #{testerId,jdbcType=INTEGER}, ",
        "#{type,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, #{content,jdbcType=VARCHAR}, ",
        "#{duration,jdbcType=REAL}, #{reward,jdbcType=SMALLINT}, ",
        "#{place,jdbcType=VARCHAR}, #{requirement,jdbcType=VARCHAR}, ",
        "#{time,jdbcType=REAL}, #{sendTimestamp,jdbcType=INTEGER}, ",
        "#{pageView,jdbcType=INTEGER}, #{enrollment,jdbcType=INTEGER}, ",
        "#{totalLikes,jdbcType=INTEGER}, #{tag,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=VARCHAR}, #{faceUrl,jdbcType=VARCHAR}, ",
        "#{username,jdbcType=VARCHAR}, #{timePeriods,jdbcType=VARCHAR})"
    })
    int insert(Experiment record);

        /*
         接口
         "keyWord":""  关键字搜索
         "type":""  实验类型
         "descType":""    降序字段 performance_score主试评分 duration时长 reward薪酬
         "pageNum":""   分页开始位置
         "pageSize":""     一页的记录数
       */
    @InsertProvider(type=ExperimentSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insertSelective(Experiment record);

    @Select({
        "select",
        "id, tester_id, type, name, content, duration, reward, place, requirement, time, ",
        "send_timestamp, page_view, enrollment, total_likes, tag, status, face_url, username, ",
        "time_periods",
        "from experiment",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tester_id", property="testerId", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="duration", property="duration", jdbcType=JdbcType.REAL),
        @Result(column="reward", property="reward", jdbcType=JdbcType.SMALLINT),
        @Result(column="place", property="place", jdbcType=JdbcType.VARCHAR),
        @Result(column="requirement", property="requirement", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.REAL),
        @Result(column="send_timestamp", property="sendTimestamp", jdbcType=JdbcType.INTEGER),
        @Result(column="page_view", property="pageView", jdbcType=JdbcType.INTEGER),
        @Result(column="enrollment", property="enrollment", jdbcType=JdbcType.INTEGER),
        @Result(column="total_likes", property="totalLikes", jdbcType=JdbcType.INTEGER),
        @Result(column="tag", property="tag", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="face_url", property="faceUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="time_periods", property="timePeriods", jdbcType=JdbcType.VARCHAR)
    })
    Experiment selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ExperimentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Experiment record);

    @Update({
        "update experiment",
        "set tester_id = #{testerId,jdbcType=INTEGER},",
          "type = #{type,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "duration = #{duration,jdbcType=REAL},",
          "reward = #{reward,jdbcType=SMALLINT},",
          "place = #{place,jdbcType=VARCHAR},",
          "requirement = #{requirement,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=REAL},",
          "send_timestamp = #{sendTimestamp,jdbcType=INTEGER},",
          "page_view = #{pageView,jdbcType=INTEGER},",
          "enrollment = #{enrollment,jdbcType=INTEGER},",
          "total_likes = #{totalLikes,jdbcType=INTEGER},",
          "tag = #{tag,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "face_url = #{faceUrl,jdbcType=VARCHAR},",
          "username = #{username,jdbcType=VARCHAR},",
          "time_periods = #{timePeriods,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Experiment record);

    @Select({
            "select *",
            "from experiment"
    })
    List<Experiment> selectAll();
    /*
         接口
         "keWord":""  关键字搜索
         "type":""  实验类型
         "descType":""    降序字段 performance_score主试评分 duration时长 reward薪酬
         "pageNum":""   分页开始位置
         "pageSize":""     一页的记录数
       */
    @SelectProvider(type=ExperimentSqlProvider.class, method="selectByExample")
    List<Experiment> selectByExample(Map<String,String> example);
    @Select({
            "select",
            "id, tester_id, type, name, content,  duration, reward, place, requirement, ",
            "time, send_timestamp, page_view, enrollment, total_likes, score, tag, status, ",
            "date_start, date_end, time_periods",
            "from experiment",
            "where tester_id = #{tester_id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="tester_id", property="testerId", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
            @Result(column="duration", property="duration", jdbcType=JdbcType.REAL),
            @Result(column="reward", property="reward", jdbcType=JdbcType.SMALLINT),
            @Result(column="place", property="place", jdbcType=JdbcType.VARCHAR),
            @Result(column="requirement", property="requirement", jdbcType=JdbcType.VARCHAR),
            @Result(column="time", property="time", jdbcType=JdbcType.SMALLINT),
            @Result(column="send_timestamp", property="sendTimestamp", jdbcType=JdbcType.INTEGER),
            @Result(column="page_view", property="pageView", jdbcType=JdbcType.INTEGER),
            @Result(column="enrollment", property="enrollment", jdbcType=JdbcType.INTEGER),
            @Result(column="total_likes", property="totalLikes", jdbcType=JdbcType.INTEGER),
            @Result(column="score", property="score", jdbcType=JdbcType.REAL),
            @Result(column="tag", property="tag", jdbcType=JdbcType.CHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.CHAR),
            @Result(column="date_start", property="dateStart", jdbcType=JdbcType.CHAR),
            @Result(column="date_end", property="dateEnd", jdbcType=JdbcType.CHAR),
            @Result(column="time_periods", property="timePeriods", jdbcType=JdbcType.VARCHAR)
    })
    List<Experiment> selectByTesterId(Integer testerId);

    @Select({
            "select *",
            "from experiment",
            "where experiment.id = ANY(select experiment_id from application where user_id =#{userId,jdbcType=INTEGER})"
    })
    List<Experiment> selectByUserId(Integer userId);

}