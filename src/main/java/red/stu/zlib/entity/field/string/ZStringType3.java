package red.stu.zlib.entity.field.string;

import red.stu.zlib.entity.field.ZFieldType;

public abstract class ZStringType3 extends ZFieldType {

    abstract public ZStringType3 maxLength(int max);

    abstract public ZStringType3 minLength(int min);

    abstract public ZStringType3 length(int max, int min);

}
