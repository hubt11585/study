package demo.knowledgepoints.functionpointer.inf;

/**
 * Ö¸Õëº¯Êý
 * @param <T>
 * @param <E>
 */
@FunctionalInterface
public interface Function<T,E> {
    public void apply(T t,E e);
}
