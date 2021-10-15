
package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Funcionario;
import model.bean.Pessoa;


public class Arquivo {
    public static void main(String[] args) throws IOException{
        
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
        
        
        
        File arquivo = new File("C:\\Users\\Josiene\\Documents\\NetBeansProjects\\ManipulacaoArquivo\\ManipulacaoArquivo\\src\\armazenaArquivosTXT\\listaFuncionario.txt");
        
        if(!arquivo.exists()){
            arquivo.createNewFile();
        }
        
        FileWriter escreverArquivo = new FileWriter(arquivo);
        
        
        for(Funcionario f:listaFuncionario){
            escreverArquivo.write(f.getCpf()+";");
            escreverArquivo.write(f.getNome()+";");
            escreverArquivo.write(f.getEmail()+";");
            escreverArquivo.write(f.getIdade()+";");
            escreverArquivo.write(f.getSalario()+";");
            escreverArquivo.write(f.getHorasExtras()+"\n");
        }
        
        
        escreverArquivo.flush();
        escreverArquivo.close();
        
    }
}
