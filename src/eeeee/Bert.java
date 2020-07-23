package eeeee;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.sun.javafx.geom.AreaOp.AddOp;
import com.sun.javafx.iio.ImageFrame;
import com.sun.javafx.scene.shape.PathUtils;

import javafx.scene.shape.Line;
import sun.awt.datatransfer.ClipboardTransferable;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;


@SuppressWarnings({ "serial", "unused" })
public class Bert {
	public static boolean TemaClaro = true;
	public static int AlturaDoASCII = 100;
	public static int LarguraDoASCII = 100;
	public static String Ascii = ""; //a ASCII já tá ocupada por outra string na subclasse frame
	static boolean TrocaValores (int QualDos5, int PraQualValor) {
		if(QualDos5 < 1||QualDos5 > 5 || PraQualValor < 0 || PraQualValor > 255) {return false;}
		switch (QualDos5) {
		case 1: Valor1 = PraQualValor;
		break;
		case 2: Valor2 = PraQualValor;
		break;
		case 3: Valor3 = PraQualValor;
		break;
		case 4: Valor4 = PraQualValor;
		break;
		case 5: Valor5 = PraQualValor;
		break;
		default: return false;}
		refresh();
		return true;
	}
	static int PegaValores (int QualDos5) {
		switch (QualDos5) {
		case 1:
			return Valor1;
			
		case 2:
			return Valor2;

		case 3:
			return Valor3;

		case 4:
			return Valor4;

		case 5:
			return Valor5;
		
		default:
			return -1;
			
		}
		
		
		
		
		
		
	}
	public static void ChangeHTML(String HTMLE) {
		HTML = HTMLE;
		
	}
	private static boolean eba = true;
	private static int Valor1 = 25;
	private static int Valor2 = 100;
	private static int Valor3 = 150;
	private static int Valor4 = 175;
	private static int Valor5 = 200;
	public static int TamanhoDaFonte = 10;
	public static String pathe;
	public static String HTML = "pain";
	
	
	
	
	
	
	public static void main(String args[]) throws FontFormatException, IOException {
		//código que lista as fontes disponives e manda pro user em forma de JOptionPane
		String fontes[]
		        = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

		/*for (int i = 0; i < fontes.length; i++) {
		    System.out.println(fontes[i]);
		}*/
		String eba = (String)JOptionPane.showInputDialog(null
				,"<html>Qual fonte você prefere que seja mostrada? <br/>(recomendo vc coloque uma que tem os caracteres de mesmo tamanho. <br/>recomendo usar a Consolas.)"
				,"escolhe uma fonte"
				,JOptionPane.QUESTION_MESSAGE
				, null
				,fontes
				,fontes[0]	);
		//FIXME essa merda ainda não tá saindo alinhada na janela, mas tá no console, MESMO COM A MESMA FUCKING FONTE
		//aparentemente na real oq acontece é que ele não tá trocando a fonte, o FIXME procede
		if (eba == null) {return;}
		
		//pronto vamo pro resto do código
		System.out.println(eba);
		JFrame frame = new ImageViewerFrame("",eba);
		frame.setTitle("cavalo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//JFrame frwame = new sliders.S1();
		//frwame.setVisible(true);
		
		
	}
	


	
	
	
		
		
		
	
	

	public static class ImageViewerFrame extends JFrame {
		
		JLabel label = new JLabel();
		JLabel ASCII = new JLabel();
		JFileChooser choos = new JFileChooser();
		JMenuBar bar = new JMenuBar();
		JMenu men = new JMenu();
		JMenuItem text = new JMenuItem("e");
		JMenuItem roll = new JMenuItem("Nudes do Bruno Berti");
		
		//@SuppressWarnings("unused")
		//TO/DO não esquece de tirar o supresswarnings (feito)
		//FIX/ME agora por algum motivo a janela resetou os parametros, eu vou me matar (fixed)
		//public ImageViewerFrame() throws FontFormatException, IOException{setSize(500, 500);new ImageViewerFrame("");}
		public ImageViewerFrame(String ASCIIDefault, String OMolho) throws FontFormatException, IOException{
			
			JLabel ebda = new JLabel(ASCIIDefault);
			Font cava = new Font(OMolho, NORMAL, TamanhoDaFonte);
			ebda.setFont(cava);
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int width = (int) screenSize.getWidth();
			int height = (int) screenSize.getHeight();
			//TODO: Fazer a janela se ajustar a tela excluindo a barra do windows
			//Basicamente o modo do quadradinho
			setSize(500, 500);
			//label.setMaximumSize(new Dimension(100, 100));
			//label.setMinimumSize(new Dimension(100, 100));
			//FIX/ME aparentemente, em vez de escalar, ele rejeita quaquer coisa que não segue esses parametros (fixed)
			add(label);
			
			add(ebda, JLabel.CENTER);
			
			choos.setCurrentDirectory(new File("."));

			
			
			men = new JMenu("Abrir");
			JMenu avan = new JMenu("Configs");
			JMenuItem fontsize = new JMenuItem("Ajustar tamanho do texto");
			JMenuItem configsavancadas = new JMenuItem("Configurar valores de saturação");
			JMenuItem Tamanho = new JMenuItem("Configurar tamanho do ASCII");
			avan.add(Tamanho);
			avan.add(configsavancadas);
			avan.add(fontsize);
			//então basicamente a JMenuBar é toda a parte de cima, enquando o JMenu é só um menu que eu tenho que colocar na abarra
			//coloca na ordem certa filho da puta
			setJMenuBar(bar);
			bar.add(men);
			bar.add(avan);
			
			JButton refreshe = new JButton("Recarregar");
			JMenu salvar = new JMenu("Salvar");
			JMenuItem eba = new JMenuItem("Transformar uma imagem em ASCII");
			men.add(eba)/*.setFont(Font.createFont(1,new File(".\\src/eee/consola.ttf")))*/;;
			
			JMenuItem Salvarpontpontoponto = new JMenuItem("Salvar...");
			salvar.add(Salvarpontpontoponto);
			JMenuItem exportarrapid = new JMenuItem("Exportar rapidamente para a área de trabalho");
			salvar.add(exportarrapid);
			JMenuItem CtrlC = new JMenuItem("Colocar o texto no seu CTRL + C");
			salvar.add(CtrlC);
			bar.add(salvar);
			CtrlC.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
				Clipboard x = Toolkit.getDefaultToolkit().getSystemClipboard();
				String text = Ascii;
				StringSelection selection = new StringSelection(text); x.setContents(selection, null);
				
				}});
			bar.add(refreshe, JMenuBar.RIGHT_ALIGNMENT);
			exportarrapid.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
					try {
						SaveToPath(System.getProperty("user.home") + "/Desktop"  + "/ASCII", Ascii);
						JOptionPane.showMessageDialog(null, "O Arquivo foi salvo como \"ASCII.txt\" na sua área de trabalho :)");
					} catch (IOException e1) {e1.printStackTrace();}}});
			refreshe.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					try {ImageViewerFrame ee = new ImageViewerFrame(HTML, OMolho);ee.setVisible(true);} catch (FontFormatException | IOException e1) 
					{e1.printStackTrace();} //bArrA BaRra ToDo, aUtoMatEdE cAtCxE bLoQ
					dispose();
					
				}
			});
			configsavancadas.addActionListener(new ActionListener() {
					
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame frwame = new sliders.S1();
					JFrame frw2me = new sliders.S2();
					JFrame frw3me = new sliders.S3();
					JFrame frw4me = new sliders.S4();
					JFrame frw5me = new sliders.S5();
					frwame.setVisible(true);
					frw2me.setVisible(true);
					frw3me.setVisible(true);
					frw4me.setVisible(true);
					frw5me.setVisible(true);

					
				}
			});
			eba.addActionListener(new ActionListener() {
					
				@Override
				public void actionPerformed(ActionEvent e) {
					
					int result = choos.showOpenDialog(null);
					String end = "cavalo";
					if (result == JFileChooser.APPROVE_OPTION) {
						pathe = choos.getSelectedFile().getPath();
						String eeeeee = null;
						try {eeeeee = ASCIIeer(Paths.get(choos.getSelectedFile().getPath()));
						} catch (IOException mamada) {mamada.printStackTrace();}
						choos.setSelectedFile(null);
						String[] eee = eeeeee.split(System.getProperty("line.separator"));
						ConvertToHTML(eee);
						
						}
						
						setVisible(false);
						try {ImageViewerFrame ee = new ImageViewerFrame(HTML, OMolho);ee.setVisible(true);} catch (FontFormatException | IOException e1) 
						{e1.printStackTrace();} //bArrA BaRra ToDo, aUtoMatEdE cAtCxE bLoQ
						dispose();
						//FIX/ME MANO PQ SAI NORMAL NO CONSOLE E AMASSADO NA JANELA PUTA MERDA É A FUCKING MESMA STRING (era problema de fonte, fixed)
						//
						//ok, TO/DO: sistema de listagem de fontes disponiveis pra quando o usuário inicializar o programa (feito)
						 
						
					}
					
				}
			);
			Tamanho.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
					String LRG = JOptionPane.showInputDialog("Qual a largura que vc quer?");
					String ALT =JOptionPane.showInputDialog("Qual a altura que vc quer?");
					LarguraDoASCII = Integer.parseInt(LRG);
					AlturaDoASCII = Integer.parseInt(ALT);
					refresh();//FIX/ME na troca de tamanho de ASCII ele não dá refresh (fixed)
					setVisible(false);
					try {ImageViewerFrame ee = new ImageViewerFrame(HTML, OMolho);ee.setVisible(true);} catch (FontFormatException | IOException e1) 
					{e1.printStackTrace();} 
					dispose();
				}
			});
			avan.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame u1 = new sliders.S1();
					JFrame u2 = new sliders.S2();
					JFrame u3 = new sliders.S3();
					JFrame u4 = new sliders.S4();
					JFrame u5 = new sliders.S5();

				}
			});
			JButton ex = new JButton("Fundo escuro");
			bar.add(ex);
			JButton xe = new JButton("Fundo claro");
			bar.add(xe);
			ex.setEnabled(TemaClaro);
			xe.setEnabled(!TemaClaro);
			ex.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
				ex.setEnabled(false);xe.setEnabled(true);
				TemaClaro = false;
				refresh();
				setVisible(false);
				try {ImageViewerFrame ee = new ImageViewerFrame(HTML, OMolho);ee.setVisible(true);} catch (FontFormatException | IOException e1) 
				{e1.printStackTrace();} 
				dispose();
				
			}});
			xe.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
				xe.setEnabled(false);ex.setEnabled(true);
				TemaClaro = true;
				refresh();
				setVisible(false);
				try {ImageViewerFrame ee = new ImageViewerFrame(HTML, OMolho);ee.setVisible(true);} catch (FontFormatException | IOException e1) 
				{e1.printStackTrace();} 
				dispose();
			}});
			Salvarpontpontoponto.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo TXT", "txt");
					choos.addChoosableFileFilter(filter);
					choos.setAcceptAllFileFilterUsed(false);
					choos.showSaveDialog(null);
					choos.removeChoosableFileFilter(filter);
					//;;System.out.println(choos.getSelectedFile());
					//if (choos.file) {return;}
					try {if(!(choos.getSelectedFile() == null)) {
						SaveToPath(choos.getSelectedFile().getPath(), Ascii);}} catch (IOException e1) {e1.printStackTrace();}
					//o atalho é ctrl+m
					
					choos.setSelectedFile(null);
				}	
			});
			men.add(roll);
			roll.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 String url_open ="https://www.youtube.com/watch?v=dQw4w9WgXcQ";
				     try {
						java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				     Robot robot;
					try {
						robot = new Robot();
						robot.delay(5000); // 5 segundos
			            robot.keyPress(KeyEvent.VK_F); 
					} catch (AWTException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				     
				}
			});
		}
		
			
	}	
	//NOTE: não deixa os voids começando no final de outros voids, quando vc encolhe fica muito estranho
	
		public static String ASCIIeer (Path nudes) throws IOException {
		String suamãepelada = null;
		BufferedImage img = ImageIO.read(nudes.toFile());
		
		//como eu não consigo escalar diretamente, eu vou dividir os pixels por (altura), crio um for no qual 
		//a int tem que ser < que a imagem, e sempre acrescento a quantidade TamanhoDaImagem/(largura) em cada loop
		//depois disso eu arredondo a double atual e peço pra ele pegar a coordenada de pixel
		//e colocar o caractere equivalente,  5Head
		
		double alto = img.getHeight()/AlturaDoASCII;
		
		
		String ASCII = "";
		int PixLarg = 0;
		int PixAlt = 0;
		while (1 > 0) {
//				System.out.println(LarguraDoASCII);
//				System.out.println(AlturaDoASCII);
			double largo = img.getWidth()/LarguraDoASCII;
			int FileiraAtual =  (int) alto;
			if (FileiraAtual >= img.getHeight()) {System.out.println("break");break;}
			 while (1 > 0) {
				int LargAtual = (int) largo;
				PixLarg ++;
				if (LargAtual >= img.getWidth()) {ASCII = ASCII + System.getProperty("line.separator");break;}
				
				//System.out.println("analisando pixel " + LargAtual + "(largura) e " + FileiraAtual +"altura");
				ASCII = ASCII + ASCII(img.getRGB(LargAtual, FileiraAtual), Valor1, Valor2, Valor3, Valor4, Valor5);
				
				largo = largo + img.getWidth()/LarguraDoASCII;
				
				
			}
			PixAlt ++;
			//System.out.println("já renderizei " + PixLarg + " pixeis  e " + PixAlt + " fileiras");
			alto = alto + img.getHeight()/AlturaDoASCII;
		}
		System.out.println(ASCII);
		
		//JFrame freim =  new ASCIIViewer(ASCII);
		//freim.setVisible(true);
		Ascii =  ASCII;
		return ASCII;
	} public static String ASCII (int RGBVALUE, int PERF1, int PERF2, int PERF3, int PERF4, int PERF5) {
									//padrões:		25			100		150			175			200   (o que sobra é o @)
									//TO/DO resizeable ASCII (feito)
		Color c = new Color(RGBVALUE);
		int alpha = c.getAlpha();
		
		int R = c.getRed();
		int G = c.getGreen();
		int B = c.getBlue();
		
		
		//basicamente eu vou calcular uma média entre os valores RGB e vou criar uns retornos a partir disso
		double MEDIA = R + G + B;
		MEDIA = MEDIA/3;
			if (!TemaClaro) {
		if (MEDIA >= 0 && MEDIA < PERF1) {return "..";} // P1
		if (MEDIA >= PERF1 && MEDIA < PERF2){return "--";} // P2
		else if (MEDIA >= PERF2 && MEDIA < PERF3){return "[]";} // P3
		else if (MEDIA >= PERF3 && MEDIA < PERF4){return "||";} //P4
		else if (MEDIA >= PERF4 && MEDIA < PERF5){return "##";} //P5
		else {return "@@";}}
			else {
				if (MEDIA >= 0 && MEDIA < PERF1) {return "@@";} // P1
				if (MEDIA >= PERF1 && MEDIA < PERF2){return "##";} // P2
				else if (MEDIA >= PERF2 && MEDIA < PERF3){return "||";} // P3
				else if (MEDIA >= PERF3 && MEDIA < PERF4){return "[]";} //P4
				else if (MEDIA >= PERF4 && MEDIA < PERF5){return "--";}
				else {return "..";}}//P5
			} //nham nham spaguete
			
		
		
		//TODO otimizar o programa para switch statements
		//TO/DO fazer com que os switches causem refresh imediato no painel (feito)
		//TO/DO aumentar o nivel dos valores RGB (feito)
		//TO/DO seletor de tema (feito)
		//TODO outros modos de salvamento além do menuzin
	
	public static void ConvertToHTML (String[] eee) {
		String end = "";
		for (int cocó = eee.length - 1; cocó >= 0; cocó--) {
			//esse negócio basicamente converte as coisas em um texto HTML
			//pro swing fazer o split de linha certo e não ficar aquela
			//aberração da natureza
			//vai ficar tipo assim: <html>Primeiralinha <br/>segundalinha
			
			if ((eee.length - 1) == cocó )
			{end = "<html>" + eee[cocó];} else 
			{end = end + "<br/>" + eee[cocó];}
			
			}
		ChangeHTML(end);
	}
	public static void SaveToPath(String path, String WhatDoIWrite) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path + ".txt")));
	    writer.append(WhatDoIWrite);
		writer.close();
		
		
	}
	public static void refresh () {if (!Ascii.equals("")){try {ASCIIeer(Paths.get(pathe) );ConvertToHTML(Ascii
	.split(System.getProperty("line.separator")));} catch (IOException cu) {cu.printStackTrace();};return;}}
	//TODO desfazer essa desgraça
	//eu gostei do .split separado sei lá o pq
}

