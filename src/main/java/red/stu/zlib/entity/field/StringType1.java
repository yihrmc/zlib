package red.stu.zlib.entity.field;
public interface StringType1 extends OneType {

    /**
     * 值可空
     */
    StringType2 nullable();

    /**
     * 值不能为{@code null}
     */
    StringType3 notNull();

    /**
     * 值不能为空字符串
     */
    StringType3 notEmpty();

    /**
     * 值不能为空白字符串
     */
    StringType3 notBlank();

}
