package Model;

public class Client {
 private int idClient;
 private String nom;



 private static int idcltcpt = 0;

    public Client() {

    }
    public Client(String nom) {

    this.idClient = idcltcpt++;
    this.nom = nom;

    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }





    @Override
     public String toString() {
          return
                 "-idClient=" + idClient + "     "+
                 "-nom='" + nom + '\''

                 ;
     }

        @Override
     public boolean equals(Object o) {
         if (this == o) {
          return true;
         } else return false;
        }

}
