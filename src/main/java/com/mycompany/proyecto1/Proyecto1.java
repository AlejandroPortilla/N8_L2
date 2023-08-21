package com.mycompany.proyecto1;
//Añadiendo importaciones
import java.util.Scanner;
import java.util.ArrayList;
import mundo.Alumno;    

public class Proyecto1 {
    public static void main(String[] args) {
        //definiendo variables lector y activo
        Scanner lector = new Scanner(System.in);
        boolean activo = true;
        
        //creando el array en el que se va a guardar cada cosa
        ArrayList<Alumno> misAlumnos = new ArrayList<Alumno>();
        
        //abriendo un do-while para que el menu se repita hasta que la bandera sea 5
        
        do {
            System.out.println("Menú de Opciones:");
            System.out.println("Qué operación deseas hacer:");
            System.out.println("1. Insertar Alumno");
            System.out.println("2. Eliminar Alumno");
            System.out.println("3. Modificar Alumno");
            System.out.println("4. Consultar Alumno");
            System.out.println("5. Mostrar listado de Alumnos:");
            System.out.println("6. Terminar Programa:");
            System.out.print("Seleccione una opción: ");
            
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
                    System.out.println("Saliendo del programa.");
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
            String nuevoNombre = lector.nextLine().trim();
            if (!nuevoNombre.isEmpty()) {
                alumno.setNombre(nuevoNombre);
            }

            System.out.print("Introduce el nuevo apellido (Dejar vacío para no cambiar): ");
            String nuevoApellido = lector.nextLine().trim();
            if (!nuevoApellido.isEmpty()) {
                alumno.setApellido(nuevoApellido);
            }

            System.out.print("Introduce el nuevo semestre (Dejar vacío para no cambiar): ");
            String nuevoSemestre = lector.nextLine().trim();
            if (!nuevoSemestre.isEmpty()) {
                alumno.setSemestre(nuevoSemestre);
            }

            System.out.print("Introduce el nuevo correo (Dejar vacío para no cambiar): ");
            String nuevoCorreo = lector.nextLine().trim();
            if (!nuevoCorreo.isEmpty()) {
                alumno.setCorreo(nuevoCorreo);
            }

            System.out.print("Introduce el nuevo celular (Dejar vacío para no cambiar): ");
            String nuevoTelefono = lector.nextLine().trim();
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
    System.out.println("Listado de Alumnos:");
    for (Alumno alumno : listaAlumnos) {
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
