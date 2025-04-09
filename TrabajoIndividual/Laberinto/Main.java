public class Main {
    public static void main(String[] args) {
     Laberinto laberinto = new Laberinto();
     laberinto.mostrarLaberinto();
 
     if(laberinto.resolver()){
         System.out.println("Encontraste la salida");
     }else{
         System.out.println("No hay salida posible");
     }
    } 
 }
 