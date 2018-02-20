package edu.bicheva.codewars.compiler;

/**
 * @author Yulia Bycheva
 **/
public class UnOp implements Ast{

    private int i;
    private String type;

    public UnOp(String type, int i) {
        this.type = type;
        this.i = i;
    }

    @Override
    public String toString() {
        return "UnOp{" +
                "i=" + i +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public String op() {
        return type;
    }

    public int n() {
        return i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnOp unOp = (UnOp) o;

        if (i != unOp.i) return false;
        return type != null ? type.equals(unOp.type) : unOp.type == null;
    }

    @Override
    public int hashCode() {
        int result = i;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
