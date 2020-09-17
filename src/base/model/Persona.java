/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.model;

import java.util.UUID;

/**
 *
 * @author JC
 */
public class Persona {

    private String nombre;
    private int edad;
    private final String NSS;
    private char sexo = this.HOMBRE;
    private float peso;
    private float altura;

    private final int FALTA_DE_PESO = -1;
    private final int PESO_NORMAL = 0;
    private final int SOBREPESO = 1;
    private final char HOMBRE = 'H';
    private final char MUJER = 'M';

    public Persona(String nombre, int edad, char sexo, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        this.NSS = generaNSS();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
    
    public int calcularImc() {
        float calculoIMC = (float) (this.peso / (Math.pow(this.altura, 2)));
        if (this.sexo == this.HOMBRE) {
            return imcHombre(calculoIMC);
        } else {
            return imcMujer(calculoIMC);
        }
    }

    private int imcHombre(float calculoIMC) {
        if (calculoIMC < 20) {
            return FALTA_DE_PESO;
        } else if (calculoIMC > 25) {
            return SOBREPESO;
        } else {
            return PESO_NORMAL;
        }
    }

    private int imcMujer(float calculoIMC) {
        if (calculoIMC < 19) {
            return FALTA_DE_PESO;
        } else if (calculoIMC > 24) {
            return SOBREPESO;
        } else {
            return PESO_NORMAL;
        }
    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    private boolean comprobarSexo(char sexo) {
        return sexo == HOMBRE || sexo == MUJER;
    }

    private String generaNSS() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 8);
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", nss=" + NSS + ", sexo=" + sexo + ", peso=" + peso + ", altura=" + altura + '}';
    }

}
