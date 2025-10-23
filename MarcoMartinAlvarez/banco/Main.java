package Banco;

import excepcion.Pobreza;

public class Main {
    public static void main(String[] args) throws Pobreza {
        FuncBanco banquito=new FuncBanco();

        banquito.usuario();
        banquito.menu();
    }
}
