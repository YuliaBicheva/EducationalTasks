package edu.bicheva.codewars.compiler;

/**
 * @author Yulia Bycheva
 **/
public class BinOp implements Ast {

    private String operand;
    private Ast binOp1;
    private Ast binOp2;

    public static void main(String[] args) {
        BinOp binOp = new BinOp("+", new UnOp("imm", 2), new UnOp("imm", 3));
        String operand = binOp.operand;
    }



    public BinOp(String operand, Ast binOp1, Ast binOp2) {
        this.operand = operand;
        this.binOp1 = binOp1;
        this.binOp2 = binOp2;
    }

    @Override
    public String toString() {
        return "BinOp{" +
                "operand='" + operand + '\'' +
                ", binOp1=" + binOp1 +
                ", binOp2=" + binOp2 +
                '}';
    }

    public Ast a() {
        return binOp1;
    }

    public Ast b() {
        return binOp1;
    }


    @Override
    public String op() {
        return operand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BinOp binOp = (BinOp) o;

        if (operand != null ? !operand.equals(binOp.operand) : binOp.operand != null) return false;
        if (binOp1 != null ? !binOp1.equals(binOp.binOp1) : binOp.binOp1 != null) return false;
        return binOp2 != null ? binOp2.equals(binOp.binOp2) : binOp.binOp2 == null;
    }

    @Override
    public int hashCode() {
        int result = operand != null ? operand.hashCode() : 0;
        result = 31 * result + (binOp1 != null ? binOp1.hashCode() : 0);
        result = 31 * result + (binOp2 != null ? binOp2.hashCode() : 0);
        return result;
    }
}
