
package polinomios;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;


public class Polista {
    Nodo cabe;
//constructor
    public Polista() {
        cabe = null;
    }
    //getter and setter

    public Nodo getCabe() {
        return cabe;
    }
    public void setCabe(Nodo cabe) {
        this.cabe = cabe;
    }
    //mostrar
    public String mostrar() {
        
        Nodo q = cabe;
        String salida= "<html>";
        DecimalFormat formato1 = new DecimalFormat("#");
        
        if(cabe == null){
            JOptionPane.showMessageDialog(null, "El polinomio se encuentra vacio");
        }else {
            while (q!=null) {
                if(q.getCoef()>0 && q != cabe){
                    salida+="+";
                }
                if(q.getExpo()==0){
                    salida=salida+formato1.format(q.getCoef());
                }if(q.getExpo()==1){
                    if(q.getCoef()==1){
                        salida=salida+"X";
                    }else{
                        salida=salida+formato1.format(q.getCoef()) + "X";
                    }
                    
                }if(q.getExpo()>
                        1){
                     salida=salida+formato1.format(q.getCoef()) + "X<sup>"+formato1.format(q.getExpo()) + "</sup>";
                }
                q=q.getLiga();
            }
        }
        salida+="</html>";
        return salida;
    }//fin mostrar
    //ingresar terminos
    public void ingresarTerminos(){
        
        int exp, pos;
        float coeficiente;
        String res;   
        
        res = JOptionPane.showInputDialog("¿Desea ingresar un término? s/n");
        
        while (res.equals("s")==true) {
           coeficiente = Float.parseFloat(JOptionPane.showInputDialog("Ingrese coeficiente"));
           exp = Integer.parseInt(JOptionPane.showInputDialog("ingrese exponente"));
           this.AlmacenarTermino(coeficiente, exp);      

           res = JOptionPane.showInputDialog("¿Desea ingresar un término? s/n");
        }
        
    }     
    public void AlmacenarTermino(float coef,int exp){
        
        Nodo q = cabe,ant = null,x;
        while(q!=null&&q.getExpo()>exp){
            
            ant=q;
            q=q.getLiga();            
        }
        
        if(q!=null && q.getExpo()==exp){
            if(q.getCoef()+coef!=0){
                q.setCoef(q.getCoef()+coef);     
                JOptionPane.showMessageDialog(null, "Se sumó con el termino que ya existía.");
            }else{
                JOptionPane.showMessageDialog(null, "La suma con el exponente que ya existía da cero. no se puede insertar");
            }
            //x=new Nodo (coef, expo);
            //x.setLiga(q);
        }else{
            x=new Nodo(coef, exp);
            x.setLiga(q);
            if(q==cabe){
                cabe=x;
            }else{
                ant.setLiga(x);
            }
        }
    }
    public float evaluar(float X){
        float resultado=0;
        Nodo P=cabe;
        if(P==null){
            JOptionPane.showMessageDialog(null, "El polinomio está vacío.");
        }else{
            while (P!=null){
                resultado=(float) (resultado+P.getCoef()*(Math.pow(X, P.getExpo())));
                P=P.getLiga();
            }
        }
        return resultado;
    }
    public void insertarTerminos(float co, int ex){
        if(co!=0){
            Nodo x, ant=null , p=cabe;
            while(p!=null && p.getExpo()>ex){
                ant=p;
                p=p.getLiga();
            }if(p!=null && p.getExpo()==ex){
                if(p.getCoef()+co!=0){
                    p.setCoef(p.getCoef()+co);
                }else{
                    if(p==cabe){
                        cabe=cabe.getLiga();
                    }else{
                        ant.setLiga(p.getLiga());
                    }
                    //delete (p)
                }
            }else{
                x=new Nodo(co, ex);
                x.setLiga(p);
                if(p==cabe){
                  cabe=x;  
                }else{
                    ant.setLiga(x);
                }
            }
            
        }
    }
    public Polista sumar(Polista B){
        Nodo p=cabe, q=B.getCabe();
        Polista r=new Polista();
        while ((p!=null)&&(q!=null)){
            if(p.getExpo()==q.getExpo()){
                if(p.getCoef()+q.getCoef()!=0){
                    r.insertarTerminos((p.getCoef()+q.getCoef()),p.getExpo());
                    p=p.getLiga();
                    q=q.getLiga();
                }
            }else{
                if(p.getExpo()>q.getExpo()){
                    r.insertarTerminos(p.getCoef(), p.getExpo());
                    p=p.getLiga();
                }else{
                    r.insertarTerminos(q.getCoef(), q.getExpo());
                    q=q.getLiga();
                }
            }
        }//fin mientras
        while((p!=null)){
            r.insertarTerminos(p.getCoef(), p.getExpo());
            p=p.getLiga();
        }
        while(q!=null){
            r.insertarTerminos(q.getCoef(),q.getExpo());
            q=q.getLiga();
        }
        return r;
    }
    public int getTamaño(){
        Nodo Q=cabe;
        int I=0;
        while(Q!=null){
            I++;
            Q=Q.getLiga();
        }
            
       return I;
    }
    public Polista multiplicar(Polista B){
        Nodo P=cabe, Q=B.getCabe();
        if(P==null && Q==null){
            JOptionPane.showMessageDialog(null, " Uno de los polinomios etá vacío");
        }else{
            Polista R=new Polista();
            while(Q!=null){
                P=cabe;
                while(P!=null){
                    R.insertarTerminos((P.getCoef()*Q.getCoef()), (P.getExpo()+Q.getExpo()));
                    P=P.getLiga();
                }//fin while
                Q=Q.getLiga();
            }//fin while
            return R;
        }
        return null;
    }
    public Polista hacerCopia(){
       Polista copia=new Polista();
       Nodo Q=cabe;
       Nodo R=null;
       while(Q!=null){
           copia.insertarTerminos(Q.getCoef(),Q.getExpo());
           Q=Q.getLiga();
       }
       return copia;
    }
    public Polista dividir(Polista B){
        Nodo P=cabe, Q=B.getCabe(), Z;
        int expT, expA;
        float coefT, coefA;
        if(P==null || Q==null){
            JOptionPane.showMessageDialog(null,"Uno de los polinomios está vacío");
            return null;
        }else{
            if(cabe.getExpo()>=Q.getExpo()){
                Polista copia=this.hacerCopia();
                Polista R=new Polista();
                P=copia.getCabe();
                while(P!=null && Q!=null && P.getExpo()>=Q.getExpo()){
                    expT=P.getExpo()-Q.getExpo();
                    coefT=P.getCoef()/Q.getCoef();
                    R.insertarTerminos(coefT, expT);
                    Z=B.getCabe();
                    
                    while(Z!=null){
                        expA=expT+Z.getExpo();
                        coefA=coefT*Z.getCoef()*(-1);
                        copia.insertarTerminos(coefA, expA);
                        Z=Z.getLiga();
                    }//fin mientras
                    P=copia.getCabe();
                    Q=B.getCabe();
                }//fin mientras
                return R;
            }else{
                JOptionPane.showMessageDialog(null, "No se pueden dividir los polinomios.");
                return null;
            }//fin si
        }//fin si
        
    }//fin dividir   
    //cuarto punto  4.resultado en polvf2= polista+porlf1;
    public  Polvf2 listMásFuno(Polvf1 b){
        int j=1, expA, expB, coeA, coeB;
        Nodo Q=cabe;
        Polvf2 R=new Polvf2(this.getTamaño()*2+1);
        while((Q!=null)&&(j <( b.getDato(0)+1))){
            expA=Q.getExpo();
            coeA=(int)Q.getCoef();
            expB=(int)b.getDato(0)+1-j;
            coeB=(int)b.getDato(j);
            
            if(expA==expB){
                if((coeA+coeB)!=0){
                R.InsertarTerm(coeA+coeB, expA);
            }
                Q=Q.getLiga();
                j=j+2;
               
            }
            else{
                if(expA>expB){
                    R.InsertarTerm(coeA, expA);
                    Q=Q.getLiga();
                }else{
                    R.InsertarTerm(coeB, expB);
                    j=j+2;
                }
            }
        }
        while(Q!=null){
            R.InsertarTerm(Q.getCoef(), (int)Q.getExpo());
            Q=Q.getLiga();
        }
        while((j<b.getDato(0)+2)){
            R.InsertarTerm(b.getDato(j), (int)b.getDato(0)+1-j);
            j=j+2;
        }
       return R;
     }
    //punto quinto 5.comparar polista con un polvf1 (determinar si son iguales);
    public void F1CompararPolista(Polvf1 B){
        Nodo a=cabe;
        Polvf1 b=B;
        
        String Primero=null, Segundo=null;                                                                                                      //ALEJANDRO
        while(a!=null){                                                                                                                         //G
            Primero= Primero+a.getCoef()+a.getExpo();                                                                                           //U
            a=a.getLiga();                                                                                                                      //DIEGO
        }                                                                                                                                       //E
        for (int i =1; i < b.getDato(0)+2; i++) {                                                                                               //L
            if(b.getDato(i)!=0){                                                                                                                //O
                Segundo=Segundo+b.getDato(i)+((int)b.getDato(0)+1-i);   
            }            
        }
        if(Primero== null && Segundo == null){
            JOptionPane.showMessageDialog(null, "Los polinomimos están vacíos.");
        }else{
            if(Primero.equals(Segundo)){
                JOptionPane.showMessageDialog(null,  Primero +"\n"+Segundo+"\nLos polinomios son iguales.");
            }else{
                JOptionPane.showMessageDialog(null, Primero+"\n"+Segundo+"\nLos polinomios no son iguales.");
            }
        }if(this.evaluar(2)==B.evaluar(2)){
            JOptionPane.showMessageDialog(null, " Los polinomios no son iguales pero su resultado es igual.");
        }
    }
    //segundo punto 2.resultado en polvf2=polista/polvf1;
    public Polvf2 ListaDivPolf1(Polvf1 B){
        Nodo P=cabe;
        Polvf1 Q=B, Z;
        int expT, expA;
        float coefT, coefA;
        if(P==null && Q==null){
            JOptionPane.showMessageDialog(null,"Uno de los polinomios está vacío");
            return null;
        }else{
            if(P.getExpo()>=Q.getDato(0)){
                Polista copia=this.hacerCopia();
                Polvf2 R=new Polvf2((int) (P.getExpo()-B.getDato(0)));
                P=copia.getCabe();
                
                while(P.getExpo()>=Q.getDato(0)){
                    expT=(int) (P.getExpo()-Q.getDato(0));
                    coefT=P.getCoef()/(int)Q.getDato(1);
                    R.InsertarTerm(coefT, expT);
                    Z=B;
                    for(int j=1; j<Z.getDato(0)+2; j++){
                        if(Z.getDato(j)!=0){
                        expA=(int) (expT+(Z.getDato(0)+1-j));
                        coefA=coefT*Z.getDato(j)*(-1);
                        copia.insertarTerminos(coefA, expA);
                        }
                        
                    }
                    //fin para
                    
                    P=copia.getCabe();
                    Q=B;
                }//fin mientras
                return R;
            }else{
                JOptionPane.showMessageDialog(null, "No se pueden dividir los polinomios.");
                return null;
            }//fin si
        }//fin si
    }
}
