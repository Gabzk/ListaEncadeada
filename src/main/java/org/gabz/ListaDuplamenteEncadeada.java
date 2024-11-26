package org.gabz;

public class ListaDuplamenteEncadeada<T> {
    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;
    private int tamanhoLista;

    public ListaDuplamenteEncadeada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        tamanhoLista = 0;
    }

    public int size() {
      return tamanhoLista;
    }

    public T get(int index) {
        return getNo(index).getValor();
    }

    public void add(T valor) {
        NoDuplo<T> novoNo = new NoDuplo<>(valor);

        if (primeiroNo == null) {
            primeiroNo = novoNo;
            ultimoNo = novoNo;

        } else {
            ultimoNo.setProximoNo(novoNo);
            novoNo.setNoAnterior(ultimoNo);
            ultimoNo = novoNo;
        }

        tamanhoLista++;
    }

    public void add(T valor, int index) {
        validaIndice(index);

        NoDuplo<T> novoNo = new NoDuplo<>(valor);
        if(index == 0) {
            if (primeiroNo == null) {
                primeiroNo = novoNo;
                ultimoNo = novoNo;
            } else {
                novoNo.setProximoNo(primeiroNo);
                primeiroNo.setNoAnterior(novoNo);
                primeiroNo = novoNo;
            }
        } else if (index == tamanhoLista) {
            ultimoNo.setProximoNo(novoNo);
            novoNo.setNoAnterior(ultimoNo);
            ultimoNo = novoNo;
        } else {
            NoDuplo<T> noAuxiliar = getNo(index);

            noAuxiliar.getNoAnterior().setProximoNo(novoNo); // Nó anterior aponta pro novo
            novoNo.setNoAnterior(noAuxiliar.getNoAnterior()); // Novo Nó aponta pro no Anterior
            novoNo.setProximoNo(noAuxiliar);
            noAuxiliar.setNoAnterior(novoNo);

        }

        tamanhoLista++;
    }

    public void remove(int index) {
        validaIndice(index); // Verifica se o índice é válido
        NoDuplo<T> noAlvo = getNo(index); // Localiza o nó a ser removido

        if (index == 0) { // Remoção do primeiro nó
            primeiroNo = noAlvo.getProximoNo(); // Atualiza o primeiro nó
            if (primeiroNo != null) { // Se a lista não ficar vazia
                primeiroNo.setNoAnterior(null);
            } else { // Se a lista ficou vazia
                ultimoNo = null;
            }
        } else if (index == tamanhoLista - 1) { // Remoção do último nó
            ultimoNo = noAlvo.getNoAnterior(); // Atualiza o último nó
            if (ultimoNo != null) { // Se ainda existir um último nó
                ultimoNo.setProximoNo(null);
            } else { // Se a lista ficou vazia
                primeiroNo = null;
            }
        } else { // Remoção no meio da lista
            noAlvo.getNoAnterior().setProximoNo(noAlvo.getProximoNo());
            noAlvo.getProximoNo().setNoAnterior(noAlvo.getNoAnterior());
        }

        // Limpa as referências do nó removido (opcional)
        noAlvo.setProximoNo(null);
        noAlvo.setNoAnterior(null);

        tamanhoLista--; // Atualiza o tamanho da lista
    }


    private NoDuplo<T> getNo(int index) {
        validaIndice(index);
        NoDuplo<T> noAuxiliar = primeiroNo;
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
