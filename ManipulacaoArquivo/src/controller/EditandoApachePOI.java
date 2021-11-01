
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class EditandoApachePOI{
    public static void main(String[] args) throws Exception {
        
        File arquivo = new File("C:\\Users\\Josiene\\Documents\\NetBeansProjects\\ManipulacaoArquivo\\ManipulacaoArquivo\\src\\armazenaArquivos\\listaFuncionario_Excel.xls");
        
        FileInputStream entrada = new FileInputStream(arquivo);
        
        HSSFWorkbook HSSFWorkbook = new HSSFWorkbook(entrada);
        
        HSSFSheet planilha = HSSFWorkbook.getSheetAt(0);
        
        Iterator<Row> linhaInterator = planilha.iterator();
        
        while(linhaInterator.hasNext()){
            Row linha = linhaInterator.next(); /*dados do funcionario na linha*/
            
             int numeroCelulas = linha.getPhysicalNumberOfCells();

            Cell cell = linha.createCell(numeroCelulas);  /*Cria nova celula nas 2 linhas */
            cell.setCellValue("disponivel"); 
        } 
        
        int respostaAlterarHoraExtra = JOptionPane.showConfirmDialog(null, "Deseja alterar o salário dos funcionários ?","Pergunta",JOptionPane.YES_NO_OPTION);
        
        if(respostaAlterarHoraExtra == 0){ //SIM
 
            for(int i = 0; i < planilha.getPhysicalNumberOfRows();i++){
                Row linha = planilha.getRow(i);
                
                String perguntaSalario = JOptionPane.showInputDialog(null,"Qual o valor do novo salario do "+linha.getCell(1)+" ?","Pergunta",JOptionPane.QUESTION_MESSAGE);

                linha.getCell(4).setCellValue("R$ "+perguntaSalario+",00");
            }
        }
        entrada.close();
        
        FileOutputStream saida = new FileOutputStream(arquivo);
        
        HSSFWorkbook.write(saida);
        saida.flush();
        saida.close();
        
        JOptionPane.showMessageDialog(null, "Planilha atualizada!","Aviso",JOptionPane.INFORMATION_MESSAGE);
    }
}
