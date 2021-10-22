
package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Cell;
import javax.swing.JOptionPane;
import model.bean.Funcionario;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;


public class ApachePOI{
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
        
        File arquivo = new File("C:\\Users\\Josiene\\Documents\\NetBeansProjects\\ManipulacaoArquivo\\ManipulacaoArquivo\\src\\armazenaArquivos\\listaFuncionario_Excel.xls");
        
        if(!arquivo.exists()){
            arquivo.createNewFile();
        }
        
        HSSFWorkbook escreverNaPlanilha = new HSSFWorkbook();
        
        HSSFSheet linhaFuncionario = escreverNaPlanilha.createSheet("Planilha de Funcionários");
        
        int numeroLinha = 0;
        for(Funcionario f:listaFuncionario){
            Row linhaPlanilha = linhaFuncionario.createRow(numeroLinha++);
            
            int celula = 0;
            
            org.apache.poi.ss.usermodel.Cell celulaCPF = linhaPlanilha.createCell(celula++);
            celulaCPF.setCellValue(f.getCpf());
            
            org.apache.poi.ss.usermodel.Cell celulaNome = linhaPlanilha.createCell(celula++);
            celulaNome.setCellValue(f.getNome());
            
            org.apache.poi.ss.usermodel.Cell celulaEmail = linhaPlanilha.createCell(celula++);
            celulaEmail.setCellValue(f.getEmail());
            
            org.apache.poi.ss.usermodel.Cell celulaIdade = linhaPlanilha.createCell(celula++);
            celulaIdade.setCellValue(f.getIdade());
            
            org.apache.poi.ss.usermodel.Cell celulaSalario = linhaPlanilha.createCell(celula++);
            celulaSalario.setCellValue(f.getSalario());
            
            org.apache.poi.ss.usermodel.Cell celulaHoraExtra = linhaPlanilha.createCell(celula++);
            celulaHoraExtra.setCellValue(String.valueOf(f.getHorasExtras()));
            
        }
        
        FileOutputStream saida = new FileOutputStream(arquivo);
        escreverNaPlanilha.write(saida);
        saida.flush();
        saida.close();
        
        JOptionPane.showMessageDialog(null,"Planilha Criada!","Aviso",JOptionPane.INFORMATION_MESSAGE);
    }
}
