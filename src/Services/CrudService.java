package Services;

import Model.Banque;
import Model.Client;
import Model.Compte;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CrudService {
    private Banque banque;

    private ArrayList<Compte> compte;

    public CrudService(Banque _banque) {
        this.banque = _banque;
    }

    public Client createClient() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nom du client");
        String nom = sc.nextLine();

        Client client = new Client(nom);

        return client;
    }




    public void createCompte() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le solde du compte");
        double solde = sc.nextDouble();
        System.out.println("Entrer la date de creation client");
        LocalDate datecreation = LocalDate.parse(sc.next());
        Client client =createClient();
        Compte compte = new Compte(solde,datecreation,client);

    }






    public boolean lierCompteAuClient(int idClient , int idCompte) {
        for (int i = 0; i < banque.getClients().size(); i++) {
            if (banque.getClients().get(i).getIdClient() == idClient) {
for (int j = 0; j < banque.getComptes().size(); j++) {
                    if (banque.getComptes().get(j).getClient().getIdClient() <=2 ) {
                        System.out.println("le client peut avoir un deuxieme compte");
                       return true;
                    }
                    else {
                        System.out.println("le client a deja 2 compte");
                        return false;
                    }
                }

                }
            }

           return false;
        }

public Compte chercherCompte(Scanner clavier) {
    System.out.println("Entrer l'id du client");
    int idCompte = clavier.nextInt();
        for (int i = 0; i < banque.getComptes().size(); i++) {
            if (banque.getComptes().get(i).getIdCompte() == idCompte) {
                return banque.getComptes().get(i);
            }
        }
        return null;
    }

    public Client chercherClient(Scanner clavier) {
        System.out.println("Entrer l'id du client");
        int idClient = clavier.nextInt();
        for (int i = 0; i < banque.getClients().size(); i++) {
            if (banque.getClients().get(i).getIdClient() == idClient) {
                return banque.getClients().get(i);
            }
        }
        return null;
    }

    public void consulterDetailCompte(Scanner clavier) {


        Compte compte = chercherCompte(clavier);
        if (compte != null) {
            System.out.println("le solde du compte est " + compte.getSolde());
            System.out.println("la date de creation du compte est " + compte.getDateCreation());
            System.out.println("le client du compte est " + compte.getClient().getNom());
        } else {
            System.out.println("le compte n'existe pas");
        }
    }
    public void consulteDetailClient(Scanner clavier) {
        Client client = chercherClient(clavier);
        if (client != null) {
            System.out.println("le nom du client est " + client.getNom());

        } else {
            System.out.println("le client n'existe pas");
        }
    }

    public void modifierClient(Scanner clavier) {
        Client client = chercherClient(clavier);
        if (client != null) {
            System.out.println("Entrer le nouveau nom du client");
            String nom = clavier.next();
            client.setNom(nom);
        } else {
            System.out.println("le client n'existe pas");
        }
    }

    public void modifierCompte(Scanner clavier) {
        Compte compte = chercherCompte(clavier);
        if (compte != null) {
            System.out.println("Entrer le nouveau solde du compte");
            double solde = clavier.nextDouble();
            compte.setSolde(solde);
        } else {
            System.out.println("le compte n'existe pas");
        }
    }

    public void supprimerClient(Scanner clavier) {
        Client client = chercherClient(clavier);
        if (client != null) {
            banque.getClients().remove(client);
        } else {
            System.out.println("le client n'existe pas");
        }
    }

    public void supprimerCompte(Scanner clavier) {
        Compte compte = chercherCompte(clavier);
        if (compte != null) {
            banque.getComptes().remove(compte);
        } else {
            System.out.println("le compte n'existe pas");
        }
    }
}

