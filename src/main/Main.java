package main;


import imc.conversion.ImcLogica;
import salario.SalarioLogica;
import salario.strings.SalarioStrings;
import vectores.VectoresLogica;
import zodiaco.SignoLogica;
import zodiaco.strings.SignoStrings;

import javax.swing.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import static imc.ImcStrings.*;
import static menu.MenuStrings.*;

public class Main {

    public static void main(String[] args) {


        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator(',');
        simbolo.setGroupingSeparator('.');

        DecimalFormat formateador = new DecimalFormat("###,###.##", simbolo);

        Object[] casos = {HALLAR_IMC.getMensaje(), HALLAR_SIGNO_ZODIACAL.getMensaje(), HALLAR_SALARIO.getMensaje()
                , HALLAR_VECTOR.getMensaje(), SALIR.getMensaje()};


        Object opcion = JOptionPane.showInputDialog(null, MENSAJE_OPCION.getMensaje(),
                MENSAJE_ELEGIR.getMensaje(),
                JOptionPane.QUESTION_MESSAGE, null, casos, casos[0]);


            if (HALLAR_IMC.getMensaje().equals(opcion)) {

                ImcLogica imcLogica = new ImcLogica();

                String valorPeso = JOptionPane.showInputDialog(null, MENSAJE_INGRESO_PESO.getMensaje());
                String valorEstatura = JOptionPane.showInputDialog(null, MENSAJE_INGRESO_ESTATURA.getMensaje());

                imcLogica.setPeso(Double.parseDouble(valorPeso));
                imcLogica.setEstatura(Double.parseDouble(valorEstatura));

                JOptionPane.showMessageDialog(null, MENSAJE_DADOS_LOS_DATOS.getMensaje() +
                        MENSAJE_SU_IMC_ES.getMensaje() + formateador.format(imcLogica.calcularImc()));
            } else if (HALLAR_SIGNO_ZODIACAL.getMensaje().equals(opcion)) {

                SignoLogica signoLogica = new SignoLogica(0, 0);
                String mesNacimiento = JOptionPane.showInputDialog(null, SignoStrings.MENSAJE_SOLICITUD_MES_NACIMIENTO.getMensaje());
                String diaNacimiento = JOptionPane.showInputDialog(null, SignoStrings.MENSAJE_SOLICITUD_DIA_NACIMIENTO.getMensaje());

                signoLogica.setMes(Integer.parseInt(mesNacimiento));

                signoLogica.setDia(Integer.parseInt(diaNacimiento));

                if (signoLogica.getMes() <= 3) {
                    JOptionPane.showMessageDialog(null, SignoStrings.SUS_DATOS_DE_NACIMIENTO.getMensaje() + signoLogica.signoZodiacal());

                } else if (signoLogica.getMes() > 3 && signoLogica.getMes() <= 6) {
                    JOptionPane.showMessageDialog(null, SignoStrings.SUS_DATOS_DE_NACIMIENTO.getMensaje() + signoLogica.signoZodiacal2());

                } else if (signoLogica.getMes() > 6 && signoLogica.getMes() <= 9) {
                    JOptionPane.showMessageDialog(null, SignoStrings.SUS_DATOS_DE_NACIMIENTO.getMensaje() + signoLogica.signoZodiacal3());

                } else if (signoLogica.getMes() > 9 && signoLogica.getMes() <= 12) {
                    JOptionPane.showMessageDialog(null, SignoStrings.SUS_DATOS_DE_NACIMIENTO.getMensaje() + signoLogica.signoZodiacal4());

                }


            } else if (HALLAR_SALARIO.getMensaje().equals(opcion)) {


                SalarioLogica sl = new SalarioLogica();

                sl.cargar();

                JOptionPane.showMessageDialog(null, SalarioStrings.MENSAJE_SALARIO_MAYOR.getMensaje()
                        + formateador.format(SalarioLogica.nMayor()));

                JOptionPane.showMessageDialog(null, SalarioStrings.SALARIO_MENOR.getMensaje()
                        + formateador.format(SalarioLogica.nMenor()));


                JOptionPane.showMessageDialog(null, SalarioStrings.TOTAL_SALARIO.getMensaje()
                        + formateador.format(SalarioLogica.sumaMax()));

                JOptionPane.showMessageDialog(null, SalarioStrings.PROMEDIO.getMensaje()
                        + formateador.format(SalarioLogica.promSalario()));


            }
            else if (HALLAR_VECTOR.getMensaje().equals(opcion)) {
                VectoresLogica vectoresLogica = new VectoresLogica();


                vectoresLogica.cargar();
                vectoresLogica.imprimir();

            }

            else if (SALIR.getMensaje().equals(opcion)) {
                while (JOptionPane.showConfirmDialog(null, SALIR_VALIDAR.getMensaje(),
                        SALIR_SEGURA.getMensaje(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                    System.exit(0);

            }




    }
}
