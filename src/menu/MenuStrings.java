package menu;

public enum MenuStrings {

   HALLAR_IMC("Hallar Indice de Masa Corporal") ,
   HALLAR_SIGNO_ZODIACAL("Signo Zodiacal"),
   HALLAR_SALARIO("Salarios"),
   HALLAR_VECTOR("Vector"),
    MENSAJE_OPCION("Por favor seleccione una opcion"),
    MENSAJE_ELEGIR("Elegir opcion del Menu"),
    SALIR("SALIR"),
    SALIR_VALIDAR("¿Desea realmente salir del sistema?"),
    SALIR_SEGURA("Salida Segura")

    ;
    MenuStrings(String s) {
        this.mensaje = s;
    }

    public String getMensaje() {
        return mensaje;
    }






    private String mensaje;
}
