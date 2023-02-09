package red.stu.zlib.sql;

import red.stu.zlib.entity.ZEntity;

/**
 * JOIN合并数据
 * <ul>
 *     <li>inner join: [mainNull=false, joinNull=false]</li>
 *     <li>left join: [mainNull=false, joinNull=true]</li>
 *     <li>right join: [mainNull=true, joinNull=false]</li>
 * </ul>
 */
public @interface ZJoin {

    /**
     * JOIN的表实体类
     */
    Class<? extends ZEntity> join();

    /**
     * JOIN合并的数据，是否允许主表的数据不存在时填充null
     */
    boolean mainNull() default false;

    /**
     * JOIN合并的数据，是否允许附加表的数据不存在时填充null
     */
    boolean joinNull() default true;

}
