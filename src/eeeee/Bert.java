package eeeee;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.sun.javafx.geom.AreaOp.AddOp;
import com.sun.javafx.iio.ImageFrame;
import com.sun.javafx.scene.shape.PathUtils;

import javafx.scene.shape.Line;

import java.awt.*;


@SuppressWarnings({ "serial", "unused" })
public class Bert {
	
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
	public static void ChangeHTML(String HTMLE) {
		HTML = HTMLE;
		
	}
	private static boolean eba = true;
	private static int Valor1 = 25;
	private static int Valor2 = 100;
	private static int Valor3 = 150;
	private static int Valor4 = 175;
	private static int Valor5 = 200;
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
				,"<html>Qual fonte você prefere que seja mostrada? <br/>(recomendo vc coloque uma que tem os caracteres de mesmo tamanho)"
				,"escolhe uma fonte"
				,JOptionPane.QUESTION_MESSAGE
				, null
				,fontes
				,fontes[0]	);
		//FIXME essa merda ainda não tá saindo alinhada na janela, mas tá no console, MESMO COM A MESMA FUCKING FONTE
		if (eba == null) {return;}
		
		//pronto vamo pro resto do código
		System.out.println(eba);
		Font eee = Font.getFont(eba);
		JFrame frame = new ImageViewerFrame("",eee);
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
		
		
		@SuppressWarnings("unused")
		//TODO não esquece de tirar o supresswarnings
		//FIXME agora por algum motivo a janela resetou os parametros, eu vou me matar
		//public ImageViewerFrame() throws FontFormatException, IOException{setSize(500, 500);new ImageViewerFrame("");}
		public ImageViewerFrame(String ASCIIDefault, Font OMolho) throws FontFormatException, IOException{
			JLabel ebda = new JLabel(ASCIIDefault);
			ebda.setFont(OMolho);
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
			JMenu avan = new JMenu("Configs avançadas");
			JMenuItem configsavancadas = new JMenuItem("Configurar valores de saturação");
			avan.add(configsavancadas);
			//então basicamente a JMenuBar é toda a parte de cima, enquando o JMenu é só um menu que eu tenho que colocar na abarra
			//coloca na ordem certa filho da puta
			setJMenuBar(bar);
			bar.add(men);
			bar.add(avan);
			JMenuItem eba = new JMenuItem("Transformar uma imagem em ASCII");
			men.add(eba)/*.setFont(Font.createFont(1,new File(".\\src/eee/consola.ttf")))*/;;
			
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
						
						String[] eee = eeeeee.split(System.getProperty("line.separator"));
						ConvertToHTML(eee);
						
						}
						System.out.println('1');
						setVisible(false);
						try {ImageViewerFrame ee = new ImageViewerFrame(HTML, OMolho);ee.setVisible(true);} catch (FontFormatException | IOException e1) 
						{e1.printStackTrace();} //bArrA BaRra ToDo, aUtoMatEdE cAtCxE bLoQ
						dispose();
						//FIXME MANO PQ SAI NORMAL NO CONSOLE E AMASSADO NA JANELA PUTA MERDA É A FUCKING MESMA STRING
						//ok, TODO: sistema de listagem de fontes disponiveis pra quando o usuário inicializar o programa
						 
						
					}
					
				}
			);
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
			
		}
		
			
	}		public static String ASCIIeer (Path nudes) throws IOException {
		String suamãepelada = null;
		BufferedImage img = ImageIO.read(nudes.toFile());
		
		//como eu não consigo escalar diretamente, eu vou dividir os pixels por 100, crio um for no qual 
		//a int tem que ser < que a imagem, e sempre acrescento a quantidade TamanhoDaImagem/100 em cada loop
		//depois disso eu arredondo a double atual e peço pra ele pegar a coordenada de pixel
		//e colocar o caractere equivalente,  5Head
		
		double alto = img.getHeight()/100;
		
		
		String ASCII = "";
		
		while (1 > 0) {
			
			double largo = img.getWidth()/100;
			int FileiraAtual =  (int) alto;
			if (FileiraAtual >= img.getHeight()) {System.out.println("break");break;}
			 while (1 > 0) {
				int LargAtual = (int) largo;
				
				if (LargAtual >= img.getWidth()) {ASCII = ASCII + System.getProperty("line.separator");break;}
				
				//System.out.println("analisando pixel " + LargAtual + " " + FileiraAtual);
				ASCII = ASCII + ASCII(img.getRGB(LargAtual, FileiraAtual), Valor1, Valor2, Valor3, Valor4, Valor5);
				
				largo = largo + img.getWidth()/100;
				
				
			}
			
			alto = alto + img.getHeight()/100;
		}
		System.out.println(ASCII);
		
		//JFrame freim =  new ASCIIViewer(ASCII);
		//freim.setVisible(true);
		Ascii =  ASCII;
		return ASCII;
	} public static String ASCII (int RGBVALUE, int PERF1, int PERF2, int PERF3, int PERF4, int PERF5) {
									//padrões:		25			100		150			175			200   (o que sobra é o @)
									//TODO resizeable ASCII
		Color c = new Color(RGBVALUE);
		int alpha = c.getAlpha();
		
		int R = c.getRed();
		int G = c.getGreen();
		int B = c.getBlue();
		
		
		//basicamente eu vou calcular uma média entre os valores RGB e o valor alpha e vou criar uns retornos a partir disso
		double MEDIA = R + G + B;
		MEDIA = MEDIA/3;
		if (MEDIA >= 0 && MEDIA < PERF1) {return "..";} // P1
		if (MEDIA >= PERF1 && MEDIA < PERF2){return "[]";} // P2
		else if (MEDIA >= PERF2 && MEDIA < PERF3){return "--";} // P3
		else if (MEDIA >= PERF3 && MEDIA < PERF4){return "||";} //P4
		else if (MEDIA >= PERF4 && MEDIA < PERF5){return "##";} //P5
		else {return "@@";}
		
		
		//TODO otimizar o programa para switch statements
		//TODO fazer com que os switches causem refresh imediato no painel
		//TO/DO aumentar o nivel dos valores RGB
	}
	
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
	
	public static void refresh () {try {ASCIIeer(Paths.get(pathe));ConvertToHTML(Ascii
	.split(System.getProperty("line.separator")));} catch (IOException cu) {cu.printStackTrace();};return;}
	//TODO desfazer essa desgraça
	//eu gostei do .split separado sei lá o pq
}

