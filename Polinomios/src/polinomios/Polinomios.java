
package polinomios;

import javax.swing.JOptionPane;


public class Polinomios {
    
   public static void main(String[] args) {
       //se llama al menu principal      
       menuppal();
    }

    public static void menuppal() {
         
        String Menu = "***Menú principal*** \n 1-Polinomios forma 1\n 2-Polinomios forma 2\n 3-Polinomio en listas\n 4-Polinomios combinados\n 0-Salir\n Digite la opción";
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(Menu));
            switch (op) {
                case 1:
                    menuppalF1();
                    break;
                case 2:
                    menuppalF2();
                    break;
                case 3:
                    menuppalLista();
                    break;
                case 4:
                    menuCombinados();
                    
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    throw new AssertionError();
            }
        } while (true);

    }
    
    public static void menuppalF1() {
        Polvf1 A, B, C;
         int cantermA , cantermB ;
         int opcion;
         float x;
         //se llenan los objetos
         int grado=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el grado del polinomio A"));
         A=new Polvf1(grado);
         A.ingresarTerm();
         
         grado=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el grado del polinomio B"));
         B=new Polvf1(grado);
         B.ingresarTerm();
         
        String Menu = "***FORMA 1*** \n 1-Mostrar \n 2-Sumar \n 3-Multiplicar\n4-Dividir\n 5-Regresar al menu principal\n 0-Salir\n Digite la opción";
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(Menu));
            
            switch (op) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Polinomio A \n" + A.mostrar()+"\n Polinomio B"+B.mostrar() );
                    break;
                case 2:
                    C = A.sumar(B);
                    JOptionPane.showMessageDialog(null, "Primer polinomio \n" + A.mostrar() + "\n Segundo polinomio \n" + B.mostrar() + "\n suma polinomios \n" + C.mostrar());
                    
                    break;
                case 3:
                    C = A.multiplicar(B);
                    JOptionPane.showMessageDialog(null, "Primer polinomio \n" + A.mostrar() + "\n Segundo polinomio \n" + B.mostrar() + "\n suma polinomios \n" + C.mostrar());
                    
                    break;
                case 5:
                    menuppal();
                    break;
                case 4:
                    C=A.Dividir(B);
                    JOptionPane.showMessageDialog(null, "Primer polinomio \n" + A.mostrar() + "\n Segundo polinomio \n" + B.mostrar() + "\n la division de los polinomios \n" + C.mostrar());
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    throw new AssertionError();
            }
        } while (op!=0);

    }
    
    public static void menuppalF2() {
        String Menu = "***FORMA 2*** \n 1-Mostrar \n 2-Sumar \n 3-Multiplicar\n4-Dividir\n5-Evaluar \n6-Regresar al menu principal\n 0-Salir\n Digite la opción";
        int op;
        Polvf2 A, B , C;
        
        int nterm=Integer.parseInt(JOptionPane.showInputDialog("¿cuantos terminos tiene el polinomio?"));
        A=new Polvf2(nterm);
        A.ingresarTerminos(nterm);
        
        nterm=Integer.parseInt(JOptionPane.showInputDialog("¿cuantos terminos tiene el polinomio?"));
        B=new Polvf2(nterm);
        B.ingresarTerminos(nterm);
        
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(Menu));
            
            switch (op) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Primero polinomio\n" + A.mostrar()+"\nSegundo polinomio\n"+B.mostrar());
                    break;
                case 2:
                    C = A.sumar(B);
                    JOptionPane.showMessageDialog(null, "Primer polinomio \n" + A.mostrar() + "\n Segundo polinomio \n" + B.mostrar() + "\n suma polinomios \n" + C.mostrar());
                    
                    break;
                case 3:
                    C = A.multiplicar(B);
                    JOptionPane.showMessageDialog(null, "Primer polinomio \n" + A.mostrar() + "\n Segundo polinomio \n" + B.mostrar() + "\n multiplicar polinomios \n" + C.mostrar());
                    
                    break;
                case 4: C=A.dividir(B);
                      JOptionPane.showMessageDialog(null, "Primer polinomio \n" + A.mostrar() + "\n Segundo polinomio \n" + B.mostrar() + "\n Dividir polinomios \n" + C.mostrar());
                        
                    
                    break;
                case 5:int OPC=Integer.parseInt(JOptionPane.showInputDialog("1-Evaluar primer polinomio\n2-Evaluar segundo polinomio"));
                       switch(OPC){
                           case 1:op=Integer.parseInt(JOptionPane.showInputDialog("Evaluar primer polinomio, ingrese un valor para X"));
                               JOptionPane.showMessageDialog(null,A.mostrar()+ "\n Donde   X="+op+"\nResultado: "+A.evaluar(op));
                               break;
                           case 2:op=Integer.parseInt(JOptionPane.showInputDialog("Evaluar el segundo polinomio, ingrese un valor para X"));
                               JOptionPane.showMessageDialog(null,B.mostrar()+ " \nDonde   X="+op+"\nResultado: "+B.evaluar(op));
                               break;
                           default: JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                                break;
                       }
                       
                    break;
                case 6: menuppal();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    throw new AssertionError();
            }
        } while (op!=0);
    }
    
    public static void menuppalLista() {
        String Menu = "***LISTAS*** \n 1-Mostrar los polinomios \n 2-Sumar \n 3-Multiplicar\n4.Evaluar \n 5-Dividir\n6-Regresar al menu principal\n 0-Salir\n Digite la opción";
        int op;
        Polista A=new Polista (), B=new Polista(), C;
        JOptionPane.showMessageDialog(null, "Primer polinomio");
        A.ingresarTerminos();
        JOptionPane.showMessageDialog(null, "Segundo polinomio");
        B.ingresarTerminos();
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(Menu));
            
            switch (op) {
                
                case 1://mostrar
                    
                    JOptionPane.showMessageDialog(null, "Primer polinomio \n" + A.mostrar()+"\nSegundo polinomio\n"+B.mostrar());
                    break;
                case 2://sumar
                    C=A.sumar(B);
                    JOptionPane.showMessageDialog(null, "Primer polinomio  \n" + A.mostrar()+"\nSegundo polinomio\n"+B.mostrar()+"\nLa suma es:\n"+C.mostrar());
                    
                    break;
                case 3://multiplicar
                        C=A.multiplicar(B);
                        JOptionPane.showMessageDialog(null, "Primer polinomio  \n" + A.mostrar()+"\nSegundo polinomio\n"+B.mostrar()+"\nLa Multiplicacion es:\n"+C.mostrar());
                    break;
                    
                case 4: int OPC=Integer.parseInt(JOptionPane.showInputDialog("1-Evaluar primer polinomio\n2-Evaluar segundo polinomio"));
                       switch(OPC){
                           case 1:op=Integer.parseInt(JOptionPane.showInputDialog("Evaluar primer polinomio, ingrese un valor para X"));
                               JOptionPane.showMessageDialog(null,A.mostrar()+ "\n Donde   X="+op+"\nResultado: "+A.evaluar(op));
                               break;
                           case 2:op=Integer.parseInt(JOptionPane.showInputDialog("Evaluar el segundo polinomio, ingrese un valor para X"));
                               JOptionPane.showMessageDialog(null,B.mostrar()+ " \nDonde   X="+op+"\nResultado: "+B.evaluar(op));
                               break;
                           default: JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                                break;
                       }
                    break;
                case 5:C=A.dividir(B);
                        JOptionPane.showMessageDialog(null, "Primer polinomio  \n" + A.mostrar()+"\nSegundo polinomio\n"+B.mostrar()+"\nLa Division es:\n"+C.mostrar());
                    break;
                case 6://regresar al menu principal
                    menuppal();
                   
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opcion invalida");
            }
        } while (op!=0);

    }
    public static void menuCombinados(){
        String menu="***combinados***\n1.resultado en Polista= polvf1*polvf2\n" +
                                        "2.resultado en polvf2=polista/polvf1\n" +
                                        "3.resultado en polvf1= polvf2/polista\n" +
                                        "4.resultado en polvf2= polista+porlf1\n" +
                                        "5 comparar polista con un polvf1 (determinar si son iguales)";
         int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
        switch(op){
            case 1: Polvf1 A; Polvf2 B; Polista C;
                    int grado=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el grado del polinomio A"));
                    A=new Polvf1(grado);
                    A.ingresarTerm();
                    
                    int nterm=Integer.parseInt(JOptionPane.showInputDialog("¿cuantos terminos tiene el polinomio B?"));
                    B=new Polvf2(nterm);
                    B.ingresarTerminos(nterm);
                    C=A.Polvf1MultiplicarF2(B);
                    JOptionPane.showMessageDialog(null, "Primer polinomio \n" + A.mostrar() + "\n Segundo polinomio \n" + B.mostrar() + "\n multiplicar polinomios \n" + C.mostrar());
                
                break;
            case 2: Polvf1 J; Polvf2 K;
                    Polista H=new Polista ();
                    JOptionPane.showMessageDialog(null, "Primer polinomio");
                    H.ingresarTerminos();
                    
                    grado=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el grado del polinomio B"));
                    J=new Polvf1(grado);
                    J.ingresarTerm();
                    K=H.ListaDivPolf1(J);
                    JOptionPane.showMessageDialog(null, "Primer polinomio \n" + H.mostrar() + "\n Segundo polinomio \n" + J.mostrar() + "\n Resultado de la division \n" + K.mostrar());
                 
            
                break;
            case 3:Polista F=new Polista (); Polvf2 G; Polvf1 S;
                   int nTerm=Integer.parseInt(JOptionPane.showInputDialog("¿cuantos terminos tiene el polinomio A?"));
                    G=new Polvf2(nTerm);
                    G.ingresarTerminos(nTerm);
                    JOptionPane.showMessageDialog(null, "Ingrese los datos del polinimio B");
                    F.ingresarTerminos();
                    
                    S=G.polvf2DividPolista(F);
                    JOptionPane.showMessageDialog(null, "Primer polinomio \n" + G.mostrar() + "\n Segundo polinomio \n" + F.mostrar() + "\n El resultado de la division  \n" + S.mostrar());
                    
                break;
                
            case 4:Polista X=new Polista (); Polvf1 Y; Polvf2 Z;
                   JOptionPane.showMessageDialog(null, "Primer polinomio");
                   X.ingresarTerminos();
                   grado=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el grado del segundo polinomio "));
                   Y=new Polvf1(grado);
                   Y.ingresarTerm();
                   Z=X.listMásFuno(Y);
                   JOptionPane.showMessageDialog(null, "Primer polinomio \n" + X.mostrar() + "\n Segundo polinomio \n" + Y.mostrar() + "\n Suma de los polinomios \n" + Z.mostrar());
                break;
            case 5: 
                    Polista h=new Polista ();
                    JOptionPane.showMessageDialog(null, "Primer polinomio");
                    h.ingresarTerminos();
                    
                    Polvf1 j;
                    grado=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el grado del polinomio A"));
                    j=new Polvf1(grado);
                    j.ingresarTerm();
                    h.F1CompararPolista(j);
                    
                break;
            default: JOptionPane.showMessageDialog(null, "Opción no válida.");
        }
         
    }
    
    
    
    
    
    
}
           
    //intentar hacer el menu por medio de metodos :V
/*ejercicios
1.resultado en Polista= polvf1*polvf2;
2.resultado en polvf2=polista/polvf1;
3.resultado en polvf1= polvf2/polista;
4.resultado en polvf2= polista+porlf1;
5 comparar polista con un polvf1 (determinar si son iguales);
*/
