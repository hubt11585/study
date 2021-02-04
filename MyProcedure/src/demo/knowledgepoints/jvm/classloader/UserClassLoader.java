package demo.knowledgepoints.jvm.classloader;

public class UserClassLoader extends ClassLoader {

    public static void main(String[] args) {

    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {

        return null;
    }

    /**
     * loadClass �����е�findLoadedClass��native���������ܱ��޸ġ���������Ҫ����Java��ί�ɻ�����Ҫ
     * ��дClassLoad �� findClass ����������ʵ�֡�
     * @param name
     * @param resolve
     * @return
     * @throws ClassNotFoundException
     */
    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException
    {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                long t0 = System.nanoTime();
                try {
                    if (name.startsWith("demo.knowledgepoints.jvm.classloader")) {
                        findClass(name);
                    } else {
                        c = this.getParent().loadClass(name);
                    }
                } catch (ClassNotFoundException e) {
                    // ClassNotFoundException thrown if class not found
                    // from the non-null parent class loader
                }

                if (c == null) {
                    // If still not found, then invoke findClass in order
                    // to find the class.
                    long t1 = System.nanoTime();
                    c = findClass(name);

                    // this is the defining class loader; record the stats
                    sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    sun.misc.PerfCounter.getFindClasses().increment();
                }
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }
}
