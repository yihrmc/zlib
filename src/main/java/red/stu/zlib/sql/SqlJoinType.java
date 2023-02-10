package red.stu.zlib.sql;

public interface SqlJoinType {

    interface P1<TYPE> {

        P2<TYPE> mainNullable();

        P2<TYPE> mainNotNull();

    }

    interface P2<TYPE> {

        TYPE joinNullable();

        TYPE joinNotNull();

    }

}
