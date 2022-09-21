// package com.example.springboot2;
//
// import com.google.common.collect.ImmutableMap;
// import lombok.Getter;
// import lombok.Setter;
// import lombok.experimental.FieldNameConstants;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.ConfigurableApplicationContext;
// import org.springframework.stereotype.Component;
//
// import java.util.Map;
// import java.util.function.Consumer;
//
// @Slf4j
// @SpringBootApplication
// public class Springboot2Application6 {
//
//     public static void main(String[] args) {
//         ConfigurableApplicationContext applicationContext = SpringApplication.run(Springboot2Application6.class, args);
//         System.out.println("容器启动完成");
//     }
//
//     /**
//      * 所有字段吧
//      */
//     @Getter
//     @Setter
//     @FieldNameConstants
//     public static class ShowVo {
//         private int columnId;
//         private int a;
//         private int b;
//     }
//
//     /**
//      * 这是个子集
//      */
//     @Getter
//     @Setter
//     @FieldNameConstants
//     public static class ShowVo2 {
//         private int a;
//     }
//
//     public static interface VoFactory<T> {
//
//     }
//
//     public static interface ShowVoService extends VoFactory<ShowVo> {
//         ShowVo2 getShowVo(int i);
//     }
//
//     @Component
//     public static class FiledAService {
//         public int getA(ShowVo showVo) {
//             int columnId = showVo.getColumnId();
//             return columnId + 1;
//         }
//     }
//
//     @Component
//     public static class FiledBService {
//         public int getB(ShowVo showVo) {
//             int columnId = showVo.getColumnId();
//             return columnId + 1;
//         }
//     }
//
//     @Component
//     public static interface ShowVoServiceImpl extends VoFactory<ShowVo> {
//
//
//         Map map = ImmutableMap.<String, Consumer<ShowVo>>builder()
//                 .put(ShowVo.Fields.a, showVo -> showVo.setA(1))
//                 .put(ShowVo.Fields.b, showVo -> showVo.setA(2))
//                 .build();
//
//         @Autowired
//         FiledAService FILED_A_SERVICE = null;
//         @Autowired
//         FiledBService FILED_B_SERVICE = null;
//
//         public ShowVo2 getShowVo2(int i);
//     }
//
// }
