package fr.formation.interfaceGr;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Ihmjeux extends JFrame implements ActionListener {
	private static final long serialVersionUID = -7694254543570004724L;
	/*
	 * private IService iService; private IServiceAdresse iServiceAdresse;
	 * private JTable tableau; private JTable tableauAdresse;
	 */
	private JTable tableau;
	JButton rejoue = null;
	JButton submit = null;
	JButton efface = null;

	ImageIcon imgVERT = new ImageIcon("images/vert.gif");
	ImageIcon imgBLEU = new ImageIcon("images/bleu.gif");
	ImageIcon imgROUGE = new ImageIcon("images/rouge.gif");

	JLabel labelVERT = new JLabel(imgVERT);
	JLabel labelBLEU = new JLabel(imgBLEU);
	JLabel labelROUGE = new JLabel(imgROUGE);

	JLabel[] cases;
	JLabel label1 = null;
	JLabel label2 = null;
	JLabel label3 = null;

	JPanel jPanelContaint = new JPanel();
	JPanel jPanelChemp = new JPanel();
	JPanel jPanel = null;
	JPanel jPanelDesPanel = null;
	JPanel jPanelBoule = null;

	public Ihmjeux() {
		super();
		initialize();
	}
	// permet d'affiche la permier fenetre
	public void initialize() {
		// titre de la fenetre et permission de le ferme
		setTitle("Gestion des Utilisateur");
		taille(500, 500);
		tableau = new JTable(10, 3);
		// jPanelChemp.setLayout(new GridLayout(10,7));
		cases = new JLabel[2];
		// jPanelChemp.add(cases);
		/* JScrollPane js = new JScrollPane(tableau); */
		jPanelDesPanel = new JPanel(new GridLayout(10, 6));
		for (int i = 0; i < 30; i++) {
			JLabel etiquette = new JLabel(imgVERT);
			etiquette.setHorizontalTextPosition(JLabel.CENTER);
			etiquette.setVerticalTextPosition(JLabel.BOTTOM);
			jPanelDesPanel.add(etiquette);
		}
		jPanelContaint.add(jPanelDesPanel,BorderLayout.CENTER);
		jPanelContaint.add(jPanelChemp, BorderLayout.CENTER);
		jPanel = new JPanel();
		jPanelBoule = new JPanel();
		// les button que l_utilisateur utilise
		rejoue = new JButton("Rejoue");
		rejoue.addActionListener(this);
		jPanel.add(rejoue);

		efface = new JButton("Efface");
		efface.addActionListener(this);
		jPanel.add(efface);
		submit = new JButton("Submit");
		submit.addActionListener(this);
		jPanel.add(submit);
		// JLabel label = new JLabel(imgAjouter); // probably an ImageIcon
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		// image vert
		labelVERT.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				System.out.println("image vert");
			}
		});
		// image bleu
		labelBLEU.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				System.out.println("image bleu");
			}
		});
		// image rouge
		labelROUGE.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				System.out.println("image rouge");
			}

		});
		jPanelBoule.add(labelVERT);
		jPanelBoule.add(labelBLEU);
		jPanelBoule.add(labelROUGE);
		jPanelContaint.add(jPanelBoule, BorderLayout.NORTH);
		jPanelContaint.add(jPanel, BorderLayout.NORTH);
		getContentPane().add(jPanelContaint);
	}
	Long idUtilisateur = null;
	Long idAdresse = null;

	// methode permet de gere les action sur les Button
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		if (s == rejoue) {
			System.out.println(" rejoue ");
		} else if (s == efface) {
			System.out.println(" efface ");
		} else if (s == submit) {
			System.out.println(" submit ");
		}
	}
	// methode permet d'affiche l'interface au milieu de l'ecran
	public void taille(int Vwidth, int Vheight) {
		int width = Vwidth;
		int height = Vheight;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		setBounds(x, y, width, height);
		setSize(width, height);
	}
}
