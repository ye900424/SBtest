package validateTest.test2;

import java.util.Map;

/**
 * @author: C.A.O
 * @Description:
 * @Date: 2018/11/8
 */
public class ValidationResult {

    // 校验结果是否有错
    private boolean             hasErrors;

    public boolean isHasErrors() {
        return hasErrors;
    }

    public void setHasErrors(boolean hasErrors) {
        this.hasErrors = hasErrors;
    }

    public Map<String, String> getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(Map<String, String> errorMsg) {
        this.errorMsg = errorMsg;
    }

    // 校验错误信息
    private Map<String, String> errorMsg;

}
