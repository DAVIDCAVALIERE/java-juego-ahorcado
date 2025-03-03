import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String palabraSecreta = "inteligencia";
        int intentos = 0;
        int intentosMaximos = 3;
        boolean palabraAdivinada = false;
        
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        for (int i = 0; i < palabraSecreta.length(); i++) {
            letrasAdivinadas[i] = '_';
        }

        while (palabraAdivinada == false && intentos < intentosMaximos) {
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");
            System.out.println("Ingresa una letra, por favor: ");
            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            if(!letraCorrecta) {
                intentos++;
                System.out.println("Letra incorrecta, intentos restantes: " + (intentosMaximos - intentos));
            }

            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("Felicidades, has adivinado la palabra secreta: " + palabraSecreta);
                
            }
        }

        if (!palabraAdivinada) {
            System.out.println("Lo siento, has perdido. La palabra secreta era: " + palabraSecreta);
        }

        scanner.close();
    }
}
