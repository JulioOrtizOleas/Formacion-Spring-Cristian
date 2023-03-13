package V1_Imperativa;

import java.util.ArrayList;
import java.util.List;

public class TestFuncinalApplication {
    public static void main(String[] args) {
        new TestFuncinalApplication();
    }



    public TestFuncinalApplication(){
        /*Crear lista de enteros */
List<Integer> numeros = crearLista();
        /*Quedarme solo con los pares */
List<Integer> pares = filtrarPares(numeros);
        System.out.println(pares);
        /*Pasar cada numero al cuadrado */
List<Integer> cuadrados = elevarAlCuadrado(pares);
        System.out.println(cuadrados);
        /*Mostrar cada cuadrado por pantalla*/
List<Integer> mostrandoLista = mostrarLista(cuadrados);
        /*Obtener la suma de los cuadrados*/
        int totalCuadrados = sumarLista(mostrandoLista);
        System.out.println("Suma de cuadrados: " + totalCuadrados);
    }

    private List<Integer> crearLista(){
/*crea una lista*/
//return Arrays.asList(0,1,2,3,5,8,13,21,34)
/*Construye una lista que no se puede modificar*/
        return List.of(0,1,2,3,5,8,13,21,34);

    }
    private List<Integer>filtrarPares(List<Integer> numeros){
        List<Integer>resultado = new ArrayList<>();
        // Se recorre la lista y se agrega a la lista resultado solo los números de la lista
// original que sean pares
        for (Integer num : numeros) {
            if(num % 2 == 0){
                resultado.add(num);
            }
        }
        return resultado;
    }
    private List<Integer>elevarAlCuadrado(List<Integer> pares){
        List<Integer>resultado = new ArrayList<>();
        // Se recorre la lista y se agrega a la lista resultado el cuadrado de los número originales
        for (Integer numPar: pares) {
            resultado.add(numPar * numPar);
        }
        return resultado;
    }
    private List<Integer>mostrarLista(List<Integer> cuadrados){
        for (Integer numParCuadrado: cuadrados) {
            System.out.println(numParCuadrado);
        }
        return cuadrados;
    }
    private int sumarLista(List<Integer>cuadrados){
        int total = 0;
        for (Integer numero : cuadrados) {
            total +=numero;
        }
        return total;
    }
}
