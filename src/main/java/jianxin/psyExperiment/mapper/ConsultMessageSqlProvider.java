package jianxin.psyExperiment.mapper;

import jianxin.psyExperiment.entity.ConsultMessage;
import org.apache.ibatis.jdbc.SQL;

public class ConsultMessageSqlProvider {
    public String insertSelective(ConsultMessage record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("consult_message");
        
        if (record.getMessageId() != null) {
            sql.VALUES("message_id", "#{messageId,jdbcType=INTEGER}");
        }
        
        if (record.getFromId() != null) {
            sql.VALUES("from_id", "#{fromId,jdbcType=INTEGER}");
        }
        
        if (record.getToId() != null) {
            sql.VALUES("to_id", "#{toId,jdbcType=INTEGER}");
        }
        
        if (record.getSendTime() != null) {
            sql.VALUES("send_time", "#{sendTime,jdbcType=DATE}");
        }
        
        if (record.getMessageContent() != null) {
            sql.VALUES("message_content", "#{messageContent,jdbcType=VARCHAR}");
        }
        
        if (record.getReadStatus() != null) {
            sql.VALUES("read_status", "#{readStatus,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ConsultMessage record) {
        SQL sql = new SQL();
        sql.UPDATE("consult_message");
        
        if (record.getFromId() != null) {
            sql.SET("from_id = #{fromId,jdbcType=INTEGER}");
        }
        
        if (record.getToId() != null) {
            sql.SET("to_id = #{toId,jdbcType=INTEGER}");
        }
        
        if (record.getSendTime() != null) {
            sql.SET("send_time = #{sendTime,jdbcType=DATE}");
        }
        
        if (record.getMessageContent() != null) {
            sql.SET("message_content = #{messageContent,jdbcType=VARCHAR}");
        }
        
        if (record.getReadStatus() != null) {
            sql.SET("read_status = #{readStatus,jdbcType=INTEGER}");
        }
        
        sql.WHERE("message_id = #{messageId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}