public class MyLinkedList<E> {
  private class Node {
    private E data;
    private Node next, prev;
    public Node(E n) {
      if (n == null) {
        throw new NullPointerException();
      }
      data = n;
      prev = null;
      next = null;
    }
    public Node(E n, Node next1, Node prev1) {
      if (n == null) {
        throw new NullPointerException();
      }
      data = n;
      next = next1;
      prev = prev1;
    }
    public Node next() {
      return next;
    }
    public Node prev() {
      return prev;
    }
    public void setNext(Node other) {
      next = other;
    }
    public void setPrev(Node other) {
      prev = other;
    }
    public E getData() {
      return data;
    }
    public E setData(E i) {
      E temp = data;
      data = i;
      return data;
    }
    public String toString(){
      return "" + data;
    }
  }

  private int size;
  private Node start,end;
  private Node currentN = start;
  public MyLinkedList() {
    size = 0;
    start = null;
    end = null;
  }

  public int size() {
    return size;
  }

  public boolean add(int value) {
    if (size == 0) {
      start = new Node(value);
      end = start;
    }
    else {
      Node add = new Node(value, null, end);
      end.setNext(add);
      end = add;
    }
    size += 1;
    return true;
  }

  public E get(int index) {
    if (index < 0 || index >= this.size()) {
      throw new NullPointerException("Invalid index");
    }
    Node current = start;
    for (int i = 0; i <= index; i++) {
      current = current.next();
    }

    return current.getData();
  }

  public E set(int index, E value) {
    if (index < 0 || index >= this.size()) {
      throw new NullPointerException("Invalid index");
    }
    for (int i = 0; i <= index; i++) {
      current = current.next();
    }
    E temp = current.getData();
    current.setData(value);
    return temp;
  }

  public boolean contains(E value) {
    Node current = start;
    while (current != null) {
      if (current.getData() == value) {
        return true;
      }
      current = current.next();
    }
    return false;
  }

  public void add(int index, E value) {
    Node current = start;
    for (int i = 0; i < index; i++) {
      current = current.next();
    }
    if (index < 0 || current.getData() == null) {
      throw new NullPointerException("Invalid index");
    }
      Node n = new Node(value, current, current.prev());
      current.prev().setNext(n);
      current.setPrev(n);
      size += 1;
  }

  public E remove(int index) {
    Node current = start;
    for (int i = 0; i <= index; i++) {
      current = current.next();
    }
    if (index < 0 || current.getData() == null) {
      throw new NullPointerException("Invalid index");
    }
    Node n = current.next();
    Node p = current.prev();
    n.setPrev(p);
    p.setNext(n);
    size -= 1;
    return current.getData();
  }

  public boolean remove(E value) {
    Node current = start;
    while (current != null) {
      if (current.getData() == value) {
        Node n = current.next();
        Node p = current.prev();
        n.setPrev(p);
        p.setNext(n);
        size -= 1;
        return true;
      }
      current = current.next();
    }
    return false;
  }

  public String toString() {
    String str = "[";
    Node current = start;
    while (current != null) {
      str += current.getData() + ", ";
      current = current.next();
    }
    return str + "]";
  }

  public void clear() {
    start = null;
    end = null;
    size = 0;
  }


  public MyLinkedList conjoin(MyLinkedList data) {
    if (this.size() == 0) {
      start = data.start;
      end = data.end;
      size = data.size();
    } if (data.start != null) {
      end.setNext(data.start);
      data.start.setPrev(end);
      end = data.end;
      size = size() + data.size();
    }
  }
}
