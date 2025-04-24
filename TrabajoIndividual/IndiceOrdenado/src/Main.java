import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        ArrayList <Persona> listaPersonas = new ArrayList<>();
        
        Persona p1 = new Persona("Jorge",22);
        Persona p2 = new Persona("Ana",25);
        Persona p3 = new Persona("Ramiro",22);

        listaPersonas.add(p1);
        listaPersonas.add(p2);
        listaPersonas.add(p3);
        
        Collections.sort(listaPersonas);
        for (Persona persona : listaPersonas) {
            System.out.println(persona.toString());
        }   
        Collections.sort(listaPersonas,new ComparadorNombres());
        for (Persona persona : listaPersonas) {
            System.out.println(persona.toString());
        }  
        
        TreeSet <Persona> personas = new TreeSet<>();

        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        

        for (Persona persona : personas) {
            System.out.println(persona.toString());
        }
     }
}
