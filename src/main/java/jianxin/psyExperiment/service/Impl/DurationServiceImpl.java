package jianxin.psyExperiment.service.Impl;

import jianxin.psyExperiment.entity.Duration;
import jianxin.psyExperiment.mapper.DurationMapper;
import jianxin.psyExperiment.service.DurationService;
import jianxin.psyExperiment.support.objIsUtil.ObjIsNullUtil;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DurationServiceImpl implements DurationService {
    @Autowired
    private DurationMapper durationMapper;

    @Override
    public ServerReturnObject insertDuration(Duration duration) throws IllegalAccessException {
        String name = ObjIsNullUtil.firstNullName(duration);
        if(name!=null){
            return ServerReturnObject.createErrorByMessage("参数不足："+name);
        }
        int result = durationMapper.insert(duration);
        if(result == 1){
            return ServerReturnObject.createSuccessByMessage("数据添加成功");
        }else{
            return ServerReturnObject.createErrorByMessage("数据添加失败");
        }
    }
}
