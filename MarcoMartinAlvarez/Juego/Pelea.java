package Juego;

import clases.MyScanner;

import java.util.Scanner;

public class Pelea {
    Personaje personaje = new Personaje();
    MyScanner sc = new MyScanner();
    Personaje pj1 = new Personaje(1000, 100, 200);
    Personaje pj2 = new Personaje(1000, 100, 200);

    public Pelea() {
    }
    public void opcionesPelea (){

        System.out.println("Que va a hacer el pj1: ");
        System.out.println("1. Atacar");
        System.out.println("2. Defender");
        int opcion1 = sc.pedirNumero("Opción: ");
        if (opcion1 < 1 || opcion1 > 2) {
            System.out.println("OPCION NO VALIDA, INTENTA DE NUEVO");
            opcionesPelea();}
        System.out.println("Que va a hacer el pj2: ");
        System.out.println("1. Atacar");
        System.out.println("2. Defender");
        int opcion2 = sc.pedirNumero("Opcion: ");
        if (opcion2 < 1 || opcion2 > 2) {
            System.out.println("OPCION NO VALIDA, INTENTA DE NUEVO");
            opcionesPelea();
        }
        if (opcion1 == 1 && opcion2 == 2) {
            System.out.println("PJ1 ATACA Y PJ2 DEFIENDE");
            int ataque = pj1.getAtaque();
            int defensa = pj2.getDefensa();
            pj2.setDefensa(defensa - ataque);
            if (pj2.getDefensa() ==0) {
                pj2.setVida(pj2.getVida()-ataque);
            }
        } else if (opcion1 == 2 && opcion2 == 1) {
            System.out.println(" PJ2 ATACA Y PJ1 DEFIENDE");
            int ataque = pj2.getAtaque();
            int defensa = pj1.getDefensa();
            pj1.setDefensa(defensa - ataque);
            if (pj1.getDefensa() ==0) {
                pj1.setVida(pj1.getVida()-ataque);
            }
        } else if (opcion1 == 1 && opcion2 == 1) {
            System.out.println("AMBOS ATACAN");
            int vida1 =  pj2.getVida();
            int ataque1 = pj1.getAtaque();
            pj2.setVida(vida1 - ataque1);
            int vida2 =  pj1.getVida();
            int ataque2 = pj2.getAtaque();
            pj1.setVida(vida2 - ataque2);
        } else if (opcion1==2 && opcion2==2) {
            System.out.println("Se miran super intensamente, se enamoran, pero recuerdan que estan peleando y pasan al siguiente turno");
        }
    }
public void iniciarPelea(){

        Scanner sc=new Scanner(System.in);

            for (int numeroDeTurno=1; numeroDeTurno<=20; numeroDeTurno++){
            opcionesPelea();
            System.out.println("Turno: "+numeroDeTurno+" \n"+"Pj1: " +
                    "-----Ataque: "+pj1.getAtaque()+"-----\n"+
                    "-----Defensa: "+pj1.getDefensa()+"-----\n"+
                    "-----Vida: "+pj1.getVida()+"-----\n"+
                    "Pj2: " +
                    "-----Ataque: "+pj2.getAtaque()+"-----\n"+
                    "-----Defensa: "+pj2.getDefensa()+"-----\n"+
                    "-----Vida: "+pj2.getVida()+"-----\n");

                if(pj1.getVida()==0 && pj2.getVida()>0){
                    System.out.println("El personaje 1 ha muerto trágicamente, VICTORIA DEL PERSONAJE 2");
                    break;
                } else if (pj2.getVida()==0 && pj1.getVida()>0) {
                    System.out.println("El personaje 2 ha muerto trágicamente, VICTORIA DEL PERSONAJE 1");
                    break;
                } else if (numeroDeTurno==20 && pj1.getVida()>0 && pj2.getVida()>0) {
                    if (pj1.getVida()>pj2.getVida()) {
                        System.out.println(" PJ 1 HA GANADO");
                        break;

                    } else if (pj2.getVida()>pj1.getVida()) {
                        System.out.println(" PJ 2 HA GANADO");
                        break;
                    } else if (pj1.getVida()== pj2.getVida()){
                        System.out.println("EMPATE, QUE ABURRIDOS SOIS");
                        break;
                    }
                }
        }
    }

}

