/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.nbplugin.newfile;

//import com.aspose.ObjectFactory;
//import com.aspose.ecplugin.examplesmodel.Folders;
import com.aspose.nbplugin.examplesmodel.Data;
import com.aspose.nbplugin.examplesmodel.Example;
import com.aspose.nbplugin.examplesmodel.Examples;
import com.aspose.nbplugin.examplesmodel.Folder;
import com.aspose.nbplugin.examplesmodel.Folders;
import com.aspose.nbplugin.examplesmodel.ObjectFactory;
import com.aspose.nbplugin.utils.AsposeComponentsManager;
import com.aspose.nbplugin.utils.AsposeConstants;
import com.aspose.nbplugin.utils.AsposeJavaComponent;
import com.aspose.nbplugin.utils.AsposeJavaComponents;
import com.aspose.nbplugin.utils.CustomtMutableTreeNode;
import com.aspose.nbplugin.utils.GitHelper;
import java.awt.Color;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectManager;
import org.netbeans.api.project.ui.OpenProjects;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;


/**
 *
 * @author Administrator
 */
public class AsposeNewFile extends javax.swing.JDialog {

    boolean examplesNotAvailable;
    //boolean initialComponentSelectBug = true;

    /**
     * Creates new form AsposeNewFile
     */
    public AsposeNewFile(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initComponentsUser();
    }

    private void initComponentsUser() {
        AsposeJavaComponents components = new AsposeJavaComponents();
        examplesNotAvailable = false;
        componentSelection.removeAllItems();
        projectSelection.removeAllItems();
        projectSelection.addItem("Select project");
        componentSelection.addItem("Select component");
        CustomtMutableTreeNode top = new CustomtMutableTreeNode("");
        DefaultTreeModel model = (DefaultTreeModel) examplesTree.getModel();
        model.setRoot(top);
        model.reload(top);
        populateOpenedProjectsList();
        validateDialog();
    }

    private boolean populateComponentsList() {
  
        File file = new File(getSelectedProjectRootPath() + File.separator + "lib");
        String[] directories = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isDirectory();
            }
        });
        
        componentSelection.removeAllItems();
        componentSelection.addItem("Select component");
        
        for(int i=0;i< directories.length;i++)
        {
            if(!directories[i].equals("CopyLibs"))
              componentSelection.addItem(directories[i]);  
        }
        return true;
    }

    private boolean populateOpenedProjectsList() {
        ProjectManager pm = ProjectManager.getDefault();
        Project[] projects = OpenProjects.getDefault().getOpenProjects();
        for (int i = 0; i < projects.length; i++) {
            projectSelection.addItem(projects[i]);
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButtonFinish = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        progressBarPr = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelMessage = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        componentSelection = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        examplesTree = new javax.swing.JTree();
        projectSelection = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(522, 584));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        org.openide.awt.Mnemonics.setLocalizedText(jButtonFinish, org.openide.util.NbBundle.getMessage(AsposeNewFile.class, "AsposeNewFile.jButtonFinish.text")); // NOI18N
        jButtonFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinishActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButtonCancel, org.openide.util.NbBundle.getMessage(AsposeNewFile.class, "AsposeNewFile.jButtonCancel.text")); // NOI18N
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jButtonFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFinish, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jButtonCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/long_banner.PNG"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(AsposeNewFile.class, "AsposeNewFile.jLabel2.text")); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(AsposeNewFile.class, "AsposeNewFile.jLabel3.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(54, 54, 54)
                .addComponent(jLabel2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        org.openide.awt.Mnemonics.setLocalizedText(jLabelMessage, org.openide.util.NbBundle.getMessage(AsposeNewFile.class, "AsposeNewFile.jLabelMessage.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(AsposeNewFile.class, "AsposeNewFile.jLabel5.text")); // NOI18N

        componentSelection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        componentSelection.setSelectedIndex(-1);
        componentSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                componentSelectionActionPerformed(evt);
            }
        });
        componentSelection.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                componentSelection_Propertychanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(AsposeNewFile.class, "AsposeNewFile.jLabel1.text")); // NOI18N

        examplesTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                examplesTree_clicked(evt);
            }
        });
        jScrollPane1.setViewportView(examplesTree);

        projectSelection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        projectSelection.setSelectedIndex(-1);
        projectSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectSelectionActionPerformed(evt);
            }
        });
        projectSelection.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                projectSelection_Propertychanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(progressBarPr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(componentSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(projectSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(projectSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(componentSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressBarPr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinishActionPerformed
     
        createExample();
        dispose();
    }//GEN-LAST:event_jButtonFinishActionPerformed

    private String getSelectedProjectRootPath() {
        String path = null;
        Project project = (Project) projectSelection.getSelectedItem();
        FileObject fo = project.getProjectDirectory();
        path = fo.getPath();

        return path;
    }

    private CustomtMutableTreeNode getSelectedNode() {
        String projectPath = getSelectedProjectRootPath();
        return (CustomtMutableTreeNode) examplesTree.getLastSelectedPathComponent();
    }

    private void copyExample(String sourcePath, String destinationPath) {
        try {
            AsposeComponentsManager.copyDirectory(sourcePath, destinationPath);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    private boolean createExample() {
        String projectPath = getSelectedProjectRootPath();
        CustomtMutableTreeNode comp = getSelectedNode();
        if (comp == null) {
            return false;
        }
        try {
            String path = comp.getExPath();
            Example ex = comp.getExample();
            AsposeJavaComponent component = AsposeJavaComponents.list.get(componentSelection.getSelectedItem());
            copyExample(GitHelper.getLocalRepositoryPath(component) + File.separator + path, projectPath + File.separator + path);
            if (ex == null) {
                return false;
            }

        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void componentSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_componentSelectionActionPerformed
        // TODO add your handling code here:
       /* if(initialComponentSelectBug)
         {
         initialComponentSelectBug = false;
         return;
         }*/
        SwingWorker sw = new SwingWorker<String, Void>() {
            @Override
            protected String doInBackground() {

                String item = (String) componentSelection.getSelectedItem();
                if (item != null && item.equals("Select component")) {
                    return null;
                }
                diplayMessage("Please wait, Preparing to refresh examples", true);
                CustomtMutableTreeNode top = new CustomtMutableTreeNode("");
                DefaultTreeModel model = (DefaultTreeModel) examplesTree.getModel();
                model.setRoot(top);
                model.reload(top);

                AsposeJavaComponent component = AsposeJavaComponents.list.get(item);
                checkAndUpdateRepo(component);
                validateDialog();
                return null;
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        sw.execute();

    }//GEN-LAST:event_componentSelectionActionPerformed

    private void clearMessage() {
        jLabelMessage.setText("");
        jButtonFinish.setEnabled(true);
    }

    private void diplayMessage(String message, boolean error) {
        if (error) {
            jLabelMessage.setForeground(Color.RED);
            jButtonFinish.setEnabled(false);
        } else {
            jLabelMessage.setForeground(Color.GREEN);
            jButtonFinish.setEnabled(true);
        }
        jLabelMessage.setText(message);
    }

    /**
     *
     * @param title
     * @param message
     * @param style
     * @return
     */
    public int showMessage(String title, String message, int buttons, int icon) {
        //JOptionPane.YES_NO_OPTION,JOptionPane.ERROR
        int result = JOptionPane.showConfirmDialog(null, message, title, buttons, icon);
        return result;
       
    }

    private void checkAndUpdateRepo(AsposeJavaComponent component) {
        if (null == component) {
            return;
        }
        if (null == component.get_remoteExamplesRepository()) {
            showMessage("Examples not available", component.get_name() + " - " + AsposeConstants.EXAMPLES_NOT_AVAILABLE_MESSAGE, JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            examplesNotAvailable = true;
            //validateDialog();
            return;
        } else {
            examplesNotAvailable = false;
            //validateDialog();
        }
        //String repoPath;
        if (GitHelper.isExamplesDefinitionsPresent(component)) {
            try {
                GitHelper.updateRepository(component);
                populateExamplesTree(GitHelper.getExamplesDefinitionsPath(component), component.get_name());
            } catch (Exception e) {
            }
        } else {
            int result = showMessage("Examples download required", component.get_name() + " - " + AsposeConstants.EXAMPLES_DOWNLOAD_REQUIRED, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                if (AsposeComponentsManager.isIneternetConnected()) {
                    GitHelper.updateRepository(component);
                    if (GitHelper.isExamplesDefinitionsPresent(component)) {
                        try {
                            populateExamplesTree(GitHelper.getExamplesDefinitionsPath(component), component.get_name());
                        } catch (Exception e) {
                        }
                    }
                } else {
                    showMessage(AsposeConstants.INTERNET_CONNECTION_REQUIRED_MESSAGE_TITLE, component.get_name() + " - " + AsposeConstants.EXAMPLES_INTERNET_CONNECTION_REQUIRED_MESSAGE, JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    private void populateExamplesTree(String examplesDefinitionFile, String componentName) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
            Unmarshaller unmarshaller;

            unmarshaller = jaxbContext.createUnmarshaller();

            Data data = (Data) unmarshaller.unmarshal(new File(examplesDefinitionFile));
            examplesTree.removeAll();
            CustomtMutableTreeNode top = new CustomtMutableTreeNode(componentName);
            top.setExPath("src");
            List<Folders> rootFoldersList = data.getFolders();
            parseFoldersTree(rootFoldersList, top);
            parseExamples(data.getExamples(), top);
            DefaultTreeModel model = (DefaultTreeModel) examplesTree.getModel();
            model.setRoot(top);
            model.reload(top);
            examplesTree.expandPath(new TreePath(top.getPath()));
        } catch (JAXBException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    /**
     *
     * @param rootFoldersList
     * @param parentItem
     */
    void parseFoldersTree(List<Folders> rootFoldersList, CustomtMutableTreeNode parentItem) {
        for (Folders folders : rootFoldersList) {
            // Get list of folder
            List<Folder> folderList = folders.getFolder();
            for (Folder folder : folderList) {
                CustomtMutableTreeNode child = new CustomtMutableTreeNode(folder.getTitle());
                child.setExPath(parentItem.getExPath() + File.separator + folder.getFolderName());
                parseExamples(folder.getExamples(), child);
                parseFoldersTree(folder.getFolders(), child);
                parentItem.add(child);
            }
        }
    }

    /**
     *
     * @param examples
     * @param parentItem
     */
    void parseExamples(List<Examples> examplesList, CustomtMutableTreeNode parentItem) {
        //
        for (Examples examples : examplesList) {
            List<Example> exampleList = examples.getExample();
            for (Example example : exampleList) {
                // false: do not run
                parseExample(example, parentItem);
            }
        }
    }

    /**
     *
     * @param example
     * @param parentItem
     */
    void parseExample(Example example, CustomtMutableTreeNode parentItem) {
        CustomtMutableTreeNode child = new CustomtMutableTreeNode(example.getTitle());
        child.setExample(example);
        child.setExPath(parentItem.getExPath() + File.separator + example.getFolderName());
        parentItem.add(child);
    }

    private boolean isExampleSelected() {
        //TreePath path = examplesTree.getSelectionPath();
        CustomtMutableTreeNode comp = (CustomtMutableTreeNode) examplesTree.getLastSelectedPathComponent();
        if (comp == null) {
            return false;
        }
        try {
            String path = comp.getExPath();
            Example ex = comp.getExample();
            if (ex == null) {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    private boolean validateDialog() {
        if (projectSelection.getSelectedIndex() == 0) {
            diplayMessage("Please select project", true);
            return false;
        }
        if (componentSelection.getSelectedIndex() == 0) {
            diplayMessage("Please select component", true);
            return false;
        }

        if (!isExampleSelected()) {
            diplayMessage("Please select example", true);
            return false;
        }

        clearMessage();
        //return true;
        return true;
    }
    private void componentSelection_Propertychanged(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_componentSelection_Propertychanged
    }//GEN-LAST:event_componentSelection_Propertychanged

    private void examplesTree_clicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_examplesTree_clicked
        // TODO add your handling code here:
        TreePath path = examplesTree.getSelectionPath();
        validateDialog();
    }//GEN-LAST:event_examplesTree_clicked

    private void projectSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectSelectionActionPerformed
        if (projectSelection.getSelectedIndex() > 0)
        populateComponentsList();
        validateDialog();
    }//GEN-LAST:event_projectSelectionActionPerformed

    private void projectSelection_Propertychanged(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_projectSelection_Propertychanged
        // TODO add your handling code here:
    }//GEN-LAST:event_projectSelection_Propertychanged

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
            java.util.logging.Logger.getLogger(AsposeNewFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsposeNewFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsposeNewFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsposeNewFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AsposeNewFile dialog = new AsposeNewFile(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox componentSelection;
    private javax.swing.JTree examplesTree;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonFinish;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JProgressBar progressBarPr;
    private javax.swing.JComboBox projectSelection;
    // End of variables declaration//GEN-END:variables
}
