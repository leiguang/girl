package xin.leiguang.girl.exception;

import xin.leiguang.girl.enums.ResultEnum;

/**
 * 继承于 RuntimeException，因为 Spring 框架只会对 RuntimeException 进行事务回滚，而不会对 Exception 进行事务回滚。
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
