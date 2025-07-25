/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.4.0
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.herumi.mcl;

public class GTVector extends java.util.AbstractList<GT> implements java.util.RandomAccess {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected GTVector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(GTVector obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(GTVector obj) {
    long ptr = 0;
    if (obj != null) {
      if (!obj.swigCMemOwn)
        throw new RuntimeException("Cannot release ownership as memory is not owned");
      ptr = obj.swigCPtr;
      obj.swigCMemOwn = false;
      obj.delete();
    }
    return ptr;
  }

  @SuppressWarnings({"deprecation", "removal"})
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        MclJNI.delete_GTVector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  @SuppressWarnings("this-escape")
  public GTVector(GT[] initialElements) {
    this();
    doReserve(initialElements.length);

    for (GT element : initialElements) {
      doAdd(element);
    }
  }

  @SuppressWarnings("this-escape")
  public GTVector(Iterable<GT> initialElements) {
    this();
    for (GT element : initialElements) {
      doAdd(element);
    }
  }

  public GT get(int index) {
    return doGet(index);
  }

  public GT set(int index, GT e) {
    return doSet(index, e);
  }

  public boolean add(GT e) {
    modCount++;
    doAdd(e);
    return true;
  }

  public void add(int index, GT e) {
    modCount++;
    doAdd(index, e);
  }

  public GT remove(int index) {
    modCount++;
    return doRemove(index);
  }

  protected void removeRange(int fromIndex, int toIndex) {
    modCount++;
    doRemoveRange(fromIndex, toIndex);
  }

  public int size() {
    return doSize();
  }

  public int capacity() {
    return doCapacity();
  }

  public void reserve(int n) {
    doReserve(n);
  }

  public GTVector() {
    this(MclJNI.new_GTVector__SWIG_0(), true);
  }

  public GTVector(GTVector other) {
    this(MclJNI.new_GTVector__SWIG_1(GTVector.getCPtr(other), other), true);
  }

  public boolean isEmpty() {
    return MclJNI.GTVector_isEmpty(swigCPtr, this);
  }

  public void clear() {
    MclJNI.GTVector_clear(swigCPtr, this);
  }

  public GTVector(int count, GT value) {
    this(MclJNI.new_GTVector__SWIG_2(count, GT.getCPtr(value), value), true);
  }

  private int doCapacity() {
    return MclJNI.GTVector_doCapacity(swigCPtr, this);
  }

  private void doReserve(int n) {
    MclJNI.GTVector_doReserve(swigCPtr, this, n);
  }

  private int doSize() {
    return MclJNI.GTVector_doSize(swigCPtr, this);
  }

  private void doAdd(GT x) {
    MclJNI.GTVector_doAdd__SWIG_0(swigCPtr, this, GT.getCPtr(x), x);
  }

  private void doAdd(int index, GT x) {
    MclJNI.GTVector_doAdd__SWIG_1(swigCPtr, this, index, GT.getCPtr(x), x);
  }

  private GT doRemove(int index) {
    return new GT(MclJNI.GTVector_doRemove(swigCPtr, this, index), true);
  }

  private GT doGet(int index) {
    return new GT(MclJNI.GTVector_doGet(swigCPtr, this, index), false);
  }

  private GT doSet(int index, GT val) {
    return new GT(MclJNI.GTVector_doSet(swigCPtr, this, index, GT.getCPtr(val), val), true);
  }

  private void doRemoveRange(int fromIndex, int toIndex) {
    MclJNI.GTVector_doRemoveRange(swigCPtr, this, fromIndex, toIndex);
  }

}
