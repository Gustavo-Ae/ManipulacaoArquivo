
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.bean.Funcionario;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class LerApachePOI{
    public static void main(String[] args) throws Exception{
        
        File arquivo = new File("C:\\Users\\Josiene\\Documents\\NetBeansProjects\\ManipulacaoArquivo\\ManipulacaoArquivo\\src\\armazenaArquivos\\listaFuncionario_Excel.xls");
        
        FileInputStream entrada = new FileInputStream(arquivo);
        
        HSSFWorkbook HSSFWorkbook = new HSSFWorkbook(entrada);
        
        HSSFSheet planilha = HSSFWorkbook.getSheetAt(0); /* Pega a primeira planilha */
        
        Iterator<Row> linhaInterator = planilha.iterator();
        
        List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        
        while(linhaInterator.hasNext()){ /*Enquanto tiver linha no arquivo Excel*/
            Row linha = linhaInterator.next();
            Iterator<Cell> celulas = linha.iterator();
            
            Funcionario funcionario = new Funcionario();
            
            while(celulas.hasNext()){
                Cell cell = celulas.next();
                
                switch(cell.getColumnIndex()){
                    case 0:
                        funcionario.setCpf(cell.getStringCellValue());
                        break;
                    case 1:
                        funcionario.setNome(cell.getStringCellValue());
                        break;
                    case 2:
                        funcionario.setEmail(cell.getStringCellValue());
                        break;
                    case 3:
                        funcionario.setIdade(cell.getStringCellValue());
                        break;
                    case 4:
                        funcionario.setSalario(cell.getStringCellValue());
                        break;
                    case 5:
                        String horasExtras = cell.getStringCellValue();
                        
                        if(horasExtras.equals("null")){
                            funcionario.setHorasExtras(null);
                        }else{
                            funcionario.setHorasExtras(Integer.parseInt(horasExtras));
                        }
                        
                        break;
                } 
            } 
            listaFuncionario.add(funcionario);
        }
        entrada.close();
        
        for(Funcionario funcionario:listaFuncionario){
            System.out.println(funcionario);
        }
    }
}
