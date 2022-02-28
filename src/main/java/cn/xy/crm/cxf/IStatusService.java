package cn.xy.crm.cxf;

import cn.xy.crm.domain.GuaranteeItem;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import java.util.List;

//保修单明细服务接口
@WebService//标明该接口是一个webService服务接口
@SOAPBinding(style=Style.RPC)//表示遵循远程过程调用协议
public interface IStatusService {
    //根据保修明细的状态,查询出该明细状态对应的明细集合
	List<GuaranteeItem> queryStatusByItem(int status);
}
