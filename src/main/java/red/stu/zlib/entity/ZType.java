package red.stu.zlib.entity;

public interface ZType {

    default String getPackageName() {
        return null;
    }

    default String getSimpleName() {
        return null;
    }

    String getQualifiedName();

    default String getMysqlTypeName() {
        return null;
    }

}
