package iris.platform.platformshop.controller.response;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class BaseResponse<T> {

    private Integer code;

    private T data;

    public BaseResponse(Integer code) {
        this.code = code;
    }

    public static final BaseResponse successResponse = new BaseResponse(200);

    public BaseResponse of(T t) {
        this.setData(t);
        return this;
    }
}
