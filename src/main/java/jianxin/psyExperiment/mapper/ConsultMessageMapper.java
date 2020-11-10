package jianxin.psyExperiment.mapper;

import jianxin.psyExperiment.entity.ConsultMessage;
import jianxin.psyExperiment.support.returnEntity.ConsultMessageCollection;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
@Mapper
public interface ConsultMessageMapper {
    @Delete({
        "delete from consult_message",
        "where message_id = #{messageId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer messageId);

    @Insert({
        "insert into consult_message (message_id, from_id, ",
        "to_id, send_time, message_content, ",
        "read_status)",
        "values (#{messageId,jdbcType=INTEGER}, #{fromId,jdbcType=INTEGER}, ",
        "#{toId,jdbcType=INTEGER}, #{sendTime,jdbcType=DATE}, #{messageContent,jdbcType=VARCHAR}, ",
        "#{readStatus,jdbcType=INTEGER})"
    })
    int insert(ConsultMessage record);

    @InsertProvider(type=ConsultMessageSqlProvider.class, method="insertSelective")
    int insertSelective(ConsultMessage record);

    @Select({
        "select",
        "message_id, from_id, to_id, send_time, message_content, read_status",
        "from consult_message",
        "where message_id = #{messageId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="message_id", property="messageId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="from_id", property="fromId", jdbcType=JdbcType.INTEGER),
        @Result(column="to_id", property="toId", jdbcType=JdbcType.INTEGER),
        @Result(column="send_time", property="sendTime", jdbcType=JdbcType.DATE),
        @Result(column="message_content", property="messageContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="read_status", property="readStatus", jdbcType=JdbcType.INTEGER)
    })
    ConsultMessage selectByPrimaryKey(Integer messageId);

    //自定义
    //根据用户id查询和其他人的聊天记录
    @Select({
            "SELECT al.* FROM ",
                    "(SELECT cm.*,u.* FROM consult_message cm INNER JOIN user u ON u.id=cm.from_id WHERE cm.to_id=1 UNION ALL",
                    "SELECT cm.*,u.* FROM consult_message cm INNER JOIN user u ON u.id=cm.to_id WHERE cm.from_id=1) al",
            "ORDER BY al.send_time ASC"
    })
    @Results({
            @Result(column="message_id", property="messageId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="from_id", property="fromId", jdbcType=JdbcType.INTEGER),
            @Result(column="to_id", property="toId", jdbcType=JdbcType.INTEGER),
            @Result(column="send_time", property="sendTime", jdbcType=JdbcType.DATE),
            @Result(column="message_content", property="messageContent", jdbcType=JdbcType.VARCHAR),
            @Result(column="read_status", property="readStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
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
            @Result(column="coins", property="coins", jdbcType=JdbcType.INTEGER)
    })
    List<ConsultMessageCollection> selectAllConsultMessageByUserId(Integer userId);

    @UpdateProvider(type=ConsultMessageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ConsultMessage record);

    @Update({
        "update consult_message",
        "set from_id = #{fromId,jdbcType=INTEGER},",
          "to_id = #{toId,jdbcType=INTEGER},",
          "send_time = #{sendTime,jdbcType=DATE},",
          "message_content = #{messageContent,jdbcType=VARCHAR},",
          "read_status = #{readStatus,jdbcType=INTEGER}",
        "where message_id = #{messageId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ConsultMessage record);
}