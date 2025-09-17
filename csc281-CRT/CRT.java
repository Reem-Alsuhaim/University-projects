/*

   Chinese Remainder Theorem Solver
   mplemented collaboratively by Reem Alsuhaim and Hessa ibn Qurmulah
 
 */



import java.util.*;

public class CRT {

   public static void main(String args[]) {
   
      Scanner input = new Scanner(System.in);
      int n;
      
      System.out.println("Enter the number of linear congruences: ");
      n = input.nextInt();
   
      int[] a = new int[n];
      int[] b = new int[n];
      int[] m = new int[n];
   
      System.out.println("Enter the equations in the form of ax ≡ b mod m:");
      System.out.println("as 3  three integers separated by spaces : a b m");
      for (int i = 0; i < n; i++) {
         System.out.println("Enter equation " + (i + 1) + ":");
         
         a[i] = input.nextInt();
         b[i] = input.nextInt();
         m[i] = input.nextInt();
      }
      
      if (!isRP(m)) {
         System.out.println("No solution: m values are not pairwise relatively prime.");
         System.exit(0);
      }
   
      eleimCoeff(a, b, m);
   
      int M = 1;
      for (int i = 0; i < n; i++) {
         M *= m[i];
      }
   
      int[] mk = new int[n];
      for (int i = 0; i < n; i++) {
         mk[i] = M / m[i];
      }
   
      int[] y = inverse(mk, m);
   
      int x = 0;
      for (int i = 0; i < n; i++) {
         x += b[i] * mk[i] * y[i];
      }
   
      System.out.println("The solutions are all integers of the form " + x % M + "+" + M + "k where k belongs to Z"); 
      
   }//End of main



   // is m  pairwise relatively prime ?
   public static boolean isRP(int[] m) {   
      for (int i = 0; i < m.length - 1; i++) {
         for (int j = m.length - 1; j>i ; j--) {
            if (gcd(m[i], m[j]) != 1)
               return false;
         }
      }
      return true;
   }



   // eliminate coefficients
   public static void eleimCoeff(int[] a, int[] b, int[] m) {
      for (int i = 0; i < m.length; i++) {
         if (a[i] != 1) {
            int[] n = inverse(a, m);
            b[i] = b[i] * n[i];
            
            while (b[i] < 0) {
               b[i] = b[i] + m[i];
            }
         }
      }
   }



   // inverse of all equations (as array)
   public static int[] inverse(int[] a, int[] m) {
      int[] result = new int[a.length];
      for (int i = 0; i < a.length; i++) {
         result[i] = modInverse(a[i], m[i]);
      }
      return result;
   }
   
   
   
   // inverse of a mod m
   public static int modInverse(int a, int m) {
      a = a % m;
      for (int x = 1; x < m; x++) {
         if ((a * x) % m == 1) {
            return x;
         }
      }
      return 1;
   }
   
   
   
   
   // greatest common divisor
   public static int gcd(int a, int b){
      int i;
      
      if (a < b)
         i = a;
      else
         i = b;
   
      for (i=i ; i > 1; i--) {
      
         if (a % i == 0 && b % i == 0){
            return i;}
      }
      return 1;
   }
   
}//End of class

