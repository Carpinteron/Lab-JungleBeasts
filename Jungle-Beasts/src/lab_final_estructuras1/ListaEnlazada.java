/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_final_estructuras1;

import lab_final_estructuras1.Tablero.Nodo;

public class ListaEnlazada {

        Nodo head; // El primer nodo de la lista

        public ListaEnlazada() {
            head = null;
        }

        public void agregarAlInicio(String dato) {
            Nodo nuevoNodo = new Nodo(dato);
            nuevoNodo.siguiente = head;
            head = nuevoNodo;
        }

        public void agregarAlFinal(String dato) {
            Nodo nuevoNodo = new Nodo(dato);

            // Si la lista está vacía, el nuevo nodo será la cabeza
            if (head == null) {
                head = nuevoNodo;
            } else {
                Nodo nodoActual = head;
                while (nodoActual.siguiente != null) {
                    nodoActual = nodoActual.siguiente;
                }
                nodoActual.siguiente = nuevoNodo;
            }
        }

        public boolean buscardato(String dato) {
            Nodo nodoActual = head;
            boolean seEncontro = false;

            if (head == null) {
                return false;
            }
            while (nodoActual != null) {

                if (nodoActual.dato.equalsIgnoreCase(dato)) {
                    return true;
                }
                nodoActual = nodoActual.siguiente;
            }
            return false;

        }

        public void insertar(String dato) {
            Nodo nuevoNodo = new Nodo(dato);

            if (head == null) {
                // Si la lista está vacía, el nuevo nodo se convierte en la cabeza
                head = nuevoNodo;
            } else {
                // Si la lista no está vacía, recorremos la lista hasta el último nodo
                // y luego enlazamos el último nodo con el nuevo nodo
                Nodo actual = head;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevoNodo;
            }
        }

        public void mostrarLista() {
            Nodo nodoActual = head;
            while (nodoActual != null) {
                System.out.print(nodoActual.dato + " -> ");
                nodoActual = nodoActual.siguiente;
            }
            System.out.println("null");
        }

        public int buscarPosicionporDato(String dato) {
            Nodo nodoActual = head;
            int indice = 0;

            while (nodoActual != null) {
                if (nodoActual.dato.equals(dato)) {
                    return indice; // Se encontró el dato en esta posición
                }
                nodoActual = nodoActual.siguiente;
                indice++;
            }

            return -1; // El dato no se encontró en la lista
        }

        public int contarRepeticiones(String elemento) {
            int contador = 0;
            Nodo actual = head;
            while (actual != null) {
                if (actual.dato.equals(elemento)) {
                    contador++;
                }
                actual = actual.siguiente;
            }
            return contador;
        }

        public boolean modificarDatoEnPosicion(int posicion, String nuevoDato) {
            if (posicion < 0) {
                return false; // Posición inválida
            }

            Nodo nodoActual = head;
            int indice = 0;

            while (nodoActual != null) {
                if (indice == posicion) {
                    nodoActual.dato = nuevoDato; // Modifica el dato del nodo en la posición deseada
                    return true; // Nodo encontrado y modificado
                }
                nodoActual = nodoActual.siguiente;
                indice++;
            }

            return false; // La posición está más allá del final de la lista
        }

        public String buscarPorPosicion(int posicion) {
            if (posicion < 0) {
                return null; // Posición inválida
            }

            Nodo nodoActual = head;
            int indice = 0;

            while (nodoActual != null) {
                if (indice == posicion) {
                    return nodoActual.dato; // Encontramos el nodo en la posición deseada
                }
                nodoActual = nodoActual.siguiente;
                indice++;
            }

            return null; // La posición está más allá del final de la lista
        }

        public void eliminarNodo(String valor) {
            Nodo temp = head;
            Nodo previo = null;

            // Si el nodo a eliminar es la cabeza
            if (temp != null && temp.dato.equals(valor)) {
                head = temp.siguiente;
                return;
            }

            // Buscar el nodo a eliminar
            while (temp != null && !temp.dato.equals(valor)) {
                previo = temp;
                temp = temp.siguiente;
            }

            // Si no se encuentra el valor en la lista
            if (temp == null) {
                System.out.println("El valor no se encontró en la lista enlazada.");
                return;
            }

            // Eliminar el nodo encontrado
            previo.siguiente = temp.siguiente;
        }
    }