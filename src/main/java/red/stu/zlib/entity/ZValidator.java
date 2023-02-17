package red.stu.zlib.entity;

import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface ZValidator<T, E extends Throwable> {

    Map<Class<?>, SoftReference<ZValidator<?, ?>>> VALIDATOR_MAP = new ConcurrentHashMap<>();

    void verify(T fieldValue, Object entity) throws E;

    @SuppressWarnings("unchecked")
    static <V extends ZValidator<?, ?>> V getInstance(Class<V> type) {
        V validator;
        SoftReference<ZValidator<?, ?>> reference = VALIDATOR_MAP.get(type);
        if (reference == null) {
            validator = null;
        } else {
            validator = (V) reference.get();
        }
        if (validator == null) {
            try {
                validator = newInstance(type);
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                     IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            VALIDATOR_MAP.put(type, new SoftReference<>(validator));
        }
        return validator;
    }

    static <V extends ZValidator<?, ?>> V newInstance(Class<V> type) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Constructor<V> constructor = type.getConstructor();
        return constructor.newInstance();
    }

}
