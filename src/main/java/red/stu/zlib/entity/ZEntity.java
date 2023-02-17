package red.stu.zlib.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 模板实体类
 *
 * <p>示例代码：</p>
 * <pre class="code">
 *     import red.stu.zlib.entity.ZEntity;
 *
 *     public interface ZDemo1 extends ZEntity {
 *
 *          &#047;*
 *          * &#064;return 字段1
 *          **&#047;
 *          String fieldName1();
 *
 *          &#047;*
 *          * &#064;return 字段2
 *          **&#047;
 *          String fieldName2();
 *
 *          &#047;*
 *          * 参数1
 *          **&#047;
 *          void param1(String t);
 *
 *     }
 * </pre>
 *
 */
public interface ZEntity {

    /**
     * 启用的Getter和Setter的方法
     */
    void enableGetterSetterMethods();

    /**
     * 关联其它实体类
     * <p>示例代码：</p>
     * <pre class="code">
     *     public interface ZDemo1 extends ZEntity {
     *          ...
     *
     *          &#047;*
     *          * {&#064;link user#id()} = {&#064;link #fieldName1()}
     *          **&#047;
     *          &#064;ZEntity.Join(mainNotNull=true, joinNotNull=false)
     *          interface user extends ZUser {
     *          }
     *
     *          ...
     *     }
     * </pre>
     */
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.SOURCE)
    @interface Join {
        /**
         * @return 主表的字段值是否允许为空
         */
        boolean mainNotNull();

        /**
         * @return 关联表的字段值是否允许为空
         */
        boolean joinNotNull();

        /**
         * @return 是否关联所有字段。如果为false，则需要重写对应字段声明方法，才为声明关联字段。
         */
        boolean allFields() default true;
    }

    /**
     * 实体类的查询条件
     * <p>示例代码：</p>
     * <pre class="code">
     *     public interface ZDemo1 extends ZEntity {
     *          ...
     *
     *          &#047;*
     *          * &#060;if test="{&#064;link #id()} != null"&#062;
     *          *    {&#064;link #id(Long)} = {&#064;link #id()}
     *          * &#060;/if&#062;
     *          **&#047;
     *          &#064;ZEntity.Where()
     *          interface where1 {
     *          }
     *
     *          ...
     *     }
     * </pre>
     */
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.SOURCE)
    @interface Where {
    }


    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.SOURCE)
    @interface SelectFields {
        SelectField[] values();
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.SOURCE)
    @interface SelectField {
        Class<? extends SelectMapper> mapper();
        Class<? extends ZValidator<?, ?>>[] validator();
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.SOURCE)
    @interface SelectMapper {
    }

}
