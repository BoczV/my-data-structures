package com.company.interfaces;

public interface MyList<T> {

    public boolean isEmpty();

    public void clear();

    public int size();

    public Object remove(int index);

    public Object remove(T removableObject);

}
