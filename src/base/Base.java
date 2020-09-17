/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import base.model.Persona;
import java.util.Scanner;

/**
 *
 * @author JC
 */
public class Base {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {

        Persona persona = new Persona("", 0,  'H', 0, 0);
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Ejercicio base");

        System.out.println("Ingrese el nombre de la persona");
        persona.setNombre(scanner.nextLine());

        System.out.println("Ingrese edad");
        persona.setEdad(scanner.nextInt());

        System.out.println("Ingrese sexo H(Hombre) o M(Mujer)");
        persona.setSexo(scanner.next().charAt(0));

        System.out.println("Ingrese peso en Kg");
        persona.setPeso(scanner.nextFloat());

        System.out.println("Ingrese altura en Mts");
        persona.setAltura(scanner.nextFloat());


        System.out.println(obtenerResultadoIMC(persona));
        System.out.println(calcularPersonaEsMayorDeEdad(persona));

        System.out.println("Resumen");
        System.out.println("Nombre: "+persona.getNombre());
        System.out.println("Sexo: "+persona.getSexo());
        System.out.println("Edad: "+persona.getEdad()+" años");
        System.out.println("Altura: "+persona.getAltura()+" Mts");
        System.out.println("Peso: "+persona.getPeso()+" Kg");
    }

    private static String calcularPersonaEsMayorDeEdad(Persona persona) {
        if (persona.esMayorDeEdad()) {
            return persona.getNombre().concat(" es mayor de edad");
        } 
        return persona.getNombre().concat(" es menor de edad");
    }

    private static String obtenerResultadoIMC(Persona persona) {
        int imc=persona.calcularImc();
        String mensaje = "El Indice de Masa Corporal de ".concat(persona.getNombre()).concat(" es: Peso normal");
        if (imc<0) {
             mensaje = "El Indice de Masa Corporal de ".concat(persona.getNombre()).concat(" es: Falta de peso");
        } else if(imc>0){
            mensaje = "El Indice de Masa Corporal de ".concat(persona.getNombre()).concat(" es: Sobrepeso"); 
        }
        return mensaje;
    }
}
