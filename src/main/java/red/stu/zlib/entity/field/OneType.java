package red.stu.zlib.entity.field;

public interface OneType<E> {

    <T extends E> T type();

}
