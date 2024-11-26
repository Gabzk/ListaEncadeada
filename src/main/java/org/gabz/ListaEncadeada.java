package org.gabz;

public class ListaEncadeada<T> {
    private No<T> noReferencia;
    private int tamanho;

    public ListaEncadeada () {
        noReferencia = null;
        tamanho = 0;
    }

    public void add(T valor) {
        No<T> novoNo = new No<>(valor);
        if (noReferencia == null) {
            noReferencia = novoNo;
            tamanho++;
            return;
        }

        No<T> noAuxilir = noReferencia;
        while(noAuxilir.getProximoNo() != null) {
            noAuxilir = noAuxilir.getProximoNo();
        }

        noAuxilir.setProximoNo(novoNo);
        tamanho ++;
    }

    public int size() {
        return tamanho;
    }

    public boolean isEmpty() {
        return noReferencia == null;
    }

    public T get(int index) {
        return getNo(index).getValor();
    }

    public T remove(int index) {
        validaIndice(index);
        No<T> noAlvo = getNo(index);

        if (index == 0) {
            noReferencia = noAlvo.getProximoNo();

        } else {
            No<T> noAnterior = getNo(index - 1);
            noAnterior.setProximoNo(noAlvo.getProximoNo());
        }
        tamanho--;
        return noAlvo.getValor();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        No<T> noAuxiliar = noReferencia;
        for (int i = 0; i < size(); i++) {
            str.append("No {Conteudo = ").append(noAuxiliar.getValor()).append("} ->\n");
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        str.append("null");
        return str.toString();
    }


    private No<T> getNo (int index) {
        validaIndice(index);

        No<T> noAuxiliar = noReferencia;

        for (int i = 0; i < index; i++) {
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        return noAuxiliar;
    }

    private void validaIndice(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Não existe conteúdo no índice " + index + " dessa lista. Essa lista vai " +
                    "apenas até o índíce " + (size() - 1));
        }
    }

}
