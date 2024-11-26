package org.gabz;

public class NoDuplo<T> {
    private T valor;
    private NoDuplo<T> proximoNo;
    private NoDuplo<T> noAnterior;

    public NoDuplo(T valor) {
        this.valor = valor;
        proximoNo = null;
        noAnterior = null;
    }

    public NoDuplo<T> getProximoNo() {
        return proximoNo;
    }

    public void setProximoNo(NoDuplo<T> proximoNo) {
        this.proximoNo = proximoNo;
    }

    public NoDuplo<T> getNoAnterior() {
        return noAnterior;
    }

    public void setNoAnterior(NoDuplo<T> noAnterior) {
        this.noAnterior = noAnterior;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "NoDuplo{" +
                "valor=" + valor +
                '}';
    }
}
