package co.nz.wone;

import java.util.function.Consumer;

public class JsonNodeModifiers<T> {

    final private T object;

    public JsonNodeModifiers(T newInstance) {
        this.object = newInstance;
    }

    public JsonNodeModifiers<T> with(Consumer<T> consumer) {
        consumer.accept(object);
        return this;
    }

    public T modify() {
        return object;
    }
}
