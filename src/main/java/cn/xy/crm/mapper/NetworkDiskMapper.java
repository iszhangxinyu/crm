package cn.xy.crm.mapper;

import cn.xy.crm.domain.NetworkDisk;
import cn.xy.crm.query.NetworkDiskQueryObject;

import java.util.List;

public interface NetworkDiskMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NetworkDisk record);

    NetworkDisk selectByPrimaryKey(Long id);

    List<NetworkDisk> selectAll();

    int updateByPrimaryKey(NetworkDisk record);

    Long queryByConditionCount(NetworkDiskQueryObject qo);

    List<NetworkDisk> queryByCondition(NetworkDiskQueryObject qo);
}