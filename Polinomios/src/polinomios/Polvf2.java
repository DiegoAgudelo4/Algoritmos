
package polinomios;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;


public class Polvf2 {
    //atributos
    int n;
    float[] vec;
    //constructores
    

    public Polvf2(int cant) {
        n=(cant*2)+1;
        vec= new float[n];
        vec[0]=cant;
    } 
//metodos
    public String mostrar () {
        String salida=""+"<html>";
        DecimalFormat formato1 = new DecimalFormat("#");
        int K;
        for(K=1;K<vec[0]*2+1;K+=2){
            if ((vec[K+1]>0)&&(K>1))
            {
                if(vec[K]>1)
                {
                salida=salida + "+" + formato1.format(vec[K+1])+"X<sup>"+formato1.format(vec[K])+"</sup>";
                }
                if(vec[K]==1 && vec[K+1]==1){
                    salida=salida + "+" +"X";
                }else{
                    if(vec[K]==1){
                        salida=salida + "+" + formato1.format(vec[K+1])+"X";
                    }
                }
                if(vec[K]==0){
                    salida=salida + "+" + formato1.format(vec[K+1]);
                }
            } 
            else
            {   
                if(vec[K+1]==1 && vec[K]==1){
                    salida=salida+"X";
                }else{
                    if(vec[K]==1){
                         salida=salida+formato1.format(vec[K+1])+"X";
                    }else{
                        if(vec[K]==0){
                            salida=salida+formato1.format(vec[K+1]);
                        }else{
                            salida=salida+formato1.format(vec[K+1])+"X<sup>"+formato1.format(vec[K])+"</sup>";
                        }
                         
                    }
                   
                }
                
            }
        }
        salida=salida+"</html>";
        return salida;
        }
    
    
    public  void ingresarTerminos(int nterm){
        int k, exp;
        float coef;
        //nterm=Integer.parseInt(JOptionPane.showInputDialog("¿cuantos terminos tiene el polinomio?"));
        for (int i = 0; i < nterm; i++) {
            coef=Float.parseFloat(JOptionPane.showInputDialog("Ingrese coeficiente"));
            exp=Integer.parseInt(JOptionPane.showInputDialog("ingrese el exponente"));
            this.almacenarTerminos(coef, exp);
        }
    }
    
    public void almacenarTerminos(float coef, int exp){
        
        int k = 1,j;
        
        while ((k < vec[0]*2+1) && (vec[k]>exp) && (vec[k+1]!=0)) {
            k+=2;            
        }
        if((k<vec[0]*2+1)&&(vec[k]==exp)&&(vec[k+1]!=0)){
            JOptionPane.showMessageDialog(null, "ya existe un termino con ese mismo exponte");
        }
        
        else {
            for (j = (int) (vec[0] * 2 - 1); j > k; j--) {
                vec[j + 1] = vec[j - 1];
            }
            vec[k] = exp;
            vec[k + 1] = coef;
        }
        
        
    }
       
       
    public void redimensionar(){
        int k;
        n=n+2;
        float[] aux= new float[n];
        for (k = 1; k < vec[0]*2+1; k++) {
            aux[k]=vec[k];
        }
        vec=aux;
    }
    
    public float evaluar (float X){
     float resultado=0;
     for (int K=1;K<vec[0]*2+1;K+=2)
             {
                 resultado+=vec[K+1]*Math.pow(X,vec[K]);
             }
     return (resultado);
    }

    public void InsertarTerm(float Coef, int Exp){
       int K=1, J;
        while((K<vec[0]*2+1)&&(vec[K]>Exp)&&(vec[K+1]!=0))
        {
            K=K+2;
        }
        if ((K<vec[0]*2+1)&&(vec[K]==Exp)&&(vec[K+1]!=0))
        {
            if ((vec[K+1]+Coef)!=0)
            {
                vec[K+1]=vec[K+1]+Coef;
            }
            else
            {
              for(J=K;J<vec[0]*2-1;J+=2)  
              {
                  vec[J]=vec[J+2];
                  vec[J+1]=vec[J+3];
              }
              vec[0]=vec[0]-1;
            }
        }
        else
        {
            if((vec[0]*2+1)==n)
            {
                this.redimensionar();
            }
            for (J=(int)vec[0]*2+1;J>K;J--)
            {
                vec[J+1]=vec[J];
            }
            vec[K]=Exp;
            vec[K+1]=Coef;
            vec[0]=vec[0]+1;
            
            }
    }
 
   public Polvf2 sumar(Polvf2 B){
        int k=1, j=1, expA, expB, coeA, coeB;
        Polvf2 R=new Polvf2((int)vec[0]);
        while((k<vec[0]*2+1)&&(j <( B.getDato(0)*2+1))){
            expA=(int)vec[k];
            expB=(int)B.getDato(j);
            coeA=(int)vec[k+1];
            coeB=(int)B.getDato(j+1);
            if(expA==expB){
                if((coeA+coeB)!=0){
                R.InsertarTerm(coeA+coeB, expA);
            }
                k=k+2;
                j=j+2;
            }
            else{
                if(expA>expB){
                    R.InsertarTerm(coeA, expA);
                    k=k+2;
                }else{
                    R.InsertarTerm(coeB, expB);
                    j=j+2;
                }
            }}
        while(k<vec[0]*2+1){
            R.InsertarTerm(vec[k+1], (int)vec[k]);
            k+=2;
        }
        while((j<B.getDato(0)*2+1)){
            R.InsertarTerm(B.getDato(j+1), (int)B.getDato(j));
            j=j+2;
        }
        return R;
    
   }
       
        
   public Polvf2 multiplicar(Polvf2 B){
          int expA, expB, expR, k, j;
        float coefR;
        Polvf2 R = new Polvf2((int) (vec[0] + B.getDato(0) + 1));
        for (j = 1; j < B.getDato(0) * 2 + 1; j++) {
            expB = (int) B.getDato(j);
            for (k = 1; k < vec[0] * 2 + 1; k += 2) {
                expA = (int) vec[k];
                expR = expA + expB;
                coefR = vec[k + 1] * B.getDato(j + 1);
                R.InsertarTerm(coefR, expR);
            }
        }
        return R;
    }
   public Polvf2 hacerCopia(){
       int k;
       Polvf2 copia=new Polvf2 ((int)(vec[0]));
       for(k=1; k<vec[0]*2+1; k++){
           copia.setDato(vec[k], k);
       }
       return copia;
     }
    //getters and setters
    public float getDato(int pos){
        return(vec[pos]);
    }
    public void setDato(float dato, int pos){
        vec[pos]=dato;
    }
    public int getTamaño(){
        return n;
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
    public Polvf2 dividir(Polvf2 B){
        Polvf2 Q=B, Z, P;
        
        int expT, expA, K=1;
        float coefT, coefA;
        if(vec[0]==0 || Q==null){
            JOptionPane.showMessageDialog(null,"Uno de los polinomios está vacío");
            return null;
        }else{
            if(vec[1]>=Q.getDato(1)){
                Polvf2 copia=this.hacerCopia();
                Polvf2 R=new Polvf2((int) (vec[1]-Q.getDato(1)));
                P=copia;
                
                while(copia.getDato(1)>=Q.getDato(1)){
                    expT=(int) (copia.getDato(1)-Q.getDato(1));
                    coefT=copia.getDato(2)/Q.getDato(2);
                    R.InsertarTerm(coefT, expT);
                    Z=B;
                    
                    for (int j = 1; j < B.getDato(0); j+=2) {
                        expA=(int) (expT+Z.getDato(j));
                        coefA=coefT*B.getDato(2)*(-1);
                        copia.InsertarTerm(coefA, expA);
                    }//fin para
                    P=copia;
                    Q=B;
                   
                }//fin mientras
                return R;
            }else{
                JOptionPane.showMessageDialog(null, "No se pueden dividir los polinomios.");
                return null;
            }//fin si
        }//fin si
        
    }//fin dividir 
     
    //tercer punto 3.resultado en polvf1= polvf2/polista;
       public Polvf1 polvf2DividPolista(Polista B){
        Polvf2 copia;
        Nodo Q=B.getCabe(), Z;
        int expT, expA, pos=1;
        float coefT, coefA;
        if(vec[0]==0 || Q==null){
            JOptionPane.showMessageDialog(null,"Uno de los polinomios está vacío");
            return null;
        }else{
            if(vec[1]>=Q.getExpo()){
                copia=this.hacerCopia();
                Polvf1 R=new Polvf1((int) (vec[1]-Q.getExpo()));
               
                
                while( copia.getDato(1)>=Q.getExpo()){
                    expT=(int) (copia.getDato(1)-Q.getExpo());
                    coefT=copia.getDato(2)/Q.getCoef();
                    R.insertarTerm(coefT,expT);
                    Z=B.getCabe();
                    
                    while(Z!=null){
                        expA=expT+Z.getExpo();
                        coefA=coefT*Z.getCoef()*(-1);
                        copia.InsertarTerm(coefA,expA);
                        Z=Z.getLiga();
                    }//fin mientras
                    
                    Q=B.getCabe();
                    
                    
                }//fin mientras
                return R;
            }else{
                JOptionPane.showMessageDialog(null, "No se pueden dividir los polinomios.");
                return null;
            }//fin si
        }//fin si
        
    }//fin dividir        
}
