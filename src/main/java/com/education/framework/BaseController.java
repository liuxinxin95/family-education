package com.education.framework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.Set;

public abstract class BaseController {
    private Logger logger = LoggerFactory.getLogger(BaseController.class);
    protected static final ApiStatusCode OK;

    public BaseController() {
    }

    public <T> void validate(T vo) throws WebApiException, StatusCodeException {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(vo, new Class[0]);
        Iterator var4 = violations.iterator();

        while(var4.hasNext()) {
            ConstraintViolation<T> v = (ConstraintViolation)var4.next();
            this.logger.info("参数校验违例: " + v.getPropertyPath().toString() + " " + v.getMessage());
        }

        if (!violations.isEmpty()) {
            ConstraintViolation<T> v = (ConstraintViolation)violations.iterator().next();
            throw new ParamValidateException(v.getPropertyPath().toString(), v.getMessage());
        } else {
            this.specialValidate(vo);
        }
    }

    public <T> void specialValidate(T apiRequest) throws ParamValidateException {
    }

    protected ApiResponse wrapApiResponse(ApiStatusCode code, String body, String msg) {
        return this.wrapApiResponse(code.value(), body, msg);
    }

    protected ApiResponse wrapApiResponse(ApiStatusCode code, String body, String msg, String traceMsg) {
        return this.wrapApiResponse(code.value(), body, msg, traceMsg);
    }

    protected <T> ApiResponse<T> wrapApiResponse(ApiStatusCode code, T body, String msg) {
        return this.wrapApiResponse(code.value(), body, msg);
    }

    protected <T> ApiResponse<T> wrapSuccessApiResponse(T body) {
        return this.wrapApiResponse(ApiStatusCode.OK, body, (String)null);
    }

    protected <T> ApiResponse<T> success(T body) {
        return this.wrapApiResponse(ApiStatusCode.OK, body, (String)null);
    }

    protected ApiResponse wrapApiResponse(int code, Object body, String msg) {
        return this.wrapApiResponse(code, body, msg, (String)null);
    }

    protected ApiResponse wrapApiResponse(int code, Object body, String msg, String traceMsg) {
        ApiResponse response = new ApiResponse();
        response.setStatusCode(code);
        response.setMsg(msg);
        if (StringUtils.isEmpty(traceMsg)) {
            response.setTraceMsg("traceId: " + TraceContext.getContext().getTraceId());
        } else {
            response.setTraceMsg(traceMsg);
        }

        response.setTimestamp(System.currentTimeMillis() / 1000L);
        response.setSignType((String)null);
        response.setBody(body);
        return response;
    }

    protected String encodeJson(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String s = null;

        try {
            s = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException var5) {
            var5.printStackTrace();
        }

        return s;
    }

    static {
        OK = ApiStatusCode.OK;
    }
}
