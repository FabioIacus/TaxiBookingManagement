package bd.model.domain;

public class RichiediCorsa {
    String IndPart;
    String IndDest;
    String CodFisc;

    public RichiediCorsa(String IndPart, String IndDest, String CodFisc) {
        this.IndPart = IndPart;
        this.IndDest = IndDest;
        this.CodFisc = CodFisc;
    }

    public String getIndPart() {
        return IndPart;
    }
    public String getIndDest() {
        return IndDest;
    }
    public String getCodFisc() {
        return CodFisc;
    }

}
