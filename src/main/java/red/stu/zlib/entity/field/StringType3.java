package red.stu.zlib.entity.field;

public interface StringType3 extends OneType {

    /**
     * 限制最大长度
     */
    StringType3 maxLength(int max);

    /**
     * 限制最小长度
     */
    StringType3 minLength(int min);

    /**
     * 限制长度在指定范围
     */
    StringType3 length(int max, int min);

}
