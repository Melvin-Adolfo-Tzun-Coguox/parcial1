package org.ejemplo;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) {
        ejemplo();
    }

        static void ejemplo2(){

                int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
                int fila = 1;
                int columna = 1;

                List<int[]> posicionesAdyacentes = encontrarPosicionesAdyacentes(matriz, fila, columna);
                System.out.println("Posiciones adyacentes a (" + fila + ", " + columna + "):");
                for (int[] posicion : posicionesAdyacentes) {
                    System.out.println("(" + posicion[0] + ", " + posicion[1] + ")");
                }
            }

            public static List<int[]> encontrarPosicionesAdyacentes(int[][] matriz, int fila, int columna) {
                List<int[]> posiciones = new ArrayList<>();

                // Verificar si la posición está dentro de la matriz
                if (fila >= 0 && fila < matriz.length && columna >= 0 && columna < matriz[0].length) {
                    // Posición arriba
                    if (fila - 1 >= 0) {
                        posiciones.add(new int[]{fila - 1, columna});
                    }
                    // Posición abajo
                    if (fila + 1 < matriz.length) {
                        posiciones.add(new int[]{fila + 1, columna});
                    }
                    // Posición izquierda
                    if (columna - 1 >= 0) {
                        posiciones.add(new int[]{fila, columna - 1});
                    }
                    // Posición derecha
                    if (columna + 1 < matriz[0].length) {
                        posiciones.add(new int[]{fila, columna + 1});
                    }
                }

                return posiciones;
    }

        static void ejemplo3(){
       
                ListNode head1 = createLinkedList(new int[]{4, 2, 1, 3});
                ListNode head2 = createLinkedList(new int[]{-1, 5, 3, 4, 0});

                Solution solution = new Solution();
                ListNode sortedHead1 = solution.sortList(head1);
                ListNode sortedHead2 = solution.sortList(head2);

                printLinkedList(sortedHead1);
                printLinkedList(sortedHead2);
            }

            private static ListNode createLinkedList(int[] values) {
                ListNode dummy = new ListNode(0);
                ListNode current = dummy;

                for (int val : values) {
                    current.next = new ListNode(val);
                    current = current.next;
                }

                return dummy.next;
            }

            private static void printLinkedList(ListNode head) {
                ListNode current = head;
                while (current != null) {
                    System.out.print(current.val + " ");
                    current = current.next;
                }
                System.out.println();
            }
        


    
        static void ejemplo(){
                int[] tablero = new int[64];
                int[] origenCasillasEspeciales = {7, 11, 31, 30, 40, 43, 50, 59};
                int[] destinoCasillasEspeciales = {38, 37, 46, 2, 21, 60, 5, 42};

                // Inicializar el tablero
                for (int i = 0; i < tablero.length; i++) {
                    tablero[i] = i + 1;
                }

                // Asignar las casillas especiales
                for (int i = 0; i < origenCasillasEspeciales.length; i++) {
                    tablero[origenCasillasEspeciales[i] - 1] = destinoCasillasEspeciales[i];
                }

                jugar(tablero);
            }

            public static void jugar(int[] tablero) {
                Random random = new Random();
                int jugador1 = 0;
                int jugador2 = 0;
                int contador6 = 0;

                while (true) {
                    // Turno del jugador 1
                    int dado = random.nextInt(6) + 1;
                    System.out.println("Jugador 1 tiró un " + dado);
                    jugador1 += dado;

                    // Verificar si el jugador 1 llegó al final del tablero
                    if (jugador1 >= tablero.length) {
                        System.out.println("¡El jugador 1 ha ganado!");
                        JOptionPane.showMessageDialog(null, "¡Felicidades! Eres el ganador");
                        break;
                    }

                    // Verificar si el jugador 1 cayó en una casilla especial
                    jugador1 = tablero[jugador1 - 1];
                    System.out.println("Jugador 1 está en la posición " + jugador1);

                    // Turno del jugador 2
                    dado = random.nextInt(6) + 1;
                    System.out.println("Jugador 2 tiró un " + dado);
                    jugador2 += dado;

                    // Verificar si el jugador 2 llegó al final del tablero
                    if (jugador2 >= tablero.length) {
                        System.out.println("¡El jugador 2 ha ganado!");
                        JOptionPane.showMessageDialog(null, "¡Felicidades! Eres el ganador");
                        break;
                    }

                    // Verificar si el jugador 2 cayó en una casilla especial
                    jugador2 = tablero[jugador2 - 1];
                    System.out.println("Jugador 2 está en la posición " + jugador2);

                    // Verificar si el jugador 1 sacó un 6 tres veces consecutivas

                    if (dado == 6) {
                        contador6++;
                        if (contador6 == 3) {
                            System.out.println("¡El jugador 1 ha sacado tres 6 consecutivos! Vuelve a la posición 1.");
                            jugador1 = 0;
                            contador6 = 0;
                        }
                        } else {
                            contador6 = 0;
                    }

                }



    }
}