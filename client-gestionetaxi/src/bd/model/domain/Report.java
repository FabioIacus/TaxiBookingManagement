package bd.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Report {
    List<Commissioni> commissioni = new ArrayList<>();
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Commissioni commissione:commissioni) {
            sb.append("Patente: ").append(commissione.getPatente()).append(", Numero di corse accettate: ").append(commissione.getNumCorse()).append(", Importo complessivo guadagnato: ").append(commissione.getImporto()).append(", Importo complessivo commissione: ").append(commissione.getCommissione()).append(" \n");
        }
        return sb.toString();
    }

    public void addCommissioni(Commissioni c){
        this.commissioni.add(c);
    }

}
