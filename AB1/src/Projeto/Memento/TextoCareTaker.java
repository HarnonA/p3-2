package Projeto.Memento;


import java.util.LinkedList;

public class TextoCareTaker {
    protected LinkedList<TextoMemento> estados;
 
    public TextoCareTaker() {
        estados = new LinkedList<TextoMemento>();
    }
 
    public void adicionarMemento(TextoMemento memento) {
        estados.add(memento);
        
    }
 
    public TextoMemento getUltimoEstadoSalvo() {
        if (estados.size() <= 0) {
            return new TextoMemento("");
        }
        TextoMemento estadoSalvo = estados.get(estados.size() - 1);
        estados.remove(estados.size() - 1);
        return estadoSalvo;
    }
}