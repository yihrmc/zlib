package red.stu.zlib.entity.field.number;

import red.stu.zlib.entity.field.ZFieldType;

public abstract class ZNumberType1 extends ZFieldType {

    /**
     * 值可空
     */
    abstract public ZNumberType1 nullable();

    /**
     * 值不能为{@code null}
     */
    abstract public ZNumberType1 notNull();

    /**
     * 值不能为{@code 0}
     */
    abstract public ZNumberType1 notZero();

}
