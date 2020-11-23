package jianxin.psyExperiment.mapper;

import jianxin.psyExperiment.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface UserMapper {
    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user (id, open_id, ",
        "username, identity, ",
        "face_url, college, ",
        "major, grade, phone, ",
        "sex, duration, sno, ",
        "performance_score, credit_score, ",
        "coins, wechat)",
        "values (#{id,jdbcType=INTEGER}, #{openId,jdbcType=VARCHAR}, ",
        "#{username,jdbcType=VARCHAR}, #{identity,jdbcType=VARCHAR}, ",
        "#{faceUrl,jdbcType=VARCHAR}, #{college,jdbcType=VARCHAR}, ",
        "#{major,jdbcType=VARCHAR}, #{grade,jdbcType=SMALLINT}, #{phone,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=VARCHAR}, #{duration,jdbcType=REAL}, #{sno,jdbcType=INTEGER}, ",
        "#{performanceScore,jdbcType=REAL}, #{creditScore,jdbcType=REAL}, ",
        "#{coins,jdbcType=INTEGER}, #{wechat,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @Select({
        "select",
        "id, open_id, username, identity, face_url, college, major, grade, phone, sex, ",
        "duration, sno, performance_score, credit_score, coins, wechat",
        "from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="open_id", property="openId", jdbcType=JdbcType.VARCHAR),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="identity", property="identity", jdbcType=JdbcType.VARCHAR),
        @Result(column="face_url", property="faceUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="college", property="college", jdbcType=JdbcType.VARCHAR),
        @Result(column="major", property="major", jdbcType=JdbcType.VARCHAR),
        @Result(column="grade", property="grade", jdbcType=JdbcType.SMALLINT),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="duration", property="duration", jdbcType=JdbcType.REAL),
        @Result(column="sno", property="sno", jdbcType=JdbcType.INTEGER),
        @Result(column="performance_score", property="performanceScore", jdbcType=JdbcType.REAL),
        @Result(column="credit_score", property="creditScore", jdbcType=JdbcType.REAL),
        @Result(column="coins", property="coins", jdbcType=JdbcType.INTEGER),
        @Result(column="wechat", property="wechat", jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(Integer id);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set open_id = #{openId,jdbcType=VARCHAR},",
          "username = #{username,jdbcType=VARCHAR},",
          "identity = #{identity,jdbcType=VARCHAR},",
          "face_url = #{faceUrl,jdbcType=VARCHAR},",
          "college = #{college,jdbcType=VARCHAR},",
          "major = #{major,jdbcType=VARCHAR},",
          "grade = #{grade,jdbcType=SMALLINT},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "duration = #{duration,jdbcType=REAL},",
          "sno = #{sno,jdbcType=INTEGER},",
          "performance_score = #{performanceScore,jdbcType=REAL},",
          "credit_score = #{creditScore,jdbcType=REAL},",
          "coins = #{coins,jdbcType=INTEGER},",
          "wechat = #{wechat,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);

    @Select({
            "select *",
            "from user"
    })
    List<User> selectAll();

    @Update({
            "update user",
            "set open_id = #{openId,jdbcType=VARCHAR},",
            "username = #{username,jdbcType=VARCHAR},",
            "identity = #{identity,jdbcType=VARCHAR},",
            "face_url = #{faceUrl,jdbcType=VARCHAR},",
            "college = #{college,jdbcType=VARCHAR},",
            "major = #{major,jdbcType=VARCHAR},",
            "grade = #{grade,jdbcType=SMALLINT},",
            "phone = #{phone,jdbcType=VARCHAR},",
            "sex = #{sex,jdbcType=VARCHAR},",
            "duration = #{duration,jdbcType=REAL},",
            "sno = #{sno,jdbcType=INTEGER},",
            "performance_score = #{performanceScore,jdbcType=REAL},",
            "credit_score = #{creditScore,jdbcType=REAL},",
            "coins = #{coins,jdbcType=INTEGER},",
            "wechat = #{wechat,jdbcType=VARCHAR}",
            "where open_id = #{openId,jdbcType=VARCHAR}"
    })
    int updateByOpenId(User record);

    @Select({
            "select *",
            " from user",
            " where user.id = ANY(select user_id from application where experiment_id =#{experimentId,jdbcType=INTEGER})"
    })
    List<User> selectByExperimentId(Integer experimentId);

    @Select({
            "select",
            "id, open_id, username, identity, face_url, college, major, grade, phone, sex, ",
            "duration, sno, performance_score, credit_score, coins, wechat",
            "from user",
            "where open_id = #{openId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="open_id", property="openId", jdbcType=JdbcType.VARCHAR),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="identity", property="identity", jdbcType=JdbcType.VARCHAR),
            @Result(column="face_url", property="faceUrl", jdbcType=JdbcType.VARCHAR),
            @Result(column="college", property="college", jdbcType=JdbcType.VARCHAR),
            @Result(column="major", property="major", jdbcType=JdbcType.VARCHAR),
            @Result(column="grade", property="grade", jdbcType=JdbcType.SMALLINT),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
            @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
            @Result(column="duration", property="duration", jdbcType=JdbcType.REAL),
            @Result(column="sno", property="sno", jdbcType=JdbcType.INTEGER),
            @Result(column="performance_score", property="performanceScore", jdbcType=JdbcType.REAL),
            @Result(column="credit_score", property="creditScore", jdbcType=JdbcType.REAL),
            @Result(column="coins", property="coins", jdbcType=JdbcType.INTEGER),
            @Result(column="wechat", property="wechat", jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectByOpenId(String openId);
}