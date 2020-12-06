package jianxin.psyExperiment.mapper;

import jianxin.psyExperiment.entity.Experiment;
import jianxin.psyExperiment.support.util.ComUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class ExperimentSqlProvider {
    public String insertSelective(Experiment record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("experiment");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTesterId() != null) {
            sql.VALUES("tester_id", "#{testerId,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getDuration() != null) {
            sql.VALUES("duration", "#{duration,jdbcType=REAL}");
        }
        
        if (record.getReward() != null) {
            sql.VALUES("reward", "#{reward,jdbcType=SMALLINT}");
        }
        
        if (record.getPlace() != null) {
            sql.VALUES("place", "#{place,jdbcType=VARCHAR}");
        }
        
        if (record.getRequirement() != null) {
            sql.VALUES("requirement", "#{requirement,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            sql.VALUES("time", "#{time,jdbcType=REAL}");
        }
        
        if (record.getSendTimestamp() != null) {
            sql.VALUES("send_timestamp", "#{sendTimestamp,jdbcType=INTEGER}");
        }
        
        if (record.getPageView() != null) {
            sql.VALUES("page_view", "#{pageView,jdbcType=INTEGER}");
        }
        
        if (record.getEnrollment() != null) {
            sql.VALUES("enrollment", "#{enrollment,jdbcType=INTEGER}");
        }
        
        if (record.getTotalLikes() != null) {
            sql.VALUES("total_likes", "#{totalLikes,jdbcType=INTEGER}");
        }
        
        if (record.getTag() != null) {
            sql.VALUES("tag", "#{tag,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getFaceUrl() != null) {
            sql.VALUES("face_url", "#{faceUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getUsername() != null) {
            sql.VALUES("username", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getTimePeriods() != null) {
            sql.VALUES("time_periods", "#{timePeriods,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Experiment record) {
        SQL sql = new SQL();
        sql.UPDATE("experiment");
        
        if (record.getTesterId() != null) {
            sql.SET("tester_id = #{testerId,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getDuration() != null) {
            sql.SET("duration = #{duration,jdbcType=REAL}");
        }
        
        if (record.getReward() != null) {
            sql.SET("reward = #{reward,jdbcType=SMALLINT}");
        }
        
        if (record.getPlace() != null) {
            sql.SET("place = #{place,jdbcType=VARCHAR}");
        }
        
        if (record.getRequirement() != null) {
            sql.SET("requirement = #{requirement,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            sql.SET("time = #{time,jdbcType=REAL}");
        }
        
        if (record.getSendTimestamp() != null) {
            sql.SET("send_timestamp = #{sendTimestamp,jdbcType=INTEGER}");
        }
        
        if (record.getPageView() != null) {
            sql.SET("page_view = #{pageView,jdbcType=INTEGER}");
        }
        
        if (record.getEnrollment() != null) {
            sql.SET("enrollment = #{enrollment,jdbcType=INTEGER}");
        }
        
        if (record.getTotalLikes() != null) {
            sql.SET("total_likes = #{totalLikes,jdbcType=INTEGER}");
        }
        
        if (record.getTag() != null) {
            sql.SET("tag = #{tag,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getFaceUrl() != null) {
            sql.SET("face_url = #{faceUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getUsername() != null) {
            sql.SET("username = #{username,jdbcType=VARCHAR}");
        }
        
        if (record.getTimePeriods() != null) {
            sql.SET("time_periods = #{timePeriods,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
    /*
    接口
    "keWord":""  关键字搜索
    "type":""  实验类型
    "descType":""    降序字段 performance_score主试评分 duration时长 reward薪酬
    "pageNum":""   分页开始位置
    "pageSize":""     一页的记录数
  */
    public String selectByExample(Map<String,String> example)
    {
        StringBuilder sb = new StringBuilder();
        if("performance_score".equals(example.get("descType")))
            sb.append("select e.id, e.tester_id, e.type, e.name, e.content, e.duration, e.reward, e.place, e.requirement, e.time, e.send_timestamp, e.page_view, e.enrollment, e.total_likes,  e.tag, e.status, e.face_url ,e.username,  " +
                    "  e.time_periods from experiment e  left join user u on e.tester_id = u.id  where 1=1 and e.status='招募中' ");
        else
            sb.append("select e.id, e.tester_id, e.type, e.name, e.content, e.duration, e.reward, e.place, e.requirement, e.time, e.send_timestamp, e.page_view, e.enrollment, e.total_likes,  e.tag, e.status, e.face_url ,e.username,  " +
                    " e.time_periods from experiment e where 1=1  and e.status='招募中' ");

        if(!ComUtils.isEmpty(example.get("type")))
            sb.append(" and e.type = '").append(example.get("type")).append("' ");
        if(!ComUtils.isEmpty(example.get("keyWord")))
            sb.append(" and e.name like '%").append(example.get("keyWord")).append("%' ");
        if("duration".equals(example.get("descType")))
            sb.append(" order by e.duration desc ");
        else
        if("reward".equals(example.get("descType")))
            sb.append(" order by e.reward desc ");
        else
        if("performance_score".equals(example.get("descType")))
            sb.append(" order by u.performance_score desc ");
        System.out.print(sb.toString());
        return sb.toString();
    }

    /*
  接口  主试首页获取实验
  testId：主试id
  status:实验状态（ 招募中 已结束 待发布

*/
    public String selectByTesterId(Map<String,String> example)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("select id, tester_id, type, name, content, duration, reward, place, requirement, time, send_timestamp, page_view, enrollment, total_likes,  tag, status, face_url ,username,  " +
                "  time_periods from experiment   where 1=1 ");

        if(!ComUtils.isEmpty(example.get("testerId")))
            sb.append(" and tester_id = ").append(example.get("testerId"));

        if("招募中".equals(example.get("status")))
            sb.append(" and status='招募中' ");
        else
        if("已结束".equals(example.get("status")))
            sb.append(" and status='已结束' ");
        else
        if("待发布".equals(example.get("status")))
            sb.append(" and status='待发布' ");

        sb.append(" and status <> '已删除' ");
        System.out.print(sb.toString());
        return sb.toString();
    }

}