
package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Arquivo {
    public static void main(String[] args) throws IOException{
        
        File arquivo = new File("C:\\Users\\Josiene\\Documents\\NetBeansProjects\\ManipulacaoArquivo\\ManipulacaoArquivo\\src\\armazenaArquivosTXT\\arquivo.txt");
        
        if(!arquivo.exists()){
            arquivo.createNewFile();
        }
        
        FileWriter escreverArquivo = new FileWriter(arquivo);
        
        for(int posicao = 1;posicao <= 10;posicao++){
            escreverArquivo.write("Minha "+posicao+"º linha \n");
        }
        
        
        escreverArquivo.flush();
        escreverArquivo.close();
        
    }
}
