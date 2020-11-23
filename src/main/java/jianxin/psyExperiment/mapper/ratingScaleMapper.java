package jianxin.psyExperiment.mapper;

import jianxin.psyExperiment.entity.ratingScale;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ratingScaleMapper {
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
    int insert(ratingScale record);

    @InsertProvider(type=ratingScaleSqlProvider.class, method="insertSelective")
    int insertSelective(ratingScale record);

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
    ratingScale selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ratingScaleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ratingScale record);

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
    int updateByPrimaryKey(ratingScale record);
}