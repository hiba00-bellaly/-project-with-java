package Controllers;

import Model.Client;
import Model.Compte;
import Model.Banque;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import Services.ServiceTransactionnel;
import Services.CrudService;

public class ProgramTest {

    public static void main(String[] args) {
        System.out.println("-----------------------clients---------------------------");
        Client C1 = new Client("hiba");
        System.out.println(C1.toString());
        Client C2 = new Client("hiba");
        System.out.println(C2.toString());


        Compte compte1 = new Compte(1000, LocalDate.now(), C1);
        System.out.println("---------------------------le compte1--------------------------------");
        System.out.println(compte1.toString());
        Compte compte2 = new Compte(2000, LocalDate.now(), C2);
        System.out.println("---------------------------le compte2--------------------------------");
        System.out.println(compte2.toString());



        Banque b1 = new Banque("Bmce","hiba@g.com",100,40 );
        b1.addClient(C1);
        b1.addClient(C2);
        b1.addCompte(compte1);
        b1.addCompte(compte2);

        System.out.println("---------------------------les banques--------------------------------");

        System.out.println(b1.toString());


        System.out.println("---------------------------test des Services--------------------------------");
        System.out.println("---------------------serviceCrud---------------");
        CrudService crudService = new CrudService(b1);
        //crudService.createCompte();
        crudService.lierCompteAuClient(1,1);
        System.out.println("-------------------servicetransactionel----------------");
        ServiceTransactionnel Servicetransactionnel = new ServiceTransactionnel(b1);
        System.out.println("---------------test retirer------------------------- ");
        System.out.println("-----------------avant-------------------------");
        System.out.println(compte1.toString());
        Servicetransactionnel.retirer(0,1000);
        System.out.println("------------apres-----------------------------");
        System.out.println(compte1.toString());
        System.out.println("-----------------------test virement------------------");
        Servicetransactionnel.virement(1,0,1000);
        System.out.println(compte1.toString());
        System.out.println(compte2.toString());

        System.out.println("----------------------test versement-------------------");
        Servicetransactionnel.verser(1,1000);
        System.out.println(compte1.toString());
        System.out.println(compte2.toString());



        }





    }
