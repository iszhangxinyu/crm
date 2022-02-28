package cn.xy.crm.service;

import cn.xy.crm.domain.NetworkDisk;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.NetworkDiskQueryObject;

/**
 *
 */
public interface INetworkDiskService {


    void save(NetworkDisk NetworkDisk);

    void delete(Long id);

    void update(NetworkDisk NetworkDisk);

    NetworkDisk get(Long id);

    PageResult query(NetworkDiskQueryObject qo);






}
