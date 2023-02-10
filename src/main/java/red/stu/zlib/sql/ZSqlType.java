package red.stu.zlib.sql;

import red.stu.zlib.entity.ZEntity;
import red.stu.zlib.entity.field.ListType;
import red.stu.zlib.entity.field.OneType;
import red.stu.zlib.entity.field.TypeAny;

public final class ZSqlType {

    public static SqlJoinType.P1<OneType<ZEntity>> joinOne(Class<? extends ZEntity> entityType) {
        return TypeAny.any();
    }

    public static SqlJoinType.P1<ListType<ZEntity>> joinList(Class<? extends ZEntity> entityType) {
        return TypeAny.any();
    }

}
