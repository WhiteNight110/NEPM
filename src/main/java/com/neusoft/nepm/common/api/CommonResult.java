package com.neusoft.nepm.common.api;

/**
 * 通用的返回结果对象
 */
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    public CommonResult() {

    }

    public CommonResult(long code,String message,T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult(long code,String message) {
        this.code = code;
        this.message = message;
    }




    public CommonResult(T data) {
        this.data = data;
    }


    public static <T> CommonResult<T> failed(T data) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(),ResultCode.FAILED.getMessage(), data);
    }


    /**
     * 操作成功返回的结果
     * @param data
     * @param message
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),message,data);
    }

    /**
     * 操作成功返回的结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }



    public static <T> CommonResult<T> failed(IErrorCode iErrorCode) {
        return new CommonResult<T>(iErrorCode.getCode(),iErrorCode.getMessage(),null);
    }




    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
