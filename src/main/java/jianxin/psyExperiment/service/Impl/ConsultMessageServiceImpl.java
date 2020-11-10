package jianxin.psyExperiment.service.Impl;

import jianxin.psyExperiment.mapper.ConsultMessageMapper;
import jianxin.psyExperiment.service.ConsultMessageService;
import jianxin.psyExperiment.support.returnEntity.WebSocketReturnEntity;
import jianxin.psyExperiment.support.util.ComUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ConsultMessageServiceImpl implements ConsultMessageService {
    @Autowired
    private ConsultMessageMapper consultMessageMapper;

    @Override
    public WebSocketReturnEntity selectAllConsultMessageByUserId(Integer userId) throws Exception {
        Objects.requireNonNull(userId);
        return WebSocketReturnEntity.CreateBySelectAllConsultMessage(consultMessageMapper.selectAllConsultMessageByUserId(userId));
    }
}
