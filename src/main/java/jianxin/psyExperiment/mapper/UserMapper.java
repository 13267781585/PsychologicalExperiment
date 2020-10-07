package jianxin.psyExperiment.mapper;

import jianxin.psyExperiment.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> selectAll();

    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user (id, username, ",
        "face_url, college, ",
        "major, grade, phone, ",
        "sex, duration, sno, ",
        "score)",
        "values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{faceUrl,jdbcType=VARCHAR}, #{college,jdbcType=VARCHAR}, ",
        "#{major,jdbcType=VARCHAR}, #{grade,jdbcType=SMALLINT}, #{phone,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=VARCHAR}, #{duration,jdbcType=REAL}, #{sno,jdbcType=INTEGER}, ",
        "#{score,jdbcType=REAL})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @Select({
        "select",
        "id, username, face_url, college, major, grade, phone, sex, duration, sno, score",
        "from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="face_url", property="faceUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="college", property="college", jdbcType=JdbcType.VARCHAR),
        @Result(column="major", property="major", jdbcType=JdbcType.VARCHAR),
        @Result(column="grade", property="grade", jdbcType=JdbcType.SMALLINT),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="duration", property="duration", jdbcType=JdbcType.REAL),
        @Result(column="sno", property="sno", jdbcType=JdbcType.INTEGER),
        @Result(column="score", property="score", jdbcType=JdbcType.REAL)
    })
    User selectByPrimaryKey(Integer id);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set username = #{username,jdbcType=VARCHAR},",
          "face_url = #{faceUrl,jdbcType=VARCHAR},",
          "college = #{college,jdbcType=VARCHAR},",
          "major = #{major,jdbcType=VARCHAR},",
          "grade = #{grade,jdbcType=SMALLINT},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "duration = #{duration,jdbcType=REAL},",
          "sno = #{sno,jdbcType=INTEGER},",
          "score = #{score,jdbcType=REAL}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}