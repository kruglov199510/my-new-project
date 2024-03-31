//Круглов А.С.


import java.util.Scanner;

public class Main {  //класс
    public static void main(String[] args) throws Exception { //исключения throws
        Main main = new Main(); //класс создаем
        Scanner scanner = new Scanner(System.in); //вызываем сканнер
        while (true){  //цикл while позволяет нам многократно выполнять ввод исходя из кода ниже и получать ответ
            String line = scanner.nextLine();
            String result = main.calc(line);
            System.out.println(result);
        }
    }
    String calc(String input) throws Exception { // введение
        try {
            String[] data = input.split(" "); //МАССИВ строка data c ПРОБЕЛОМ через метод split
            String[] rim = {"VIII", "VII", "IV", "VI", "III", "IX", "II", "I", "V", "X"}; //МАССИВ  rim c римскими до 10 == ТЗ КОСТЫЛЬ
            String[] arab = {"8", "7", "4", "6", "3", "9", "2", "1", "5", "10"}; //МАССИВ arab c арабскими до 10 == ТЗ

            if ((!contains(rim, data[0]) && !contains(arab, data[0])) || (!contains(rim, data[2]) && !contains(arab, data[2]))) {
                throw new Exception(); // проверяем через contains исключения не равно римскому и не равно арабскому или 2 символ, то исключение
            }
            if (contains(rim, data[0]) && contains(arab, data[2]) || contains(rim, data[2]) && contains(arab, data[0])) {
                throw new Exception(); // если равно первый римский а второй арабский или наоборот то исключение
            }
            if (data.length != 3) { // исключение если мы вводим 1+1+(1) третья единица лишняя значит исключение (в строке)
                throw new Exception();
            }

            boolean roman = false; //булин либо фолс либо тру. В данном случае FALSE  ????

            for (String sim : rim) // условие  строка - rim   присвоение значения переменной
            {
                if (input.contains(sim)) { // сравни
                    roman = true;
                }
            }

            for (int i = 0; i < arab.length; i++) {     //l. длина массива
                // цикл фор, массив от нуля меньше чем арабские. i инкр. до тех пор пока i не будет меньше чем арабские числа
                input = input.replace(rim[i], arab[i]); //возвращает в новую строку
            }
            data = input.split(" ");
            int num1 = Integer.parseInt(data[0]); //целое число ==ТЗ 1 число
            int num2 = Integer.parseInt(data[2]); //целое число ==ТЗ 2число
            String operation = data[1]; // строка со знаком Знак

            int result = 0; // Содержит результат
            if (operation.equals("+")) result = num1 + num2; //если операция знака + то считай
            else if (operation.equals("-")) result = num1 - num2; // в ином случае
            else if (operation.equals("*")) result = num1 * num2; // в ином случае
            else if (operation.equals("/")) result = num1 / num2; // в ином случае
            else {
                throw new Exception(); // исключение иесли знак другой
            }
            if (result < 0 && roman) { // если результат равен меньше нуля для римских то исключение
                throw new Exception();
            }

            if (roman) return convertNumToRoman(result); // если возвращаем конвертируемый результат
            else return String.valueOf(result); //в ином случае возвращает строковые представления
        }
        catch (Exception e){
            throw new Exception(); // в ином случае - исключение
        }
    }

    String convertNumToRoman (int numArabian) { // строка и массив
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[numArabian]; // выход из строки
    }

    boolean contains(String[] arr, String str){ // сравни строки
        for (String s : arr) { // присваиваем значение
            if (str.equals(s)){ //в ином случае сравни с этой строчкой
                return true;
            }
        }
        return false;
    }
}