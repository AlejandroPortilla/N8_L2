package com.mycompany.proyecto1;
//Añadiendo importaciones
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import mundo.Alumno;
import java.io.FileWriter;
import java.io.IOException;



public class Proyecto1 {
    public static void main(String[] args) {
        //definiendo variables lector y activo
        Scanner lector = new Scanner(System.in);        
        ArrayList<Alumno> misAlumnos = new ArrayList<Alumno>();
        
        cargarDatosDesdeArchivo(misAlumnos);
        
        boolean activo = true;
        
        //abriendo un do-while para que el menu se repita hasta que la bandera sea 5
        
        do {
            System.out.println("Menú de Opciones:");
            System.out.println("Qué operación deseas hacer:");
            System.out.println("1. Insertar Alumno");
            System.out.println("2. Eliminar Alumno");
            System.out.println("3. Modificar Alumno");
            System.out.println("4. Consultar Alumno");
            System.out.println("5. Mostrar listado de Alumnos:");
            System.out.println("6. Generar un reporte en txt");
            System.out.println("7. elimina los archivos dentro del archivo txt");
            System.out.println("8. elimina un estudiante dentro del txt");
            System.out.println("9. Terminar Programa:");
            System.out.println("Seleccione una opción: ");
            
            int opcion = lector.nextInt();
            //aqui abrimos el switch en el que se va a cumplir lo de el menu de opciones
            switch (opcion) {
                case 1:
                    System.out.println("Ha seleccionado la Opción 1. (Insertar Alumno)");
                    //llamando a la funcion agregarAlumno
                    agregarAlumno(misAlumnos, lector);
                    break;
                case 2:
                    System.out.println("Ha seleccionado la Opción 2. (Eliminar Alumno)");
                    //llamando a la funcion eliminarAlumno
                    eliminarAlumno(misAlumnos, lector);
                    break;
                case 3:
                    System.out.println("Ha seleccionado la Opción 3. (Modificar Alumno)");
                    //llamando a la funcion modificarAlumno
                    modificarAlumno(misAlumnos,lector);
                    break;
                case 4:
                    System.out.println("Ha seleccionado la Opción 4. (Consultar Alumno)");
                    //llamando a la funcion consultarAlumno
                    consultarAlumno(misAlumnos, lector);
                    break;
                case 5:
                    System.out.println("Ha seleccionado la Opción 5. (mostrar listado de Alumnos)");
                    mostrarListadoAlumnos(misAlumnos);
                    break;
                case 6:
                    System.out.println("Ha seleccionado la opcion 6. (Generar reporte");
                    generarReporte(misAlumnos);
                    break;
                case 7:
                    eliminarArchivo("data.txt");
                    break;
                case 8:
                    System.out.println("Ha seleccionado la opción 8. (Eliminar estudiante)");
                    System.out.print("Digita la cedula del estudiante que quieres eliminar: ");
                    String cedulaEliminar = lector.next();
                    eliminarEstudiantePorCedulaTXT(misAlumnos, cedulaEliminar);
                    break;
                case 9:
                    System.out.println("Saliendo del programa.");
                    guardarDatosEnArchivo(misAlumnos); // Guardar datos antes de salir
                    activo = false;
            break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
            //cerramos el while y se coloca la variable activo como bandera
        } while (activo);
         //cerramos el scanner(lector)  
        lector.close();
    }
    //FUNCIONES DEL SWITCH

    public static void agregarAlumno(ArrayList<Alumno> listaAlumnos, Scanner lector) {
    Alumno nuevoAlumno = new Alumno();

    System.out.print("Introduzca el nombre: ");
    nuevoAlumno.setNombre(lector.next().trim());
    while (nuevoAlumno.getNombre().isEmpty()) {
        System.out.println("El nombre no puede estar vacío. Introduzca el nombre nuevamente: ");
        nuevoAlumno.setNombre(lector.next().trim());
    }

    System.out.print("Introduce el apellido del alumno: ");
    nuevoAlumno.setApellido(lector.next().trim());
    while (nuevoAlumno.getApellido().isEmpty()) {
        System.out.println("El apellido no puede estar vacío. Introduzca el apellido nuevamente: ");
        nuevoAlumno.setApellido(lector.next().trim());
    }

    System.out.print("Introduce la cédula del alumno: ");
    nuevoAlumno.setCedula(lector.next().trim());
    while (nuevoAlumno.getCedula().isEmpty()) {
        System.out.println("La cédula no puede estar vacía. Introduzca la cédula nuevamente: ");
        nuevoAlumno.setCedula(lector.next().trim());
    }

    System.out.print("Introduce el semestre del alumno: ");
    nuevoAlumno.setSemestre(lector.next().trim());
    while (nuevoAlumno.getSemestre().isEmpty()) {
        System.out.println("El semestre no puede estar vacío. Introduzca el semestre nuevamente: ");
        nuevoAlumno.setSemestre(lector.next().trim());
    }

    System.out.print("Introduce el correo del alumno: ");
    nuevoAlumno.setCorreo(lector.next().trim());
    while (nuevoAlumno.getCorreo().isEmpty()) {
        System.out.println("El correo no puede estar vacío. Introduzca el correo nuevamente: ");
        nuevoAlumno.setCorreo(lector.next().trim());
    }

    System.out.print("Introduce el celular del alumno: ");
    nuevoAlumno.setTelefono(lector.next().trim());
    while (nuevoAlumno.getTelefono().isEmpty()) {
        System.out.println("El celular no puede estar vacío. Introduzca el celular nuevamente: ");
        nuevoAlumno.setTelefono(lector.next().trim());
    }

    listaAlumnos.add(nuevoAlumno);
    System.out.println("Alumno agregado exitosamente.");
}
    
    public static void eliminarAlumno(ArrayList<Alumno> listaAlumnos, Scanner lector) {
    System.out.print("Ingrese la cédula del alumno a eliminar: ");
    String cedulaEliminar = lector.next();

    Alumno alumnoAEliminar = null;
    for (Alumno alumno : listaAlumnos) {
        if (alumno.getCedula().equals(cedulaEliminar)) {
            alumnoAEliminar = alumno;
            break;
        }
    }

    if (alumnoAEliminar != null) {
        listaAlumnos.remove(alumnoAEliminar);
        System.out.println("Alumno eliminado exitosamente.");
    } else {
        System.out.println("No se encontró ningún alumno con la cédula proporcionada.");
    }
}

    public static void modificarAlumno(ArrayList<Alumno> listaAlumnos, Scanner lector) {
    System.out.print("Ingrese la cédula del alumno a modificar: ");
    String cedulaModificar = lector.next();

    boolean encontrado = false;
    for (Alumno alumno : listaAlumnos) {
        if (alumno.getCedula().equals(cedulaModificar)) {
            System.out.println("Modificando datos del alumno: " + alumno.getNombre() + " " + alumno.getApellido());

            System.out.print("Introduzca el nuevo nombre (Dejar vacío para no cambiar): ");
            String nuevoNombre = lector.next().trim();
            if (!nuevoNombre.isEmpty()) {
                alumno.setNombre(nuevoNombre);
            }

            System.out.print("Introduce el nuevo apellido (Dejar vacío para no cambiar): ");
            String nuevoApellido = lector.next().trim();
            if (!nuevoApellido.isEmpty()) {
                alumno.setApellido(nuevoApellido);
            }

            System.out.print("Introduce el nuevo semestre (Dejar vacío para no cambiar): ");
            String nuevoSemestre = lector.next().trim();
            if (!nuevoSemestre.isEmpty()) {
                alumno.setSemestre(nuevoSemestre);
            }

            System.out.print("Introduce el nuevo correo (Dejar vacío para no cambiar): ");
            String nuevoCorreo = lector.next().trim();
            if (!nuevoCorreo.isEmpty()) {
                alumno.setCorreo(nuevoCorreo);
            }

            System.out.print("Introduce el nuevo celular (Dejar vacío para no cambiar): ");
            String nuevoTelefono = lector.next().trim();
            if (!nuevoTelefono.isEmpty()) {
                alumno.setTelefono(nuevoTelefono);
            }

            System.out.println("Alumno modificado exitosamente.");
            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        System.out.println("No se encontró ningún alumno con la cédula proporcionada.");
    }
}
    
    public static void consultarAlumno(ArrayList<Alumno> listaAlumnos, Scanner lector) {
    System.out.print("Ingrese la cédula del alumno a consultar: ");
    String cedulaConsultar = lector.next();

    Alumno alumnoConsultado = null;
    for (Alumno alumno : listaAlumnos) {
        if (alumno.getCedula().equals(cedulaConsultar)) {
            alumnoConsultado = alumno;
            break;
        }
    }

    if (alumnoConsultado != null) {
        System.out.println("Datos del alumno:");
        System.out.println("Nombre: " + alumnoConsultado.getNombre());
        System.out.println("Apellido: " + alumnoConsultado.getApellido());
        System.out.println("Cédula: " + alumnoConsultado.getCedula());
        System.out.println("Semestre: " + alumnoConsultado.getSemestre());
        System.out.println("Correo: " + alumnoConsultado.getCorreo());
        System.out.println("Celular: " + alumnoConsultado.getTelefono());
    } else {
        System.out.println("No se encontró ningún alumno con la cédula proporcionada.");
    }
    
}
    
    public static void mostrarListadoAlumnos(ArrayList<Alumno> listaAlumnos) {
    if (listaAlumnos.isEmpty()) {
        System.out.println("No hay nada en el array.");
    } else {
        System.out.println("Listado de Alumnos:");
        for (Alumno alumno : listaAlumnos) {
            System.out.println("---------------------------");
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("Cédula: " + alumno.getCedula());
            System.out.println("Semestre: " + alumno.getSemestre());
            System.out.println("Correo: " + alumno.getCorreo());
            System.out.println("Celular: " + alumno.getTelefono());
            System.out.println("---------------------------");
                    
        }
    }
}

   public static void generarReporte(ArrayList<Alumno> listaAlumnos) {
    try {
        File archivo = new File("data.txt");
        
        if (!archivo.exists()) {
            archivo.createNewFile();
        }

        // Crear una nueva lista para almacenar alumnos con cédulas únicas
        ArrayList<Alumno> listaAlumnosUnicos = new ArrayList<>();

        // Filtrar y agregar solo los alumnos con cédulas únicas a la nueva lista
        for (Alumno alumno : listaAlumnos) {
            boolean cedulaRepetida = false;
            for (Alumno alumnoUnico : listaAlumnosUnicos) {
                if (alumnoUnico.getCedula().equals(alumno.getCedula())) {
                    cedulaRepetida = true;
                    break;
                }
            }
            if (!cedulaRepetida) {
                listaAlumnosUnicos.add(alumno);
            }
        }

        FileWriter writer = new FileWriter(archivo, true); // Modo de apéndice

        for (Alumno alumno : listaAlumnosUnicos) {
            writer.write("Nombre: " + alumno.getNombre() + "\n");
            writer.write("Apellido: " + alumno.getApellido() + "\n");
            writer.write("Cédula: " + alumno.getCedula() + "\n");
            writer.write("Semestre: " + alumno.getSemestre() + "\n");
            writer.write("Correo: " + alumno.getCorreo() + "\n");
            writer.write("Celular: " + alumno.getTelefono() + "\n");
            writer.write("---------------------------\n");
        }

        writer.close();
        System.out.println("Reporte generado exitosamente.");
    } catch (IOException e) {
        System.out.println("Error al generar el reporte: " + e.getMessage());
    }
}
    
   public static void eliminarArchivo(String data) {
        File archivo = new File(data);

        if (archivo.exists()) {
            if (archivo.delete()) {
                System.out.println("Archivo eliminado exitosamente.");
            } else {
                System.out.println("No se pudo eliminar el archivo.");
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }
   
   public static void eliminarEstudiantePorCedulaTXT(ArrayList<Alumno> listaAlumnos, String cedula) {
        Alumno estudianteEliminar = null;
        for (Alumno alumno : listaAlumnos) {
            if (alumno.getCedula().equals(cedula)) {
                estudianteEliminar = alumno;
                break;
            }
        }

        if (estudianteEliminar != null) {
            listaAlumnos.remove(estudianteEliminar);
            System.out.println("Estudiante eliminado exitosamente.");

            // Volver a escribir el archivo con la lista actualizada
            try {
                FileWriter fileWriter = new FileWriter("data.txt", false);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for (Alumno alumno : listaAlumnos) {
                    bufferedWriter.write("Nombre: " + alumno.getNombre());
                    bufferedWriter.newLine();
                    bufferedWriter.write("Apellido: " + alumno.getApellido());
                    bufferedWriter.newLine();
                    bufferedWriter.write("Cédula: " + alumno.getCedula());
                    bufferedWriter.newLine();
                    bufferedWriter.write("Semestre: " + alumno.getSemestre());
                    bufferedWriter.newLine();
                    bufferedWriter.write("Correo: " + alumno.getCorreo());
                    bufferedWriter.newLine();
                    bufferedWriter.write("Celular: " + alumno.getTelefono());
                    bufferedWriter.newLine();
                    bufferedWriter.newLine(); // Separador entre estudiantes
                }

                bufferedWriter.close();
            } catch (IOException e) {
                System.out.println("Error al escribir el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("No se encontró ningún estudiante con la cédula proporcionada.");
        }
    }
   
   public static void cargarDatosDesdeArchivo(ArrayList<Alumno> listaAlumnos) {
    try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
        String line;
        Alumno alumnoActual = new Alumno();
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Cédula: ")) {
                if (alumnoActual.getCedula() != null) {
                    listaAlumnos.add(alumnoActual);
                    alumnoActual = new Alumno();
                }
                alumnoActual.setCedula(line.substring("Cédula: ".length()));
            } else if (line.startsWith("Nombre: ")) {
                alumnoActual.setNombre(line.substring("Nombre: ".length()));
            } else if (line.startsWith("Apellido: ")) {
                alumnoActual.setApellido(line.substring("Apellido: ".length()));
            } else if (line.startsWith("Semestre: ")) {
                alumnoActual.setSemestre(line.substring("Semestre: ".length()));
            } else if (line.startsWith("Correo: ")) {
                alumnoActual.setCorreo(line.substring("Correo: ".length()));
            } else if (line.startsWith("Celular: ")) {
                alumnoActual.setTelefono(line.substring("Celular: ".length()));
            }
        }
        if (alumnoActual.getCedula() != null) {
            listaAlumnos.add(alumnoActual);
        }
    } catch (IOException e) {
        System.out.println("Error al cargar los datos desde el archivo: " + e.getMessage());
    }
}

   public static void guardarDatosEnArchivo(ArrayList<Alumno> listaAlumnos) {
    try {
        FileWriter fileWriter = new FileWriter("data.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (Alumno alumno : listaAlumnos) {
            bufferedWriter.write("Nombre: " + alumno.getNombre() + "\n");
            bufferedWriter.write("Apellido: " + alumno.getApellido() + "\n");
            bufferedWriter.write("Cédula: " + alumno.getCedula() + "\n");
            bufferedWriter.write("Semestre: " + alumno.getSemestre() + "\n");
            bufferedWriter.write("Correo: " + alumno.getCorreo() + "\n");
            bufferedWriter.write("Celular: " + alumno.getTelefono() + "\n");
            bufferedWriter.write("---------------------------\n");
        }

        bufferedWriter.close();
        fileWriter.close();
    } catch (IOException e) {
        System.out.println("Error al guardar los datos en el archivo: " + e.getMessage());
    }
}
   
   

       



      



}
