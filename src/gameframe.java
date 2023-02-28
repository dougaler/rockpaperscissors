import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class gameframe extends JFrame
{
    Random rnd = new Random();
    JPanel mainPnl;
    JPanel iconPnl;
    JPanel displayPnl;
    JPanel controlPnl;
    JTextArea displayTA;
    JTextArea displayWins;
    JTextArea displayLosses;
    JTextArea displayTies;
    JTextArea displayTotal;
    JScrollPane scroller;
    JLabel titleLbl;
    ImageIcon icon;
    JButton rockBtn;
    JButton scissorsBtn;
    JButton paperBtn;
    JButton quitBtn;
    String printResult;
    thegame tisAResult = new thegame();

    /**
     *  Method to provide layout for the java swing
     */
    public gameframe()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createIconPanel();
        mainPnl.add(iconPnl, BorderLayout.NORTH);

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.CENTER);

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.SOUTH);

        add(mainPnl);
        setSize(600, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    /**
     *  Method to create the layout for the specific Top Label panel for the swing program
     */
    private void createIconPanel()
    {
        iconPnl = new JPanel();
        icon = new ImageIcon("src/fortuneteller.jpg");
        titleLbl = new JLabel("Rock Paper Scissors!", icon, JLabel.CENTER);
        titleLbl.setFont(new Font("Courier", Font.BOLD,30));
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        iconPnl.add(titleLbl);
    }

    /**
     *  Method that contains the game portion of the project. This is where the player will control the game.
     */
    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setBorder(BorderFactory.createMatteBorder(
                2, 2, 2, 2, Color.BLACK));
        ImageIcon rockImg = new ImageIcon("src/rockimg-removebg-preview.png");
        ImageIcon paperImg = new ImageIcon("src/paperimg-removebg-preview.png");
        ImageIcon scissorsImg = new ImageIcon("src/scissorsimg-removebg-preview.png");
        ImageIcon quitImg = new ImageIcon("src/leave.jpg");

        JLabel rockLabel;
        rockLabel = new JLabel("Rock!", JLabel.CENTER);
        rockLabel.setFont(new Font("Courier", Font.BOLD,15));
        rockLabel.setVerticalTextPosition(JLabel.BOTTOM);

        JLabel paperLabel;
        paperLabel = new JLabel("Paper!", JLabel.CENTER);
        paperLabel.setFont(new Font("Courier", Font.BOLD,15));
        paperLabel.setVerticalTextPosition(JLabel.BOTTOM);

        JLabel scissorsLabel;
        scissorsLabel = new JLabel("Scissors!", JLabel.CENTER);
        scissorsLabel.setFont(new Font("Courier", Font.BOLD,15));
        scissorsLabel.setVerticalTextPosition(JLabel.BOTTOM);

        JLabel quitLabel;
        quitLabel = new JLabel("Quit", JLabel.CENTER);
        quitLabel.setFont(new Font("Courier", Font.BOLD,15));
        quitLabel.setVerticalTextPosition(JLabel.BOTTOM);

        controlPnl.setLayout(new GridLayout(2, 4));
        rockBtn = new JButton(rockImg);
        paperBtn = new JButton(paperImg);
        scissorsBtn = new JButton(scissorsImg);
        quitBtn = new JButton(quitImg);

        rockBtn.addActionListener((ActionEvent ae) ->
        {
            int yourResult = tisAResult.getPlay(1);
            printResult = tisAResult.getResult(yourResult);
            displayTA.append( printResult + "\n");

            if(yourResult == 1 || yourResult == 3 || yourResult == 5){
                displayWins.setText(String.valueOf(tisAResult.playerWinCounter(yourResult)));
            } else if(yourResult == 2 || yourResult == 4 || yourResult == 6){
                displayLosses.setText(String.valueOf(tisAResult.computerWinCounter(yourResult)));
            }else{
                displayTies.setText(String.valueOf(tisAResult.tiesCounter(yourResult)));
            }
            displayTotal.setText(String.valueOf(tisAResult.gameCounter(yourResult)));
        });
        
        paperBtn.addActionListener((ActionEvent ae) ->{
            int yourResult = tisAResult.getPlay(2);
            printResult = tisAResult.getResult(yourResult);
            displayTA.append( printResult + "\n");

            if(yourResult == 1 || yourResult == 3 || yourResult == 5){
                displayWins.setText(String.valueOf(tisAResult.playerWinCounter(yourResult)));
            } else if(yourResult == 2 || yourResult == 4 || yourResult == 6){
                displayLosses.setText(String.valueOf(tisAResult.computerWinCounter(yourResult)));
            }else{
                displayTies.setText(String.valueOf(tisAResult.tiesCounter(yourResult)));
            }
            displayTotal.setText(String.valueOf(tisAResult.gameCounter(yourResult)));
        });
        scissorsBtn.addActionListener((ActionEvent ae) ->{
            int yourResult= tisAResult.getPlay(3);
            printResult = tisAResult.getResult(yourResult);
            displayTA.append( printResult + "\n");

            if(yourResult == 1 || yourResult == 3 || yourResult == 5){
                displayWins.setText(String.valueOf(tisAResult.playerWinCounter(yourResult)));
            } else if(yourResult == 2 || yourResult == 4 || yourResult == 6){
                displayLosses.setText(String.valueOf(tisAResult.computerWinCounter(yourResult)));
            }else{
                displayTies.setText(String.valueOf(tisAResult.tiesCounter(yourResult)));
            }
            displayTotal.setText(String.valueOf(tisAResult.gameCounter(yourResult)));
        });
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        controlPnl.add(rockLabel);
        controlPnl.add(paperLabel);
        controlPnl.add(scissorsLabel);
        controlPnl.add(quitLabel);
        controlPnl.add(rockBtn);
        controlPnl.add(paperBtn);
        controlPnl.add(scissorsBtn);
        controlPnl.add(quitBtn);

    }
    /**
     *  Method to provide layout and details of the results. It shows all of the win details as well as the results of each game played
     */
    private void createDisplayPanel()
    {
        displayPnl = new JPanel();
        displayPnl.setLayout(new GridLayout(1, 2));

        JLabel winLabel;
        winLabel = new JLabel("Wins: \n", JLabel.CENTER);
        winLabel.setFont(new Font("Courier", Font.BOLD,15));
        winLabel.setVerticalTextPosition(JLabel.BOTTOM);

        JLabel lossesLabel;
        lossesLabel = new JLabel("Losses: \n", JLabel.CENTER);
        lossesLabel.setFont(new Font("Courier", Font.BOLD,15));
        lossesLabel.setVerticalTextPosition(JLabel.BOTTOM);

        JLabel tiesLabel;
        tiesLabel = new JLabel("Ties: \n", JLabel.CENTER);
        tiesLabel.setFont(new Font("Courier", Font.BOLD,15));
        tiesLabel.setVerticalTextPosition(JLabel.BOTTOM);

        JLabel totalLabel;
        totalLabel = new JLabel("Total Games: \n", JLabel.CENTER);
        totalLabel.setFont(new Font("Courier", Font.BOLD,15));
        totalLabel.setVerticalTextPosition(JLabel.BOTTOM);


        displayTA = new JTextArea(10, 25);
        displayWins = new JTextArea(1,3);
        displayLosses = new JTextArea(1,3);
        displayTies = new JTextArea(1,3);
        displayTotal = new JTextArea(1,3);

        displayTA.setEditable(false);
        displayWins.setEditable(false);
        displayLosses.setEditable(false);
        displayTies.setEditable(false);
        displayTotal.setEditable(false);

        scroller = new JScrollPane(displayTA);

        Box box = Box.createVerticalBox();
        box.add(totalLabel);
        box.add(displayTotal);
        box.add(winLabel);
        box.add(displayWins);
        box.add(lossesLabel);
        box.add(displayLosses);
        box.add(tiesLabel);
        box.add(displayTies);

        displayPnl.add(scroller);
        displayPnl.add(box);

    }

}
