
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ModelArchivo;
import view.ViewArchivo;

public class ControllerArchivo implements ActionListener {
    
    private final ModelArchivo modelArchivo;
    private final ViewArchivo viewArchivo;

    public ControllerArchivo(ModelArchivo modelArchivo, ViewArchivo viewArchivo) {
        this.modelArchivo = modelArchivo;
        this.viewArchivo = viewArchivo;
        
        viewArchivo.jmi_open.addActionListener(this);
        viewArchivo.jmi_save.addActionListener(this);
        initComponents();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewArchivo.jmi_open){
            openFile();
        }
        else if (e.getSource() == viewArchivo.jmi_save){
            saveFile();
        }
    }
    public void openFile(){
        modelArchivo.setPath("C:\\Users\\VICTOR MANUEL ARANDA\\Documents\\archivos\\document.txt");
        modelArchivo.readFile(modelArchivo.getPath());
        viewArchivo.jta_file.setText(modelArchivo.getMessage());
        
    }
    public void saveFile(){
        modelArchivo.setPath("C:\\Users\\VICTOR MANUEL ARANDA\\Documents\\archivos\\document.txt"
                + ".txt");
        modelArchivo.setMessage(viewArchivo.jta_file.getText());
        modelArchivo.writeFile(modelArchivo.getPath(), modelArchivo.getMessage());
    }
    public void initComponents(){
        viewArchivo.setTitle("Bloc de notas Chay");
        viewArchivo.setVisible(true);
        viewArchivo.setLocationRelativeTo(null);
        
    }
    
}
