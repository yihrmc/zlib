package red.stu.zlib.entity.field;

import java.util.List;

public interface ListType {

    <T extends List<?>> T type();

}
