package red.stu.zlib.entity.field;

public interface NumberType1 extends OneType {

    /**
     * 值可空
     */
    NumberType1 nullable();

    /**
     * 值不能为{@code null}
     */
    NumberType1 notNull();

    /**
     * 值不能为{@code 0}
     */
    NumberType1 notZero();

}
