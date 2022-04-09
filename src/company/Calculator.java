package company;

import java.util.function.*;

public class Calculator {
	static Supplier<Calculator> instance = Calculator::new;

	BinaryOperator<Integer> plus = (x, y) -> x + y;
	BinaryOperator<Integer> minus = (x, y) -> x - y;
	BinaryOperator<Integer> multiply = (x, y) -> x * y;

	/*Ошибка выбрасывается при делении целого числа на ноль.
	При делении дробных чисел ошибка выбрасываться не будет.
	Как вариант, можно во всех переменных сменить тип на Double/Float*/
	BinaryOperator<Integer> devide = (x, y) -> x / y;

	/*Сохранен целочисленный тип, ошибка выбрасывается, но программа продолжает выполнение
	и возвращает максимальное/минимальное значение.*/
	BinaryOperator<Integer> divide = (x, y) ->
	{
		int result = (x > 0) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		try {
			result = x / y;
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		return result;
	};

	UnaryOperator<Integer> pow = x -> x * x;
	UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

	Predicate<Integer> isPositive = x -> x > 0;

	Consumer<Integer> println = System.out::println;
}
