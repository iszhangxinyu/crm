package cn.xy.crm.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 */
@Getter
@Setter
@ToString
public class NetworkDiskQueryObject extends QueryObject {

    private String keyword;

    private Long pid;

    private Long currentId;
}
