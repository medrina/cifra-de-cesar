// Utilizei jQuery

$(document).ready(function(){
    
    // botão Encriptar
    $('#botaoEncriptar').click(function(){
        let mensagem = $('#mensagem').val();
        let numero = $('#numero').val();
        
        // verifica se os campos estão vazios. Se estiverem vazios, ele ativa o Modal
        if(mensagem === '' || numero === ''){
            $('#tituloModal').text('ERRO');
            $('#paragrafoModal').text(('PREENCHA TODOS OS CAMPOS!!!'))
            $('#modal').modal('show');
        }
        else if(numero == 0){
            $('#resultadoEncriptacao').html(`<textarea class="bordaPreta form-control mb-2 mt-2" rows="5" readonly></textarea>`);
            $('#instrucoes').text("");
            $('#link').html("");
        }
        else {
            
            // envia uma requisição HTTP por POST (para encriptar a mensagem) junto com os dados para o Servlet do Java, que retorna a mensagem encriptada como param
            $.post(`http://localhost:8080/cifra2/principal`,{req: "encriptar", msg: mensagem, num: numero},function(param){
                let dados = param;
                
                // é mostrado os dados na página html
                $('#resultadoEncriptacao').html(`<textarea class="bordaPreta form-control mb-2 mt-2" rows="5" readonly>${dados}</textarea>`);
                $('#instrucoes').html('<p>A mensagem acima está encriptada. Para desencriptá-la, você deve copiar a mensagem acima, anotar o número de deslocamento, e clicar no link abaixo.');
                $('#link').html('<a id="linkPagina" href="desencriptar.html" target="_blank">Desencriptar Mensagem</a>');
            });
        }
    });
    
    // botão Desencriptar (desencriptar.html)
    $('#botaoDesencriptar').click(function(){
        let mensagem = $('#mensagemEncriptada2').val();
        let numero = $('#numero2').val();
        
        // verifica se os campos estão vazios. Se estiverem vazios, ele ativa o Modal
        if(mensagem === '' || numero === ''){
            $('#tituloModal').text('ERRO');
            $('#paragrafoModal').text(('PREENCHA TODOS OS CAMPOS!!!'))
            $('#modal').modal('show');
        }
        else {
            
            // envia uma requisição HTTP por POST (para desencriptar a mensagem), junto com os dados para o Servlet do Java, que retorna a mensagem desencriptada pelo param
            $.post(`http://localhost:8080/cifra2/principal`,{req: "desencriptar",msg: mensagem, num: numero},function(param){
                let dados = param;
                
                // é mostrado os dados na página desencriptar.html
                $('#resultadoDesencriptacao').html(`<textarea class="bordaPreta form-control mt-2" rows="5" readonly>${dados}</textarea>`);
                
                $('#sobre').html('Esse é o princípio da encriptação, fazer com que a mensagem torne-se indecifrável. Para que o destinatário consiga descobrir a mensagem original, ele precisa de uma chave que seja íntegro no momento da criptografia. Nesse sistema, o Número de Deslocamento é a <b>chave.</b>');
            });
        }
    });
});