/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;
import excepciones.*;
/**
 *
 * @author rmorales1
 */
public class Cuenta {
    private long numero_cuenta;
    private long numero_identificacion;
    private double saldo_actual;

    public Cuenta(long numero_cuenta, long numero_identificacion, double saldo_actual) throws NoNegativoException, NoCeroException {
        if (numero_cuenta<0){
            throw new NoNegativoException("El número de cuenta no debe ser negativo");    
        }
        if(numero_identificacion<0){
            throw new NoNegativoException("El número de identificación no debe ser negativo");    
        }
        
        if (numero_cuenta==0){
            throw new NoCeroException("El número de cuenta no debe ser cero");    
        }
        if(numero_identificacion==0){
            throw new NoCeroException("El número de identificación no debe ser cero");    
        }

        this.numero_cuenta = numero_cuenta;
        this.numero_identificacion = numero_identificacion;
        this.saldo_actual = saldo_actual;
        if(this.saldo_actual < 0){
        }  
    }
    
    
    public Cuenta(long numero_cuenta, long numero_identifacion) throws NoNegativoException, NoCeroException{
        if (numero_cuenta<0){
            throw new NoNegativoException("El número de cuenta no debe ser negativo");    
        }
        if(numero_identificacion<0){
            throw new NoNegativoException("El número de identificación no debe ser negativo");    
        }

        if (numero_cuenta==0){
            throw new NoCeroException("El número de cuenta no debe ser cero");    
        }
        if(numero_identificacion==0){
            throw new NoCeroException("El número de identificación no debe ser cero");    
        }
        
        this.numero_cuenta=numero_cuenta;
        this.numero_identificacion=numero_identifacion;
        this.saldo_actual=0;
    }

    public long getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(long numero_cuenta) throws NoNegativoException, NoCeroException {
         if (numero_cuenta<0){
            throw new NoNegativoException("El número de cuenta no debe ser negativo");    
        }
         if (numero_cuenta==0){
            throw new NoCeroException("El número de cuenta no debe ser cero");    
        }
        this.numero_cuenta = numero_cuenta;
    }

    public long getNumero_identificacion() {
        return numero_identificacion;
    }

    public void setNumero_identificacion(long numero_identificacion) throws NoCeroException {
        if(numero_identificacion<0){
            throw new NoCeroException("El número de identificación no debe ser negativo");    
        }
        if (numero_identificacion==0){
            throw new NoCeroException("El número de identificación no debe ser cero");
        }
        this.numero_identificacion = numero_identificacion;
    }

    public double getSaldo_actual() {
        return saldo_actual;
    }

    public void setSaldo_actual(double saldo_actual) throws NoNegativoException {
        if (saldo_actual<0){
            throw new NoNegativoException("El saldo actual no debe ser negativo");
        }
        this.saldo_actual = saldo_actual;
    }
   
    public void actulizarSaldo(double ian) throws NoNegativoException{
        double aux, aux2;
        if(ian<0){
            throw new NoNegativoException("El interes no puede ser negativo");
        }
        aux = this.getSaldo_actual()*(ian/365);
        aux2 = this.getSaldo_actual() + aux;
        this.setSaldo_actual(aux2);
    }
    
   public void ingresar(double ingreso) throws NoNegativoException{

       double aux;
       aux=this.getSaldo_actual()+ingreso;
       this.setSaldo_actual(aux);
   }
   
   public void retirar(double egreso) throws NoNegativoException{
       if (egreso<0){
           throw new NoNegativoException("El egreso no debe ser negativo");
       }
       double aux;
       aux = this.getSaldo_actual() - egreso;
       this.setSaldo_actual(aux);
       
   }
   
   public String mostrar(){
       String aux;
       aux = "No. de la cuenta: "+this.getNumero_cuenta()+"\n"
           + "No. de Identificación: "+this.getNumero_identificacion()+"\n"
           + "Saldo Actual: "+this.getSaldo_actual();
        return aux;
              
   }
    
    
    
}
