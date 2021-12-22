package kr.or.artsuwon.common;

/**
 * Tuple class
 * @param <T> Left type
 * @param <E> Right type
 * @author 신현진
 */
public class Tuple<T, E> {
    /// FIELDs
	private T first;
    private E second;

    /// CONSTRUCTORs
    public Tuple(T first, E second) {
        this.first = first;
        this.second = second;
    }

    /// GETTERs
    public T getFirst() { return first; }
    public E getSecond() { return second; }
    /// SETTERs
    public void setFirst(T first) { this.first = first; }
    public void setSecond(E second) { this.second = second; }
}
