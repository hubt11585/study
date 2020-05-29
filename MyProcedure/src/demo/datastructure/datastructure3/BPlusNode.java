package demo.datastructure.datastructure3;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class BPlusNode<K extends Comparable<K>, V> {

    // �Ƿ�ΪҶ�ӽڵ�
    protected boolean isLeaf;

    // �Ƿ���ڸ��ڵ�
    protected boolean isRoot;

    // ���ڵ�
    protected BPlusNode<K, V> parent;

    // Ҷ�ڵ��ǰ�ڵ�
    protected BPlusNode<K, V> previous;

    // Ҷ�ڵ�ĺ�ڵ�
    protected BPlusNode<K, V> next;

    // �ڵ�Ĺؼ����б�
    protected List<Map.Entry<K, V>> entries;

    // �ӽڵ��б�
    protected List<BPlusNode<K, V>> children;

    public BPlusNode(boolean isLeaf) {
        this.isLeaf = isLeaf;
        entries = new ArrayList();

        if (!isLeaf) {
            children = new ArrayList();
        }
    }

    public BPlusNode(boolean isLeaf, boolean isRoot) {
        this(isLeaf);
        this.isRoot = isRoot;
    }

    public V get(K key) {
        //�����Ҷ�ӽڵ�
        if (isLeaf) {
            int low = 0, high = entries.size() - 1, mid;
            int comp;
            while (low <= high) {
                mid = (low + high) / 2;
                comp = entries.get(mid).getKey().compareTo(key);
                if (comp == 0) {
                    return entries.get(mid).getValue();
                } else if (comp < 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            //δ�ҵ���Ҫ��ѯ�Ķ���
            return null;
        }
        //�������Ҷ�ӽڵ�
        //���keyС�ڽڵ�����ߵ�key���ص�һ���ӽڵ��������
        if (key.compareTo(entries.get(0).getKey()) < 0) {
            return children.get(0).get(key);
            //���key���ڵ��ڽڵ����ұߵ�key�������һ���ӽڵ��������
        } else if (key.compareTo(entries.get(entries.size() - 1).getKey()) >= 0) {
            return children.get(children.size() - 1).get(key);
            //�����ر�key���ǰһ���ӽڵ��������
        } else {
            int low = 0, high = entries.size() - 1, mid = 0;
            int comp;
            while (low <= high) {
                mid = (low + high) / 2;
                comp = entries.get(mid).getKey().compareTo(key);
                if (comp == 0) {
                    return children.get(mid + 1).get(key);
                } else if (comp < 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return children.get(low).get(key);
        }
    }

    public void insertOrUpdate(K key, V value, BPlusTree<K, V> tree) {
        //�����Ҷ�ӽڵ�
        if (isLeaf) {
            //����Ҫ���ѣ�ֱ�Ӳ�������
            if (contains(key) != -1 || entries.size() < tree.getOrder()) {
                insertOrUpdate(key, value);
                if (tree.getHeight() == 0) {
                    tree.setHeight(1);
                }
                return;
            }
            //��Ҫ����
            //���ѳ����������ڵ�
            BPlusNode<K, V> left = new BPlusNode<K, V>(true);
            BPlusNode<K, V> right = new BPlusNode<K, V>(true);
            //��������
            if (previous != null) {
                previous.next = left;
                left.previous = previous;
            }
            if (next != null) {
                next.previous = right;
                right.next = next;
            }
            if (previous == null) {
                tree.setHead(left);
            }

            left.next = right;
            right.previous = left;
            previous = null;
            next = null;

            //����ԭ�ڵ�ؼ��ֵ����ѳ������½ڵ�
            copy2Nodes(key, value, left, right, tree);

            //������Ǹ��ڵ�
            if (parent != null) {
                //�������ӽڵ��ϵ
                int index = parent.children.indexOf(this);
                parent.children.remove(this);
                left.parent = parent;
                right.parent = parent;
                parent.children.add(index, left);
                parent.children.add(index + 1, right);
                parent.entries.add(index, right.entries.get(0));
                entries = null; //ɾ����ǰ�ڵ�Ĺؼ�����Ϣ
                children = null; //ɾ����ǰ�ڵ�ĺ��ӽڵ�����

                //���ڵ�������¹ؼ���
                parent.updateInsert(tree);
                parent = null; //ɾ����ǰ�ڵ�ĸ��ڵ�����
                //����Ǹ��ڵ�
            } else {
                isRoot = false;
                BPlusNode<K, V> parent = new BPlusNode<K, V>(false, true);
                tree.setRoot(parent);
                left.parent = parent;
                right.parent = parent;
                parent.children.add(left);
                parent.children.add(right);
                parent.entries.add(right.entries.get(0));
                entries = null;
                children = null;
            }
            return;

        }
        //�������Ҷ�ӽڵ�
        //���keyС�ڵ��ڽڵ�����ߵ�key���ص�һ���ӽڵ��������
        if (key.compareTo(entries.get(0).getKey()) < 0) {
            children.get(0).insertOrUpdate(key, value, tree);
            //���key���ڽڵ����ұߵ�key�������һ���ӽڵ��������
        } else if (key.compareTo(entries.get(entries.size() - 1).getKey()) >= 0) {
            children.get(children.size() - 1).insertOrUpdate(key, value, tree);
            //�����ر�key���ǰһ���ӽڵ��������
        } else {
            int low = 0, high = entries.size() - 1, mid = 0;
            int comp;
            while (low <= high) {
                mid = (low + high) / 2;
                comp = entries.get(mid).getKey().compareTo(key);
                if (comp == 0) {
                    children.get(mid + 1).insertOrUpdate(key, value, tree);
                    break;
                } else if (comp < 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            if (low > high) {
                children.get(low).insertOrUpdate(key, value, tree);
            }
        }
    }

    private void copy2Nodes(K key, V value, BPlusNode<K, V> left,
                            BPlusNode<K, V> right, BPlusTree<K, V> tree) {
        //���������ڵ�ؼ��ֳ���
        int leftSize = (tree.getOrder() + 1) / 2 + (tree.getOrder() + 1) % 2;
        boolean b = false;//���ڼ�¼��Ԫ���Ƿ��Ѿ�������
        for (int i = 0; i < entries.size(); i++) {
            if (leftSize != 0) {
                leftSize--;
                if (!b && entries.get(i).getKey().compareTo(key) > 0) {
                    left.entries.add(new AbstractMap.SimpleEntry<K, V>(key, value));
                    b = true;
                    i--;
                } else {
                    left.entries.add(entries.get(i));
                }
            } else {
                if (!b && entries.get(i).getKey().compareTo(key) > 0) {
                    right.entries.add(new AbstractMap.SimpleEntry<K, V>(key, value));
                    b = true;
                    i--;
                } else {
                    right.entries.add(entries.get(i));
                }
            }
        }
        if (!b) {
            right.entries.add(new AbstractMap.SimpleEntry<K, V>(key, value));
        }
    }

    /**
     * ����ڵ���м�ڵ�ĸ���
     */
    protected void updateInsert(BPlusTree<K, V> tree) {

        //����ӽڵ�����������������Ҫ���Ѹýڵ�
        if (children.size() > tree.getOrder()) {
            //���ѳ����������ڵ�
            BPlusNode<K, V> left = new BPlusNode<K, V>(false);
            BPlusNode<K, V> right = new BPlusNode<K, V>(false);
            //���������ڵ��ӽڵ�ĳ���
            int leftSize = (tree.getOrder() + 1) / 2 + (tree.getOrder() + 1) % 2;
            int rightSize = (tree.getOrder() + 1) / 2;
            //�����ӽڵ㵽���ѳ������½ڵ㣬�����¹ؼ���
            for (int i = 0; i < leftSize; i++) {
                left.children.add(children.get(i));
                children.get(i).parent = left;
            }
            for (int i = 0; i < rightSize; i++) {
                right.children.add(children.get(leftSize + i));
                children.get(leftSize + i).parent = right;
            }
            for (int i = 0; i < leftSize - 1; i++) {
                left.entries.add(entries.get(i));
            }
            for (int i = 0; i < rightSize - 1; i++) {
                right.entries.add(entries.get(leftSize + i));
            }

            //������Ǹ��ڵ�
            if (parent != null) {
                //�������ӽڵ��ϵ
                int index = parent.children.indexOf(this);
                parent.children.remove(this);
                left.parent = parent;
                right.parent = parent;
                parent.children.add(index, left);
                parent.children.add(index + 1, right);
                parent.entries.add(index, entries.get(leftSize - 1));
                entries = null;
                children = null;

                //���ڵ���¹ؼ���
                parent.updateInsert(tree);
                parent = null;
                //����Ǹ��ڵ�
            } else {
                isRoot = false;
                BPlusNode<K, V> parent = new BPlusNode<K, V>(false, true);
                tree.setRoot(parent);
                tree.setHeight(tree.getHeight() + 1);
                left.parent = parent;
                right.parent = parent;
                parent.children.add(left);
                parent.children.add(right);
                parent.entries.add(entries.get(leftSize - 1));
                entries = null;
                children = null;
            }
        }
    }

    /**
     * ɾ���ڵ���м�ڵ�ĸ���
     */
    protected void updateRemove(BPlusTree<K, V> tree) {

        // ����ӽڵ���С��M / 2����С��2������Ҫ�ϲ��ڵ�
        if (children.size() < tree.getOrder() / 2 || children.size() < 2) {
            if (isRoot) {
                // ����Ǹ��ڵ㲢���ӽڵ������ڵ���2��OK
                if (children.size() >= 2) return;
                // �������ӽڵ�ϲ�
                BPlusNode<K, V> root = children.get(0);
                tree.setRoot(root);
                tree.setHeight(tree.getHeight() - 1);
                root.parent = null;
                root.isRoot = true;
                entries = null;
                children = null;
                return;
            }
            //����ǰ��ڵ�
            int currIdx = parent.children.indexOf(this);
            int prevIdx = currIdx - 1;
            int nextIdx = currIdx + 1;
            BPlusNode<K, V> previous = null, next = null;
            if (prevIdx >= 0) {
                previous = parent.children.get(prevIdx);
            }
            if (nextIdx < parent.children.size()) {
                next = parent.children.get(nextIdx);
            }

            // ���ǰ�ڵ��ӽڵ�������M / 2���Ҵ���2������䴦�貹
            if (previous != null
                    && previous.children.size() > tree.getOrder() / 2
                    && previous.children.size() > 2) {
                //ǰҶ�ӽڵ�ĩβ�ڵ���ӵ���λ
                int idx = previous.children.size() - 1;
                BPlusNode<K, V> borrow = previous.children.get(idx);
                previous.children.remove(idx);
                borrow.parent = this;
                children.add(0, borrow);
                int preIndex = parent.children.indexOf(previous);

                entries.add(0, parent.entries.get(preIndex));
                parent.entries.set(preIndex, previous.entries.remove(idx - 1));
                return;
            }

            // �����ڵ��ӽڵ�������M / 2���Ҵ���2������䴦�貹
            if (next != null
                    && next.children.size() > tree.getOrder() / 2
                    && next.children.size() > 2) {
                //��Ҷ�ӽڵ���λ��ӵ�ĩβ
                BPlusNode<K, V> borrow = next.children.get(0);
                next.children.remove(0);
                borrow.parent = this;
                children.add(borrow);
                int preIndex = parent.children.indexOf(this);
                entries.add(parent.entries.get(preIndex));
                parent.entries.set(preIndex, next.entries.remove(0));
                return;
            }

            // ͬǰ��ڵ�ϲ�
            if (previous != null
                    && (previous.children.size() <= tree.getOrder() / 2
                    || previous.children.size() <= 2)) {
                for (int i = 0; i < children.size(); i++) {
                    previous.children.add(children.get(i));
                }
                for (int i = 0; i < previous.children.size(); i++) {
                    previous.children.get(i).parent = this;
                }
                int indexPre = parent.children.indexOf(previous);
                previous.entries.add(parent.entries.get(indexPre));
                for (int i = 0; i < entries.size(); i++) {
                    previous.entries.add(entries.get(i));
                }
                children = previous.children;
                entries = previous.entries;

                //���¸��ڵ�Ĺؼ����б�
                parent.children.remove(previous);
                previous.parent = null;
                previous.children = null;
                previous.entries = null;
                parent.entries.remove(parent.children.indexOf(this));
                if ((!parent.isRoot
                        && (parent.children.size() >= tree.getOrder() / 2
                        && parent.children.size() >= 2))
                        || parent.isRoot && parent.children.size() >= 2) {
                    return;
                }
                parent.updateRemove(tree);
                return;
            }

            // ͬ����ڵ�ϲ�
            if (next != null
                    && (next.children.size() <= tree.getOrder() / 2
                    || next.children.size() <= 2)) {
                for (int i = 0; i < next.children.size(); i++) {
                    BPlusNode<K, V> child = next.children.get(i);
                    children.add(child);
                    child.parent = this;
                }
                int index = parent.children.indexOf(this);
                entries.add(parent.entries.get(index));
                for (int i = 0; i < next.entries.size(); i++) {
                    entries.add(next.entries.get(i));
                }
                parent.children.remove(next);
                next.parent = null;
                next.children = null;
                next.entries = null;
                parent.entries.remove(parent.children.indexOf(this));
                if ((!parent.isRoot && (parent.children.size() >= tree.getOrder() / 2
                        && parent.children.size() >= 2))
                        || parent.isRoot && parent.children.size() >= 2) {
                    return;
                }
                parent.updateRemove(tree);
                return;
            }
        }
    }

    public V remove(K key, BPlusTree<K, V> tree) {
        //�����Ҷ�ӽڵ�
        if (isLeaf) {
            //����������ùؼ��֣���ֱ�ӷ���
            if (contains(key) == -1) {
                return null;
            }
            //�������Ҷ�ӽڵ����Ǹ��ڵ㣬ֱ��ɾ��
            if (isRoot) {
                if (entries.size() == 1) {
                    tree.setHeight(0);
                }
                return remove(key);
            }
            //����ؼ���������M / 2��ֱ��ɾ��
            if (entries.size() > tree.getOrder() / 2 && entries.size() > 2) {
                return remove(key);
            }
            //�������ؼ�����С��M / 2������ǰ�ڵ�ؼ���������M / 2������䴦�貹
            if (previous != null &&
                    previous.parent == parent
                    && previous.entries.size() > tree.getOrder() / 2
                    && previous.entries.size() > 2) {
                //��ӵ���λ
                int size = previous.entries.size();
                entries.add(0, previous.entries.remove(size - 1));
                int index = parent.children.indexOf(previous);
                parent.entries.set(index, entries.get(0));
                return remove(key);
            }
            //�������ؼ�����С��M / 2�����Һ�ڵ�ؼ���������M / 2������䴦�貹
            if (next != null
                    && next.parent == parent
                    && next.entries.size() > tree.getOrder() / 2
                    && next.entries.size() > 2) {
                entries.add(next.entries.remove(0));
                int index = parent.children.indexOf(this);
                parent.entries.set(index, next.entries.get(0));
                return remove(key);
            }

            //ͬǰ��ڵ�ϲ�
            if (previous != null
                    && previous.parent == parent
                    && (previous.entries.size() <= tree.getOrder() / 2
                    || previous.entries.size() <= 2)) {
                V returnValue = remove(key);
                for (int i = 0; i < entries.size(); i++) {
                    //����ǰ�ڵ�Ĺؼ�����ӵ�ǰ�ڵ��ĩβ
                    previous.entries.add(entries.get(i));
                }
                entries = previous.entries;
                parent.children.remove(previous);
                previous.parent = null;
                previous.entries = null;
                //��������
                if (previous.previous != null) {
                    BPlusNode<K, V> temp = previous;
                    temp.previous.next = this;
                    previous = temp.previous;
                    temp.previous = null;
                    temp.next = null;
                } else {
                    tree.setHead(this);
                    previous.next = null;
                    previous = null;
                }
                parent.entries.remove(parent.children.indexOf(this));
                if ((!parent.isRoot && (parent.children.size() >= tree.getOrder() / 2
                        && parent.children.size() >= 2))
                        || parent.isRoot && parent.children.size() >= 2) {
                    return returnValue;
                }
                parent.updateRemove(tree);
                return returnValue;
            }
            //ͬ����ڵ�ϲ�
            if (next != null
                    && next.parent == parent
                    && (next.entries.size() <= tree.getOrder() / 2
                    || next.entries.size() <= 2)) {
                V returnValue = remove(key);
                for (int i = 0; i < next.entries.size(); i++) {
                    //����λ��ʼ��ӵ�ĩβ
                    entries.add(next.entries.get(i));
                }
                next.parent = null;
                next.entries = null;
                parent.children.remove(next);
                //��������
                if (next.next != null) {
                    BPlusNode<K, V> temp = next;
                    temp.next.previous = this;
                    next = temp.next;
                    temp.previous = null;
                    temp.next = null;
                } else {
                    next.previous = null;
                    next = null;
                }
                //���¸��ڵ�Ĺؼ����б�
                parent.entries.remove(parent.children.indexOf(this));
                if ((!parent.isRoot && (parent.children.size() >= tree.getOrder() / 2
                        && parent.children.size() >= 2))
                        || parent.isRoot && parent.children.size() >= 2) {
                    return returnValue;
                }
                parent.updateRemove(tree);
                return returnValue;
            }
        }
        /*�������Ҷ�ӽڵ�*/

        //���keyС�ڵ��ڽڵ�����ߵ�key���ص�һ���ӽڵ��������
        if (key.compareTo(entries.get(0).getKey()) < 0) {
            return children.get(0).remove(key, tree);
            //���key���ڽڵ����ұߵ�key�������һ���ӽڵ��������
        } else if (key.compareTo(entries.get(entries.size() - 1).getKey()) >= 0) {
            return children.get(children.size() - 1).remove(key, tree);
            //�����ر�key���ǰһ���ӽڵ��������
        } else {
            int low = 0, high = entries.size() - 1, mid = 0;
            int comp;
            while (low <= high) {
                mid = (low + high) / 2;
                comp = entries.get(mid).getKey().compareTo(key);
                if (comp == 0) {
                    return children.get(mid + 1).remove(key, tree);
                } else if (comp < 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return children.get(low).remove(key, tree);
        }
    }

    // �жϵ�ǰ�ڵ��Ƿ�����ùؼ���
    protected int contains(K key) {
        int low = 0, high = entries.size() - 1, mid;
        int comp;
        while (low <= high) {
            mid = (low + high) / 2;
            comp = entries.get(mid).getKey().compareTo(key);
            if (comp == 0) {
                return mid;
            } else if (comp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // ���뵽��ǰ�ڵ�Ĺؼ�����
    protected void insertOrUpdate(K key, V value) {
        //������ң�����
        int low = 0, high = entries.size() - 1, mid;
        int comp;
        while (low <= high) {
            mid = (low + high) / 2;
            comp = entries.get(mid).getKey().compareTo(key);
            if (comp == 0) {
                entries.get(mid).setValue(value);
                break;
            } else if (comp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (low > high) {
            entries.add(low, new AbstractMap.SimpleEntry<K, V>(key, value));
        }
    }

    // ɾ���ڵ�
    protected V remove(K key) {
        int low = 0, high = entries.size() - 1, mid;
        int comp;
        while (low <= high) {
            mid = (low + high) / 2;
            comp = entries.get(mid).getKey().compareTo(key);
            if (comp == 0) {
                return entries.remove(mid).getValue();
            } else if (comp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("isRoot: ");
        sb.append(isRoot);
        sb.append(", ");
        sb.append("isLeaf: ");
        sb.append(isLeaf);
        sb.append(", ");
        sb.append("keys: ");
        for (Map.Entry<K, V> entry : entries) {
            sb.append(entry.getKey());
            sb.append(", ");
        }
        sb.append(", ");
        return sb.toString();
    }

    public void printBPlusTree(int index) {
        if (this.isLeaf) {
            System.out.print("�㼶��" + index + ",Ҷ�ӽڵ㣬keysΪ: ");
            for (int i = 0; i < entries.size(); ++i)
                System.out.print(entries.get(i) + " ");
            System.out.println();
        } else {
            System.out.print("�㼶��" + index + ",��Ҷ�ӽڵ㣬keysΪ: ");
            for (int i = 0; i < entries.size(); ++i)
                System.out.print(entries.get(i) + " ");
            System.out.println();
            for (int i = 0; i < children.size(); ++i)
                children.get(i).printBPlusTree(index + 1);
        }
    }
}
