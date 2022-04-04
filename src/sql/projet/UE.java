package sql.projet;

public class UE {

    public UE() {
    }

    ;

    public UE(String intitule, int credit, int semestre) {
        this.intitule = intitule;
        this.credit = credit;
        this.semestre = semestre;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    String intitule;
    int credit, semestre;

}
