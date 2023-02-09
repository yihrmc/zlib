package red.stu.zlib.entity.field;

import red.stu.zlib.entity.field.number.ZNumberType1;
import red.stu.zlib.entity.field.string.ZStringType1;

public abstract class ZFieldType {

    public static ZStringType1 string() {
        return get();
    }

    public static ZNumberType1 number() {
        return get();
    }

    private static <T> T get() {
        return null;
    }

}
