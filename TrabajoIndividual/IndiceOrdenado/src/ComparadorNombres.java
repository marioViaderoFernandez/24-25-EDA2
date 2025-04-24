import java.util.Comparator;

public class ComparadorNombres implements Comparator<Persona>{

    public int compare(Persona o1, Persona o2) {
        int resultado;
        if(o1.getEdad()>o2.getEdad()){
            resultado = -1;
        }else if(o1.getEdad()<o2.getEdad()){
            resultado = 1;
        }else{
            resultado = o1.getNombre().compareTo(o2.getNombre());
        }
        return resultado;
    }
}
