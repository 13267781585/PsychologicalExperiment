package jianxin.psyExperiment.controller.Impl;

import jianxin.psyExperiment.controller.AttendanceController;
import jianxin.psyExperiment.service.AttendanceService;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendanceControllerImpl implements AttendanceController {

    @Autowired
    public AttendanceService attendanceService;
    @RequestMapping("/checkIn")
    public ServerReturnObject checkIn(Integer userId, Integer timestamp) {
        return attendanceService.checkIn(userId,timestamp);
    }

    @RequestMapping("/getCheckInDay")
    public ServerReturnObject getCheckInDay(Integer userId) {
        return attendanceService.getCheckInDay(userId);
    }
}
