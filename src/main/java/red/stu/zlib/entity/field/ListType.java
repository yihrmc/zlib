package red.stu.zlib.entity.field;

import java.util.List;

public interface ListType<E> {

    <T extends E> List<T> type();

}
