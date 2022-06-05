/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Procesos.Grafos;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int N = Integer.parseInt(JOptionPane.showInputDialog("Tamaño del grafo: ")), opc;
        Grafos grafo_1 = new Grafos(N);

        String menu = "**********Menu****************\n"
                + "1.Ingresar Datos\n"
                + "2.Recorrer DFS\n"
                + "3.Recorrer BFS\n"
                + "4.Mostrar Datos\n"
                + "5.Mostrar el grado de un vértice dado\n"
                + "6.Mostrar el grado de cada uno de los vértices de un grafo\n"
                + "7.Mostrar el vértice con mayor grado\n"
                + "8.Mostrar el grado de cada uno de los vértices adyacentes a un vértice dado\n"
                + "9.Mostrar adyacentes a cada vertice\n"
                + "10.Mostrar Vertices ordenados deacuerdo al grado\n"
                + "0.Salir";
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opc) {
                case 1:
                    grafo_1.ingresar_datos();
                    break;
                case 2:
                    grafo_1.Recorrido_DFS(1);
                    separador();
                    break;
                case 3:
                    grafo_1.Recorrido_BFS(1);
                    separador();
                    break;
                case 4:
                    grafo_1.mostrar_datos();
                    separador();
                    break;
                case 5://Mostrar el grado de un vértice dado
                    grafo_1.mostrar_Grado_de_un_verticeDado();
                    separador();
                    break;
                case 6://Mostrar el grado de cada uno de los vértices de un grafo
                    grafo_1.mostrar_Grado_deCadUno();
                    separador();
                    break;
                case 7://Mostrar el vértice con mayor grado
                    grafo_1.mostrar_vertice_con_mayor_grado();
                    separador();
                    break;
                case 8: //Mostrar el grado de cada uno de los vértices adyacentes a un vértice dado
                    grafo_1.mostrar_Grado_deCadUno_verticesAdya();
                    separador();
                    break;
                case 9: //Mostrar adyacentes a cada vertice
                    grafo_1.mostrar_adyacentesCadUno();
                    separador();
                    break;
                case 10://Mostrar Vertices ordenados deacuerdo al grado
                    grafo_1.mostrarPorGradoMayor();
                    separador();
                         
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "opcion no valida");
                    break;
            }//fin switch
        } while (opc != 0);//fin do while
    }

    public static void separador() {
        System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+");
    }
    
//1. Mostrar el grado de un vértice dado.                                           //ya
//2. Mostrar el grado de cada uno de los vértices de un grafo.                      //ya
//3. Mostrar los vértices ordenados de acuerdo al grado                             
//4. Mostrar el grado de cada uno de los vértices que hay en un recorrido DFS       
//5. Mostrar el grado de cada uno de los vértices que hay en un recorrido BFS        
//6. Mostrar el vértice con mayor grado.                                            //ya
//7. Mostrar el grado de cada uno de los vértices adyacentes a un vértice dado      //ya
//8. Permitirle al usuario almacenar un grafo en una matriz de adyacencia           
//9. Permitirle al usuario almacenar un grafo en listas de adyacencia.              
//10.Pasar grafo de matriz de adyacencia a listas de adyacencia.                    
//11.Pasar grafo de listas de adyacencia a matriz de adyacencia.                    
//12.Mostrar el grado entrante de un vértice dado.                                  
//13.Para un grafo dirigido muestre los vértices desde los cuales se pueda llegar a 
//un vértice dado                                                                   
//14.Mostrar los vértices donde el grado saliente sea mayor al grado entrante.      
}
