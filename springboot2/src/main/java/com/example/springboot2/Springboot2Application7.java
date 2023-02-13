package com.example.springboot2;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@Slf4j
@SpringBootApplication
public class Springboot2Application7 {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Springboot2Application7.class, args);
        System.out.println("容器启动完成");
    }

    public static class CacheWrapper implements BeanPostProcessor{

    }

    /**
     * 所有字段吧
     */
    @Getter
    @Setter
    @FieldNameConstants
    public static class ResponseShowVo {
        private Long columnId;
        private String title;
        private List<Long> courseIds;
    }

    @Setter
    @FieldNameConstants
    public static class ColumnResponseShowVo {
        private Long columnId;
        private String title;
    }

    public static class RequestContext {
        private List<String> fields;

        private long columnId;

    }

    public interface IResponseShowVoService<C, R> {
        R get(C context);
    }

    public static class ResponseShowVoService implements IResponseShowVoService<RequestContext, ResponseShowVo> {

        @Override
        public ResponseShowVo get(RequestContext context) {
            ResponseShowVo responseShowVo = new ResponseShowVo();
            if (context.fields.contains(ResponseShowVo.Fields.columnId)) {
                responseShowVo.setColumnId(1L);
            }
            if (context.fields.contains(ResponseShowVo.Fields.title)) {
                responseShowVo.setTitle("title");
            }
            if (context.fields.contains(ResponseShowVo.Fields.courseIds)) {
                responseShowVo.setCourseIds(Lists.newArrayList(10L, 12L));
            }

            return responseShowVo;
        }
    }

}
