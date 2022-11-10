package Model;

import java.util.ArrayList;

public class Banque {



        private int idBanque;
        private String nomAgence;
        private String emailAgence;
        private int maxComptes;
        private int maxClients;
        private ArrayList<Compte> comptes;
        private ArrayList<Client> clients;
        private static int cptBanque=0;

        public Banque(String nomAgence, String emailAgence, int maxComptes, int maxClients) {
            this.idBanque = cptBanque++;
            this.nomAgence = nomAgence;
           if (emailAgence.contains("@") && emailAgence.contains(".")){
               this.emailAgence = emailAgence;
              }else {
               System.out.println("email non valide");
           }

            this.maxComptes = maxComptes;
            this.maxClients = maxClients;
            this.comptes = new ArrayList<Compte>(maxComptes);
            this.clients = new ArrayList<Client>(maxClients);
        }

        public int getIdBanque() {
            return idBanque;
        }

        public void setIdBanque(int idBanque) {
             this.idBanque = idBanque;
        }

        public String getNomAgence() {
            return nomAgence;
        }

        public void setNomAgence(String nomAgence) {
            this.nomAgence = nomAgence;
        }

        public String getEmailAgence() {
            return emailAgence;
        }

        public void setEmailAgence(String emailAgence) {
            this.emailAgence = emailAgence;
        }

        public int getMaxComptes() {
            return maxComptes;
        }

        public void setMaxComptes(int maxComptes) {
            this.maxComptes = maxComptes;
        }

        public int getMaxClients() {
            return maxClients;
        }

        public void setMaxClients(int maxClients) {
            this.maxClients = maxClients;
        }

        public ArrayList<Compte> getComptes() {
            return comptes;
        }

        public void setComptes(ArrayList<Compte> comptes) {
            this.comptes = comptes;
        }

        public ArrayList<Client> getClients() {
            return clients;
        }

        public void setClients(ArrayList<Client> clients) {
            this.clients = clients;
        }

          @Override
        public String toString() {
            return
                    "-idBanque=" + idBanque + "       "+
                    "-nomAgence='" + nomAgence + "        " +
                    "-emailAgence='" + emailAgence +"    " +
                    "- maxComptes=" + maxComptes + "    " +

                    "- maxClients=" + maxClients + "     " +
                            "- comptes=" + comptes +
                    "- clients=" + clients
                    ;
        }

        @Override

    public boolean equals(Object o) {
                if (this == o) return true;
                else   return false;

          }

    public void addClient(Client cl1) {
        if (clients.size() < maxClients) {
            clients.add(cl1);
        } else {
            System.out.println("nombre max de clients atteint");
        }
    }

    public void addCompte(Compte c1) {
        if (comptes.size() < maxComptes) {
            comptes.add(c1);
        } else {
            System.out.println("nombre max de comptes atteint");
        }
    }
}
