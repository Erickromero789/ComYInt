import java.util.*;

public class Main {
   
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String cod;
        int n, acu1 = 0, acu2 = 0;
        double mayor = 0, menor = 0;
        double n1, n2, n3, notaf, suma = 0, prom = 0, rango, varianza = 0;
        
      
        List<String> lista = new ArrayList<>();
        //List<Double> notap = new ArrayList<>();
        double notap[]  = new double [10];
        double [] resultado = ordenarmayormenor(notap);
        for (double item:notap){
          System.out.print(item+" ");
        }
        //String [] codigos = new String [n];
        //List<String> listaNombres = Arrays.asList(codigos);
      
        System.out.println("\n**************************************");
        System.out.println("**********Calculo De Notas************");
        System.out.println("**************************************\n");

        do {
            System.out.print("Introduce Cantidad De Estudiantes A Registrar: ");
            n = sc.nextInt();  //n contiene el número de estudiantes
        } while (n <= 0); //repetir mientras que el valor de n sea <= 0

        for (int i = 1; i <= n; i++) {  // leemos el resto de notas desde el estudiante  2 hasta el estudiante n
            
            System.out.print("\n****Nota Codigo Del Estudiante Ejemplo (A0001): ");
            cod= sc.next(); // leemos la primera nota
                       
            System.out.print("\n*****Ingrese Notas del Estudiantes " + cod + "***** \n");

            do {
                System.out.print("Nota del Parcial: ");
                n1 = sc.nextDouble(); // leemos la primera nota         
            } while (n1 < 0.0 || n1 > 5.0);
            n1 = n1*0.5;

            do {
                System.out.print("Nota de Quices: ");
                n2 = sc.nextDouble(); // leemos la segunda nota
            } while (n2 < 0.0 || n2 > 5.0);
            n2 = n2*0.3;

            do {
                System.out.print("Nota de los Trabajos y Talleres: ");
                n3 = sc.nextDouble(); // leemos la tercera nota         
            } while (n3 < 0.0 || n3 > 5.0);
            n3 = n3*0.2;

            notaf = n1+n2+n3;
            notap.add(notaf);            
          
            suma = suma + notaf; // sumamos la nota al acumulador
            prom = suma/n;
            
            
             if (notaf > 2.9 ){  // Estudiantes que aprobaron la materia
              acu1 ++;
              System.out.printf("\n+ La Nota Final Es " +notaf+ "\n");
              System.out.print("\n+ El Estudiante A Aprobado\n");
            
            } else if (notaf < 3.0 ) {
              acu2 ++;
              System.out.printf("\n+ La Nota Final Es " +notaf+ "\n");
              System.out.print("\n+ El Estudiante A Desaprobado\n");

            }
          
             if (notaf == 5.0 ){  // Estudiantes que aprobaron la materia con nota = 5.0
                lista.add(cod);
            }
              
        }
        
        // Se Muestran los resultados
        System.out.printf("\n+ Aprobaron "+ acu1 + " Estudiante(s)\n");
        System.out.printf("\n+ Desaprobaron "+ acu2 + " Estudiante(s)\n");
        System.out.printf("\n+ Nota Promedio Del Curso: %.2f %n ", suma/n);
        //System.out.printf("\n+ Nota Promedio Del Curso: %.2f %n ", varianza);


        System.out.printf("\n--- Lista De Estudiantes Que Sacaron (5.0) En La Nota Final ---");
        for (String str : lista) {
          System.out.println("\n-------------------------------");
	        System.out.println("\n + EL Estudiante "+str);
        }

        //Arrays.sort(notap);
        for (double db : notap) {
          System.out.println("\n-------------------------------");
	        System.out.println("\n + La nota mas alta es: "+ db);
        }    
    }
    public static double[] ordenarmayormenor(double[] inicio){
      for (int i=0; i < inicio.length; i++){
        for (j = i+1; j< inicio.length; j++){
          if (inicio[j]<inicio[i]){
            int anterio = inicio[i];
            int nuevoMenor = inicio[j];
            inicio[i] = nuevoMenor;
            inicio[j] = anterio;
          }
        }
        return inicio;
      }
    }
}
