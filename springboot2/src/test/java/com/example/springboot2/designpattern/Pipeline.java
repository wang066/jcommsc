package com.example.springboot2.designpattern;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Map;

public class Pipeline {

    public static class Context{

    }
    public interface  IPipeline{
        void start();
        Context getContext();
    }

    public interface Value{
        void  invoke(Context context);
        void invokeNext(Context context);
        String getValueName();
    }

    /**
     * 传递到管道的上下文
     */
    @Getter
    @Setter
    public class PipelineContext {

        /**
         * 处理开始时间
         */
        private LocalDateTime startTime;

        /**
         * 处理结束时间
         */
        private LocalDateTime endTime;

        /**
         * 获取数据名称
         */
        public String getName() {
            return this.getClass().getSimpleName();
        }
    }
    /**
     * 模型实例构建的上下文
     */
    @Getter
    @Setter
    public class InstanceBuildContext extends PipelineContext {

        /**
         * 模型 id
         */
        private Long modelId;

        /**
         * 用户 id
         */
        private long userId;

        /**
         * 表单输入
         */
        private Map<String, Object> formInput;

        /**
         * 保存模型实例完成后，记录下 id
         */
        private Long instanceId;

        /**
         * 模型创建出错时的错误信息
         */
        private String errorMsg;

        // 其他参数

        @Override
        public String getName() {
            return "模型实例构建上下文";
        }
    }
    /**
     * 管道中的上下文处理器
     */
    public interface ContextHandler<T extends PipelineContext> {

        /**
         * 处理输入的上下文数据
         *
         * @param context 处理时的上下文数据
         * @return 返回 true 则表示由下一个 ContextHandler 继续处理，返回 false 则表示处理结束
         */
        boolean handle(T context);
    }

    public class ModelInstanceCreator implements ContextHandler<InstanceBuildContext> {

        private final Logger logger = LoggerFactory.getLogger(this.getClass());

        @Override
        public boolean handle(InstanceBuildContext context) {
            logger.info("--根据输入数据创建模型实例--");

            // 假装创建模型实例

            return true;
        }
    }

}
