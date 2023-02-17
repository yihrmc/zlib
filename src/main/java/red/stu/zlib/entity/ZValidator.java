package red.stu.zlib.entity;

import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface ZValidator<T> {

    Map<Class<?>, SoftReference<ZValidator<?>>> VALIDATOR_MAP = new ConcurrentHashMap<>();

    void verify(T fieldValue, String fieldName, Object entity);

    @SuppressWarnings("unchecked")
    static void verify(Class<? extends ZValidator<?>> type, Object fieldValue, String fieldName, Object entity) {
        ZValidator<Object> validator;
        SoftReference<ZValidator<?>> reference = VALIDATOR_MAP.get(type);
        if (reference == null) {
            validator = null;
        } else {
            validator = (ZValidator<Object>) reference.get();
        }
        if (validator == null) {
            try {
                validator = (ZValidator<Object>) newInstance(type);
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                     IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            VALIDATOR_MAP.put(type, new SoftReference<>(validator));
        }
        validator.verify(fieldValue, fieldName, entity);
    }

    static <V extends ZValidator<?>> V newInstance(Class<V> type) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Constructor<V> constructor = type.getConstructor();
        return constructor.newInstance();
    }

}
