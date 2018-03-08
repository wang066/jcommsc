package cn.jcomm.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by jowang on 2017/4/20 0020.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> {
    //商品集合
    private List<T> itemList;
    //总记录数
    private long recordCount;
    //总页数
    private long pageCount;
    //当前页
    private long currentPage;
}
