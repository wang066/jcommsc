package cn.jcomm.handler;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @author 66wan
 * 提供日志切面 对接kafka日志系统
 */
@Aspect
@Order(5)
@Component
@Slf4j
public class WebLogAspect {

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * cn.jcomm.controller..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {

        //传入uuid做请求追踪
//        String uuid = UuidUtil.getTimeBasedUuid().toString();
//        ThreadContext.put("guid",uuid );
//        ThreadContext.put("clientIP", IpUtils.getHostName());
//        ThreadContext.put("hostname",IpUtils.getHostName() );
//        ThreadContext.put("userId",uuid );

        startTime.set(System.currentTimeMillis());

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        StringBuilder sbArgs = new StringBuilder();
        sbArgs.append("ARGS : ");
        Object[] paramValues = joinPoint.getArgs();
        String[] paramNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();

        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());

        for (int i = 0; i < paramNames.length; i++) {
            sbArgs.append("[" + paramNames[i] + "=" + paramValues[i] + "]");
        }

        log.info(sbArgs.toString());
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret)  {
        // 处理完请求，返回内容
        log.info("RESPONSE : " + ret);
        log.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));

//        ThreadContext.clearAll();
    }

//
    @AfterThrowing(throwing="ex",pointcut = "webLog()")
    public void doRecoveryActions(Throwable ex){
//        log.error("exception :", ex);

        log.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));

//        ThreadContext.clearAll();
    }
}

