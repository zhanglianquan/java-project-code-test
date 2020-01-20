package src.datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @Author zhanglianquan
 * @Description 自定义泛型列表
 * @Date 2020/1/20
 **/
public class CustomGenericList<T> implements Iterable<T>{
    //MyArrayList把大小和数组作为成员变量进行存储
    private static final int DEFAULT_CAPACITY = 10;    //初始化数组时数组的长度
    private int theSize;            //当前数组元素个数
    private  T[] theItems;              //当前数组

    /**
     * 初始化数组
     * **/
    public CustomGenericList(){
        doClear();
    }

    /**
     * 清空数组
     * **/
    public void clear(){
        doClear();
    }

    /**
     * 清理数组
     * **/
    private void doClear(){
        theSize=0;              //让数组元素个数为零为0，并重新为数组分配内存
        ensureCapacity(DEFAULT_CAPACITY);
    }

    /**
     * 获得当前数组的元素个数
     **/
    public int size(){
        return theSize;
    }

    /**
     * 判断数组是否为空
     **/
    public boolean isEmpty(){
        return size() == 0;
    }

    /**
     * 将容量设置为 MyArrayList 中元素的实际数目
     **/
    public void trimToSize(){
        ensureCapacity(size());
    }

    /**
     * 获得指定索引位置的元素
     **/
    public T get(int idx){
        if(idx<0||idx>=size())     //索引位置不在范围，抛出异常
            throw new ArrayIndexOutOfBoundsException();
        return theItems[idx];        //返回对应元素
    }

    /**往指定位置插入值（覆盖），并返回原来的元素
     * idx:索引位置
     * newVai:新元素
     **/
    public T set(int idx,T newVai){
        if (idx<0 || idx >=size())           //索引位置不在范围，抛出异常
            throw new ArrayIndexOutOfBoundsException();
        T old=theItems[idx];
        theItems[idx] = newVai;
        return old;
    }

    /**
     * 容量扩充：newCapacity 为要扩充的长度
     **/
    public void ensureCapacity(int newCapacity){
        if (newCapacity < theSize)
        {
            return;
        }
        T[] old=theItems;    //存储一个对原数组的引用
        theItems=(T[])new Object[newCapacity];        //为新数组分配内存
        for (int i=0;i<size();i++){
            theItems[i] = old[i];                       //旧数组拷贝到新数组中
        }
    }
    /**
     * 添加新元素，尾插
     **/
    public boolean add(T x){
        add(size(),x);
        return true;
    }

    /**
     * 添加新元素列表头部，头插
     **/
    public boolean addHead(T x){
        add(0,x);
        return true;
    }
    /**
     * 插入新元素到指定位置
     **/
    public void add(int idx,T x){
        if (theItems.length == size())          //判断元素个数是否和数组容量相等，相等则扩容
            ensureCapacity(size()*2+1);
        for (int i=theSize;i>idx;i--)                   //从最后一个元素开始往后移动元素，直到要插入的位置停止
            theItems[i]=theItems[i-1];
        theItems[idx] = x;         //将空出来的位置插入新元素
        theSize++;                  //元素个数++
    }

    /**
     * 移除指定位置的元素，并返回该元素
     **/
    public T remove(int idx)
    {
        T removedItem = theItems[idx];          //获得该元素
        for (int i = idx;i<size()-1;i++)        //从idx+1的元素开始将后面的元素前移一个位置
            theItems[i]=theItems[i+1];
        theSize--;                       //总元素个数--
        return removedItem;
    }

    /**
     * 从列表尾部删除元素
     **/
    public T removeFromTail()
    {
        return remove(size()-1);
    }

    private void fastRemove(int index) {
        int numMoved = theSize - index - 1;
        if (numMoved > 0)
            System.arraycopy(theItems, index+1, theItems, index,
                    numMoved);
        theItems[--theSize] = null; // clear to let GC do its work
    }

    /**
     * 删除指定值的元素
     **/
    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size(); index++)
                if (theItems[index] == null) {
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size(); index++)
                if (o.equals(theItems[index])) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }


    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size(); i++)
                if (theItems[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size(); i++)
                if (o.equals(theItems[i]))
                    return i;
        }
        return -1;
    }

    /**
     * 判断列表中是否包含某个值
     **/
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public Iterator<T> iterator(){
        return new ArrayListIterator();
    }

    /**
     * 内部类实现Iterator接口
     **/
    public class ArrayListIterator implements Iterator<T>{

        private int current = 0;        //迭代初始位置为0
        @Override
        public boolean hasNext() {
            return current<size();
        }
        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return theItems[current++];
        }
        @Override
        public void remove() {
            CustomGenericList.this.remove(--current);
        }
    }

//    /**
//     * 添加新元素列表头部
//     * **/
//    public void addHead(T value) {
//        add(0, value);
//    }
//    /**
//    插入新元素到指定位置
//    **/
//    public void add(int index, T value) {
//
//        genericList.add(index, value);
//    }
//    /**
//     *  从列表尾部删除元素
//     * **/
//    public  T removeFromTail(T value) {
//        return remove(0);
//    }
//    /**
//     * 删除指定值的元素
//     * **/
//    public boolean remove(T value) {
//        return genericList.remove(value);
//    }
//    /**
//     *删除指定位置上元素
//     * **/
//    public T remove(int index) {
//        return genericList.remove(index);
//    }




}
