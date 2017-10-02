package com.nab.mayco.repository;

import java.io.Serializable;
import java.util.List;

public interface Repository<PK extends Serializable, E> {

  public List<E> list();

  public void add(E e);

  public E delete(E e);


}
