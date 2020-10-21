package jianxin.psyExperiment.mapper;

import jianxin.psyExperiment.entity.ExperimentUserLike;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface ExperimentUserLikeMapper {
    @Delete({
        "delete from experiment_user_like",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    //新增
    @Delete({
            "delete from experiment_user_like",
            "where experiment_id = #{experimentId,jdbcType=INTEGER}" ,
            " and user_id = #{userId,jdbcType=INTEGER}"
    })
    int deleteByRecord(ExperimentUserLike record);

    @Insert({
        "insert into experiment_user_like (id, experiment_id, ",
        "user_id)",
        "values (#{id,jdbcType=INTEGER}, #{experimentId,jdbcType=INTEGER}, ",
        "#{userId,jdbcType=INTEGER})"
    })
    int insert(ExperimentUserLike record);

    @InsertProvider(type=ExperimentUserLikeSqlProvider.class, method="insertSelective")
    int insertSelective(ExperimentUserLike record);

    @Select({
        "select",
        "id, experiment_id, user_id",
        "from experiment_user_like",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="experiment_id", property="experimentId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER)
    })
    ExperimentUserLike selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ExperimentUserLikeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ExperimentUserLike record);

    @Update({
        "update experiment_user_like",
        "set experiment_id = #{experimentId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ExperimentUserLike record);
}