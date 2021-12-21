package kr.or.artsuwon.common;

/**
 * Tuple class
 * @param <T> Left type
 * @param <E> Right type
 * @author 신현진
 */
public class Tuple<T, E> {
    /// FIELDs
	private T valueLeft;
    private E valueRight;

    /// CONSTRUCTORs
    public Tuple(T valueLeft, E valueRight) {
        this.valueLeft = valueLeft;
        this.valueRight = valueRight;
    }

    /// GETTERs
    public T getValueLeft() { return valueLeft; }
    public E getValueRight() { return valueRight; }
    /// SETTERs
    public void setValueLeft(T valueLeft) { this.valueLeft = valueLeft; }
    public void setValueRight(E valueRight) { this.valueRight = valueRight; }
}
