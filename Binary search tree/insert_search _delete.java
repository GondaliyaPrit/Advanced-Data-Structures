
package com.prit.Tree;

class Nodeclass {
    int data;
    Nodeclass right;
    Nodeclass left;

    public Nodeclass(int data) {
        this.data = data;
    }
}


public class Binary_search_tree {
    public static void main(String[] args) {
        Nodeclass  rootdata = null;
        rootdata = insert(rootdata,20);
        rootdata = insert(rootdata,5);
        rootdata = insert(rootdata,21);
        rootdata = insert(rootdata,15);
        rootdata = insert(rootdata,9);
        rootdata = insert(rootdata,5);
        rootdata = insert(rootdata,26);


        inorder(rootdata);
        System.out.println("");
        BSTsearch(rootdata,20);



    }

    public static  Nodeclass insert(Nodeclass root , int data)
    {
        Nodeclass newnode  = new Nodeclass(data);
         return insert(root,newnode);
    }

    public  static Nodeclass insert(Nodeclass root , Nodeclass newnode)
    {
        if(root == null )
        {
            return  newnode ;
        }
        if(root.data < newnode.data )
        {
            root.right=insert(root.right ,newnode);
        }
        else
        {
            root.left = insert(root.left,newnode);
        }
        return  root;
    }


    public static  void BSTsearch(Nodeclass root , int data)
    {
        if (root == null)
        {
            System.out.print(data+ " Data Not Prsent in BST");
        }
        if(root.data == data)
        {
            System.out.print(data+ " Data  Prsent in BST");
        }
        if(root.data <  data )
        {
            BSTsearch(root.right ,data);
        }
        if (root.data >data)
        {
            BSTsearch(root.left  , data);
        }
    }
    
   
    
    // Toatal 3 case
    1) Delete Leaf Node 
    2) Delete node only one child
    3) Delete node have 2 child or sub tree 
        
     public static  Node del(Node root , int data)
   {
       if(root == null)
       {
           return  root ;
       }
       if(root.data < data)
       {
           root.right = del(root.right, data);
       }
      else if(root.data > data )
       {
           root.left = del(root.left , data) ;
       }
      else
       {
           if(root.left == null)
           {
               return  root.right;
           }
           else if( root.right == null)
           {
               return  root.left;
           }
           root.data = minvalue(root);
           root.right= del(root ,root.data);
       }
      return  root ;

   }


   public static  int minvalue(Node root)
   {
       int minvalue = root.data;

       while(root.left != null)
       {
        minvalue = root.left.data;
        root =root.left;
       }
       return  minvalue;

   }



    public  static  void inorder(Nodeclass root)
    {
        if(root == null)
        {
            return;
        }
        inorder(root.left);
        System.out.print(root.data +" ");
        inorder(root.right);
    }
}
