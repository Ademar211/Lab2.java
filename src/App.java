import grades.GradeManager;
import java.util.Scanner;
public class App {

    public static void main(String[] args) {

        GradeManager gradeManager = new GradeManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== GESTIÓN DE NOTAS =====");
            System.out.println("1. Agregar una nota");
            System.out.println("2. Ver la nota promedio");
            System.out.println("3. Ver número de aprobados");
            System.out.println("4. Salir");
            System.out.println("5. Eliminar una nota");
            System.out.println("============================");

            System.out.print("Elige una opción: ");

            try {

                int choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Ingrese una nota: ");
                        double grade = scanner.nextDouble();

                        if (grade < 0 || grade > 100) {
                            System.out.println(
                                "Error: la nota debe estar entre 0 y 100."
                            );
                        } else {
                            gradeManager.addGrade(grade);
                            System.out.println("Nota agregada correctamente.");
                        }

                        break;

                    case 2:
                        System.out.println(
                            "Promedio: " +
                            gradeManager.calculateAverage()
                        );

                        break;

                    case 3:
                        System.out.println(
                            "Número de aprobados: " +
                            gradeManager.countPassingGrades()
                        );

                        break;

                    case 4:
                        System.out.println("Saliendo del programa...");
                        scanner.close();
                        System.exit(0);

                        break;

                    case 5:

                        gradeManager.showGrades();

                        System.out.println("\n¿Cómo desea eliminar la nota?");
                        System.out.println("1. Por posición");
                        System.out.println("2. Por valor");
                        System.out.print("Elija una opción: ");

                        int deleteOption = scanner.nextInt();

                        if (deleteOption == 1) {

                            System.out.print("Ingrese la posición: ");
                            int position = scanner.nextInt();

                            if (gradeManager.removeGradeByPosition(position)) {
                                System.out.println(
                                    "Nota eliminada correctamente."
                                );
                            } else {
                                System.out.println(
                                    "Error: posición inválida."
                                );
                            }

                        } else if (deleteOption == 2) {

                            System.out.print("Ingrese el valor de la nota: ");
                            double value = scanner.nextDouble();

                            if (gradeManager.removeGradeByValue(value)) {
                                System.out.println(
                                    "Nota eliminada correctamente."
                                );
                            } else {
                                System.out.println(
                                    "No se encontró esa nota."
                                );
                            }

                        } else {
                            System.out.println("Opción inválida.");
                        }

                        break;

                    default:
                        System.out.println(
                            "Opción inválida. Intente nuevamente."
                        );
                }

            } catch (Exception e) {

                System.out.println(
                    "Entrada inválida. Por favor, ingrese un número."
                );

                scanner.nextLine();
            }
        }
    }
}
}
