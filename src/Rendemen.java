/**
 * @(#)Rendemen.java
 *
 *
 * @author
 * @version 1.00 2010/4/16
 */

import java.util.Date;
import java.awt.Font;
import java.awt.Color;
import java.awt.List;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.LookAndFeel;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


public class Rendemen extends JFrame implements KeyListener{

	private JLabel lblF0;
	private JLabel lblF00;
	private JLabel lblF123;
	private JLabel lblF4;
	private JLabel lblF5;
	private JLabel lblBrd;

	protected static IntegerTextField F0;
    protected static IntegerTextField F00;
    protected static IntegerTextField F123;
    protected static IntegerTextField F4;
    protected static IntegerTextField F5;
    protected static IntegerTextField Brd;
    protected static JTextArea result;

    private JLabel lblPF0;
	private JLabel lblPF00;
	private JLabel lblPF123;
	private JLabel lblPF4;
	private JLabel lblPF5;
	private JLabel lblPBrd;

	private JLabel lblTitle;

	protected static IntegerTextField PF0;
    protected static IntegerTextField PF00;
    protected static IntegerTextField PF123;
    protected static IntegerTextField PF4;
    protected static IntegerTextField PF5;
    protected static IntegerTextField PBrd;

    private JButton btnHitung;
    private JButton btnClear;
    private JButton btnSimpan;
    private JButton btnUbah;

    protected static IntegerTextField tfWaktu;
    private JPanel pnlWaktu;
    private JPanel pnlFraksi;
    private JPanel pnlPotensi;

	String dgTanggal = null;
	String dgJam = null;
	String dgMenit = null;
	String dgDetik = null;
	Date dt = null;
	int tanggal;
	int hari;
	int bulan;
	int tahun;
	int jam;
	int menit;
	int detik;
	String []strHari = {"Minggu","Senin","Selasa","Rabu","Kamis","Jumat","Sabtu"};
	String []strBulan = {"Januari","Februari","Maret","April","Mei","Juni","Juli","Agustus","September","Oktober","November","Desember"};


    IntegerTextField txtUser = new IntegerTextField();
    JPasswordField txtPass = new JPasswordField();
    JLabel lblUser = new JLabel("Username");
    JLabel lblPass = new JLabel("Password");

    ImageIcon icon = new ImageIcon("Gambar/key.png");

    public Rendemen() {
       initComponents();
       setTheme();
       setPotensi();
       ThreadJam jam = new ThreadJam();
       jam.start();
    }

    private void initComponents() {
    	this.setTitle("Rendemen Teoritis v1.0");
    	setIconImage (getToolkit().getImage("icon.png"));
    	this.setResizable(false);
    	btnHitung = new JButton("Hitung");
    	btnClear = new JButton("Clear");
    	btnSimpan = new JButton("Simpan Data Potensi");
    	btnUbah = new JButton("Ubah Data Potensi");

    	lblF0 = new JLabel();
    	lblF00 = new JLabel();
    	lblF123 = new JLabel();
    	lblF4 = new JLabel();
    	lblF5 = new JLabel();
    	lblBrd = new JLabel();
    	F0 = new IntegerTextField();
    	F00 = new IntegerTextField();
    	F123 = new IntegerTextField();
    	F4 = new IntegerTextField();
    	F5 = new IntegerTextField();
    	Brd = new IntegerTextField();
    	result = new JTextArea();

    	lblPF0 = new JLabel();
    	lblPF00 = new JLabel();
    	lblPF123 = new JLabel();
    	lblPF4 = new JLabel();
    	lblPF5 = new JLabel();
    	lblPBrd = new JLabel();
    	lblTitle = new JLabel();
    	PF0 = new IntegerTextField();
    	PF00 = new IntegerTextField();
    	PF123 = new IntegerTextField();
    	PF4 = new IntegerTextField();
    	PF5 = new IntegerTextField();
    	PBrd = new IntegerTextField();

        tfWaktu = new IntegerTextField();
        pnlWaktu = new JPanel();
        pnlFraksi = new JPanel();
        pnlPotensi = new JPanel();

        result.setFont(new Font("Dialog",0,18));

		/*tfNoPonsel.setFont(new Font("Dialog",0,14));
		tfNoPonsel.setEditable(false);
        btnStop.setEnabled(false);*/

        getContentPane().setLayout(null);

        //start panel waktu
		pnlWaktu.setLayout(null);
		pnlWaktu.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 0, 11), new Color(125, 125, 125)));

        lblTitle.setText("RENDEMEN TEORITIS");
        lblTitle.setFont(new Font("Dialog",0,18));
        pnlWaktu.add(lblTitle);
        pnlWaktu.add(tfWaktu);

		lblTitle.setBounds(17, 15, 250, 20);

        tfWaktu.setBackground(this.getBackground());
        tfWaktu.setForeground(Color.gray);
        tfWaktu.setBorder(null);
        tfWaktu.setBounds(220, 15, 250, 20);
        tfWaktu.setHorizontalAlignment(SwingConstants.RIGHT);
        tfWaktu.setFont(new Font("Dialog",0,14));
		getContentPane().add(pnlWaktu);
		pnlWaktu.setBounds(10, 10, 485, 45);
		//end panel waktu

		//start panel fraksi
        pnlFraksi.setLayout(null);
        pnlFraksi.setBorder(BorderFactory.createTitledBorder(null, "TBS per Fraksi (Kg)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 0, 11), new Color(125, 125, 125)));
        lblF0.setText("F0");
        lblF00.setText("F00");
        lblF123.setText("F123");
        lblF4.setText("F4");
        lblF5.setText("F5");
        lblBrd.setText("Brondolan");
        pnlFraksi.add(lblF0);
        pnlFraksi.add(lblF00);
        pnlFraksi.add(lblF123);
        pnlFraksi.add(lblF4);
        pnlFraksi.add(lblF5);
        pnlFraksi.add(lblBrd);

        lblF0.setBounds(20, 15, 30, 25);
        lblF00.setBounds(95, 15, 30, 25);
        lblF123.setBounds(170, 15, 30, 25);
        lblF4.setBounds(245, 15, 30, 25);
        lblF5.setBounds(320, 15, 30, 25);
        lblBrd.setBounds(395, 15, 60, 25);
        //lblNoPonsel.setBounds(10, 25, 80, 25);

        pnlFraksi.add(F0);
        pnlFraksi.add(F00);
        pnlFraksi.add(F123);
        pnlFraksi.add(F4);
        pnlFraksi.add(F5);
        pnlFraksi.add(Brd);
        F0.setBounds(20, 35, 70, 25);
        F00.setBounds(95, 35, 70, 25);
        F123.setBounds(170, 35, 70, 25);
        F4.setBounds(245, 35, 70, 25);
        F5.setBounds(320, 35, 70, 25);
        Brd.setBounds(395, 35, 70, 25);
        //tfNoPonsel.setBounds(56, 25, 215, 25);

        pnlFraksi.add(btnHitung);
        btnHitung.setBounds(20, 70, 70, 35);

        pnlFraksi.add(btnClear);
        btnClear.setBounds(20, 108, 70, 35);

        //result.setColumns(20);
        //result.setRows(5);
        pnlFraksi.add(result);
        result.setBounds(99, 70, 365, 72);

        getContentPane().add(pnlFraksi);
        pnlFraksi.setBounds(10, 60, 485, 155);
		//end panel fraksi

		//start panel potensi
		pnlPotensi.setLayout(null);
        pnlPotensi.setBorder(BorderFactory.createTitledBorder(null, "Potensi Fraksi (%)", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 0, 11), new Color(125, 125, 125)));

		lblPF0.setText("F0");
        lblPF00.setText("F00");
        lblPF123.setText("F123");
        lblPF4.setText("F4");
        lblPF5.setText("F5");
        lblPBrd.setText("Brondolan");
        pnlPotensi.add(lblPF0);
        pnlPotensi.add(lblPF00);
        pnlPotensi.add(lblPF123);
        pnlPotensi.add(lblPF4);
        pnlPotensi.add(lblPF5);
        pnlPotensi.add(lblPBrd);
        lblPF0.setBounds(20, 15, 30, 25);
        lblPF00.setBounds(95, 15, 30, 25);
        lblPF123.setBounds(170, 15, 30, 25);
        lblPF4.setBounds(245, 15, 30, 25);
        lblPF5.setBounds(320, 15, 30, 25);
        lblPBrd.setBounds(395, 15, 60, 25);

        pnlPotensi.add(PF0);
        pnlPotensi.add(PF00);
        pnlPotensi.add(PF123);
        pnlPotensi.add(PF4);
        pnlPotensi.add(PF5);
        pnlPotensi.add(PBrd);
        PF0.setBounds(20, 35, 70, 25);
        PF00.setBounds(95, 35, 70, 25);
        PF123.setBounds(170, 35, 70, 25);
        PF4.setBounds(245, 35, 70, 25);
        PF5.setBounds(320, 35, 70, 25);
        PBrd.setBounds(395, 35, 70, 25);

        getContentPane().add(pnlPotensi);
        pnlPotensi.setBounds(10, 220, 485, 120);
        //end panel potensi


        btnHitung.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               	hitung(evt);
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               	clear(evt);
            }
        });

        btnSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                simpan(evt);
            }
        });

        btnUbah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ubah(evt);
            }
        });

		try{
     		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
  		}catch(Exception e) {
  		    System.out.println("Error setting native LAF: " + e);
  		}

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-702)/2, (screenSize.height-350)/2, 510, 380);
    }

    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            	//JOptionPane.showMessageDialog(this, "Stop server untuk keluar!");
            	System.exit(0);
        }
    }

  	public void Jam(){
		dt = new Date();
		tanggal = dt.getDate();
		hari = dt.getDay();
		bulan = dt.getMonth();
		tahun  = dt.getYear() + 1900;
		jam = dt.getHours();
		menit = dt.getMinutes();
		detik = dt.getSeconds();

		if(tanggal <= 9)dgTanggal = "0";
		else dgTanggal = "";

		if(jam <= 9) dgJam = "0";
		else dgJam = "";

		if(menit <= 9) dgMenit = "0";
		else dgMenit = "";

		if(detik <= 9) dgDetik = "0";
		else dgDetik = "";

		tfWaktu.setText("" +strHari[hari] +", " +dgTanggal +tanggal +" " +strBulan[bulan] +" "
			+tahun +"  |  " +dgJam +jam +":" +dgMenit +menit +":" +dgDetik +detik);
	}

	public static String getWaktu(){
		return tfWaktu.getText();
    }

    private void setPotensi() {
    	Setting set = new Setting();
    	PF0.setText(set.getF0());
    	PF00.setText(set.getF00());
    	PF123.setText(set.getF123());
    	PF4.setText(set.getF4());
    	PF5.setText(set.getF5());
    	PBrd.setText(set.getBrd());

    	PF0.setEditable(false);
    	PF00.setEditable(false);
    	PF123.setEditable(false);
    	PF4.setEditable(false);
    	PF5.setEditable(false);
    	PBrd.setEditable(false);


    	pnlPotensi.add(btnUbah);
        btnUbah.setBounds(20, 70, 140, 35);

        result.setEditable(false);
    }

    private void ubah(ActionEvent evt) {
    	PF0.setEditable(true);
    	PF00.setEditable(true);
    	PF123.setEditable(true);
    	PF4.setEditable(true);
    	PF5.setEditable(true);
    	PBrd.setEditable(true);

    	pnlPotensi.remove(btnUbah);
    	pnlPotensi.add(btnSimpan);
        btnSimpan.setBounds(20, 70, 140, 35);

        btnHitung.setEnabled(false);

    }

    private void simpan(ActionEvent evt) {
    	PF0.setEditable(false);
    	PF00.setEditable(false);
    	PF123.setEditable(false);
    	PF4.setEditable(false);
    	PF5.setEditable(false);
    	PBrd.setEditable(false);

    	pnlPotensi.remove(btnSimpan);
    	pnlPotensi.add(btnUbah);
        btnUbah.setBounds(20, 70, 140, 35);

        String a = PF0.getText();
        String b = PF00.getText();
        String c = PF123.getText();
        String d = PF4.getText();
        String e = PF5.getText();
        String f = PBrd.getText();

        Save save = new Save(a,b,c,d,e,f);
        btnHitung.setEnabled(true);
    }

    private void clear(ActionEvent evt) {
		F0.setText("");
		F00.setText("");
		F123.setText("");
		F4.setText("");
		F5.setText("");
		Brd.setText("");
		result.setText("");
    }

    private void hitung(ActionEvent evt) {
    	if(cekData()){
    		//if(PF0.getText())
			double numF0 = Double.parseDouble(F0.getText());
			double numF00 = Double.parseDouble(F00.getText());
			double numF123 = Double.parseDouble(F123.getText());
			double numF4 = Double.parseDouble(F4.getText());
			double numF5 = Double.parseDouble(F5.getText());
			double numBrd = Double.parseDouble(Brd.getText());

			double numPF0 = Double.parseDouble(PF0.getText());
			double numPF00 = Double.parseDouble(PF00.getText());
			double numPF123 = Double.parseDouble(PF123.getText());
			double numPF4 = Double.parseDouble(PF4.getText());
			double numPF5 = Double.parseDouble(PF5.getText());
			double numPBrd = Double.parseDouble(PBrd.getText());

			double mF0 = numF0 * numPF0 / 100;
			double mF00 = numF00 * numPF00 / 100;
			double mF123 = numF123 * numPF123 / 100;
			double mF4 = numF4 * numPF4 / 100;
			double mF5 = numF5 * numPF5 / 100;
			double mBrd = numBrd * numPBrd / 100;

			double total_tbs = numF0 + numF00 + numF123 + numF4 + numF5 + numBrd;
			double total_ms = mF0 + mF00 + mF123 + mF4 + mF5 + mBrd;
			total_tbs = Math.round(total_tbs * 100.0) / 100.0;
			total_ms = Math.round(total_ms * 100.0) / 100.0;

			String strFormat ="#,###.00";
			DecimalFormat df = new DecimalFormat(strFormat, new DecimalFormatSymbols(Locale.GERMAN));

			try{
				double res = (total_ms / total_tbs) * 100;
				res = Math.round(res * 100.0) / 100.0;
				String strTBS = df.format(total_tbs);
				String strMS = df.format(total_ms);
				String strBRD = df.format(res);
				String toTextArea = "";
				toTextArea += " TBS    = " +strTBS +"\r\n";
				toTextArea += " MS     = " +strMS +"\r\n";
				toTextArea += " Rend. = " +strBRD +"\r\n";
				result.setText(toTextArea);
			}catch(Exception e){
				JOptionPane.showMessageDialog(this, e,"Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}else{
				JOptionPane.showMessageDialog(this, "Silahkan Lengkapi Inputan Fraksi","Error", JOptionPane.INFORMATION_MESSAGE);
		}
    }

    private boolean cekData(){
    	boolean status = true;
    	if(F0.getText().trim().equals( "" ) || F00.getText().trim().equals( "" ) || F123.getText().trim().equals( "" ) || F4.getText().trim().equals( "" ) || F5.getText().trim().equals( "" ) || Brd.getText().trim().equals( "" )){
    		status = false;
    	}
    	if(PF0.getText().trim().equals( "" ) || PF00.getText().trim().equals( "" ) || PF123.getText().trim().equals( "" ) || PF4.getText().trim().equals( "" ) || PF5.getText().trim().equals( "" ) || PBrd.getText().trim().equals( "" )){
    		status = false;
    	}
    	return status;
    }



    private boolean verifikasi(){
    	txtUser.setText("");
    	txtPass.setText("");
    	boolean b = false;
    	int res = JOptionPane.showOptionDialog(null, new Object[] {lblUser, txtUser, lblPass, txtPass},
    	"Input Username dan Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, null, null);
    	return true;
    }

    class ThreadJam extends Thread{
		public ThreadJam(){}
		public void run(){
			while(true){
				Jam();
				try{
					Thread.sleep(1000);
				}catch(InterruptedException ie){}
			}
		}
	}

	public void keyReleased(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {
       char c = e.getKeyChar();
       if (!(Character.isDigit(c) ||
          (c == KeyEvent.VK_BACK_SPACE) ||
          (c == KeyEvent.VK_DELETE))) {
            e.consume();
          }

     }

	public static void setTheme(){
		 try{
	   		LookAndFeel lf = new com.jtattoo.plaf.acryl.AcrylLookAndFeel();
			UIManager.setLookAndFeel(lf);
	     }catch(Exception e) {
	    	System.out.println("Error : " + e);
         }
	}

	public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	setTheme();
			   	new Rendemen().setVisible(true);
            }
        });
    }
}
