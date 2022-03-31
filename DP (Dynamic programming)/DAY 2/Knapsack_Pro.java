/*
Qes 1) 
https://github.com/pritGondaliyav/Advanced-Data-Structures/blob/main/DP%20(Dynamic%20programming)/DAY%202/problemStatment.jpeg
DP (Dynamic programming)/DAY 2/problemStatment.jpeg --> You need to put item array to bag such that the bag has max price value 

This is a Optimazation  Problem 

Ans : 
  --> Choice Diagram 
  For each item we can  Make Two Choice 
    
                  Item
                 /    \
                /      \
            Put item    Not put this 
            in bag      item  in bag
                              /\
                             /  \
                            /    \
                    the weight      Skipping it my own    
                    of item more 
                    than bag 
                    capacity left
                             
*/


====================USING RECUERSION====================
  
//Time Complexity: O(2*N)
  
public class Knapsack_Pro {
    public static void main(String[] args) {
        int[] wight = {10, 20, 30};
        int[] price = {60, 100, 120};
        int cap = 50;
        int n = wight.length;

        System.out.println(MaxNumber(price, wight, n, cap));
        
    }

    public static int MaxNumber(int[] price, int[] wight, int n, int cap) {
        if (n == 0 || cap <= 0) {
            return 0;
        }
        // Calling Recuersion for pick item
        int pickit = MaxNumber(price, wight, n - 1, cap - wight[n - 1]);
        // Calling Recuersion for skip item 
        int skip = MaxNumber(price, wight, n - 1, cap);

        if (wight[n - 1] > cap) {
            return skip;
        } else {
            // if you pick item than you add price  otherwise not add price   
            return Math.max(pickit + price[n - 1], skip);
        }
    }
}


====================USING DP====================
  
  
  
  
  
  



