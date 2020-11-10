package jianxin.psyExperiment.controller.Impl;

import jianxin.psyExperiment.mapper.ConsultMessageMapper;
import jianxin.psyExperiment.service.ConsultMessageService;
import jianxin.psyExperiment.support.returnEntity.WebSocketReturnEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsultMessageControllerImpl implements ConsultMessageController {
    @Autowired
    private ConsultMessageMapper consultMessageMapper;

    @RequestMapping("/consult")
    @Override
    public Object findAllConsultMessage(Integer userId) {
        return WebSocketReturnEntity.CreateBySelectAllConsultMessage(consultMessageMapper.selectAllConsultMessageByUserId(userId));
    }
}
