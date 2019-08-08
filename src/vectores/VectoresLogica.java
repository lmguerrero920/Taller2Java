package vectores;


import vectores.enteros.VectorEntero;
import vectores.strings.VectoresStrings;

import javax.swing.*;




public class VectoresLogica  extends VectorEntero {


    private  static int[]x;


    public void cargar(){
        int tam;

        tam=(Integer.parseInt(JOptionPane.showInputDialog(null,
                VectoresStrings.VECTOR_SOLICITAR_CANTIDAD.getMensaje())));

        x = new int[tam];

        // Llenar Vector
        for(int i = 0; i < x.length; i++)

            x[i] = Integer.parseInt(JOptionPane.showInputDialog(VectoresStrings.VECTOR_SOLICITAR_NUMERO.getMensaje()+i+
                    VectoresStrings.VECTOR_SOLICITAR_NUMERO2.getMensaje()));
    }

    public static double promVectores()
    {
        int sumVector = 0;
        for (int i = 0; i < x.length; i++)
        {
            sumVector+=x[i];
        }
        return ( sumVector/x.length) ;

    }



    public void imprimir() {

        do{

        for(int f=0;f<x.length;f++) {



            if (x[f] > 0) {


                JOptionPane.showMessageDialog(null, VectoresStrings.POSITIVO.getMensaje());

            } else {
                JOptionPane.showMessageDialog(null, VectoresStrings.NEGATIVO.getMensaje());


            }
        }

        } while (this.getOpcion()!=0);

    }



    public static void main(String[] args) {
        VectoresLogica sl= new VectoresLogica();
        sl.cargar();
        sl.imprimir();


    }



}
