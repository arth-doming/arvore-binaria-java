public class Node{
    private int  info;
    private Node esquerda;
    private Node direita;

    public Node(int info, Node esquerda, Node direita){
        this.info = info;
        this.esquerda = esquerda;
        this.direita = direita;
    }

    public int getInfo() { return info; }
    public Node getEsquerda() { return esquerda; }
    public Node getDireita() { return direita; }
}
public class Arvore_Binaria{
    private Node raiz;

    public Arvore_Binaria(){
        this.raiz = null;
    }

    // funcao para inserir elemento
    public void inserir(int info){
        raiz = inserirNo(raiz, info);
    }
    private Node inserirNo(Node atual, int info){
        if(atual == null){
            return new Node(info, null, null );
        }
        if (info < atual.info){
            atual.esquerda = inserirNo(atual.esquerda, info);
        }
        if(info >= atual.info){
            atual.direita = inserirNo(atual.direita, info);
        }
        return atual;
    }
    //funcao buscar elemento
    public Node buscar(int info){
        Node atual = raiz;
        while(atual != null && atual.getInfo() != info){
            if(info < atual.info){
                atual = atual.getEsquerda();
            }
            else{
                atual = atual.getDireita();
            }
        }

        if(atual != null){
            System.out.println("Encontrado o elemento: " + atual.getInfo());
        }
        else{
            System.out.println("Elemento não encontrado");
        }
        return atual;
    }
// Criterio: menor elemento da subarvore direita (sucessor in-ordem).
    public void removeElemento(int elemento) {
        if (existe(elemento) == false) {
            System.out.println("Elemento nao encontrado: " + elemento);
            return;
        }
        raiz = remove(raiz, elemento);
        System.out.println("Removido: " + elemento);
    }

    private No remove(No no, int elemento) {
        if (no == null) {
            return null;
        }

        if (elemento < no.dado) {
            no.esquerda = remove(no.esquerda, elemento);
        } else if (elemento > no.dado) {
            no.direita = remove(no.direita, elemento);
        } else {
            // Achou o no a remover

            // Caso 1 e 2: nenhum filho ou um filho so
            if (no.esquerda == null) {
                return no.direita;
            }
            if (no.direita == null) {
                return no.esquerda;
            }

            // Caso 3: dois filhos
            // Copia o menor valor da subarvore direita para este no
            int substituto = menorValor(no.direita);
            no.dado = substituto;
            // e apaga o substituto da posicao antiga dele
            no.direita = remove(no.direita, substituto);
        }
        return no;
    }

}

void main() {
    Arvore_Binaria arvore = new Arvore_Binaria();

    arvore.inserir(10);
    arvore.inserir(20);
    arvore.inserir(5);

}