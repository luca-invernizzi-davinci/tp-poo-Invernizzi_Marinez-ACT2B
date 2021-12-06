import java.util.Locale;
import java.util.Scanner;

public class CuentaBancaria {

    //Atributos
    String nombreCliente;
    String dniCliente;
    double saldo;
    double ultimoMovimiento;
    String opcion;

    //Constructores
    public CuentaBancaria(String nombreCliente, String dniCliente) {
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
    }

    public CuentaBancaria(String nombreCliente, String dniCliente, double saldo) {
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
        this.saldo = saldo;
    }

    //Metodos
    private void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo = saldo + cantidad;
            ultimoMovimiento=cantidad;
        }
    }

    private void retirar(double cantidad) {
        if (cantidad > 0) {
            cantidad= Double.parseDouble("-" + cantidad);
            saldo = saldo + cantidad;
            ultimoMovimiento=cantidad;
        }
        if (saldo < cantidad){
            System.out.println("No tenes plata \n");
        }
    }

    public void consultarUltimoMovimiento(double ultimoMovimiento) {
        if (ultimoMovimiento > 0){
            System.out.println("Cantidad depositada: " + ultimoMovimiento + "\n");
        } else if (ultimoMovimiento < 0) {
            System.out.println("Cantidad retirada: " + ultimoMovimiento + "\n");
        } else if (ultimoMovimiento == 0 ) {
            System.out.println("No se han realizado transacciones \n");
        }
    }



    public void mostrarMenu (){
        System.out.println("Bienvenido " + nombreCliente);
        System.out.println("Ingrese una opción:\n" +
                "Opción A: Consultar Saldo.\n" +
                "Opción B: Depositar\n" +
                "Opción C: Retirar\n" +
                "Opción D: Consultar último movimiento\n" +
                "Opción E: Salir.");
        Scanner sc = new Scanner(System.in);
        String opcion;
        opcion = sc.nextLine();
        switch (opcion.toUpperCase()) {
            case "A":
                System.out.println("Su saldo es: " + saldo);
                break;
            case "B":
                Scanner scb = new Scanner(System.in);
                double deposito;
                System.out.println("Ingrese cantidad a depositar");
                deposito = scb.nextDouble();
                depositar(deposito);
                mostrarMenu();
                break;
            case "C":
                Scanner scc = new Scanner(System.in);
                double retiro;
                System.out.println("Ingrese cantidad a retirar");
                retiro = scc.nextDouble();
                retirar(retiro);
                mostrarMenu();
                break;
            case "D":
                consultarUltimoMovimiento(ultimoMovimiento);
                mostrarMenu();
                break;
            case "E":
                System.out.println("Hasta luego, tenga un buen día");
                break;
            default:
                System.out.println("Opción inválida, intente de nuevo");
                mostrarMenu();
        }
    }


}
