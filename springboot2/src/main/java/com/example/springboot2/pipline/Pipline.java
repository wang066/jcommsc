// package com.example.springboot2.pipline;
//
// import lombok.Getter;
// import lombok.Setter;
//
// import java.io.Serializable;
// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Map;
//
// public class Pipline {
//
//     public static class M {
//         public static void main(String[] args) {
//             LinkedList<List<Node>> nodes = new LinkedList<>();
//             nodes.add(new ArrayList<>());
//             for (List<Node> nodeList : nodes) {
//                 if (nodeList == null || nodeList.size() == 0) {
//                     return;
//                 }
//                 if (nodeList.size() == 1) {
//
//                 } else {
//
//                 }
//             }
//         }
//     }
//
//     public interface Node<T, S> {
//         String getName();
//
//         S invoke(T context);
//
//         T build(T context);
//     }
//
//     public interface Nodes extends Node {
//         Node findNode(String name);
//     }
//
//     public class FlowExecutor {
//
//     }
//
//     // public interface IBaseContextHandler<T, S> {
//     //     S handle(T context);
//     // }
//     //
//     // public interface IMultiContextHandler<T, S> extends IBaseContextHandler<T, S> {
//     //     boolean async();
//     //
//     //     S multiHandle(T context);
//     // }
//     //
//     // public interface IHandlerNode {
//     //     IBaseContextHandler next();
//     // }
//
//     // public abstract class CompositeContextHandlerChain {
//     //
//     // }
//
//     // public abstract class FeedItemAbstractContextHandler implements IMultiContextHandler<FeedItemContext, FeedItem> {
//     //
//     // }
//
//     @Getter
//     public class FeedItemContext {
//         private int pageNo;
//         private int status;
//
//
//         private Map<AFeedItem, Integer> loadNumber;
//     }
//
//     @Getter
//     @Setter
//     public class FeedItem implements Serializable {
//         private long id;
//
//         private int type;
//     }
//
//     public class AFeedItem extends FeedItem {
//         private String name;
//     }
//
//
//     public class BFeedItem extends FeedItem {
//         private int age;
//     }
//
//
// }
