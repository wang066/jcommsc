package cn.jcomm.test.basicjava;

import junit.framework.TestCase;

interface Interface1 {
    int i = 1;//public static final

    int getSum(int i1, int i2);//public abstract

    default int getSum(int i1, int i2, int i3) {
        return i1 + i2 + i3;
    }
}

/**
 * Created by 066 on 2017/3/30 0030.
 */
public class Test1 extends TestCase {
    public void test1() {

    }
}
/**
 * 服务层命名
 * A) Service/DAO层方法命名规约1）获取单个对象的方法用get做前缀。2）获取多个对象的方法用list做前缀。3）获取统计值的方法用count做前缀。4）插入的方法用save（推荐）或insert做前缀。5）删除的方法用remove（推荐）或delete做前缀。6）修改的方法用update做前缀。B) 领域模型命名规约1）数据对象：xxxDO，xxx即为数据表名。2）数据传输对象：xxxDTO，xxx为业务领域相关的名称。3）展示对象：xxxVO，xxx一般为网页名称。4）POJO是DO/DTO/BO/VO的统称，禁止命名成xxxPOJO
 */


//2）【推荐】如果是形容能力的接口名称，取对应的形容词做接口名（通常是–able的形式）。正例：AbstractTranslator实现Translatable。


//1）所有的POJO类属性必须使用包装数据类型。2）RPC方法的返回值和参数必须使用包装数据类型。3）所有的局部变量推荐使用基本数据类型。说明：POJO类属性没有初值是提醒使用者在需要使用时，必须自己显式地进行赋值，任何NPE问题，或者入库检查，都由使用者来保证。正例：数据库的查询结果可能是null，因为自动拆箱，用基本数据类型接收有NPE风险。反例：某业务的交易报表上显示成交总额涨跌情况，即正负x%，x为基本数据类型，调用的RPC服务，调用不成功时，返回的是默认值，页面显示：0%，这是不合理的，应该显示成中划线-。所以包装数据类型的null值，能够表示额外的信息，如：远程调用失败，异常退出。

//定义DO/DTO/VO等POJO类时，不要设定任何属性默认值。


//构造方法里面禁止加入任何业务逻辑，如果有初始化逻辑，请放在init方法中。

//使用集合转数组的方法，必须使用集合的toArray(T[] array)，传入的是类型完全一样的数组，大小就是list.size()

//强制】表达是与否概念的字段，必须使用is_xxx的方式命名，数据类型是unsigned tinyint（1表示是，0表示否），此规则同样适用于odps建表。

//【强制】表名、字段名必须使用小写字母或数字；禁止出现数字开头，禁止两个下划线中间只出现数字。数据库字段名的修改代价很大，因为无法进行预发布，所以字段名称需要慎重考虑。正例：getter_admin，task_config，level3_name

//【强制】小数类型为decimal，禁止使用float和double。说明：float和double在存储的时候，存在精度损失的问题，很可能在值的比较时，得到不正确的结果。如果存储的数据范围超过decimal的范围，建议将数据拆成整数和小数分开存储。

//【强制】varchar是可变长字符串，不预先分配存储空间，长度不要超过5000，如果存储长度大于此值，定义字段类型为TEXT，独立出来一张表，用主键来对应，避免影响其它字段索引效率。

//【强制】表必备三字段：id, gmt_create, gmt_modified。说明：其中id必为主键，类型为unsigned bigint、单表时自增、步长为1；分表时改为从TDDL Sequence取值，确保分表之间的全局唯一。gmt_create, gmt_modified的类型均为date_time类型。

//【推荐】表的命名最好是加上“业务名称_表的作用”，避免上云梯后，再与其它业务表关联时有混淆。正例：tiger_task / tiger_reader / mpp_config