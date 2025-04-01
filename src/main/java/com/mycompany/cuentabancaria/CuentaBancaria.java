/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cuentabancaria;

/**
 *
 * @author HP
 */
import java.util.Scanner;

public class CuentaBancaria {
    // Atributo privado para el saldo
    private double saldo;

    // Constructor que inicializa el saldo a 0
    public CuentaBancaria() {
        this.saldo = 0.0;
    }

    // Getter para obtener el saldo
    public double getSaldo() {
        return saldo;
    }

    // Método para depositar dinero
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Se han depositado " + cantidad + ". Nuevo saldo: " + saldo);
        } else {
            System.out.println("La cantidad a depositar debe ser mayor que 0.");
        }
    }

    // Método para retirar dinero
    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Se han retirado " + cantidad + ". Nuevo saldo: " + saldo);
        } else if (cantidad > saldo) {
            System.out.println("Fondos insuficientes. Saldo actual: " + saldo);
        } else {
            System.out.println("La cantidad a retirar debe ser mayor que 0.");
        }
    }

    // Método principal para probar la clase
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CuentaBancaria cuenta = new CuentaBancaria();
        boolean continuar = true;

        while (continuar) {
            System.out.println("¿Desea (1) Depositar o (2) Retirar dinero? (0 para salir)");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double cantidadDeposito = scanner.nextDouble();
                    cuenta.depositar(cantidadDeposito);
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double cantidadRetiro = scanner.nextDouble();
                    cuenta.retirar(cantidadRetiro);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

            // Mostrar saldo actual
            System.out.println("Saldo actual: " + cuenta.getSaldo());
        }

        System.out.println("Gracias por usar el sistema bancario.");
        scanner.close();
    }
}
