package org.gabz;

public class No<T> {
    private T valor;
    private No<T> proximoNo;

    public No() {
        this.proximoNo = null;
    }

    public No(T valor) {
        this.proximoNo = null;
        this.valor = valor;
    }

    public No(T valor, No<T> proximoNo) {
        this.proximoNo = proximoNo;
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No<T> getProximoNo() {
        return proximoNo;
    }

    public void setProximoNo(No<T> proximoNo) {
        this.proximoNo = proximoNo;
    }

    @Override
    public String toString() {
        return "No{" +
                "valor=" + valor +
                '}';
    }

}
