package cn.xy.crm.service.impl;

import cn.xy.crm.domain.NetworkDisk;
import cn.xy.crm.mapper.NetworkDiskMapper;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.NetworkDiskQueryObject;
import cn.xy.crm.service.INetworkDiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class NetworkDiskServiceImpl implements INetworkDiskService {

    @Autowired
    private NetworkDiskMapper dao;

    @Override
    public void save(NetworkDisk NetworkDisk) {
        dao.insert(NetworkDisk);
    }

    @Override
    public void delete(Long id) {

        dao.deleteByPrimaryKey(id);

    }

    @Override
    public void update(NetworkDisk NetworkDisk) {

        dao.updateByPrimaryKey(NetworkDisk);
    }

    @Override
    public NetworkDisk get(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public PageResult query(NetworkDiskQueryObject qo) {

        Long count = dao.queryByConditionCount(qo);
        if (count == 0) {
            return PageResult.EMPTY;
        }
        List<NetworkDisk> NetworkDisks = dao.queryByCondition(qo);
        return new PageResult(count, NetworkDisks);
    }


}
