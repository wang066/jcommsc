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

/**
 * 搜索 全局异常处理
 */

@ControllerAdvice
@Slf4j
public class GlobalHandlerExceptionResolver {


    @ExceptionHandler(value = RuntimeException.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {

        log.error("", e);

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

    @ExceptionHandler(value = ApiException.class)
    @ResponseBody
    public Result<String> jsonErrorHandler(HttpServletRequest req, ApiException e) throws Exception {

        //info 是参数类型
        log.error(JSON.toJSONString(e.getInfo()), e);

        return Result.error(e.getCode(), e.getMsg());
    }

}
