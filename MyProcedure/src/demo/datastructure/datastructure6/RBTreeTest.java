package demo.datastructure.datastructure6;

public class RBTreeTest {

    private static final int a[] = {10, 40, 30, 60, 90, 70, 20, 50, 80};
    private static final boolean mDebugInsert = false;    // "����"�����ļ�⿪��(false���رգ�true����)
    private static final boolean mDebugDelete = false;    // "ɾ��"�����ļ�⿪��(false���رգ�true����)

    public static void main(String[] args) {
        int i, iLen = a.length;
        RBTree<Integer> tree=new RBTree<Integer>();

        System.out.printf("���������ڵ�: ");
        for(i=0; i<iLen; i++){
            System.out.printf("%d ", a[i]);
            tree.insert(a[i]);
            // ����mDebugInsert=true,����"��Ӻ���"
            if (mDebugInsert) {
                System.out.printf("== ��ӽڵ�: %d\n", a[i]);
                System.out.printf("== ������ϸ��Ϣ: \n");
                tree.print();
                System.out.printf("\n");
            }
        }

        System.out.printf("\n");
        System.out.printf("������ϸ��Ϣ: \n");
        tree.print();
        System.out.printf("\n");

        // ����mDebugDelete=true,����"ɾ������"
        if (mDebugDelete) {
            for(i=0; i<iLen; i++){
                tree.remove(a[i]);
                System.out.printf("== ɾ���ڵ�: %d\n", a[i]);
                System.out.printf("== ������ϸ��Ϣ: \n");
                tree.print();
                System.out.printf("\n");
            }
        }

        // ���ٶ�����
        tree.clear();
    }
}
