package cn.jcomm.handler;

import cn.jcomm.common.exception.ApiException;
import cn.jcomm.common.pojo.Result;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * 搜索 全局异常处理
 */

@ControllerAdvice
@Slf4j
public class GlobalHandlerExceptionResolver {


    @ExceptionHandler(value = RuntimeException.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) {

        log.error("defaultErrorHandler:",e);

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");

        return mav;
    }

    @ExceptionHandler(value = ApiException.class)
    @ResponseBody
    public Result<String> jsonErrorHandler(HttpServletRequest req, ApiException e)  {

        //info 是参数类型
        if(e.isWriteLog()){
            log.error(JSON.toJSONString(e.getInfo()), e);
        }else {
            log.error("", e);
        }


        return Result.error(e.getCode(), e.getMsg());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public String jsonErrorHandler(HttpServletRequest req, ConstraintViolationException e)  {
        StringBuilder messages = new StringBuilder();

        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            messages.append(violation.getMessage() + "\n");
        }

        return messages.toString();
    }

}
