package ru.itmo.java;

import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) return new int[]{};

        int[] result = new int[inputArray.length];

        for (int i = inputArray.length - 1; i > 0; i--){
            result[i] = inputArray[i - 1];
        }
        result[0] = inputArray[inputArray.length - 1];
        return result;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
     if (inputArray == null || inputArray.length == 0) return 0;
     if (inputArray.length == 1) return inputArray[0];
     if (inputArray.length == 2) return inputArray[0] * inputArray[1];

     int prevMinValue = Integer.MAX_VALUE;
     int minValue = Integer.MAX_VALUE;

     int prevMaxValue = Integer.MIN_VALUE;
     int maxValue = Integer.MIN_VALUE;

     for(int i: inputArray){
         if (i < 0){
             if (i < minValue){
                 prevMinValue = minValue;
                 minValue = i;
             } else if (i < prevMinValue){
                 prevMinValue = i;
             }
         } else {
             if (i > maxValue){
                 prevMaxValue = maxValue;
                 maxValue = i;
             } else if (i > prevMaxValue){
                 prevMaxValue = i;
             }
         }
     }
     return Integer.max(prevMaxValue*maxValue, prevMinValue*minValue);
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.length() == 0) return 0;

        int count = 0;

        for (char c: input.toLowerCase().toCharArray()){
            if (c == 'a' || c == 'b') count++;
        }
        return count * 100/ input.length();
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null) return false;

        int i = 0;
        int j = input.length() - 1;
        while (i <= j){
            if (input.charAt(i) != input.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.length() == 0) return "";

        StringBuilder sb = new StringBuilder();
        char lastChar = input.charAt(0);
        int lastCount = 0;
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) == lastChar){
                lastCount++;
            } else {
                sb.append(lastChar).append(lastCount);
                lastChar = input.charAt(i);
                lastCount = 1;
            }
        }
        sb.append(lastChar).append(lastCount);
        return sb.toString();
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null || one.length() != two.length() || one.length() == 0) return false;

        char[] oneArray = one.toCharArray();
        char[] twoArray = two.toCharArray();

        Arrays.sort(oneArray);
        Arrays.sort(twoArray);

        return Arrays.equals(oneArray, twoArray);
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.length() == 0) return false;

        boolean[] charSet  = new boolean[Character.MAX_VALUE];
        for (char c: s.toCharArray()){
            if (charSet[c]) return false;
            charSet[c] = true;
        }
        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null || m.length == 0) return new int[][]{{}};
        int[][] result = new int[m.length][m.length];
        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m.length; j++){
                result[i][j] = m[j][i];
            }
        }
        return result;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (inputStrings == null || inputStrings.length == 0) return "";

        StringBuilder sb = new StringBuilder();
        Character sep = separator == null ? ' ' : separator;

        for (int i = 0; i < inputStrings.length - 1; i++){
            sb.append(inputStrings[i]).append(sep);
        }

        sb.append(inputStrings[inputStrings.length - 1]);
        return sb.toString();
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || prefix == null) return 0;

        int count = 0;
        for(String s: inputStrings) {
            if (s.substring(0, prefix.length()).equals(prefix)) count++;
        }
        return count;
    }
}
