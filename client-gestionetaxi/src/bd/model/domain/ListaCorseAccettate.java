package bd.model.domain;

import java.util.ArrayList;
import java.util.List;

public class ListaCorseAccettate {
    List<CorseAccettate> corseAccettate = new ArrayList<>();
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(CorseAccettate corsaAccettata:corseAccettate) {
            sb.append("Codice: ").append(corsaAccettata.getCodice()).append(", Importo: ").append(corsaAccettata.getImporto()).append(", Commissione: ").append(corsaAccettata.getCommissione()).append(" \n");
        }
        return sb.toString();
    }
    public void addCorseAccettate(CorseAccettate c){
        this.corseAccettate.add(c);
    }
}
