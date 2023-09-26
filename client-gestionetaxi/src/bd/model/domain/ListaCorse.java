package bd.model.domain;

import java.util.ArrayList;
import java.util.List;

public class ListaCorse {
    List<Corse> corse = new ArrayList<>();
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Corse corsa:corse) {
            sb.append("Codice: ").append(corsa.getCodice()).append(", Indirizzo partenza: ").append(corsa.getIndPartenza()).append(", Indirizzo destinazione : ").append(corsa.getIndDestinazione()).append(" \n");
        }
        return sb.toString();
    }
    public void addCorse(Corse c){
        this.corse.add(c);
    }
}
