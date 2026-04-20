package clases;

import java.util.ArrayList;

public class Lista {
    public static void main(String[] args) {
        ArrayList lista = new ArrayList();

        lista.add(1);
        lista.add(2);
        lista.add(0);
        lista.add(30);
        lista.add(3);

        for (int i = 0; i<lista.size();i++) {
            System.out.println(lista.get(i));
        }
    }
}
