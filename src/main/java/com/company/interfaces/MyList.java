package com.company.interfaces;

import java.util.Collection;

public interface MyList<T> {

    public boolean isEmpty();

    public void clear();

    public int size();

    public Object remove(int index);

    public Object remove(T removableObject);

    public void sort();

    public void add(T newElement);

    public Object getFirst();

    public void insert(int index, T newElement);

    public void addAll(Collection<T> newElements);

    public void addAll(T[] newElements);

    public Object get(int index);

    public boolean contains(T element);

    public Object[] toArray();
}
