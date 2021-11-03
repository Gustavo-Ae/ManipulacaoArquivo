package controller.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Funcionario;



public class escreverJSON {
    public static void main(String[] args) throws IOException {
        
        Funcionario atendente = new Funcionario();
        
        atendente.setCpf("397.945.603-08");
        atendente.setNome("Isabelle Eloá Mirella Porto");
        atendente.setEmail("iisabelleeloamirellaporto@agaxtur.com.br");
        atendente.setIdade("25");
        atendente.setSalario("R$ 1.850,00");
        atendente.setHorasExtras(null);
        
        Funcionario engenheiro = new Funcionario();
        
        engenheiro.setCpf("754.415.387-83");
        engenheiro.setNome("Sebastião Levi Augusto Assunção");
        engenheiro.setEmail("sebastiaoleviaugustoassuncao__sebastiaoleviaugustoassuncao@portoweb.com.br");
        engenheiro.setIdade("50");
        engenheiro.setSalario("R$ 6.000,00");
        engenheiro.setHorasExtras(null);
        
        List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        
        listaFuncionario.add(atendente);
        listaFuncionario.add(engenheiro);
        
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        String jsonUsuarios = gson.toJson(listaFuncionario); //passa para JSON
        
        System.out.println(jsonUsuarios);
        
        FileWriter escreverArquivo = new FileWriter("C:\\Users\\Josiene\\Documents\\NetBeansProjects\\ManipulacaoArquivo\\ManipulacaoArquivo\\src\\armazenaArquivos\\fileJson.json");
        
        escreverArquivo.write(jsonUsuarios);
        escreverArquivo.flush();
        escreverArquivo.close();
    }
}
