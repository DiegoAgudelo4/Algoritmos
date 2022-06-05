
package polinomios;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;


public class Polvf1 {
    int n, exp;
    float vec[];
    
    
    //Método constructor
    public Polvf1(int grado) {
        
        n = grado+2;
        vec = new float[n];
        
        //asigna grado en la posicion 0
        vec[0] = grado;
    }  
    //método para mostrar
    
      public String mostrar()
    {
        int k, expo, coef;
        String salida=""+"<html>";
        DecimalFormat formato1 = new DecimalFormat("#");
        for(k=1;k<vec[0]+2;k++)
        {
            if(vec[k]!=0)
            {
                expo=(int)vec[0]+1-k;
                coef=(int)vec[k];
                if(vec[k]>0&&k>1)
                {
                    salida=salida+"+";
                }if(expo>1){
                    if(coef==1)
                    {
                        salida=salida+"X<sup>"+String.valueOf(expo)+"</sup>";
                    }else{
                        salida=salida+formato1.format(vec[k])+"X<sup>"+String.valueOf(expo)+"</sup>";
                    }
                    
                }
                else{
                    if(expo==1){
                        if(coef==1){
                            salida=salida+"X";
                        }else{
                            salida=salida+formato1.format(vec[k])+"X";
                        }
                        
                    }
                }if(expo==0){
                    salida=salida+formato1.format(vec[k]);
                }
            }
        }
        salida=salida+"</html>";
       return salida;
    }
    
    public void almacenarTerm(float coef, int exp)
    {
        int pos;
        if(exp>=0&&exp<=vec[0])
        {
            pos=(int)vec[0]+1-exp;
            if(vec[pos]==0)
            {
                vec[pos]=coef;
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Ya existe un término con ese exponente");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"El exponente no corresponde al polinomio");
        }
    }
    //Método para ingresar los términos del polinomio
    public void ingresarTerm()
    {
        float coef;
        int expo;
        String rpa;
        rpa=JOptionPane.showInputDialog("Desea ingresar término? S/N");
        while(rpa.equalsIgnoreCase("S"))
        {
            coef=Float.parseFloat(JOptionPane.showInputDialog("Ingrese coeficiente")); 
            expo=Integer.parseInt(JOptionPane.showInputDialog("Ingrese exponente")); 
            this.almacenarTerm(coef,expo);
            rpa=JOptionPane.showInputDialog("Desea ingresar término? S/N"); 
        }
    }
    public float evaluar(float x)
    {
        float resultado=0;
        for(int k=1;k<vec[0]+2;k++)
        {
           resultado=resultado+ vec[k]*(float)Math.pow(x,(vec[0]+1-k));
        }
        return(resultado);
    }
    public float getDato(int pos)
    {
        return(vec[pos]);
    }
    public void setDato(float dato, int pos)
    {
        vec[pos]=dato;
    }
    //Método para sumar
    public Polvf1 sumar(Polvf1 B)
    {
        int expA,expB,my,k=1,j=1,posR;
        if(vec[0]>B.getDato(0))
        {
            my=(int)vec[0];
        }
        else
        {
            my=(int)B.getDato(0);
        }
        Polvf1 R=new Polvf1(my);
        while(k<vec[0]+2&&j<B.getDato(0)+2)
        {
            expA=(int)vec[0]+1-k;
            expB=(int)B.getDato(0)+1-j;
            if(expA==expB)
            {
                posR=(int)R.getDato(0)+1-expA;
                R.setDato(vec[k]+B.getDato(j), posR);
                k++;
                j++;
            }
            else
            {
               if(expA>expB) 
               {
                    posR=(int)R.getDato(0)+1-expA;
                    R.setDato(vec[k], posR);
                    k++; 
               }
               else
               {
                    posR=(int)R.getDato(0)+1-expB;
                    R.setDato(B.getDato(j), posR);
                    j++; 
               }
            }
            
        }
        //R.ajustar();
        return(R);
    }
    public Polvf1 multiplicar( Polvf1 B){
        int k,j,expA, expB, tamanio;
        tamanio=(int) ((vec[0])+(B.getDato(0)));
        Polvf1 R=new Polvf1 (tamanio);
        
        for( j=1; j<(B.getDato(0)+2); j++){
            expB=(int)(B.getDato(0)+1-j);
            for (k = 1;  k<vec[0]+2; k++) {
                expA=(int) (vec[0]+1-k);
                R.insertarTerm((vec[k]*B.getDato(j)), (expA+expB));
            }
        }
        
        return R;
    }
    public void insertarTerm(float coef, int exp){
        int pos;
        if(exp<0){
            JOptionPane.showMessageDialog(null, "Exp no valido");
        }else{
            if(exp<=vec[0]){
                pos=(int)(vec[0]+1-exp);
                vec[pos]=vec[pos]+coef;
                this.ajustar();
            }else{
                this.redimensionar(exp);
                vec[0]=exp;
                vec[1]=coef;
            }
        }
    }
   public void redimensionar(int exp){
       int k, pos=exp+1;
       n=exp+2;
       float[] aux=new float[n];
       for(k=(int)(vec[0]+1); k>0; k--){
           aux[pos]=vec[k];
           pos=pos-1;
       }
       vec=aux;
   }
   public void ajustar(){
       int j=1,k, cont = 0;
       while(j<(int)(vec[0]+2)&&(vec[j]==0)){
           cont=cont+1;
           j=j+1;
       }
       for(k=j;k<(int)(vec[0]+2);k++){
           vec[k-cont]=vec[k];
       }
       vec[0]=vec[0]-cont;
   }
   public Polvf1 hacerCopia(){
       int k;
       Polvf1 copia=new Polvf1((int)(vec[0]));
       for(k=1; k<vec[0]+2; k++){
           copia.setDato(vec[k], k);
       }
       return copia;
   }
   public Polvf1 Dividir(Polvf1 B)
    {
        int K,Expt,posR,ExpA,PosA;
        float Coet,CoeA;
        Polvf1 R=null;
        if(vec[0]>=B.getDato(0))
        {
            Polvf1 Copia=this.hacerCopia();
            R=new Polvf1((int) (vec[0]-B.getDato(0)));
            while(Copia.getDato(0)>=B.getDato(0))
            {
                Expt=(int) (Copia.getDato(0)-B.getDato(0));
                Coet=Copia.getDato(1)/B.getDato(1);
                posR=(int) (R.getDato(0)+1-Expt);
                R.setDato(Coet,posR);
                for(K=1;K<=(B.getDato(0)+1);K++)
                {
                    ExpA=(int) (Expt+B.getDato(0)+1-K);
                    CoeA=Coet*B.getDato(K);
                    PosA=(int) (Copia.getDato(0)+1-ExpA);
                    Copia.setDato(Copia.getDato(PosA)-CoeA,PosA);                    
                }
                Copia.ajustar();
            }
            
        }
        else
            JOptionPane.showInputDialog("No se puede dividir ");
        return(R);      
    }

    int getDato() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //primer punto 1.resultado en Polista= polvf1*polvf2;
   public Polista Polvf1MultiplicarF2( Polvf2 B){
        int k,j,expA, expB, tamanio;
        Polista R=new Polista ();
        
        for( j=1; j<(B.getDato(0)+2); j++){
            expB=(int)(B.getDato(j));
            for (k = 1;  k<vec[0]+2; k++) {
                expA=(int) (vec[0]+1-k);
                R.insertarTerminos((vec[k]*B.getDato(j+1)), (expA+expB));
            }
        }
        return R;
  
       }
}
 
