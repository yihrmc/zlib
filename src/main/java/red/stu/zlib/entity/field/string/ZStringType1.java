package red.stu.zlib.entity.field.string;

import red.stu.zlib.entity.field.ZFieldType;

public abstract class ZStringType1 extends ZFieldType {

    /**
     * 值可空
     */
    abstract public ZStringType2 nullable();

    /**
     * 值不能为{@code null}
     */
    abstract public ZStringType3 notNull();

    /**
     * 值不能为空字符串
     */
    abstract public ZStringType3 notEmpty();

    /**
     * 值不能为空白字符串
     */
    abstract public ZStringType3 notBlank();

}
