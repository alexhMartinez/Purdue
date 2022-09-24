import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ChatBotDiscussionV1 {
	
	private static void printWithDelays(String data)
	        throws InterruptedException {
	    for (char ch:data.toCharArray()) {
	        System.out.print(ch);
	        TimeUnit.MILLISECONDS.sleep(75);
	    }
	    System.out.println();
	}
	
	static int[] locIndex(String strArr[][], String strKey) {
		int result[] = {-1};
		
		for(int i = 0; i < strArr.length; i++) {
			for(int j = 0; j < 1; j++) {
				if(strArr[i][j].toLowerCase().contains(strKey)) {
					result[0] = i;
					return result;
				}
			}
		}
		return result;
	}

	static String[][] chartInfo = {
		{"graph/chart","description","image"},
		{"Line Graph","Line charts, or line graphs, are powerful visual tools that illustrate trends in data over a period of time or a particular correlation. For example, one axis of the graph might represent a variable value, while the other axis often displays a timeline.","https://visme.co/blog/wp-content/uploads/2017/07/Line-Graphs-2.jpg"},
		{"Bar Graph","The simplest and and most straightforward way to compare various categories is the classic bar graph. The universally-recognized graph features a series of bars of varying lengths.","https://visme.co/blog/wp-content/uploads/2017/07/Bar-Graphs.jpg"},
		{"Pie Charts","Pie charts are the simplest and most efficient visual tool for comparing parts of a whole. For example, a pie chart can quickly and effectively compare various budget allocations, population segments or market-research question responses.","https://visme.co/blog/wp-content/uploads/2017/07/Pie-Charts.jpg"},
		{"Mosaic or Mekko Charts","Basic line, bar and pie charts are excellent tools for comparing one or two variables in few categories, but what happens when you need to compare multiple variables or multiple categories at the same time?","https://visme.co/blog/wp-content/uploads/2017/07/Mosaic-or-Mekko-Charts.jpg"},
		{"Population Pyramids","Market segments are often divided based on age and gender, and a population pyramid is an ideal visual representation of the two groups.","https://visme.co/blog/wp-content/uploads/2017/07/Marketing-Population-Pyramids.jpg"},
		{"Spider Charts","When a statistician needs to visually compare three or more quantitative variables, he or she might choose to use a radar chart, also known as a spider or star chart.","https://visme.co/blog/wp-content/uploads/2017/07/Spider-Charts.jpg"},
		{"Stock Charts","One of the most vital of all financial graphs, stock charts help investors track the markets to determine profits and loss, as well as make buying and selling decisions.","https://visme.co/blog/wp-content/uploads/2017/06/Business-and-Finance-Stock-Charts.jpg"},
		{"Flow Charts","Oftentimes in business – as well as other industries – a process must be diagrammed. A flow chart allows a process to be sequenced step-by-step, from beginning to end, for the purpose of analyzing, designing, documenting or managing it.","https://visme.co/blog/wp-content/uploads/2017/07/Flow-Charts.jpg"},
		{"Gantt Charts","Gantt charts are special types of bar graphs used to diagram projects and schedules. The use of colored bars of varying lengths reflect not only a project’s start and end dates, but also important events, tasks, milestones and their timeframes.","https://visme.co/blog/wp-content/uploads/2017/07/Gantt-Charts.jpg"},
		{"Control Charts","Also commonly known as a process-behavior chart, a control chart helps determine if a data set falls within a mean or predetermined control range.","https://visme.co/blog/wp-content/uploads/2017/07/Business-and-Finance-control-charts.jpg"},
		{"Waterfall Charts","Particularly useful in accounting and qualitative analysis, waterfall charts illustrate how an initial value is affected positively and negatively by various factors.","https://visme.co/blog/wp-content/uploads/2017/07/Business-and-Finance-Waterfall-charts.jpg"},
		{"Hierarchy Diagrams","Similar in appearance to a flow chart, a hierarchical diagram, also known as an organizational chart or an organigram, illustrates the structure of an organization, as well as the relationships within it.","https://visme.co/blog/wp-content/uploads/2017/07/Hierarchy-Diagrams.jpg"},
		{"Scatter Plots","Also known as a scattergram, the graph consists of two axes, each representing a set of data. For example, one axis might represent the numbers of miles driven by a vehicle, while the second axis displays the total gallons of gas used.","https://visme.co/blog/wp-content/uploads/2017/07/Engineering-and-Technology-Scatter-Plots.jpg"},
		{"Trellis Plots","Sometimes a statistician will need to compare more data sets than can be represented by a single graph. What if, for example, a graph needs to compare not only miles driven and gallons used, but also the number of gears and cylinders contained in each vehicle sample?","https://visme.co/blog/wp-content/uploads/2017/07/Engineering-and-technology-Trellis-Plots.jpg"},
		{"Function Plots","Mathematicians, engineers and statisticians often need to determine the value of an equation by graphing its result. The graph of a function is the set of all points whose coordinates satisfy the equation.  ","https://visme.co/blog/wp-content/uploads/2017/07/Function-Plots.jpg"},
		{"Binary Decision Diagrams","A binary decision is a choice between two alternatives, so a binary-decision diagram illustrates the path from one decision to another.","https://visme.co/blog/wp-content/uploads/2017/07/Binary-Decision-Diagrams.jpg"},
		{"Circuit Diagrams","Just as its name implies, a circuit diagram is a visual representation of an electrical circuit. Using simple shapes and images, the diagram illustrates the components and interconnections of a circuit, from start to finish.","https://visme.co/blog/wp-content/uploads/2017/07/Engineering-and-technology-Circuit-Diagrams.jpg"},
		{"Timelines","Possibly the most self-explanatory of data visualizations, a timeline tracks data over a time period. Significant dates and events are highlighted at the point at which they appear on a chronological scale. Timelines can be used alone or in conjunction with other visualizations.","https://visme.co/blog/wp-content/uploads/2017/07/Timelines.jpg"},
		{"Tree Diagrams","A form of hierarchical diagram, a genealogical tree illustrates the structure of a family. It can either begin with an ancestor, then diagram his or her descendants, their siblings, marriages and children, and so on.","https://visme.co/blog/wp-content/uploads/2017/07/History-Tree-Diagrams.jpg"},
		{"Sunburst Charts","A type of multi-level pie chart, a sunburst chart is used to illustrate hierarchical data using concentric circles. Each ring of the “sunburst” represents a level in the hierarchy, with the root node represented by the center circle, and the hierarchy moving outward.","https://visme.co/blog/wp-content/uploads/2017/07/History-Sunburst-Charts.jpg"},
		{"Line Graphs","If a timeline is a form of graph, then it only makes sense that historians often employ it in displaying other data. By plotting immigration levels against a timeline, the resulting histogram illustrates population trends over a century or longer with a basic line graph.","https://visme.co/blog/wp-content/uploads/2017/07/Line-Graphs.jpg"},
		{"Stacked Area Charts","Stacked area charts are frequently used to diagram changes of multiple variables across time. Multiple lines can be drawn, for example, to track the population changes of various states across time.","https://visme.co/blog/wp-content/uploads/2017/07/History-Stacked-Area-Charts.jpg"},
		{"Stacked Bar Graphs","When studying groups of people, it’s common to compare multiple variables at once. After all, it’s enormously more useful to examine racial backgrounds, ages and gender in addition to total population.","https://visme.co/blog/wp-content/uploads/2017/07/Political-Science-and-Sociology-Stacked-Bar-Graphs.jpg"},
		{"Trellis Bar Graphs","When presenting data with three variables, a designer might try and create a three-dimensional bar graph, but adding an additional axis can sometimes appear cluttered and unclear, especially in printed form.","https://visme.co/blog/wp-content/uploads/2017/07/Political-Science-and-Sociology-Trellis-Bar-Graphs.jpg"},
		{"Stacked Area Charts","Stacked area charts are ideal for comparing values that would normally require multiple line graphs. Each line represents a different category, and the area below each line is generally shaded a designated color so each data set can be easily compared.","https://visme.co/blog/wp-content/uploads/2017/07/Political-Science-and-Sociology-Stacked-Area-Charts.jpg"},
		{"Multi-level Pie Charts","All too often a designer finds him or herself with more sets of data than can be presented in a single standard graph. Fortunately, in the case of a pie chart, multiple layers of data can be presented without the need for multiple images or a trellis design.","https://visme.co/blog/wp-content/uploads/2017/07/Multi-level-Pie-Charts.jpg"},
		{"Venn Diagrams","The classic Venn diagram, also known as a logic diagram, illustrates all possible logical relationships between a designated collection of sets.","https://visme.co/blog/wp-content/uploads/2017/07/Venn-Diagrams.jpg"},
		{"Scattergrams","Scattergrams, also known as scatter plots, are graphs that show the relationship between two or more variables. The plots use mathematical coordinates to represent two variables of a data set.","https://visme.co/blog/wp-content/uploads/2017/07/Science-Scattergrams.jpg"},
		{"Trellis Line Graphs","Trellis graphs allow scientists to examine complex, multi-variable data sets, comparing a greater deal of information at once.","https://visme.co/blog/wp-content/uploads/2017/07/Science-Trellis-Line-graphs.jpg"},
		{"Pareto Charts","Sometimes a basic graph doesn’t display enough information to draw the necessary conclusion. A Pareto chart combines a bar graph with a line graph to illustrate not only categories’ individual values, but also the cumulative total of the entire set.","https://visme.co/blog/wp-content/uploads/2017/07/Pareto-Charts.jpg"},
		{"Radar Charts","A radar chart, also commonly referred to as a spider chart or a star chart, displays data sets consisting of three or more variables on a two-dimensional graphic. Each variable’s quantitative value is reflected across an axis that usually starts in the chart’s center point.","https://visme.co/blog/wp-content/uploads/2017/07/Science-Radar-Charts.jpg"},
		{"Spherical Contour Graphs","Plotting planetary conditions on a basic two-axis graph can pose a problem. The Earth, after all, is a sphere. Instead, data can be plotted on a three-axis field using variables of x, y and z. The resulting plot, if completed, will take the form of a sphere.","https://visme.co/blog/wp-content/uploads/2017/07/Science-Spherical-Contour-Graphs.jpg"},
		{"Multi-Line Graphs","Just as medical symptoms are rarely isolated, neither is the analysis of biometric data. After all, rarely does one statistic paint the entire medical picture.","https://visme.co/blog/wp-content/uploads/2017/07/Health-and-Wellness-Multi-Line-Graphs.jpg"},
		{"Stacked Bar Graphs","Stacked bar graphs aren’t useful only in illustrating parts of of a whole. They can also be used to display additional variables.","https://visme.co/blog/wp-content/uploads/2017/07/Health-and-Wellness-Stacked-Bar-Graphs.jpg"},
		{"Flow Charts","Following the proper process is probably more important in medicine than in any other field. After all, if the surgeon forgets a step, you might very well bleed to death while you sleep.","https://visme.co/blog/wp-content/uploads/2017/07/Flowcharts.jpg"},
		{"Pictograms","In a pictogram, or pictograph, images and symbols are used to illustrate data. For example, a basic pictogram might use an image of the sun to signify each fair-weather day in a month and a rain cloud to symbolize each stormy day.","https://visme.co/blog/wp-content/uploads/2017/07/Health-and-Wellness-Pictographs.jpg"},
		{"Anatomical Diagrams","Medical diagrams are often used to illustrate anatomy, treatments or disease pathology in order to explain treatments for patients and others without an extensive biomedical background.","https://visme.co/blog/wp-content/uploads/2017/07/Anatomical-Diagrams.jpg"},
		{"Multi-Pie Charts","Just as in the cases of multi-level pie graphs, stacked bar graphs and trellis plots, multi-pie graphs paint a more detailed portrait of the data set it illustrates.","https://visme.co/blog/wp-content/uploads/2017/07/Health-and-Wellness-Multi-Pie-Charts.jpg"},
		{"Scatter Plots","It can be difficult to graphically represent medical data sets that consist of hundreds -- or more -- patients, as is the case in most medical studies.","https://visme.co/blog/wp-content/uploads/2017/07/Health-and-Wellness-Scatter-Plots.jpg"},
		{"Contour Plots","Contour plots allow for the analysis of three variables in a two-dimensional format. Instead of plotting data along two main axes, the graph also presents a third value that is based on shading or color.","https://visme.co/blog/wp-content/uploads/2017/07/Meteorology-and-Environment-Contour-Plots.jpg"}
	};
	
	public static void main(String[] args) throws InterruptedException, IOException {
		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in);
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		String sl;
		
		printWithDelays("Hi there! I am your IT460 chatbot!");
		System.out.println();
		printWithDelays("What is your name?");
		String userName = myObj.nextLine();
		System.out.println();
		printWithDelays("Hi " + userName + "! It is a pleasure to meet you.  How are you doing today?");
		String userFeel = myObj.nextLine();
		String ufl = userFeel.toLowerCase();
		
		if((ufl.contains("no") || ufl.contains("meh") || ufl.contains("bad") || ufl.contains("could be")) &&
		   (ufl.contains("how about") || ufl.contains("how are"))) {
			System.out.println();
			printWithDelays("Im so sorry to hear. :/");
			printWithDelays("I am doing well though thank you for asking!");
			printWithDelays("I really do hope today gets better for you " + userName + ", and that I can assist you with todays discussion.");
			System.out.println();
		}
		else if((!ufl.contains("no") || !ufl.contains("meh") || !ufl.contains("bad") || !ufl.contains("could be")) &&
			   (ufl.contains("how about") || ufl.contains("how are"))) {
			System.out.println();
			printWithDelays("That is fantastic news " + userName + "!");
			printWithDelays("We have something in common, because I am also doing well! Thank you for asking! :)");
			System.out.println();
		}
		else if(ufl.contains("no") || ufl.contains("meh") || ufl.contains("bad") || ufl.contains("could be")) {
			System.out.println();
			printWithDelays("Im so sorry to hear. :/");
			printWithDelays("I really do hope today gets better for you " + userName + ", and that I can assist you with todays discussion.");
			System.out.println();
		}
		else {
			System.out.println();
			printWithDelays("That is fantastic news " + userName + "!");
			System.out.println();
		}
		
		printWithDelays("Now let me get started, and guide you through this weeks discussion.");
		printWithDelays("This week you want to first identify types of graphs available, and next get a description with some visualized context.");
		
		do {
			System.out.println();
			printWithDelays("Would you like to start with the first or second part of the discussion?");
			String start = myObj.nextLine();
			System.out.println();
			sl = start.toLowerCase();
			
			if(sl.contains("first") || sl.contains("1")) {
				i1++;
			}
			else if(sl.contains("second") || sl.contains("2")) {
				printWithDelays("I dont think this is a good starting point " + userName);
				System.out.println();
				printWithDelays("Maybe consider the sequence of events when to find the right visualization...");
			}
			else {
				printWithDelays("Hey " + userName +"! Thats not one of the parts this week! haha");
				printWithDelays("Im not sure which part '" + start + "' is...");
				System.out.println();
				printWithDelays("So that being said... lets try again!");
			}
		} while(i1 == 0);
				
		printWithDelays("The first step is to try and identify what you are trying to represent.");
		System.out.println();
		printWithDelays("Please see the decision tool that is about to open, so you can determine your optimal chart");
		System.out.println();

        URL decurl = new URL("https://extremepresentation.typepad.com/.a/6a00d8341bfd2e53ef01b7c7364672970b-pi");
        BufferedImage flowchart = ImageIO.read(decurl);
        printWithDelays("Loading image into frame...");
        JLabel label1 = new JLabel(new ImageIcon(flowchart));
        JFrame f1 = new JFrame();
        f1.getContentPane().add(label1);
        f1.pack();
        f1.setLocation(200, 200);
        f1.setVisible(true);
		
		do {
			System.out.println();
			printWithDelays("Type 'Done' when you know which visual you require");
			String next = myObj.nextLine();
			
			if(next.toLowerCase().contains("done")) {
				i2++;
			}
			else if(next.toLowerCase().contains("confus") || next.toLowerCase().contains("issue") || next.toLowerCase().contains("probl")) {
				System.out.println();
				printWithDelays("Well " + userName + ", regretfully I am just a simple chatbot.  You may need to see the professor.");
				System.out.println();
				printWithDelays("When you are ready.  Please:");
			}
			else {
				System.out.println();
				printWithDelays("It seems you are not truly ready...");
			}
		} while(i2 == 0);
		
		System.out.println();
		printWithDelays("Which chart did you select?");
		String chart = myObj.nextLine();
		System.out.println();
		
		//identify array index points for 
		int[] chartLookup = locIndex(chartInfo,chart.toLowerCase());
		int indexPoint = chartLookup[0];
		
		printWithDelays("Wow that is great choice " + userName + "!");
		System.out.println();
		printWithDelays("I have found this source from your instructor:");
		System.out.println("https://visme.co/blog/types-of-graphs/");
		System.out.println();
		printWithDelays("From my understanding of the website this is the best description:");
		System.out.println();
		printWithDelays("'" + chartInfo[indexPoint][1] + "'");
		
		do {
			System.out.println();
			printWithDelays("Would you like to see an image example of this graph?");
			String image = myObj.nextLine();
			String il = image.toLowerCase();
			System.out.println();
			
			if(il.contains("no") || il.contains("n")) {
				printWithDelays("Sounds good " + userName + "! Goodbye for now, and see you later!");
				i3++;
			}
			else if(il.contains("yes") || il.contains("y")) {
				String urlpath = chartInfo[indexPoint][2];
				
				String path = urlpath;
                URL url = new URL(path);
                BufferedImage img = ImageIO.read(url);
                printWithDelays("Loading image into frame...");
                JLabel label2 = new JLabel(new ImageIcon(img));
                JFrame f2 = new JFrame();
                f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f2.getContentPane().add(label2);
                f2.pack();
                f2.setLocation(200, 200);
                f2.setVisible(true);
                
                System.out.println();
                printWithDelays("I hope you like the visualization " + userName + "! Goodbye for now, and see you later!");
				i3++;
			}
			else {
				printWithDelays("Im not sure what you mean...");
			}
		} while(i3 == 0);
		
	}
}