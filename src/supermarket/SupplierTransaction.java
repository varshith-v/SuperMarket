/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

/**
 *
 * @author varsh
 */
public class SupplierTransaction extends javax.swing.JFrame {
    
    String url,uname,pass;
    Connection con;
    Statement st;
    PreparedStatement pst;
    CallableStatement cst;
    String query,update;
    ResultSet rs;
    
    DefaultTableModel model;
    double sum=0;
    int empID, supplierID;

    /**
     * Creates new form SupplierTransaction
     */
    public SupplierTransaction(int eID) {
        this.empID = eID;
        initComponents();
        try{
            url = "jdbc:mysql://localhost:3306/supermarket?autoReconnect=true&useSSL=false";
            uname = "root";
            pass = "password";
            con = DriverManager.getConnection(url,uname,pass);
            st = con.createStatement();
            query = "select * from product";
            rs = st.executeQuery(query);
            while(rs.next()){
                productComboBox.addItem(rs.getString("p_name"));
            }
            
//            query = "SELECT * from employee WHERE eid = " + this.empID;
//            rs = st.executeQuery(query);
            
            cst = con.prepareCall("call getEmployee(?)");
            cst.setInt(1, this.empID);
            rs = cst.executeQuery();
            
            rs.next();
            myAccountTxt.setText(" Employee ID:  " + eID + "\n\n Name: \t" + rs.getString("e_name") + 
                    "\n\n Phone: \t" + rs.getString("e_phone") +  "\n\n Email: \t" + rs.getString("email") +
                    "\n\n Designation: \t" + rs.getString("designation") +"\n\n Salary: \t" + rs.getString("salary"));
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e); 
          }  
        model =(DefaultTableModel) jTable1.getModel();
        AutoCompletion.enable(productComboBox);
         billBtn.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
        deleteBtn.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        custPanel = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sidTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        addCustBtn = new javax.swing.JButton();
        supplierBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        supDetailsTxt = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        accountPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        myAccountTxt = new javax.swing.JTextArea();
        billPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        productComboBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        qty1Txt = new javax.swing.JTextField();
        pnameBtn = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pidTxt = new javax.swing.JTextField();
        qty2Txt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        pidBtn = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        sumLabel = new javax.swing.JLabel();
        billBtn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        custPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel15.setText("Select Supplier:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("EXISTING Supplier:");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel2.setText("Supplier ID:");

        sidTxt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("NEW Supplier:");

        addCustBtn.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        addCustBtn.setText("ADD Supplier");
        addCustBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustBtnActionPerformed(evt);
            }
        });

        supplierBtn.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        supplierBtn.setText("Submit");
        supplierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierBtnActionPerformed(evt);
            }
        });

        supDetailsTxt.setEditable(false);
        supDetailsTxt.setColumns(20);
        supDetailsTxt.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        supDetailsTxt.setRows(5);
        supDetailsTxt.setBorder(null);
        jScrollPane2.setViewportView(supDetailsTxt);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel5.setText("Selected Supplier Details:");

        javax.swing.GroupLayout custPanelLayout = new javax.swing.GroupLayout(custPanel);
        custPanel.setLayout(custPanelLayout);
        custPanelLayout.setHorizontalGroup(
            custPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(custPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(custPanelLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(custPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(custPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(custPanelLayout.createSequentialGroup()
                        .addGroup(custPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(custPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(custPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(supplierBtn)
                                    .addComponent(sidTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(custPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addCustBtn)
                            .addComponent(jLabel3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        custPanelLayout.setVerticalGroup(
            custPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(custPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(custPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(custPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sidTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(addCustBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(supplierBtn)
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        accountPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Your ACCOUNT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        jButton1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton1.setText("Change Password");

        myAccountTxt.setEditable(false);
        myAccountTxt.setColumns(20);
        myAccountTxt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        myAccountTxt.setRows(5);
        myAccountTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane3.setViewportView(myAccountTxt);

        javax.swing.GroupLayout accountPanelLayout = new javax.swing.GroupLayout(accountPanel);
        accountPanel.setLayout(accountPanelLayout);
        accountPanelLayout.setHorizontalGroup(
            accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton1)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        accountPanelLayout.setVerticalGroup(
            accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountPanelLayout.createSequentialGroup()
                .addGroup(accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(accountPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(accountPanelLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jButton1)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        billPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Price per unit", "Current Stock", "Stock  to Add", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setGridColor(new java.awt.Color(153, 153, 153));
        jTable1.setRowHeight(22);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(400);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel7.setText("Product Name");

        productComboBox.setEditable(true);
        productComboBox.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Stock to add");

        qty1Txt.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        qty1Txt.setText("1");

        pnameBtn.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        pnameBtn.setText("ADD");
        pnameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnameBtnActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel13.setText("OR");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel8.setText("Product ID");

        pidTxt.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        qty2Txt.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        qty2Txt.setText("1");

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setText("Stock to add");

        pidBtn.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        pidBtn.setText("ADD");
        pidBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pidBtnActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel14.setText("Add products to Bill:");

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel11.setText("BILL");

        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Delete Product");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel1.setText("Total:   ");

        sumLabel.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        sumLabel.setText("₹0.0");

        billBtn.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        billBtn.setForeground(new java.awt.Color(255, 255, 255));
        billBtn.setText("Confirm Transaction");
        billBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billBtnActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel12.setText("Supplier Transaction (Adding Stock)");

        javax.swing.GroupLayout billPanelLayout = new javax.swing.GroupLayout(billPanel);
        billPanel.setLayout(billPanelLayout);
        billPanelLayout.setHorizontalGroup(
            billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(207, 207, 207))
            .addGroup(billPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addComponent(productComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pidTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149))
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(billPanelLayout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(pnameBtn))
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addGap(105, 105, 105)))
                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(232, 232, 232))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billPanelLayout.createSequentialGroup()
                                .addComponent(pidBtn)
                                .addGap(203, 203, 203))))
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(qty1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qty2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(194, 194, 194))
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(billBtn)
                            .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 922, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 79, Short.MAX_VALUE))
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addComponent(deleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sumLabel)
                        .addGap(133, 133, 133))))
        );
        billPanelLayout.setVerticalGroup(
            billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pidTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(qty1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(qty2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pnameBtn)
                    .addComponent(pidBtn))
                .addGap(17, 17, 17)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn)
                        .addGap(53, 53, 53)
                        .addComponent(billBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billPanelLayout.createSequentialGroup()
                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(sumLabel))
                        .addGap(101, 101, 101))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(billPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(custPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accountPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(billPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(accountPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(custPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addCustBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustBtnActionPerformed
        // TODO add your handling code here:
        new AddSupplier().setVisible(true);
    }//GEN-LAST:event_addCustBtnActionPerformed

    private void supplierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierBtnActionPerformed
        // TODO add your handling code here:
        String sid = sidTxt.getText();
        query = "SELECT * FROM supplier WHERE sid = '" + sid + "'";
        try{
            rs = st.executeQuery(query);
            rs.next();
            supplierID = rs.getInt("sid");
            String sName = rs.getString("s_name");
            String ph = rs.getString("s_phone");
            String addr = rs.getString("s_address");
            supDetailsTxt.setText("  Supplier ID:\t" + supplierID + "\n\n  Name:\t" + sName + "\n\n  Address:\t" + addr + "\n\n  Phone No:\t" + ph);

        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No supplier found with this SID!\nPlease add new supplier details");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }

    }//GEN-LAST:event_supplierBtnActionPerformed

    private void pnameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnameBtnActionPerformed
        // TODO add your handling code here:
        String pnameTxt = (String) productComboBox.getSelectedItem();
        double qty = Double.parseDouble(qty1Txt.getText());
        if(qty<=0){
            JOptionPane.showMessageDialog(null,"Quantity must be greater than 0");
            return;
        }
        query = "SELECT * FROM product WHERE p_name = '" + pnameTxt + "'";
        try{
            rs = st.executeQuery(query);
            rs.next();
            int pid = rs.getInt("pid");
            String pname = rs.getString("p_name");
            int price = rs.getInt("price");
            double netPrice = price*qty;
            double stock = rs.getDouble("stock");
                model.addRow(new Object[]{pid,pname,price,stock,qty,netPrice});
                sum = sum + Double.parseDouble(jTable1.getValueAt(model.getRowCount()-1,5).toString());
                sumLabel.setText("₹" + Double.toString(sum));
                qty1Txt.setText("1");
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_pnameBtnActionPerformed

    private void pidBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pidBtnActionPerformed
        // TODO add your handling code here:
        String pidText = (String) this.pidTxt.getText();
        double qty = Double.parseDouble(qty2Txt.getText());
        if(qty<=0){
            JOptionPane.showMessageDialog(null,"Quantity must be greater than 0");
            return;
        }
        query = "SELECT * FROM product WHERE pid = '" + pidText + "'";
        try{
            rs = st.executeQuery(query);
            rs.next();
            int pid = rs.getInt("pid");
            String pname = rs.getString("p_name");
            int price = rs.getInt("price");
            double netPrice = price*qty;
            double stock = rs.getDouble("stock");
            model.addRow(new Object[]{pid,pname,price,stock,qty,netPrice});
                sum = sum + Double.parseDouble(jTable1.getValueAt(model.getRowCount()-1,5).toString());
                sumLabel.setText("₹" + Double.toString(sum));
                qty1Txt.setText("1");

        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No product with this ID found!\nPlease use Product Name");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_pidBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        int[] selectedRows = jTable1.getSelectedRows();
        if (selectedRows.length > 0) {
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                sum = sum - Double.parseDouble(jTable1.getValueAt(selectedRows[i],5).toString());
                sumLabel.setText("₹" + Double.toString(sum));
                model.removeRow(selectedRows[i]);
                
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void billBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billBtnActionPerformed
        // TODO add your handling code here:
        try{
            if(sum <= 0)
            JOptionPane.showMessageDialog(null,"Total amount cannot be ₹0\n Add items to the list");
            else if(supplierID == 0)
            JOptionPane.showMessageDialog(null,"Please select a Supplier\n before proceeding");
            else{
                for (int count = 0; count < model.getRowCount(); count++){
                    String pid = model.getValueAt(count, 0).toString();
                    String stockToAdd = model.getValueAt(count, 4).toString();
                    update = "UPDATE product SET stock = stock + "+ stockToAdd +" WHERE pid = "+ pid +";";
                    st.executeUpdate(update);
                }
                
                
                update = "INSERT INTO supplier_bills (sid,eid,amount,date) VALUES (?,?,?,?);";
                pst = con.prepareStatement(update);
                pst.setString(1, Integer.toString(supplierID));
                pst.setString(2, Integer.toString(empID));
                pst.setString(3, Double.toString(sum));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(new java.util.Date());
                pst.setString(4, date);
                int status = pst.executeUpdate();
                if(status>0){
                    JOptionPane.showMessageDialog(rootPane, "Transaction completed Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    MessageFormat headerFormat = new MessageFormat("Add Stock Summary");
                    MessageFormat footerFormat = new MessageFormat("Paid to Supplier: ₹" + sum);
                    jTable1.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
                    new SupplierTransaction(empID).setVisible(true);
                    this.dispose();
                }
                 else
                    JOptionPane.showMessageDialog(rootPane, "Could not complete Transaction", "Failed", JOptionPane.ERROR_MESSAGE);

                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_billBtnActionPerformed


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accountPanel;
    private javax.swing.JButton addCustBtn;
    private javax.swing.JButton billBtn;
    private javax.swing.JPanel billPanel;
    private javax.swing.JPanel custPanel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea myAccountTxt;
    private javax.swing.JButton pidBtn;
    private javax.swing.JTextField pidTxt;
    private javax.swing.JButton pnameBtn;
    private javax.swing.JComboBox<String> productComboBox;
    private javax.swing.JTextField qty1Txt;
    private javax.swing.JTextField qty2Txt;
    private javax.swing.JTextField sidTxt;
    private javax.swing.JLabel sumLabel;
    private javax.swing.JTextArea supDetailsTxt;
    private javax.swing.JButton supplierBtn;
    // End of variables declaration//GEN-END:variables
}
