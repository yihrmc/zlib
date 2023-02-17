package red.stu.zlib.entity;

public interface ZValidator<T, E extends Throwable> {

    void verify(T fieldValue) throws E;

}
