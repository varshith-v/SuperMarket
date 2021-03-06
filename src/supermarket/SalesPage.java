/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.util.*;
import java.sql.*;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;


/**
 *
 * @author varsh
 */
public class SalesPage extends javax.swing.JFrame  {

    String url,uname,pass;
    Connection con;
    Statement st;
    PreparedStatement pst;
    CallableStatement cst;
    String query,update;
    ResultSet rs;
    
    DefaultTableModel model;
    double sum=0;
    int empID, custID, rewardPoints, redeemableRewards;
    

    public SalesPage(int eID) {
        this.empID = eID;
        initComponents();
//        billBtn.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
//        deleteBtn.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
        
        try{
            url = "jdbc:mysql://localhost:3306/supermarket?autoReconnect=true&useSSL=false";
            uname = "root";
            pass = "password";
            con = DriverManager.getConnection(url,uname,pass);
            
            st = con.createStatement();
            query = "SELECT * FROM product ORDER BY p_name";
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
            System.out.println(e);
            JOptionPane.showMessageDialog(null,e); 
          }  
        
        model =(DefaultTableModel) jTable1.getModel();
        AutoCompletion.enable(productComboBox);
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
        custPhTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        addCustBtn = new javax.swing.JButton();
        custPhBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        custDetailsTxt = new javax.swing.JTextArea();
        redeemBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        rewardLabel = new javax.swing.JLabel();
        accountPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        myAccountTxt = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
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
        redemptionLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        sumLabel = new javax.swing.JLabel();
        billBtn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sales");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1920, 1055));

        custPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel15.setText("Customer Info:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("EXISTING CUSTOMER:");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel2.setText("Customer Phone No:");

        custPhTxt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("NEW CUSTOMER:");

        addCustBtn.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        addCustBtn.setText("ADD Customer");
        addCustBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustBtnActionPerformed(evt);
            }
        });

        custPhBtn.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        custPhBtn.setText("Submit");
        custPhBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custPhBtnActionPerformed(evt);
            }
        });

        custDetailsTxt.setEditable(false);
        custDetailsTxt.setColumns(20);
        custDetailsTxt.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        custDetailsTxt.setRows(5);
        custDetailsTxt.setBorder(null);
        jScrollPane2.setViewportView(custDetailsTxt);

        redeemBtn.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        redeemBtn.setText("REDEEM REWARD POINTS");
        redeemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redeemBtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel5.setText("Customer Details:");

        rewardLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        rewardLabel.setText(" REWARD POINTS Available:  -");

        javax.swing.GroupLayout custPanelLayout = new javax.swing.GroupLayout(custPanel);
        custPanel.setLayout(custPanelLayout);
        custPanelLayout.setHorizontalGroup(
            custPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(custPanelLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(custPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(custPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(596, Short.MAX_VALUE))
                    .addGroup(custPanelLayout.createSequentialGroup()
                        .addGroup(custPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(custPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(custPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(custPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(custPhTxt)
                                        .addComponent(custPhBtn)))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addGroup(custPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addCustBtn)
                            .addComponent(jLabel3))
                        .addContainerGap(93, Short.MAX_VALUE))))
            .addGroup(custPanelLayout.createSequentialGroup()
                .addGroup(custPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(custPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15))
                    .addGroup(custPanelLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(rewardLabel))
                    .addGroup(custPanelLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(redeemBtn)))
                .addGap(0, 0, Short.MAX_VALUE))
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
                    .addComponent(custPhTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(addCustBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(custPhBtn)
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rewardLabel)
                .addGap(27, 27, 27)
                .addComponent(redeemBtn)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        accountPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Your ACCOUNT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        myAccountTxt.setEditable(false);
        myAccountTxt.setColumns(20);
        myAccountTxt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        myAccountTxt.setRows(5);
        myAccountTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane3.setViewportView(myAccountTxt);

        jButton1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton1.setText("Change Password");

        javax.swing.GroupLayout accountPanelLayout = new javax.swing.GroupLayout(accountPanel);
        accountPanel.setLayout(accountPanelLayout);
        accountPanelLayout.setHorizontalGroup(
            accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(68, 68, 68))
        );
        accountPanelLayout.setVerticalGroup(
            accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountPanelLayout.createSequentialGroup()
                .addGroup(accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(accountPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(accountPanelLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jButton1)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        billPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Price per unit", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(500);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel7.setText("Product Name");

        productComboBox.setEditable(true);
        productComboBox.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Quantity:");

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
        jLabel10.setText("Quantity:");

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

        deleteBtn.setText("Delete Product");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        redemptionLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        redemptionLabel.setText("-0");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setText("Reward Redemption:");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel1.setText("Total:   ");

        sumLabel.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        sumLabel.setText("₹0.0");

        billBtn.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        billBtn.setText("Generate BILL");
        billBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billBtnActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel12.setText("RETAIL INVOICE");

        javax.swing.GroupLayout billPanelLayout = new javax.swing.GroupLayout(billPanel);
        billPanel.setLayout(billPanelLayout);
        billPanelLayout.setHorizontalGroup(
            billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(billPanelLayout.createSequentialGroup()
                .addGap(364, 364, 364)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(billPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(deleteBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(23, 23, 23)
                .addComponent(redemptionLabel)
                .addGap(154, 154, 154))
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
                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 922, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 79, Short.MAX_VALUE))
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(qty1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qty2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(194, 194, 194))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sumLabel))
                    .addComponent(billBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109))
        );
        billPanelLayout.setVerticalGroup(
            billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(0, 31, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteBtn)
                    .addComponent(jLabel6)
                    .addComponent(redemptionLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sumLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(billBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
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
                .addContainerGap(44, Short.MAX_VALUE))
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
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            if(qty <= stock){      
                update = "UPDATE product SET stock = stock - "+ qty +" WHERE pid = "+ pid +";";
                st.executeUpdate(update);
                model.addRow(new Object[]{pid,pname,price,qty,netPrice});
                sum = sum + Double.parseDouble(jTable1.getValueAt(model.getRowCount()-1,4).toString());            
                sumLabel.setText("₹" + Double.toString(sum));
                qty1Txt.setText("1");
            }
            else
                JOptionPane.showMessageDialog(null,"Enough stock not available\nAvailable: "+stock);
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
            if(qty <= stock){     
                update = "UPDATE product SET stock = stock - "+ qty +" WHERE pid = "+ pid +";";
                st.executeUpdate(update);
                model.addRow(new Object[]{pid,pname,price,qty,netPrice});                      
                sum = sum + Double.parseDouble(jTable1.getValueAt(model.getRowCount()-1,4).toString());  
                sumLabel.setText("₹" + Double.toString(sum));
                qty2Txt.setText("1");
            }
            else
                JOptionPane.showMessageDialog(null,"Enough stock not available\nAvailable:"+stock);
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No product with this ID found!\nPlease use Product Name");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e); 
        }
    }//GEN-LAST:event_pidBtnActionPerformed

    private void billBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billBtnActionPerformed
        // TODO add your handling code here:
        try{
            if(sum <= 0)
                 JOptionPane.showMessageDialog(null,"Total amount of Bill must be more than ₹0 \n Add items to the bill");
            else if(custID == 0)
                JOptionPane.showMessageDialog(null,"Please add Customer details\n before generating Bill");
            else{
                update = "INSERT INTO retail_invoice (cid,eid,amount,date) VALUES (?,?,?,?);";
                pst = con.prepareStatement(update);
                pst.setString(1, Integer.toString(custID));
                pst.setString(2, Integer.toString(empID));
                pst.setString(3, Double.toString(sum));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(new java.util.Date());
                pst.setString(4, date);
                int status = pst.executeUpdate();
                
                update = "UPDATE customer SET reward_points = reward_points - "+ redeemableRewards +" WHERE cid = "+ custID +";";
                st.executeUpdate(update);
                
                if(status>0)
                    JOptionPane.showMessageDialog(rootPane, "Bill Generated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(rootPane, "Could not generate Bill", "Failed", JOptionPane.ERROR_MESSAGE);

                MessageFormat headerFormat = new MessageFormat("Invoice");
                MessageFormat footerFormat = new MessageFormat("PAY: ₹" + sum);
                jTable1.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
                new SalesPage(empID).setVisible(true);
                this.dispose();
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);  
        }
    }//GEN-LAST:event_billBtnActionPerformed

    private void custPhBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custPhBtnActionPerformed
        // TODO add your handling code here:
        String ph = custPhTxt.getText();
        query = "SELECT * FROM customer WHERE c_phone = '" + ph + "'";
        try{
            rs = st.executeQuery(query);
            rs.next();
            custID = rs.getInt("cid");
            rewardPoints = rs.getInt("reward_points");
            String cName = rs.getString("c_name");
            String addr = rs.getString("c_address");
            custDetailsTxt.setText(" Customer ID:\t" + custID + "\n\n Name:\t" + cName + "\n\n Address:\t" + addr );
            rewardLabel.setText(" REWARD POINTS Available:  " + rewardPoints);
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No customer found!\nPlease add new customer details");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
    }//GEN-LAST:event_custPhBtnActionPerformed

    private void addCustBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustBtnActionPerformed
        // TODO add your handling code here:
        new AddCustomer().setVisible(true);
    }//GEN-LAST:event_addCustBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        int[] selectedRows = jTable1.getSelectedRows();
        if (selectedRows.length > 0) {
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                 String qty = jTable1.getValueAt(selectedRows[i],3).toString();
                 String pid = jTable1.getValueAt(selectedRows[i],0).toString();
                 sum = sum - Double.parseDouble(jTable1.getValueAt(selectedRows[i],4).toString()); 
                 sumLabel.setText("₹" + Double.toString(sum));
                 update = "UPDATE product SET stock = stock + "+ qty +" WHERE pid = "+ pid +";";
                 try{
                 st.executeUpdate(update);
                 model.removeRow(selectedRows[i]);
                 }
                 catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                 }
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void redeemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redeemBtnActionPerformed
        // TODO add your handling code here:
        if(sum <= rewardPoints)
            redeemableRewards = (int)sum-1;
        else
            redeemableRewards = rewardPoints;
        rewardPoints -= redeemableRewards; 
        redemptionLabel.setText(" - " + redeemableRewards);
        sum = sum - redeemableRewards;
        sumLabel.setText("₹" + Double.toString(sum));
        rewardLabel.setText(" REWARD POINTS Available:  " + (rewardPoints ));
    }//GEN-LAST:event_redeemBtnActionPerformed

    
           

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accountPanel;
    private javax.swing.JButton addCustBtn;
    private javax.swing.JButton billBtn;
    private javax.swing.JPanel billPanel;
    private javax.swing.JTextArea custDetailsTxt;
    private javax.swing.JPanel custPanel;
    private javax.swing.JButton custPhBtn;
    private javax.swing.JTextField custPhTxt;
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
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JButton redeemBtn;
    private javax.swing.JLabel redemptionLabel;
    private javax.swing.JLabel rewardLabel;
    private javax.swing.JLabel sumLabel;
    // End of variables declaration//GEN-END:variables
}
