
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.bean.Funcionario;
import model.bean.Pessoa;


public class LerArquivo {
    public static void main(String[] args) throws FileNotFoundException {
        
        FileInputStream entradaArquivo = new FileInputStream(new File("C:\\Users\\Josiene\\Documents\\NetBeansProjects\\ManipulacaoArquivo\\ManipulacaoArquivo\\src\\armazenaArquivosTXT\\listaFuncionario.txt"));
                
        Scanner lerArquivo = new Scanner(entradaArquivo,"UTF-8");
        
        List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        
        while(lerArquivo.hasNext()){ 
            
            String linha = lerArquivo.nextLine();
  
            if(!linha.isEmpty()){
                String[] dados = linha.split("\\;");
                Funcionario funcionario = new Funcionario();

                funcionario.setCpf(dados[0]);
                funcionario.setNome(dados[1]);
                funcionario.setEmail(dados[2]);
                funcionario.setIdade(dados[3]);
                funcionario.setSalario(dados[4]);
                if(dados[5].contains("null")){
                    funcionario.setHorasExtras(null);
                }else{
                    funcionario.setHorasExtras(Integer.parseInt(dados[5]));
                }
                
                listaFuncionario.add(funcionario);
            }
        }
        
        for(Funcionario funcionario:listaFuncionario){
            System.out.println(funcionario);
        }
        
    }
}
