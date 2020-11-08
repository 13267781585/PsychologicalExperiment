package jianxin.psyExperiment.mapper;

import jianxin.psyExperiment.entity.CancelTimePeriod;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface CancelTimePeriodMapper {
    @Delete({
        "delete from cancel_time_period",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into cancel_time_period (id, time_period, ",
        "tester_id, experiment_id)",
        "values (#{id,jdbcType=INTEGER}, #{timePeriod,jdbcType=VARCHAR}, ",
        "#{testerId,jdbcType=INTEGER}, #{experimentId,jdbcType=INTEGER})"
    })
    int insert(CancelTimePeriod record);

    @InsertProvider(type=CancelTimePeriodSqlProvider.class, method="insertSelective")
    int insertSelective(CancelTimePeriod record);

    @Select({
        "select",
        "id, time_period, tester_id, experiment_id",
        "from cancel_time_period",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="time_period", property="timePeriod", jdbcType=JdbcType.VARCHAR),
        @Result(column="tester_id", property="testerId", jdbcType=JdbcType.INTEGER),
        @Result(column="experiment_id", property="experimentId", jdbcType=JdbcType.INTEGER)
    })
    CancelTimePeriod selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CancelTimePeriodSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CancelTimePeriod record);

    @Update({
        "update cancel_time_period",
        "set time_period = #{timePeriod,jdbcType=VARCHAR},",
          "tester_id = #{testerId,jdbcType=INTEGER},",
          "experiment_id = #{experimentId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CancelTimePeriod record);
}