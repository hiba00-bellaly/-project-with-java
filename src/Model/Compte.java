package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Compte {

    private static int Cpt=0;
    private  int idCompte;
    private double solde;
    private LocalDate DateCreation;
    private ArrayList<String> journalisation;
    private Client client;



    public Compte(double solde, LocalDate dateCreation, Client client) {
        this.idCompte =Cpt++;
        this.solde = solde;
        this.DateCreation = dateCreation;
        this.journalisation =new ArrayList<String>() ;
        this.client=client;
        this.journalisation.add("Creer le "+this.DateCreation);
        if (solde > 0) {
            this.journalisation.add("le solde est " + this.solde);
        } else {
            System.out.println("le sold doit etre superieur a 0");
        }

    }



    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void setDateCreation(LocalDate dateCreation) {
        DateCreation = dateCreation;
    }


    public int getIdCompte() {
        return idCompte;
    }

    public double getSolde() {
        return solde;
    }

    public LocalDate getDateCreation() {
        return DateCreation;
    }

    public  Client getClient() {
        return client;
    }



    /**
     * @return
     */
    @Override
    public String toString() {
        return
                "-idCompte=" + idCompte +"       "+
                "-solde=" + solde + "        "+
                "-DateCreation=" + DateCreation
                ;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        else  return false;
          }


    public ArrayList getJournalisation() {
        return journalisation;
    }
}