package demo.knowledgepoints.functionpointer.inf;

/**
 * ָ�뺯��
 * @param <T>
 * @param <E>
 */
@FunctionalInterface
public interface Function<T,E> {
    public void apply(T t,E e);
}
