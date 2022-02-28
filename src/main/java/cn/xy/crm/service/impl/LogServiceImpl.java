package cn.xy.crm.service.impl;

import cn.xy.crm.domain.Log;
import cn.xy.crm.mapper.LogMapper;
import cn.xy.crm.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author z-xy
 * @version v1.0
 * @date created in 2021-12-22 15:52
 */
@Service
public class LogServiceImpl implements ILogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public int save(Log log) {
        return logMapper.insert(log);
    }
}
