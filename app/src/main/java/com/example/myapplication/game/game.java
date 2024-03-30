package game;
public class game{
    public boolean even(int input){
        if(input%2==0){
            return true;
        }
        else{
            return false;
        }
    }

    public String hint(int rand){
        if(rand<=10){
            return "The number I'm thinking of falls somewhere between "+0+" and "+10;
        }
        else{
            int a = rand/10;
            return "The number I'm thinking of falls somewhere between "+(a*10)+" and "+((a*10)+10);
        }
    }

    public int factor(int num){
        for(int i = 2 ;i*i<=num;i++){
            if(num%i==0){
                return i;
            }


        }
        return 0;
    }


    public String hint(int num, int tries, int userInput){
        switch(tries){
            case 2:
                if(even(userInput)==true && num%2==0) {
                    return "Got it! So, it's still even, but we're exploring a different characteristic altogether. Let's keep the detective work going!";
                } else if (even(userInput)==false && num%2==1) {
                    return "Oh, nice! We're getting warmer. And hey, just a heads up, the number I'm thinking of is also on the odd side. So, we're definitely on the right track here!";
                }
                else if(even(userInput)==false && num%2==0){
                    return "Actually... The Number that I'm thinking of is even";
                }
                else if(even(userInput)==true && num%2==1){
                    return "Umm... The Number that I'm thinking of is odd";
                }
            
            case 3:
                
                
                if(factor(num)==0 && factor(userInput)==0){
                    return "Looks like we're on the same wavelength! The number I'm thinking of is also a prime one. Great minds think alike, huh?";
                }
                else if(factor(num)==0 && factor(userInput)!=0){
                    return "Hey, my number is like a loner at a party - it's prime!";
                }
                else if(factor(num)!=0 && factor(userInput)==0) {
                    return "Cool, gotcha. So, here's the scoop: the number I've got in mind isn't prime";
                }
                else if(factor(num)!=0 && factor(userInput)!=0){
                    return "So, the number I've got in mind is like a buddy of "+factor(num)+", hanging out in its multiples club.";
                }
                //else {
                    //return "Psst, here's the inside scoop: the number I've got cooking isn't prime. Just between you and me";
                //}
            
            case 4:
                return "Ah, got it! So, the magic number we've been circling around is "+num;
            
        }
        return "invalid";
    
    }
}