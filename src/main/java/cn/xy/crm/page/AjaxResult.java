package cn.xy.crm.page;

import lombok.Getter;
import lombok.Setter;

/**
 * @author z-xy
 * @version v1.0
 * @date created in 2021-12-19 14:47
 */
@Setter
@Getter
public class AjaxResult {
    private boolean success;
    private String message;

    public AjaxResult() {
    }

    public AjaxResult(boolean success) {
        this.success = success;
    }

    public AjaxResult(String message) {
        this.message = message;
    }

    public AjaxResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
