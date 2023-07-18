package fila;

public class No <T> {

    private T object;
    private No<T> refNo;

    public No() {
    }

    public No(T object) {
        this.object = object;
        this.refNo = null;               //O ref Nó do primeiro da fila é null.
    }

    public Object getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public No<T> getRefNo() {
        return refNo;
    }

    public void setRefNo(No refNo) {
        this.refNo = refNo;
    }

    @Override
    public String toString() {           //toString somente do objeto
        return "No{" +
                "object=" + object +
                '}';
    }

}
