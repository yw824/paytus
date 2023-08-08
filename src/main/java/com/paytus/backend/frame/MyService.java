package com.paytus.backend.frame;

import javax.transaction.Transactional;
import java.util.List;

public interface MyService<K, V> {

    @Transactional
    public void register(V v) throws Exception;

    @Transactional
    public void remove(K k) throws Exception;

    @Transactional
    public void modify(V v) throws Exception;

    @Transactional
    public V get(K k) throws Exception;

    @Transactional
    public List<V> get() throws Exception;

}
