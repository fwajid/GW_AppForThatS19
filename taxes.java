/* We calculate Taxes based on a bracket system. If your income
 * lands within a certain range, you owe that % on your income
 * to the government. Suppose the tax bracket looks like the
 * following: 
 *
 * <= 7,800     -> 10% bracket
 * <= 31,800    -> 15% bracket
 * <= 69,000    -> 25% bracket
 * <= 76,800    -> 35% bracket
 *
 * Example: Suppose you earn $60,000, you fall into the 25%
 * tax bracket and owe $11,430.00 in taxes. Let's see how:
 * 
 * Let X -> your income (of $60,000)
 * Bracket Tax on Income:
 *    A = (X - 31,800) * 0.25
 * Added Tax from previous brackets:
 *    B = (7,800 * .10) + ((31,800 - 7,800)*.15)
 * Tax Owed: A + B = $11,430.00
 * 
 * Examples:
 * Input:  $248,000
 * Output: $75,550.00
 *
 * Input: $780.00
 * Output: $780.00
 */

public class Taxes {
    public static void main(String[] args) {
      /* Your Code Here */
    }
}
