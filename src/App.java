import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import DTO.inmueble;
import interfaces.ListadoDeNotas;
import interfaces.SepararPalabras;

public class App {
    public static void main(String[] args) throws Exception {

        App app = new App();
        // app.calculadora();
        // app.separarPalabras();
        // app.listaDeNotas();
        // app.listado();
        // app.listado();
        // app.listadoNotasAprobadas();
        // app.inmuebles();
        // app.calculadoraReactiva();
        // app.separarPalabrasreactiva();
        // app.listaNotasReactiva();
        // app.diccionarioNotasreactiva();
        // app.listadonotasAprobadasreactiva();
        app.inmobiliaria();

    }

    public void calculadora() {

        System.out.println("CALCULADORA CIENTÍFICA");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una operación");
        String operacion = sc.next();
        System.out.println("Ingrese el valor a operar");
        Double numero = sc.nextDouble();

        BiConsumer<String, Double> operaciones = (a, b) -> {
            if (a.equals("Seno")) {
                for (int i = 1; i <= b; i++) {
                    Double resultado = Math.sin(i);
                    System.out.println(i + "          " + resultado);
                }
            } else if (a.equals("Coseno")) {
                Double resultado = Math.cos(b);
                System.out.println(resultado);
            } else if (a.equals("Tangente")) {
                Double resultado = Math.tan(b);
                System.out.println(resultado);
            } else if (a.equals("Exponencial")) {
                Double resultado = Math.exp(b);
                System.out.println(resultado);
            } else if (a.equals("Logaritmo Neperiano")) {
                Double resultado = Math.log1p(b);
                System.out.println(resultado);
            }
        };

        operaciones.accept(operacion, numero);
    }

    public void separarPalabras() {

        /*
         * SepararPalabras sPalabras = (String a) -> { String[] partes = a.split(" ");
         * for (String elemento : partes) { String palabra = elemento.toString(); int
         * longitud = elemento.toString().length(); System.out.println(palabra + "    "
         * + longitud); } return partes; };
         * sPalabras.separarPalabras("La vida es bella");
         */

        Function<String, String[]> funcion = a -> {
            String[] partes = a.split(" ");
            for (String elemento : partes) {
                String palabra = elemento.toString();
                int longitud = elemento.toString().length();
                System.out.println(palabra + " " + longitud);
            }
            return partes;
        };
        funcion.apply("La vida es bella");
    }

    public void listaDeNotas() {
        String arr[][] = { { "Cálculo Multivariado y Vectorial", "5" }, { "Inglés", "3" }, { "Electiva", "4" } };
        ListadoDeNotas lNotas = (String[][] notas) -> {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.print(notas[i][j].toUpperCase());
                    System.out.print("     ");

                }
                System.out.println();
            }
            return notas;
        };
        lNotas.asignaturas(arr);
    }

    public void listado() {
        UnaryOperator<List<String>> lista = x -> {
            for (String string : x) {
                if (string.equals("5")) {
                    System.out.println("Cinco");
                } else if (string.contains("4")) {
                    System.out.println("Cuatro");
                } else if (string.contains("3")) {
                    System.out.println("Tres");
                } else if (string.contains("2")) {
                    System.out.println("Dos");
                } else if (string.contains("1")) {
                    System.out.println("Uno");
                }
            }
            return x;
        };
        lista.apply(new ArrayList<String>(Arrays.asList("5", "2", "3")));
        // List<String> notas = new ArrayList<String>(Arrays.asList("5","2","3"));
        // notas.forEach((String nota)-> System.out.println(nota));

    }

    public void listadoNotasAprobadas() {
        List<List<String>> listadoMaterias = new ArrayList<List<String>>();
        List<List<String>> listadoMateriasPasadas = new ArrayList<List<String>>();
        List<String> listadoMateriasPasadas2 = new ArrayList<>();
        List<String> conversion = new ArrayList<>();
        List<String> notas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            listadoMaterias.add(new ArrayList<String>());
        }
        listadoMaterias.get(0).add("Multivariado y Vectorial");
        listadoMaterias.get(0).add("3");
        listadoMaterias.get(1).add("Inglés");
        listadoMaterias.get(1).add("4");
        listadoMaterias.get(2).add("Programación");
        listadoMaterias.get(2).add("2");

        Predicate<String> listados = x -> (Integer.parseInt(x) >= 3);
        for (int i = 0; i < listadoMaterias.size(); i++) {
            boolean validacion = listados.test(listadoMaterias.get(i).get(1).toString());
            if (validacion) {
                listadoMateriasPasadas2 = new ArrayList<>();
                UnaryOperator<String> convertirAMayuscula = (x) -> x.toUpperCase();
                conversion.add(convertirAMayuscula.apply(listadoMaterias.get(i).get(0).toString()));
                notas.add(listadoMaterias.get(i).get(1).toString());
                listadoMateriasPasadas2.add(conversion.toString());
                listadoMateriasPasadas2.add(notas.toString());
                listadoMateriasPasadas.add(listadoMateriasPasadas2);
                conversion.clear();
                notas.clear();
            }
        }
        System.out.println(listadoMateriasPasadas);

    }

    public void inmuebles() {
        List<inmueble> listaInmuebles = new ArrayList<>();
        List<inmueble> resultado2 = new ArrayList<>();
        inmueble inm = new inmueble(2000, 100, 3, true, "A");
        inmueble inm2 = new inmueble(2012, 60, 2, true, "B");
        inmueble inm3 = new inmueble(1980, 120, 4, false, "A");
        inmueble inm4 = new inmueble(2005, 75, 3, true, "B");
        inmueble inm5 = new inmueble(2015, 90, 2, false, "A");
        listaInmuebles.add(inm);
        listaInmuebles.add(inm2);
        listaInmuebles.add(inm3);
        listaInmuebles.add(inm4);
        listaInmuebles.add(inm5);

        BiConsumer<List<inmueble>, Double> funciones2 = (x, y) -> {
            for (inmueble inmueble2 : x) {
                Predicate<inmueble> predicate = s -> s.getZona().contains("A");
                boolean zonaA = predicate.test(inmueble2);
                if (zonaA) {
                    double resultado = (inmueble2.getMetros() * 1000 + inmueble2.getHabitaciones() * 5000 + 15000);
                    UnaryOperator<inmueble> inmuebles = w -> new inmueble(inmueble2.getAno(), inmueble2.getMetros(),
                            inmueble2.getHabitaciones(), inmueble2.isGaraje(), inmueble2.getZona(), resultado);
                    Predicate<Double> predicate2 = p -> p > y;
                    boolean precio = predicate2.test(resultado);
                    if (precio) {
                        System.out.println(inmuebles.apply(inmueble2));
                    }
                } else {
                    double resultado = (inmueble2.getMetros() * 1000 + inmueble2.getHabitaciones() * 5000 + 4000);
                    UnaryOperator<inmueble> inmuebles = w -> new inmueble(inmueble2.getAno(), inmueble2.getMetros(),
                            inmueble2.getHabitaciones(), inmueble2.isGaraje(), inmueble2.getZona(), resultado);
                    Predicate<Double> predicate2 = p -> p > y;
                    boolean precio = predicate2.test(resultado);
                    if (precio) {
                        System.out.println(inmuebles.apply(inmueble2));
                    }
                }
            }
        };
        funciones2.accept(listaInmuebles, 13.0);

        // Function<List<inmueble>,Integer> funciones3 = x->(x.get(0).getMetros())

    }

    public void calculadoraReactiva() {
        System.out.println("CALCULADORA CIENTÍFICA");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una operación");
        String operacion = sc.next();
        System.out.println("Ingrese el valor a operar");
        Double numero = sc.nextDouble();

        BiConsumer<String, Double> operaciones = (a, b) -> {
            List<Double> resultados = new ArrayList<>();
            for (double i = 1; i <= b; i++) {
                resultados.add(i);
            }
            resultados.stream().filter(x -> a.equals("Seno")).map(x -> Math.sin(x)).forEach(x -> System.out.println(x));
            resultados.stream().filter(x -> a.equals("Coseno")).map(x -> Math.cos(x))
                    .forEach(x -> System.out.println(x));
            resultados.stream().filter(x -> a.equals("Tangente")).map(x -> Math.tan(x))
                    .forEach(x -> System.out.println(x));
            resultados.stream().filter(x -> a.equals("Exponencial")).map(x -> Math.exp(x))
                    .forEach(x -> System.out.println(x));
            resultados.stream().filter(x -> a.equals("Logaritmo")).map(x -> Math.log(x))
                    .forEach(x -> System.out.println(x));
        };
        operaciones.accept(operacion, numero);
    }

    public void separarPalabrasreactiva() {
        Function<String, List<String>> funcion = a -> {
            // String[] partes = a.split(" ");
            // List<String> partes2 = Arrays.asList(partes);
            List<String> partes2 = new ArrayList<>();
            partes2.add(a.toString());
            List<String> alfa = Arrays.asList(a.split(" "));
            alfa.stream().map(x -> x.concat(" " + x.length())).forEach(x -> System.out.println(x));
            return alfa;
        };
        funcion.apply("La vida es bella");
    }

    public void listaNotasReactiva() {
        List<Double> listado = List.of(3.6, 5.0, 4.7, 2.0);
        Function<List<Double>, List<String>> funcion = x -> {
            List<String> notas = new ArrayList<>();
            x.stream().filter(y -> y >= 0 && y < 1.0).forEach(y -> notas.add("Deficiente"));
            x.stream().filter(y -> y >= 1.0 && y < 2.0).forEach(y -> notas.add("Insuficiente"));
            x.stream().filter(y -> y >= 2.0 && y < 3.0).forEach(y -> notas.add("Aceptable"));
            x.stream().filter(y -> y >= 3.0 && y < 4.0).forEach(y -> notas.add("Sobresaliente"));
            x.stream().filter(y -> y >= 4.0 && y <= 5.0).forEach(y -> notas.add("Excelente"));
            System.out.println(notas.toString());
            notas.stream().sorted().forEach((String elemento) -> System.out.println(elemento));
            return notas;
        };
        funcion.apply(listado);
    }

    public void diccionarioNotasreactiva() {
        String arr[][] = { { "Cálculo Multivariado y Vectorial", "5" }, { "Inglés", "3" }, { "Electiva", "4" } };
        List<List<String>> listaNotasyMaterias = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            listaNotasyMaterias.add(new ArrayList<>());
            for (int j = 0; j < 2; j++) {
                listaNotasyMaterias.get(i).add(arr[i][j]);
            }
        }
        listaNotasyMaterias.stream().map(x -> x.toString().toUpperCase()).forEach(System.out::println);
    }

    public void listadonotasAprobadasreactiva() {
        String arr[][] = { { "Cálculo Multivariado y Vectorial", "5" }, { "Inglés", "3" }, { "Electiva", "2" } };
        List<List<String>> listadoNotas = new ArrayList<>();
        List<String> listadoNotasAprobadas = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            listadoNotas.add(new ArrayList<>());
            for (int j = 0; j < 2; j++) {
                listadoNotas.get(i).add(arr[i][j]);
            }
            listadoNotasAprobadas = listadoNotas.stream().filter(x -> Integer.parseInt(x.get(1)) >= 3)
                    .map(x -> x.toString().toUpperCase()).collect(Collectors.toList());
        }
        listadoNotasAprobadas.stream().forEach(System.out::println);
    }

    public void inmobiliaria() {
        List<inmueble> resultadoInmueblesA = new ArrayList<>();
        List<inmueble> resultadoInmueblesB = new ArrayList<>();
        List<inmueble> Inmueble = new ArrayList<>();
        Inmueble.add(new inmueble(2000, 100, 3, true, "A"));
        Inmueble.add(new inmueble(2012, 60, 2, true, "B"));
        Inmueble.add(new inmueble(1980, 120, 4, false, "A"));
        Inmueble.add(new inmueble(2005, 75, 3, true, "B"));
        Inmueble.add(new inmueble(2015, 90, 2, false, "A"));
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese un precio");
        Double precio = sc.nextDouble();

        resultadoInmueblesA = Inmueble.stream().filter(x -> x.getZona().equals("A"))
                .map(x -> new inmueble(x.getAno(), x.getMetros(), x.getHabitaciones(), x.isGaraje(), x.getZona(),
                        x.getMetros() * 1000 + x.getHabitaciones() * 5000 + 15000))
                .filter(x -> x.getPrecio() < precio).collect(Collectors.toList());

        resultadoInmueblesB = Inmueble.stream().filter(x -> x.getZona().equals("B"))
                .map(x -> new inmueble(x.getAno(), x.getMetros(), x.getHabitaciones(), x.isGaraje(), x.getZona(),
                        x.getMetros() * 2000 + x.getHabitaciones() * 6000 + 15000))
                .filter(x -> x.getPrecio() < precio).collect(Collectors.toList());

        List<inmueble> resultList = Stream.concat(resultadoInmueblesA.stream(), resultadoInmueblesB.stream())
                .collect(Collectors.toList());
        resultList.stream().forEach(System.out::println);

    }

}