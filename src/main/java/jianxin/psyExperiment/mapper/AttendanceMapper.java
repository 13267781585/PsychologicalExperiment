package jianxin.psyExperiment.mapper;

import jianxin.psyExperiment.entity.Attendance;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
@Mapper
public interface AttendanceMapper {
    @Delete({
        "delete from attendance",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into attendance (id, user_id, ",
        "timestamp, days)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{timestamp,jdbcType=INTEGER}, #{days,jdbcType=TINYINT})"
    })
    int insert(Attendance record);

    @InsertProvider(type=AttendanceSqlProvider.class, method="insertSelective")
    int insertSelective(Attendance record);

    @Select({
        "select",
        "id, user_id, timestamp, days",
        "from attendance",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="timestamp", property="timestamp", jdbcType=JdbcType.INTEGER),
        @Result(column="days", property="days", jdbcType=JdbcType.TINYINT)
    })
    Attendance selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AttendanceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Attendance record);

    @Update({
        "update attendance",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "timestamp = #{timestamp,jdbcType=INTEGER},",
          "days = #{days,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Attendance record);

    @Select({
            "select",
            "id",
            "from attendance",
            "where user_id = #{userId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true)
    })
    Integer findPrimaryKeyByUserId(Integer userId);

    @Select({
            "select",
            "days",
            "from attendance",
            "where user_id = #{userId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="days", property="days", jdbcType=JdbcType.INTEGER, id=true)
    })
    Integer selectByuserId(Integer userId);
}