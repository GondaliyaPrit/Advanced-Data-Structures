/*

Knapsack_Pro --> Its mens always pick number and parfrom any opration 

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

//Time Complexity: O(N)
public class Main {

    public static void main(String[] args) {
        int[] wight = {10, 20, 30};
        int[] price = {60, 100, 120};
        int cap = 50;
        int n = wight.length;

        System.out.println(MaxnumUsingdp(price, wight, n, cap));

    }

    public static int MaxnumUsingdp(int[] price, int[] wight, int n, int cap) {
        int memo[][] = new int[n + 1][cap + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < cap + 1; j++) {
                memo[i][j] = -1;
            }
        }
        if (n == 0 || cap <= 0) {
            return 0;
        }
        if (memo[n][cap] != -1) {
            return memo[n][cap];
        }
        int ans = 0;
       // Calling Recuersion for pick item
        int pickit = MaxnumUsingdp(price, wight, n - 1, cap - wight[n - 1]);
        // Calling Recuersion for skip item
        int skip = MaxnumUsingdp(price, wight, n - 1, cap);
        if (wight[n - 1] > cap) {
            ans = skip;
        } else {
            ans = Math.max(pickit + price[n - 1], skip);
        }
        memo[n][cap] = ans;
        return ans;
    }
}

  
--------------------------------------------------------------------------------------------------------------------------------------------------------  

  Child Problem 
 /* 
 Qes 2) Thare is an Array  {3,5,4,4,2,1,6} thare is a sum = 8 tell me Yes or No ans  it is posible to create pick element from this set such that sum is 8  ?
 
 */
 
 
====================USING RECUERSION====================

public class Childpro {
    //todo Qes 2) Thare is an Array  {3,5,4,4,2,1,6} thare is a sum = 8 tell me Yes or No ans  it is posible to create pick element from this set such that sum is 8 ?

    public static void main(String[] args) {
        int arr[] = {3,5,4,4,2,1,6} ;
        int sum = 8 ;
        int n = arr.length;

        if (ispossible(arr,n,sum))
        {
            System.out.println("Yes ispossible");
        }
        else {
            System.out.println("Not possible");
        }

    }

    public static  boolean ispossible(int[] arr , int n , int sum)
    {
       if(sum == 0)
       {
           return  true;
       }
       if(n==0)
       {
           return   false;
       }
        boolean skip = ispossible(arr,n-1,sum);
        boolean pick = ispossible(arr,n-1,sum-arr[n-1]);

       if(arr[n-1] >sum)
       {
           return  skip;
       }
       else {
           return  skip || pick ;
       }
    }

}




====================USING DP====================
  
  //CODE NOT WORKING 
  
 public static void main(String[] args) {
        int arr[] = { 1, 5, 3, 7, 4 };
        int sum = 12;
        int n = arr.length;

        if (ispossibleUsingDp(arr, n, sum)!=0) {
            System.out.println("Yes ispossible");
        } else {
            System.out.println("Not possible");
        }

    }


    public static int ispossibleUsingDp(int[] arr, int n, int sum) {
        int memo[][] = new int[n+1][sum+1];

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < sum ; j++) {
                memo[i][j] = -1;
            }
        }
        if (sum == 0) {
            return 1;
        }
        if (n <= 0) {
            return 0;
        }

        if (memo[n-1][sum] != -1) {
            return memo[n-1][sum];
        }
//        int ans = 0;
//        int skip = ispossibleUsingDp(arr, n - 1, sum);
//        int pick = ispossibleUsingDp(arr, n - 1, sum - arr[n - 1]);
        if(arr[n-1] >sum)
        {
         //   ans = skip;
            return  memo[n - 1][sum]=ispossibleUsingDp(arr, n - 1, sum);
        }
        else
        {
            if (ispossibleUsingDp(arr,n-1,sum) != 0 || ispossibleUsingDp(arr,n-1,sum-arr[n-1]) != 0)
            {
                    return  memo[n-1][sum] =1;
            }
            else
            {
                return memo[n-1][sum] =0;
            }
        }
    }

  
  



