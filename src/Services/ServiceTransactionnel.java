package Services;

import Model.Banque;

public class ServiceTransactionnel {
    private Banque banque;

    public ServiceTransactionnel(Banque _banque) {
        this.banque = _banque;
    }

    public void verser(int idCompte, double montant) {
        this.banque.getComptes().get(idCompte).setSolde(this.banque.getComptes().get(idCompte).getSolde() + montant);
        this.banque.getComptes().get(idCompte).getJournalisation().add("verser le " + this.banque.getComptes().get(idCompte).getDateCreation() + " montant " + montant);
    }

    public void retirer(int idCompte, double montant) {
        if(montant > 0){
            if (montant<=this.banque.getComptes().get(idCompte).getSolde()) {
                this.banque.getComptes().get(idCompte).setSolde(this.banque.getComptes().get(idCompte).getSolde() - montant);
                this.banque.getComptes().get(idCompte).getJournalisation().add(" le  montant retiré " + montant);
            }else {
                System.out.println("le solde est insuffisant");
            }
        }else {
            System.out.println("le montant doit etre superieur a 0");
        }
    }

    public void virement(int idCompte1, int idCompte2, double montant) {
        if(montant > 0){
            if (this.banque.getComptes().get(idCompte1).getSolde() >= montant) {
                this.banque.getComptes().get(idCompte1).setSolde(this.banque.getComptes().get(idCompte1).getSolde() - montant);
                this.banque.getComptes().get(idCompte2).setSolde(this.banque.getComptes().get(idCompte2).getSolde() + montant);
                this.banque.getComptes().get(idCompte1).getJournalisation().add("virement de ce montant " + montant + " vers le compte " + this.banque.getComptes().get(idCompte2).getIdCompte());
                this.banque.getComptes().get(idCompte2).getJournalisation().add("virement de ce montant " + montant + " depuis le compte " + this.banque.getComptes().get(idCompte1).getIdCompte());
            } else {
                System.out.println("le solde du compte " + this.banque.getComptes().get(idCompte1).getIdCompte() + " est insuffisant");
            }
        } else {
            System.out.println("le montant doit etre superieur a 0");
        }

    }


}
