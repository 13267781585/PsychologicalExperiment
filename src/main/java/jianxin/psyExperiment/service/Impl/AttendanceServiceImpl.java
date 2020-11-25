package jianxin.psyExperiment.service.Impl;


import jianxin.psyExperiment.entity.Attendance;
import jianxin.psyExperiment.mapper.AttendanceMapper;
import jianxin.psyExperiment.mapper.UserMapper;
import jianxin.psyExperiment.service.AttendanceService;
import jianxin.psyExperiment.service.UserService;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private UserService userService;

    @Autowired
    private AttendanceMapper attendanceMapper;

    @Override
    public ServerReturnObject checkIn(Integer userId, Integer timestamp) {
        if(userId == null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：userId");
        }
        if(timestamp==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：timestamp");
        }
        Integer id = attendanceMapper.findPrimaryKeyByUserId(userId);
        if(id!=null) {
            Attendance attendance = attendanceMapper.selectByPrimaryKey(id);
            int days = attendance.getDays()+1;
            if (days == 3) {
                attendance.setDays((byte) (days));
                attendance.setTimestamp(timestamp);
                attendanceMapper.updateByPrimaryKey(attendance);
                userService.coinsInc(userId, days);
                return ServerReturnObject.createSuccessByMessageAndData("签到成功", days );
            } else if (days == 7) {
                attendance.setDays((byte) 0);
                attendance.setTimestamp(timestamp);
                attendanceMapper.updateByPrimaryKey(attendance);
                userService.coinsInc(userId, days);
                return ServerReturnObject.createSuccessByMessageAndData("签到成功", 0);
            } else {
                attendance.setDays((byte) (days ));
                attendance.setTimestamp(timestamp);
                attendanceMapper.updateByPrimaryKey(attendance);
                userService.coinsInc(userId, 1);
                return ServerReturnObject.createSuccessByMessageAndData("签到成功", days );
            }
        }else
        {//第一次签到
            Attendance attendance = new Attendance();
            attendance.setUserId(userId);
            attendance.setDays((byte) 1);
            attendance.setTimestamp(timestamp);
            attendanceMapper.insert(attendance);
            userService.coinsInc(userId, 1);
            return ServerReturnObject.createSuccessByMessageAndData("签到成功",  1);
        }
    }

    @Override
    public ServerReturnObject getCheckInDay(Integer userId) {
        if(userId == null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：userId");
        }
        Integer day = attendanceMapper.selectByuserId(userId);
        if(day==null){
            return  ServerReturnObject.createByCodeAndMessageAndData(0,"该用户未曾签到",null);
        }
        return ServerReturnObject.createSuccessByMessageAndData("获取签到天数",day);
    }
}
