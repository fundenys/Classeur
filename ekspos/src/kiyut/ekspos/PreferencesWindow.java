
package kiyut.ekspos;

import java.awt.CardLayout;
import javax.swing.DefaultListModel;
import kiyut.ekspos.prefs.GeneralPreferencesPane;
import kiyut.ekspos.prefs.IIOPreferencesPane;
import kiyut.ekspos.prefs.PreferencesPane;

/** Preferences Window
 *
 * @author  Kiyut
 */
public class PreferencesWindow extends javax.swing.JDialog {
    private static String GENERAL_PREFS = "General";
    private static String IIO_PREFS = "Codec";
    
    private PreferencesPane generalPreferencesPane;
    private PreferencesPane iioPreferencesPane;
    
    /** Creates new form PreferencesWindow */
    public PreferencesWindow(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initCustomComponents();
        loadPrefs();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        contentPane = new javax.swing.JPanel();
        mainPane = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        preferencesList = new javax.swing.JList();
        preferencesPane = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        buttonPane = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        contentPane.setLayout(new java.awt.GridBagLayout());

        contentPane.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(5, 5, 5, 5)));
        mainPane.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(75, 200));
        preferencesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        preferencesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                preferencesListValueChanged(evt);
            }
        });

        jScrollPane1.setViewportView(preferencesList);

        mainPane.add(jScrollPane1, java.awt.BorderLayout.WEST);

        preferencesPane.setLayout(new java.awt.CardLayout());

        preferencesPane.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(0, 10, 0, 0)));
        preferencesPane.setPreferredSize(new java.awt.Dimension(350, 300));
        mainPane.add(preferencesPane, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        contentPane.add(mainPane, gridBagConstraints);

        jSeparator1.setMinimumSize(new java.awt.Dimension(0, 2));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        contentPane.add(jSeparator1, gridBagConstraints);

        buttonPane.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        buttonPane.add(okButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        buttonPane.add(cancelButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        contentPane.add(buttonPane, gridBagConstraints);

        getContentPane().add(contentPane, java.awt.BorderLayout.CENTER);

    }
    // </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //setVisible(false);
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        savePrefs();
        applyPrefs();
        setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed

    private void preferencesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_preferencesListValueChanged
        if (evt.getValueIsAdjusting() == true) { return;}
        String name = (String)preferencesList.getSelectedValue();
        CardLayout layout = (CardLayout)preferencesPane.getLayout();
        layout.show(preferencesPane, name);
    }//GEN-LAST:event_preferencesListValueChanged
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPane;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel contentPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mainPane;
    private javax.swing.JButton okButton;
    private javax.swing.JList preferencesList;
    private javax.swing.JPanel preferencesPane;
    // End of variables declaration//GEN-END:variables
    
    private void initCustomComponents() {
        setTitle("Preferences - " + Application.getName());

        generalPreferencesPane = new GeneralPreferencesPane();
        iioPreferencesPane = new IIOPreferencesPane();
        
        preferencesPane.add(generalPreferencesPane,GENERAL_PREFS);
        preferencesPane.add(iioPreferencesPane,IIO_PREFS);

        DefaultListModel model = new DefaultListModel();
        preferencesList.setModel(model);
        model.addElement(GENERAL_PREFS);
        model.addElement(IIO_PREFS);
        
        preferencesList.setSelectedIndex(0);
        
        java.awt.Dimension size = new java.awt.Dimension(500,420);
        setSize(size);
        setPreferredSize(size);
    }
    
    private void loadPrefs() {
        generalPreferencesPane.loadPrefs();
        iioPreferencesPane.loadPrefs();
    }
    
    private void savePrefs() {
        generalPreferencesPane.savePrefs();
        iioPreferencesPane.savePrefs();
    }
    
    private void applyPrefs() {
        WindowManager windowManager = WindowManager.getInstance();
        BrowserWindow appFrame = (BrowserWindow)windowManager.getBrowserWindow();
        appFrame.restoreFromPreferences();
    }
}
