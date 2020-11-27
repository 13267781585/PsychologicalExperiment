package jianxin.psyExperiment.mapper;

import jianxin.psyExperiment.entity.Duration;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
@Mapper
public interface DurationMapper {
    @Delete({
        "delete from duration",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into duration (id, tester_id, ",
        "user_id, increase, timestamp, ",
        "experiment_id)",
        "values (#{id,jdbcType=INTEGER}, #{testerId,jdbcType=INTEGER}, ",
        "#{userId,jdbcType=INTEGER}, #{increase,jdbcType=REAL}, #{timestamp,jdbcType=INTEGER}, ",
        "#{experimentId,jdbcType=INTEGER})"
    })
    int insert(Duration record);

    @InsertProvider(type=DurationSqlProvider.class, method="insertSelective")
    int insertSelective(Duration record);

    @Select({
        "select",
        "id, tester_id, user_id, increase, timestamp, experiment_id",
        "from duration",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tester_id", property="testerId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="increase", property="increase", jdbcType=JdbcType.REAL),
        @Result(column="timestamp", property="timestamp", jdbcType=JdbcType.INTEGER),
        @Result(column="experiment_id", property="experimentId", jdbcType=JdbcType.INTEGER)
    })
    Duration selectByPrimaryKey(Integer id);

    @UpdateProvider(type=DurationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Duration record);

    @Update({
        "update duration",
        "set tester_id = #{testerId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "increase = #{increase,jdbcType=REAL},",
          "timestamp = #{timestamp,jdbcType=INTEGER},",
          "experiment_id = #{experimentId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Duration record);
}