package cifra.operacoes;

public class DesencriptarMensagem {
    
        /* o método desencriptarMensagem, está recebendo os parâmetros do Servlet Java. O parâmetro mensagemEncriptada, contém a mensagem que está encriptada no
        atributo mensagemAux do Servlet. O atributo numeroDeslocamento, contém o número inserido pelo usuário para deslocar as letras. */
	public String desencriptacao(String mensagem, int numeroDeslocamento) {
                String mensagemEncriptada = mensagem.toUpperCase();
		String mensagemDesencriptada = "";
		int quantCaracteres = 0, num = 0, aux = 0;
		char letraAux;
                
                // retorna quantos caracteres a mensagem possui
		quantCaracteres = mensagemEncriptada.length();
		
                //for vai repetir de acordo com o número de caracteres que quantCaracteres tem. A variável subtrai -1 por causa do i que inicia com zero
		for(int i = 0 ; i <= quantCaracteres - 1 ; i++){
                                        
                    // letraAux recebe a letra na posição indicada da String
                    letraAux = mensagemEncriptada.charAt(i);
                    
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
                    
                    // faz comparações com pontuações e ortografia. Caso ele encontre algum caractere, 
                    if(letraAux == (char) 13 || letraAux == (char) 32 || letraAux == (char) 33 || letraAux == (char) 44 || letraAux == (char) 45 || letraAux == (char) 46 || letraAux == (char) 58 || 
                            letraAux == (char) 59 || letraAux == (char) 63 || letraAux == (char) 167 || letraAux == (char) 248)
                        letraAux = (char) letraAux;
                    
                    // faz comparações com códigos ASCII de números. Caso ele encontre algum número, ele recebe o número
                    else if(letraAux >= (char) 48 && letraAux <= (char) 57)
                        letraAux = (char) letraAux;
                    
                    else {
                        
                        // recebe o valor do código ASCII da letra
                        num = (int) letraAux;
                        
                        // subtrai o código ASCII recebido menos o número de deslocamento
                        num = num - numeroDeslocamento;
                        
                        // verifica se o resultado da subtração acima for menor que 65. Porque 65 é o código ASCII da letra A
                        if(num < 65){
                            
                            // aux recebe a diferença de 65 - num
                            aux = 65 - num;
                            
                            // Esse cálculo faz com que a contagem do alfabeto vire de A para Z, e que ele percorra os códigos ASCII subtraindo com a diferença acima (aux)
                            num = 91 - aux;
                            
                            // recebe a letra correspondente segundo o código ASCII que tem na variável num. Precisa fazer um casting para forçar ele retornar o caractere (char)
                            letraAux = (char) num;
                        }
                        
                        // se o resultado da subtração não for menor que 65, significa que as letras percorridas estão dentro do range do alfabeto, então ele retorna o caractere (char)
                        else
                            letraAux = (char) num;
                    }
                    
                    // a cada iteração do for, a letra desencriptada é concatenada à variável mensagemDesencriptada
                    mensagemDesencriptada += letraAux;
		}
                
                // retorna toda a mensagemDesencriptada para o Servlet
		return mensagemDesencriptada;
	}
}