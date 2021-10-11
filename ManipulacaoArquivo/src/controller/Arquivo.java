
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
        
        escreverArquivo.write("Hello World");
        escreverArquivo.flush();
        escreverArquivo.close();
        
    }
}
