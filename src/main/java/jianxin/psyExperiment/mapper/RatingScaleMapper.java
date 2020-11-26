package jianxin.psyExperiment.mapper;

import jianxin.psyExperiment.entity.RatingScale;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
@Mapper
public interface RatingScaleMapper {
    @Delete({
        "delete from rating_scale",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into rating_scale (id, experiment_id, ",
        "type, tester_id, ",
        "user_id, score, timestamp)",
        "values (#{id,jdbcType=INTEGER}, #{experimentId,jdbcType=INTEGER}, ",
        "#{type,jdbcType=VARCHAR}, #{testerId,jdbcType=INTEGER}, ",
        "#{userId,jdbcType=INTEGER}, #{score,jdbcType=INTEGER}, #{timestamp,jdbcType=INTEGER})"
    })
    int insert(RatingScale record);

    @InsertProvider(type=RatingScaleSqlProvider.class, method="insertSelective")
    int insertSelective(RatingScale record);

    @Select({
        "select",
        "id, experiment_id, type, tester_id, user_id, score, timestamp",
        "from rating_scale",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="experiment_id", property="experimentId", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="tester_id", property="testerId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="timestamp", property="timestamp", jdbcType=JdbcType.INTEGER)
    })
    RatingScale selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RatingScaleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RatingScale record);

    @Update({
        "update rating_scale",
        "set experiment_id = #{experimentId,jdbcType=INTEGER},",
          "type = #{type,jdbcType=VARCHAR},",
          "tester_id = #{testerId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "score = #{score,jdbcType=INTEGER},",
          "timestamp = #{timestamp,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RatingScale record);

    @Select({
            "select",
            "count(user_id)",
            "from rating_scale",
            "where user_id = #{userId,jdbcType=INTEGER} and type = 'user' "
    })
    int getNumByUserId(Integer userId);

    @Select({
            "select",
            "count(tester_id)",
            "from rating_scale",
            "where tester_id = #{testerId,jdbcType=INTEGER} and type = 'tester' "
    })
    int getNumByTesterId(Integer testerId);
}