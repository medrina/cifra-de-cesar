package cifra.principal;

import cifra.operacoes.DesencriptarMensagem;
import cifra.operacoes.EncriptarMensagem;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Principal extends HttpServlet {

    String mensagemAux;
        
    // método que recebe requisições via POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mensagem;
        int numero;
        
        // pega o parâmetro req para ser comparado no if/else.
        String requisicao = request.getParameter("req");
        
        // requisição para encriptar a mensagem
        if(requisicao.equals("encriptar")){
            
            // mensagemAux: pega o parâmetro que está sendo recebido via POST lá do encripta.js
            mensagemAux= request.getParameter("msg");
            
            // numero: contém o número para trocar as letras e alterar a mensagem
            numero = Integer.parseInt(request.getParameter("num"));
                        
            mensagem = encriptarMensagem(mensagemAux,numero);
        }
        
        // requisição para desencriptar a mensagem
        else if(requisicao.equals("desencriptar")){
            
            // as variáveis abaixo pegam os parâmetros que estão sendo enviados via POST lá do encripta.js
            mensagem = request.getParameter("msg");
            numero = Integer.parseInt(request.getParameter("num"));
            
            // mensagemAux: recebe a mensagem que foi desencriptada
            // numero: contém o número para trocar as letras e voltar a mensagem original
            mensagemAux = desencriptarMensagem(mensagem, numero);
        }
        
        // processo de conversão da mensagem em formato JSON para ser enviado para o JavaScript
        Gson gson = new Gson();
        String json = gson.toJson(mensagemAux);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
        mensagemAux = "";
    }
    
    // método para encriptar a mensagem
    private String encriptarMensagem(String msg, int num){
        EncriptarMensagem encripta = new EncriptarMensagem();
        String mensagem = encripta.encriptacao(msg, num);
        return mensagem;
    }
    
    // método para desencriptar a mensagem
    private String desencriptarMensagem(String msg, int num){
        DesencriptarMensagem desencripta = new DesencriptarMensagem();
        String mensagem = desencripta.desencriptacao(msg, num);
        return mensagem;
    }
}