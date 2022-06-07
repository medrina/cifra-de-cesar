package cifra.operacoes;

public class EncriptarMensagem {
	
    /* o método encriptacao, está recebendo os parâmetros do Servlet Java. A variável palavra, contém a mensagem inserida do usuário. A variável
    numeroDeslocamento, contém o número inserido pelo usuário para deslocar as letras. */
    public String encriptacao(String palavra, int numeroDeslocamento){
	
        String mensagem = "";
	char letra, letraAux;
	int num = 0, num2 = 0, aux = 0;
	
        //conta quantos números de caracteres a palavra digitada possui
        num = palavra.length();
	 
        //for vai repetir de acordo com o número de caracteres que palavra tem. A variável num subtrai -1 por causa do i que inicia com zero
	for(int i = 0 ; i <= num - 1 ; i++){
            
            // a cada iteração do for, letraAux recebe a posição do caractere na String palavra
            letraAux = palavra.charAt(i);
            
            // faz comparações com acentos nos códigos ASCII da letra A. Caso seja verdadeiro, ele atribui a letra A
            if(letraAux == (char) 192 || letraAux == (char) 193 || letraAux == (char) 194 || letraAux == (char) 195 || letraAux == (char) 196)
                letraAux = (char) 65;
            
            // faz comparações com acentos nos códigos ASCII da letra E. Caso seja verdadeiro, ele atribui a letra E
            else if(letraAux == (char) 200 || letraAux == (char) 201 || letraAux == (char) 202 || letraAux == (char) 203)
                letraAux = (char) 69;
            
            // faz comparações com acentos nos códigos ASCII da letra I. Caso seja verdadeiro, ele atribui a letra I
            else if(letraAux == (char) 204 || letraAux == (char) 205 || letraAux == (char) 206 || letraAux == (char) 207)
                letraAux = (char) 73;
            
            // faz comparações com acentos nos códigos ASCII da letra O. Caso seja verdadeiro, ele atribui a letra O
            else if(letraAux == (char) 210 || letraAux == (char) 211 || letraAux == (char) 212 || letraAux == (char) 213 || letraAux == (char) 214)
                letraAux = 79;
            
            // faz comparações com acentos nos códigos ASCII da letra U. Caso seja verdadeiro, ele atribui a letra U
            else if(letraAux == (char) 217 || letraAux == (char) 218 || letraAux == (char) 219 || letraAux == 220)
                letraAux = (char) 85;
            
            // faz comparação com o código ASCII do Ç. Caso seja verdadeiro, ele atribui a letra C
            else if(letraAux == (char) 199)
                letraAux = (char)67;
            
            // faz comparação com o código ASCII do Ñ. Caso seja verdadeiro, ele atribui a letra N
            else if(letraAux == (char) 209)
                letraAux = (char) 78;
            //---------------------------------------------------------------------------------------------------------------------------------------
            
            // faz comparações com os códigos ASCII de pontuações. Caso seja verdadeiro, ele atribui o código ASCII corrente.
            if(letraAux == (char) 13 || letraAux == (char) 32 || letraAux == (char) 33 || letraAux == (char) 44 || letraAux == (char) 45 || letraAux == (char) 46 || letraAux == (char) 58 ||
               letraAux == (char) 59 || letraAux == (char) 63 || letraAux == (char) 167 || letraAux == (char) 248)
		letra = (char) + palavra.charAt(i);
            
            // faz comparações com os códigos ASCII dos números. Caso esteja dentro do intervalo dos números, ele atribui o código ASCII do númmero que foi digitado
            else if(palavra.charAt(i) >= (char) 48 && palavra.charAt(i) <= (char) 57)
                letra = (char) + palavra.charAt(i);
            
            else {
                
                //retorna código ASCII da letra da variável letraAux
		num2 = (int) letraAux;
                
                //soma do código ASCII com o número de deslocamento
                num2 += numeroDeslocamento;
			
		//compara se o número é maior que 90, porque 90 equivale a letra Z em ASCII
                if(num2 > 90){
                    
                    //aux recebe a diferença de num2 - 90.
                    aux = num2 - 90;
                    
                    // Esse cálculo faz com que a contagem do alfabeto recomece de Z para A, e que ele percorra os códigos ASCII somando com a diferença acima (aux)
                    num2 = 64 + aux;
		}
                
                // recebe a letra correspondente segundo o código ASCII que tem na variável num2. Precisa fazer um casting para forçar ele retornar o caractere (char)
                letra = (char) num2;
            }
            
            // a cada iteração do for, ele recebe a letra que foi trocada concatenando com a variável mensagem
            mensagem += letra;
	}
        // retorna a mensagem encriptada
	return mensagem;
    }
}