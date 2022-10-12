import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class MAIN extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Launch the frame
	 */
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		CreateXMLFile.main();
		GetGrades.results();
		
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("unused")
			public void run() {
				try {
					MAIN frame = new MAIN();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 * @return 
	 */
	
	public MAIN() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblminGrade = new JLabel("min grade is: " + GetGrades.minGrade);
		lblminGrade.setBounds(64, 80, 200, 16);
		contentPane.add(lblminGrade);
		
		JLabel lblmaxGrade = new JLabel("max grade is: " + GetGrades.maxGrade);
		lblmaxGrade.setBounds(64, 100, 200, 16);
		contentPane.add(lblmaxGrade);
		
		JLabel lblavgGrade = new JLabel("avg grade is: " + GetGrades.avgGrade);
		lblavgGrade.setBounds(64, 120, 200, 16);
		contentPane.add(lblavgGrade);
		
	}
}
