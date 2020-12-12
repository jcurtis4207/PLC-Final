public class RDA {
    public static String nextToken;
    public static void main(String args[]){
        // read in input
        // get first token
        // Start -> A { ( = | /= ) A }
        A_expr();
        while(nextToken == "=" || nextToken == "/="){
            lex();
            A_expr();
        }
        System.out.println("End of expression");
    }
    // A -> B { ( || | ~| ) B }
    public static void A_expr(){
        B_expr();
        while(nextToken == "||" || nextToken == "~|"){
            lex();
            B_expr();
        }
    }
    // B -> C { ( && | / ) C } | !C
    public static void B_expr(){
        if(nextToken == "!"){
            lex();
            C_expr();
        }
        else{
            C_expr();
            while(nextToken == "&&" || nextToken == "/"){
                lex();
                C_expr();
            }
        }
    }
    // C -> D { ( > | < ) D }
    public static void C_expr(){
        D_expr();
        while(nextToken == ">" || nextToken == "<"){
            lex();
            D_expr();
        }
    }
    // D -> ( - | + ) E | E { % E }
    public static void D_expr(){
        if(nextToken == "-" || nextToken == "+"){
            lex();
            E_expr();
        }
        else{
            E_expr();
            while(nextToken == "%"){
                lex();
                E_expr();
            }
        }
    }
    // E -> F { ( + | - | <= ) F }
    public static void E_expr(){
        F_expr();
        while(nextToken == "+" || nextToken == "-" || nextToken == "<="){
            lex();
            F_expr();
        }
    }
    // F -> G { ( * | >= | & ) G }
    public static void F_expr(){
        G_expr();
        while(nextToken == "*" || nextToken == ">=" || nextToken == "&"){
            lex();
            G_expr();
        }
    }
    // G -> { ( ++ | -- ) H } | int_lit
    public static void G_expr(){
        if(nextToken == "++" || nextToken == "--"){
            lex();
            H_expr();
        }
        else if(nextToken == "INT_LIT"){
            lex();
            // end of leaf
        }
        else{
            error();
        }
    }
    // H -> J { ( ++ | -- ) }
    public static void H_expr(){
        J_expr();
        if(nextToken == "++" || nextToken == "--"){
            lex();
        }
    }
    // J -> variable
    public static void J_expr(){
        if(nextToken == "VARIABLE"){
            lex();
            // end of leaf
        }
        else{
            error();
        }
    }
    // BLANK FUNCTIONS
    public static void lex(){
        // parse next lexeme and set nextToken
    }
    public static void error(){
        // throw error and halt execution
    } 
}
