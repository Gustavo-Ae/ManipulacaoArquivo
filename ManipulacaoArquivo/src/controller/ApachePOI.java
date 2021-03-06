
package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
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
        
        HSSFWorkbook HSSFWorkbook = new HSSFWorkbook();
        
        HSSFSheet planilha = HSSFWorkbook.createSheet("Planilha de Funcionários");
        
        int numeroLinha = 0;
        for(Funcionario f:listaFuncionario){
            Row linhaPlanilha = planilha.createRow(numeroLinha++);
            
            int celula = 0;
            
            Cell celulaCPF = linhaPlanilha.createCell(celula++);
            celulaCPF.setCellValue(f.getCpf());
            
            Cell celulaNome = linhaPlanilha.createCell(celula++);
            celulaNome.setCellValue(f.getNome());
             
            Cell celulaEmail = linhaPlanilha.createCell(celula++);
            celulaEmail.setCellValue(f.getEmail());
            
            Cell celulaIdade = linhaPlanilha.createCell(celula++);
            celulaIdade.setCellValue(f.getIdade());
             
            Cell celulaSalario = linhaPlanilha.createCell(celula++);
            celulaSalario.setCellValue(f.getSalario());
            
            Cell celulaHoraExtra = linhaPlanilha.createCell(celula++);
            celulaHoraExtra.setCellValue(String.valueOf(f.getHorasExtras()));
           
        }
        
        for(int linha = 0; linha <= 7;linha++){ /*Ajusta a largura da coluna*/
            planilha.autoSizeColumn(linha);
        }
        
        
        
        FileOutputStream saida = new FileOutputStream(arquivo);
        HSSFWorkbook.write(saida);
        saida.flush();
        saida.close();
        
        JOptionPane.showMessageDialog(null,"Planilha Criada!","Aviso",JOptionPane.INFORMATION_MESSAGE);
    }
}
