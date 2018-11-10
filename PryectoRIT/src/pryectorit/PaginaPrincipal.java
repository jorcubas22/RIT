/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pryectorit;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Jorge
 */
public class PaginaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form PaginaPrincipal
     */
    public PaginaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelEscalafon = new javax.swing.JLabel();
        BotonIndexar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaIndice = new javax.swing.JTable();
        LabelArchivo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaEscalafon = new javax.swing.JTable();
        BotonIrPagina = new javax.swing.JButton();
        BotonSiguienteEscalafon = new javax.swing.JButton();
        BotonLeerArchivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LabelEscalafon.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        LabelEscalafon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelEscalafon.setText("Escalafón Creado");

        BotonIndexar.setText("Indexar");
        BotonIndexar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIndexarActionPerformed(evt);
            }
        });

        TablaIndice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Numero Archivo", "Nombre Archivo"
            }
        ));
        jScrollPane1.setViewportView(TablaIndice);

        LabelArchivo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        LabelArchivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelArchivo.setText("Archivos A  Indexar");

        TablaEscalafon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Posición Escalafon", "Nombre Archivo", "Valor Resultante"
            }
        ));
        jScrollPane2.setViewportView(TablaEscalafon);

        BotonIrPagina.setText("Ir  a Página");

        BotonSiguienteEscalafon.setText("Next");

        BotonLeerArchivo.setText("Leer Archivos");
        BotonLeerArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLeerArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(LabelArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelEscalafon, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(345, 345, 345))
            .addGroup(layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(BotonIndexar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonIrPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(355, 355, 355))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonLeerArchivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 281, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonSiguienteEscalafon, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(213, 213, 213))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelEscalafon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotonSiguienteEscalafon)
                        .addGap(32, 32, 32)
                        .addComponent(BotonIrPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(97, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BotonLeerArchivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotonIndexar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonIndexarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIndexarActionPerformed
        try {
            // TODO add your handling code here:
            Indexar();
        } catch (IOException ex) {
            Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonIndexarActionPerformed

    private void BotonLeerArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLeerArchivoActionPerformed
        try {
            // TODO add your handling code here:
            Archivos();
        } catch (IOException ex) {
            Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonLeerArchivoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaginaPrincipal().setVisible(true);
            }
        });
    }
    
    public void Archivos() throws IOException{
        final File folder = new File("C:/Users/Jorge/Documents/TEC/VII Semestre/RIT 2/TP2 - RIT - 2018ii");
        List<String> ListaArchivos = new ArrayList<String>();
        ListaArchivos = listFilesForFolder(folder);
        System.out.println(ListaArchivos);
        for(int i = 0; i < ListaArchivos.size(); i++){
            TablaIndice.setValueAt(i+1, i, 0);
            TablaIndice.setValueAt(ListaArchivos.get(i), i, 1);
        }
    }
    
    public List listFilesForFolder(final File folder) {
        List<String> ListaArchivos = new ArrayList<String>();
        for (final File fileEntry : folder.listFiles()) {
                if (fileEntry.isDirectory()) {
                    listFilesForFolder(fileEntry);
                 } else {
                    ListaArchivos.add(fileEntry.getName());
                    /*System.out.println(fileEntry.getName());*/
            }
        }
        return ListaArchivos;
    }
    
    public void Indexar() throws IOException, FileNotFoundException, URISyntaxException{
        final File folder = new File("C:/Users/Jorge/Documents/TEC/VII Semestre/RIT 2/TP2 - RIT - 2018ii");
        List<String> ListaArchivos = new ArrayList<String>();
        ListaArchivos = listFilesForFolder(folder);        
        int FilaSeleccionada = TablaIndice.getSelectedRow();
        LeeArchivos(ListaArchivos.get(FilaSeleccionada));
    }
    
    public void LeeArchivos(String ArchivoSeleccionado) throws FileNotFoundException, IOException, URISyntaxException{
        File f = new File("C:/Users/Jorge/Documents/TEC/VII Semestre/RIT 2/TP2 - RIT - 2018ii/" +ArchivoSeleccionado);
        BufferedReader br = new BufferedReader(new FileReader(f)); 
        String st; 
        int Comienza = 0;
        int Finaliza = 0;
        int contador = 0;
        //boolean salite = false;
        List<String> where = new ArrayList<String>();
        while ((st = br.readLine()) != null){
            contador+=1;
            String[] words = st.split(" ");
            for(int i =0; i < words.length; i++) {
                where.add(words[i]);
                if(words[i].equals("<!DOCTYPE")){
                    Comienza = contador;
                }
                if(words[i].equals("</html>")){
                    Finaliza = contador;
                    EscribeArchivo(where, Comienza, Finaliza);
                    where = new ArrayList<String>();
                }
            }
        }
        //System.out.println(where.size());
    }
    
    
    public void EscribeArchivo(List<String> ArchivoEscribir, int Comienza, int Finaliza) throws URISyntaxException, IOException{
                String FILENAME = "C:\\Users\\Jorge\\Documents\\TEC\\filename.html";
        	try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
                        for(int i = 0; i < ArchivoEscribir.size(); i++){
                            bw.write(ArchivoEscribir.get(i));
                            bw.write(" ");
                        }
			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();
		}
                File sourceFile = new File("C:\\Users\\Jorge\\Documents\\TEC\\filename.html");
                org.jsoup.nodes.Document doc = Jsoup.parse(sourceFile, "UTF-8");
                
                Element body = doc.body();
                Document DocumentoRecuperado = Jsoup.parse(body.wholeText());
                Element body2 = DocumentoRecuperado.body();
                String Cuerpo = body2.ownText();
                Cuerpo = StringUtils.stripAccents(Cuerpo);
                
                /* Buscar Headers*/
                Elements buscaHeaders = doc.select("h1, h2, h3, h4, h5, h6, h7, h8, h9");
                Elements h1Tags = buscaHeaders.select("h1");
                String h1 = "";
                //List<String> h1s = new ArrayList<String>();
                Elements h2Tags = buscaHeaders.select("h2");
                String h2 = "";
                Elements h3Tags = buscaHeaders.select("h3");
                String h3 = "";
                Elements h4Tags = buscaHeaders.select("h4");
                String h4 = "";
                Elements h5Tags = buscaHeaders.select("h5");
                String h5 = "";
                Elements h6Tags = buscaHeaders.select("h6");
                String h6 = "";
                Elements h7Tags = buscaHeaders.select("h7");
                String h7 = "";
                Elements h8Tags = buscaHeaders.select("h8");
                String h8 = "";
                Elements h9Tags = buscaHeaders.select("h9");
                String h9 = "";
                
                for(int i = 0; i < h1Tags.size(); i++){
                    String temporal2 = h1Tags.get(i).ownText();
                    h1 += temporal2 + " ";
                    /*String[] words = temporal2.split(" ");
                    h1s.addAll(Arrays.asList(words));*/
                }
                System.out.println("Header h1: ");
                h1 = StringUtils.stripAccents(h1);
                System.out.println(h1);
                for(int i = 0; i < h2Tags.size(); i++){
                    String temporal2 = h2Tags.get(i).ownText();
                    h2 += temporal2 + " ";
                }
                h2 = StringUtils.stripAccents(h2);
                System.out.println("Header h2: ");
                System.out.println(h2);                
                for(int i = 0; i < h3Tags.size(); i++){
                    String temporal2 = h3Tags.get(i).ownText();
                    h3 += temporal2 + " ";
                }                
                System.out.println("Header h3: ");
                h3 = StringUtils.stripAccents(h3);
                System.out.println(h3);
                
                for(int i = 0; i < h4Tags.size(); i++){
                    String temporal2 = h4Tags.get(i).ownText();
                    h4 += temporal2 + " ";
                }
                System.out.println("Header h4: ");
                h4 = StringUtils.stripAccents(h4);
                System.out.println(h4);
                
                for(int i = 0; i < h5Tags.size(); i++){
                    String temporal2 = h5Tags.get(i).ownText();
                    h5 += temporal2 + " ";
                }
                System.out.println("Header h5: ");
                h5 = StringUtils.stripAccents(h5);
                System.out.println(h5);
                
                for(int i = 0; i < h6Tags.size(); i++){
                    String temporal2 = h6Tags.get(i).ownText();
                    h6 += temporal2 + " ";
                }
                System.out.println("Header h6: ");
                h6 = StringUtils.stripAccents(h6);
                System.out.println(h6);
                
                for(int i = 0; i < h7Tags.size(); i++){
                    String temporal2 = h7Tags.get(i).ownText();;
                    h7 += temporal2 + " ";
                }
                h7 = StringUtils.stripAccents(h7);
                System.out.println("Header h7: ");
                System.out.println(h7);
                
                for(int i = 0; i < h8Tags.size(); i++){
                    String temporal2 = h8Tags.get(i).ownText();
                    h8 += temporal2 + " ";
                }
                h8 = StringUtils.stripAccents(h8);
                System.out.println("Header h8: ");
                System.out.println(h8);
                
                for(int i = 0; i < h9Tags.size(); i++){
                    String temporal2 = h9Tags.get(i).ownText();
                    h9 += temporal2 + " ";
                }
                h9 = StringUtils.stripAccents(h9);
                System.out.println("Header h9: ");
                System.out.println(h9);
                
                /* Busca Títulos*/
                Elements Title = doc.select("title");
                String titulo = "";
                for(int i = 0; i < Title.size(); i++){
                    String temporal2 = Title.get(i).ownText();
                    titulo += temporal2 + " ";
                }
                titulo = StringUtils.stripAccents(titulo);
                System.out.println("Titulos: ");
                System.out.println(titulo);
                
                /* Busqueda de <a>*/
                Elements ref = doc.select("a[href]");
                String HyperLink = "";
                for(int i = 0; i < ref.size(); i++){
                    String temporal2 = ref.get(i).ownText();
                    HyperLink += temporal2 + " ";
                }
                System.out.println("HyperLinks <a>: ");
                HyperLink = StringUtils.stripAccents(HyperLink);
                HyperLink = HyperLink.replaceAll("[^\\p{IsDigit}\\p{IsAlphabetic}]", " ");
                System.out.println(HyperLink);
                
                
                System.out.println("Comienza: ");
                System.out.println(Comienza);
                
                System.out.println("Finaliza: ");
                System.out.println(Finaliza);
                
                //ObjetoArchivos tituloc = new ObjetoArchivos(Cuerpo, Titulos, CuerpoPalabras, HyperLinks, h1s, h2s, h3s, h4s, h5s, h6s, h7s, h8s, h9s);
                // Utilizado Para Abrir Archivo HTML desde Java
                /*String url = "file:///C:/Users/Jorge/Documents/TEC/filename.html";
                URI oURL = new URI(url);
                Desktop.getDesktop().browse(oURL);*/
                
                
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonIndexar;
    private javax.swing.JButton BotonIrPagina;
    private javax.swing.JButton BotonLeerArchivo;
    private javax.swing.JButton BotonSiguienteEscalafon;
    private javax.swing.JLabel LabelArchivo;
    private javax.swing.JLabel LabelEscalafon;
    private javax.swing.JTable TablaEscalafon;
    private javax.swing.JTable TablaIndice;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
