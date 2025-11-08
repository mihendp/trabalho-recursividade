void main() {
    IO.println("========== Preenchimento de listas ==========");

    IO.print("Digite um número natural para definir o tamanho da lista que deseja criar: ");
    String prompt = IO.readln();

    try {
        int arraySize = Integer.parseInt(prompt);
        if (arraySize < 0) throw new NumberFormatException();

        int[] array = new int[arraySize];
        insertUserInputOnArray(array, 0);

        IO.print("Resultado: [");
        printArray(array, 0);
        IO.println("]");

    } catch (NumberFormatException e) {
        IO.println("Você não digitou um número natural válido, tente novamente.");
        main();
    }
}

void insertUserInputOnArray(int[] array, int index) {
    if (index == array.length) return;

    try {
        array[index] = Integer.parseInt(IO.readln("Digite o valor que será inserido na posição " + (index + 1) + ": "));
    } catch (NumberFormatException e) {
        IO.println("O valor digitado não é um número válido, tente novamente.");
        insertUserInputOnArray(array, index);
    }
    insertUserInputOnArray(array, index + 1);
}

void printArray(int[] array, int index) {
    if (index == array.length) {
        return;
    }

    IO.print(array[index]);
    if (index != array.length - 1) {
        IO.print(",");
    }
    printArray(array, index + 1);
}