import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import DTO.inmueble;

public class App2 {

    public static void main(String[] args) {
        App2 app = new App2();
        app.calculadoraReactiva();
        app.separarPalabrasreactiva();
        app.listaNotasReactiva();
        app.diccionarioNotasreactiva();
        app.listadonotasAprobadasreactiva();
        app.inmobiliaria();
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
            resultados.stream().filter(x -> a.equals("Coseno")).map(x -> Math.cos(x)).forEach(x -> System.out.println(x));
            resultados.stream().filter(x -> a.equals("Tangente")).map(x -> Math.tan(x)).forEach(x -> System.out.println(x));
            resultados.stream().filter(x -> a.equals("Exponencial")).map(x -> Math.exp(x)).forEach(x -> System.out.println(x));
            resultados.stream().filter(x -> a.equals("Logaritmo")).map(x -> Math.log(x)).forEach(x -> System.out.println(x));
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
