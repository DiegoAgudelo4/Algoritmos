/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class Grafos {

    private Nodo[] vec;
    private int N;
    private int visitado[], cola[];

    public Grafos(int N) {
        this.vec = new Nodo[N];
        this.N = N;
        this.visitado = new int[N];
        this.cola = new int[N];
        this.setear_Cola_Vec();
    }

    //getters and setters
    public Nodo[] getVec() {
        return vec;
    }

    public void setVec(Nodo[] vec) {
        this.vec = vec;
    }

    //operaciones
    public void Recorrido_DFS(int v) {
        int k;
        Nodo p;
        visitado[v] = 1;
        System.out.println(v+1);
        p = vec[v];
        while (p != null) {
            k = p.getVertice();
            if (visitado[k] == 0) {
                Recorrido_DFS(v);
            }//fin si
            p = p.getSiguiente();
        }//fin while
    }

    public void Recorrido_BFS(int v) {
        int k, primero = 0, ultimo = 1;
        Nodo p;
        visitado[v] = 1;
        cola[ultimo] = v;
        while (primero != ultimo) {
            primero=primero +1;
            v = cola[primero-1];
            System.out.println(v);
            p = vec[v];
            while (p != null) {
                k = p.getVertice()-1;
                if (visitado[k] != 1) {     
                    visitado[k] = 1;
                    ultimo=ultimo+1;
                    cola[ultimo-1] = k;
                }//finsi
                p = p.getSiguiente();
            }//fin while
        }//fin while
        this.setear_Cola_Vec();
    }//fin metodo

    private void setear_Cola_Vec(){
        for (int i = 0; i < N; i++) {
            visitado[i]=0;
            cola[i]=0;
        }
    }
    public void ingresar_datos() {
        for (int i = 0; i < N; i++) {
            int s = JOptionPane.showConfirmDialog(null, "Vertice [" + (i + 1) + "] ¿tiene conexiones?", "Si/No", 0);
            while (s == 0) {
                int vertice = Integer.parseInt(JOptionPane.showInputDialog("ingrese el vertice con el que tiene conexion: "));
                this.almacenar_datos(i, vertice);
                s = JOptionPane.showConfirmDialog(null, "Vertice [" + (i + 1) + "] ¿tiene más conexiones?", "Si/No", 0);
            }//fin while
        }//fin for
    }

    private void almacenar_datos(int posicionV, int vertice) {
        Nodo p = vec[posicionV];
        if (p != null) {
            while (p.getVertice() <= vertice && p.getSiguiente() != null) {
                if (p.getVertice() == vertice) {
                    JOptionPane.showMessageDialog(null, "ese dato ya existe");
                    System.out.println("dato no almacenado");
                    return;
                } else {
                    p = p.getSiguiente();
                }
            }
        }

        Nodo nuevo = new Nodo(vertice);
        if (p == null) {
            vec[posicionV] = nuevo;
            System.out.println("almacenado correctamente en la primera posicion de la lista");
        } else {
            p.setSiguiente(nuevo);
            p = nuevo;
            System.out.println("almacenado correctamente");
        }//fin if, else
    }

    public void mostrar_datos() {
        for (int i = 0; i < N; i++) {
            Nodo p = vec[i];
            System.out.println("El vertice [" + (i + 1) + "] tiene relacion con: ");
            while (p != null) {
                System.out.println(p.getVertice());
                p = p.getSiguiente();
            }
        }
    }

    public void mostrar_Grado_de_un_verticeDado() {
        int s;
        do {
            int v = Integer.parseInt(JOptionPane.showInputDialog("ingrese el vertice"));
            System.out.println("El grado del vertice [" + (v) + "] es: " + this.mostrar_Grado(v - 1));
            s = JOptionPane.showConfirmDialog(null, "¿Desea ver el grado de otro vertice? ", "Si/No", 0);

        } while (s == 0);
    }

    public void mostrar_vertice_con_mayor_grado() {
        int[] vec = new int[2];
        int aux;
        vec[1] = 0;
        for (int i = 0; i < N; i++) {
            aux = mostrar_Grado(i);
            if (aux > vec[1]) {
                vec[0] = i;
                vec[1] = aux;
            }//fin si
        }//fin para
        System.out.println("el vertice con mayor grado es [" + (vec[0] + 1) + "] con Grado: " + vec[1] + " ");
    }

    public void mostrar_Grado_deCadUno() {
        for (int i = 0; i < N; i++) {
            System.out.println("el grado del vertice [" + (i + 1) + "]: " + this.mostrar_Grado(i));
        }
    }

    public void mostrar_Grado_deCadUno_verticesAdya() {
        int vertice = Integer.parseInt(JOptionPane.showInputDialog("ingrese el vertice")) - 1;
        Nodo p = vec[vertice];
        while (p != null) {
            System.out.println(p.getVertice() + " es adyacente a " + (vertice + 1) + " Con Grado: " + this.mostrar_Grado(p.getVertice() - 1));
            p = p.getSiguiente();
        }//fin while
    }

    private int mostrar_Grado(int v) {
        Nodo p = vec[v];
        int cant = 0;
        while (p != null) {
            cant++;
            p = p.getSiguiente();
        }//fin while
        //System.out.println("El grado del vertice ["+(v+1)+"] es: "+ cant);   
        return cant;
    }

    public void mostrar_adyacentesCadUno() {
        for (int i = 0; i < N; i++) {
            Nodo p = vec[i];
            if (vec[i] != null) {
                System.out.println("el vertice [" + (i + 1) + "] tiene comoa adyacentes a: ");
            }
            while (p != null) {
                System.out.println(p.getVertice());
                p = p.getSiguiente();
            }//fin while
        }//fin para
    }

    public void mostrarPorGradoMayor() {
        int mat[][] = new int[2][N];
        for (int i = 0; i < N; i++) {
            mat[0][i] = i;
            mat[1][i] = this.mostrar_Grado(i);
        }
        this.ordenar(mat);
    }

    private void ordenar(int a[][]) {

        int temporal[] = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < (N - i); j++) {
                if (a[1][j - 1] > a[1][j]) {
                    temporal[1] = a[1][j - 1];
                    temporal[0] = a[0][j - 1];
                    a[1][j - 1] = a[1][j];
                    a[0][j - 1] = a[0][j];
                    a[1][j] = temporal[1];
                    a[0][j] = temporal[0];

                }
            }   
        }
        for (int i = 0; i < N; i++) {
            System.out.println((a[0][i] + 1) + " grado: "+a[1][i] +"\n");
        }
    }

}
