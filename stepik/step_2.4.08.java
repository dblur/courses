/*
Реализуйте метод, сливающий два отсортированных по неубыванию массива чисел в один отсортированный в том же порядке массив.
Массивы могут быть любой длины, в том числе нулевой.
Предполагается, что вы реализуете алгоритм слияния, имеющий линейную сложность: 
он будет идти по двум исходным массивам и сразу формировать отсортированный результирующий массив. 
Так, чтобы сортировка полученного массива при помощи Arrays.sort() уже не требовалась. 
К сожалению, автоматически это не проверить, так что это остается на вашей совести :)

Пример:
Если на вход подаются массивы {0, 2, 2} и {1, 3}, то на выходе должен получиться массив {0, 1, 2, 2, 3}
*/

public static int[] mergeArrays(int[] a1, int[] a2) {
  int[]c = new int[a1.length + a2.length];
  int count = 0;
      
	for(int i = 0; i < a1.length; i++) {
	  c[i] = a1[i];
	  count++;
	}
	
  for(int j = 0; j<a2.length; j++) {
	        c[count++] = a2[j];
	}
	  Arrays.sort(c);
	    for(int i = 0; i < c.length; i++) {
      }
  return c;
}