package jianxin.psyExperiment.service.Impl;
import jianxin.psyExperiment.entity.CancelTimePeriod;
import jianxin.psyExperiment.mapper.CancelTimePeriodMapper;
import jianxin.psyExperiment.service.CancelTimePeriodService;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancelTimePeriodServiceImpl implements CancelTimePeriodService{
    @Autowired
    private CancelTimePeriodMapper cancelTimePeriodMapper;

    @Override
    public ServerReturnObject cancelTime(CancelTimePeriod record) {
        if(record.getTesterId()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：testerId");
        }
        if(record.getExperimentId()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：experimentId");
        }
        if(record.getTimePeriod()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：timePeriod");
        }

        int result=cancelTimePeriodMapper.insert(record);
        if(result==1)
        return ServerReturnObject.createSuccessByMessageAndData("取消时间段成功",record);
        else
            return ServerReturnObject.createErrorByMessage("取消时间段失败");
    }
}
