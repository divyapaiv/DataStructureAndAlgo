
class Gcd{
public static void main(String args[]){
  int x = gcd(100,20);
  
}

public static int gcd(int A , int B) 
    { 
      // 
        //code here
        if(B==0)
            return A;
        return(gcd(B,A%B));
        
    } 
}